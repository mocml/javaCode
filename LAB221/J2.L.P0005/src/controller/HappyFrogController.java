/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import view.HappyFrogForm;

/**
 *
 * @author vanhv
 */
public class HappyFrogController {

    //Object frog and pipes
    private final HappyFrogForm view;
    private final JButton colUp_1;
    private final JButton colUp_2;
    private final JButton colUp_3;
    private final JButton colDown_1;
    private final JButton colDown_2;
    private final JButton colDown_3;
    private final JButton frog;

    private final int JUMP_SPACE = 180;//Frog's jupm space
    private final int SCREEN_WIDTH = 860;// Width display game
    private final int SCREEN_HEIGHT = 500;//Height
    private final int SCREEN_HEIGHT_EXTANT = SCREEN_HEIGHT - JUMP_SPACE;//320 = SC
    private final int SCREEN_SPACE_BETWEEN = 860;//Space from left to last column at right

    private int space_0_1 = 260;//space between left and pipe 1
    private int space_1_2 = 560;//space between pipe 1 and pipe 2
    private int space_2_3 = 860;//space between pipe 2 and pipe 3
    private int height_1 = 160; //default height of pipe
    private int height_2 = 280;
    private int height_3 = 200;
    //frog locate
    private int frog_pos = 230; // 1/2Screen - 1/2frog (500/2 - 40/2)
    private int score = 0;
    private int speedRun = 2;
    //cache of save
    private int space_0_1_nd;
    private int space_1_2_nd;
    private int space_2_3_nd;
    private int height_1_nd;
    private int height_2_nd;
    private int height_3_nd;
    private int frog_pos_nd;
    private int score_nd;

    private Timer timer;

    //check application run to use button New Game
    private boolean start = false;
    //Check pause action
    private boolean pause = false;
    //Save a check point
    private boolean save = false;
    //Check when press a key
    private boolean press = false;
    //Check release key
    private boolean release = true;

    public HappyFrogController(HappyFrogForm view) {
        this.view = view;
        colUp_1 = new JButton();
        colUp_2 = new JButton();
        colUp_3 = new JButton();
        colDown_1 = new JButton();
        colDown_2 = new JButton();
        colDown_3 = new JButton();
        frog = new JButton();

        view.setTitle("Happy Frog");
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        //Set icon for title bar
        view.setIconImage(Toolkit.getDefaultToolkit().getImage("frog.png"));
        view.getBtnPause().setEnabled(false);

        addColumn();
        controllerButton();
    }

    private void controllerButton() {
        view.getBtnNew().addActionListener((e) -> {
            save = false;
            newGame();
        });
        view.getBtnPause().addActionListener((e) -> {
            pause();
        });
        view.getBtnSave().addActionListener((e) -> {
            save();
        });
    }

    //set bound for each object and add to jpanel
    private void addColumn() {
        colUp_1.setBounds(space_0_1, 0, 40, height_1);
        colDown_1.setBounds(space_0_1, height_1 + JUMP_SPACE, 40, SCREEN_HEIGHT_EXTANT - height_1);

        colUp_2.setBounds(space_1_2, 0, 40, height_2);
        colDown_2.setBounds(space_1_2, height_2 + JUMP_SPACE, 40, SCREEN_HEIGHT_EXTANT - height_2);

        colUp_3.setBounds(space_2_3, 0, 40, height_3);
        colDown_3.setBounds(space_2_3, height_3 + JUMP_SPACE, 40, SCREEN_HEIGHT_EXTANT - height_3);

        frog.setBounds(48, frog_pos, 40, 40);
        view.getDisplayPanel().add(colUp_1);
        view.getDisplayPanel().add(colDown_1);

        view.getDisplayPanel().add(colUp_2);
        view.getDisplayPanel().add(colDown_2);

        view.getDisplayPanel().add(colUp_3);
        view.getDisplayPanel().add(colDown_3);

        view.getDisplayPanel().add(frog);
        designView_Buttons();
    }

    //Increase Score when position of frog = position of pipe +40
    private void getScore() {
        if (frog.getX() == (colUp_1.getX() + 40) || frog.getX() == (colUp_2.getX() + 40)
                || frog.getX() == (colUp_3.getX() + 40)) {
            score += 2;
            view.getLblPoint().setText(score + "");
        }
    }

    // draw a rectangle hitbox for all object inside jpanel
    // Using intersects to check when frog touch one of pipes or margin of display
    private boolean isTouchColumn() {
        //touch above  || touch under 
        if (frog.getY() <= 0 || frog.getY() + 40 >= 500) {
            return true;
        }
        //draw hitbox for object
        Rectangle frog_hitbox = new Rectangle(frog.getX(), frog.getY(), frog.getWidth(), frog.getHeight());

        Rectangle colUp_1_hitbox = new Rectangle(colUp_1.getX(), colUp_1.getY(), colUp_1.getWidth(), colUp_1.getHeight());
        Rectangle colDown_1_hitbox = new Rectangle(colDown_1.getX(), colDown_1.getY(), colDown_1.getWidth(), colDown_1.getHeight());

        Rectangle colUp_2_hitbox = new Rectangle(colUp_2.getX(), colUp_2.getY(), colUp_2.getWidth(), colUp_2.getHeight());
        Rectangle colDown_2_hitbox = new Rectangle(colDown_2.getX(), colDown_2.getY(), colDown_2.getWidth(), colDown_2.getHeight());

        Rectangle colUp_3_hitbox = new Rectangle(colUp_3.getX(), colUp_3.getY(), colUp_3.getWidth(), colUp_3.getHeight());
        Rectangle colDown_3_hitbox = new Rectangle(colDown_3.getX(), colDown_3.getY(), colDown_3.getWidth(), colDown_3.getHeight());

        //Check touch
        return frog_hitbox.intersects(colUp_1_hitbox)
                || frog_hitbox.intersects(colDown_1_hitbox)
                || frog_hitbox.intersects(colUp_2_hitbox)
                || frog_hitbox.intersects(colDown_2_hitbox)
                || frog_hitbox.intersects(colUp_3_hitbox)
                || frog_hitbox.intersects(colDown_3_hitbox);
    }

    private void runProcess() {
        //Run from right to left, update position each 25ms 
        timer = new Timer(24, (ActionEvent e) -> {
            //Check frog jump when press "F", "SPACE","UP"
            view.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent ex) {
                    if (ex.getKeyCode() == KeyEvent.VK_UP || ex.getKeyCode() == KeyEvent.VK_SPACE || ex.getKeyCode() == KeyEvent.VK_F) {
                        if (release) {
                            press = true;
                            release = false;
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    release = true;
                }
            });
            //default speed run from right to left
            int speedJump = 6;
            //default speed jump of frog
            //when press frog's position decrease 40 | 230 -- press -- 190
            if (press) {
                frog_pos -= speedJump * 10;
                press = false;
            }
            //add pipe and update new position
            addColumn();
            space_0_1 -= speedRun;
            space_1_2 -= speedRun;
            space_2_3 -= speedRun;

            frog_pos += speedJump;
            //when first pipe out of screen  -  create new pipe at space out of right screen
            // and set with random height
            if (space_0_1 == -40) {
                Random r1 = new Random();
                space_0_1 = SCREEN_SPACE_BETWEEN;
                height_1 = (r1.nextInt(6) + 1) * 40;
                levelUp();
            }
            //when second pipe out of screen left -  create new pipe at space out of right screen
            // and set with random height
            if (space_1_2 == -40) {
                Random r2 = new Random();
                space_1_2 = SCREEN_SPACE_BETWEEN;
                height_2 = (r2.nextInt(6) + 1) * 40;
                levelUp();
            }
            //when third pipe out of screen  -  create new pipe at space out of right screen
            // and set with random height
            if (space_2_3 == -40) {
                Random r3 = new Random();
                space_2_3 = SCREEN_SPACE_BETWEEN;
                height_3 = (r3.nextInt(6) + 1) * 40;
                levelUp();
            }
            //view.getSpeed().setText(speedRun + "");
            //Set score
            getScore();
            //if touch - game over application is stop and show message
            if (isTouchColumn()) {
                if (save == false) {
                    timer.stop();
                    messageWithoutSave();
                } else {
                    timer.stop();
                    messageWithSave();
                }
            }
        });
        timer.start();
    }

    private void levelUp() {
        if (score == 0) {
            speedRun = 2;
        }
        if (score == 10) {
            speedRun = 3;
        }
        if (score == 20) {
            speedRun = 4;
        }
        if (score == 30) {
            speedRun = 6;
        }
        if (score == 40) {
            speedRun = 12;
        }
    }

    //Application run when press new game
    //if game is runing and new game again, game will reset
    private void newGame() {
        if (start == false) {
            reset();
            runProcess();
            view.getBtnPause().setEnabled(true);
            start = true;
            view.getBtnNew().setText("New Game");
        } else if (pause == true && start == true) {
            newWithPause();
            view.getBtnNew().setText("Start");
        } else {

            reset();

        }
    }

    private void newWithPause() {
        timer.start();
        view.getBtnPause().setText("Pause");
        view.getBtnPause().setEnabled(false);
        //    view.getBtnNew().setText("Start");
        pause = false;
        start = false;
        reset();
        addColumn();
        timer.stop();
    }
//if pause applicaion is pause at current position

    private void pause() {
        if (pause == false) {
            //if
            if (start) {
                timer.stop();
                pause = true;
                view.getBtnPause().setText("Resume");
            }
        } else {
            timer.start();
            pause = false;
            view.getBtnPause().setText("Pause");
        }
    }

    private void save() {
        save = true;
        space_0_1_nd = space_0_1;
        space_1_2_nd = space_1_2;
        space_2_3_nd = space_2_3;
        height_1_nd = height_1;
        height_2_nd = height_2;
        height_3_nd = height_3;
        frog_pos_nd = frog_pos;
        score_nd = score;
    }

    private void resetSave() {
         speedRun = 2;
        space_0_1 = space_0_1_nd;
        space_1_2 = space_1_2_nd;
        space_2_3 = space_2_3_nd;
        height_1 = height_1_nd;
        height_2 = height_2_nd;
        height_3 = height_3_nd;
        frog_pos = frog_pos_nd;
        score = score_nd;
        view.getLblPoint().setText(score_nd + "");
    }

    private void reset() {
         speedRun = 2;
        space_0_1 = 260;
        space_1_2 = 560;
        space_2_3 = 860;
        height_1 = 160;
        height_2 = 280;
        height_3 = 200;
        frog_pos = 230;
        score = 0;
        view.getLblPoint().setText("0");
    }

    private String getMedal() {
        if (score < 10) {
            return "Your score is " + score + ", NO medal";
        } else if (score >= 10 && score < 20) {
            return "Your score is " + score + ", BZONE medal";
        } else if (score >= 20 && score < 30) {
            return "Your score is " + score + ", SILVER medal";
        } else if (score >= 30 && score < 40) {
            return "Your score is " + score + ", GOLD medal";
        } else {
            return "Your score is " + score + ", PLATINUM medal";
        }
    }

    //if new game selected reset all to default
    private void messageWithoutSave() {
        String message[] = {"New Game", "Exit"};
        int option = JOptionPane.showOptionDialog(null, getMedal(), "Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, message, message[0]);
        if (option == 0) {
            reset();
            timer.start();
        } else {
            System.exit(0);
        }
    }

//if new game selected reset all to default
//if replay selected reset all to save point by 2nd cache value
    private void messageWithSave() {
        String message[] = {"New Game", "Replay", "Exit"};
        int option = JOptionPane.showOptionDialog(null, getMedal(), "Game Over",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, message, message[0]);
        switch (option) {
            case 0: {
                reset();
                save = false;
                timer.start();
                break;
            }
            case 1: {
                resetSave();
                save = false;
                timer.start();
                break;
            }
            default:
                System.exit(0);
        }
    }
//Design color, back ground , icon

    private void designView_Buttons() {
        view.getDisplayPanel().setBackground(Color.white);

        colUp_1.setEnabled(false);
        colUp_2.setEnabled(false);
        colUp_3.setEnabled(false);
        colDown_1.setEnabled(false);
        colDown_2.setEnabled(false);
        colDown_3.setEnabled(false);
        frog.setBorder(null);

        colUp_1.setBackground(new Color(0, 153, 102));
        colUp_2.setBackground(new Color(0, 153, 102));
        colUp_3.setBackground(new Color(0, 153, 102));
        colDown_1.setBackground(new Color(0, 153, 102));
        colDown_2.setBackground(new Color(0, 153, 102));
        colDown_3.setBackground(new Color(0, 153, 102));

        ImageIcon frog_icon = new ImageIcon("frog2.png");
        frog.setIcon(frog_icon);
    }

}
