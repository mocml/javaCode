/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import view.FormSimplePain;

/**
 *
 * @author vanhv
 */
public class ControllerSimplePain {

    //Initialization BORDER_FOCUS & BORDER_LOST_FOCUS (set border button when select)
    //setBorder when lost focus on button | COLOR.WHITE
    private final Border BORDER_FOCUS = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.white, 2), null);
    //setBorder when lost focus on button | COLOR.GRAY
    private final Border BORDER_LOST_FOCUS = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(153, 153, 153), 2), null);

    private final Graphics2D graphic;//declare graphic a object of Graphics2D
    private Color painColor;//declare paintColor a object of Color
    //declare firsPoint and lastPoint the object of Point 
    private Point firstPoint, lastPoint;

    public ControllerSimplePain(FormSimplePain view) {
        //--------------------
        //Set title
        view.setTitle("Simple paint program");
        //set Location to center screen
        view.setLocationRelativeTo(null);
        //Show application
        view.setVisible(true);
        //--------------------
        //get JPanel's graphic
        graphic = (Graphics2D) view.getPainPanel().getGraphics();
        //initialization selected button Color
        graphic.setColor(Color.GREEN);
        //set size to pen
        graphic.setStroke(new BasicStroke(12));//set size to pen
        //--------------------
        //Set border default
        setBorder(view, view.getBtnGreen());
        actionButton(view);//All Button Action
        actionPain(view);//Draw action
    }

    //Draw by mouse motion (draw line while mouse continuous motion)
    private void actionPain(FormSimplePain view) {
        //Add Action mousePress for painArea
        view.getPainPanel().addMouseListener(new MouseAdapter() {
            @Override
            //Get first point(x,y) and draw a dot at first point
            public void mousePressed(MouseEvent e) {
                //getFirst point when press on JPanel
                firstPoint = e.getPoint();
                //when click : lastpoint = firstpoint
                lastPoint = firstPoint;
                //draw point at first mouse press
                graphic.drawLine(firstPoint.x, firstPoint.y, lastPoint.x, lastPoint.y);
            }
        });

        //Create new first and last point while drag until drop
        view.getPainPanel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            //  Get last point, draw and create new first & last point while drag
            // mouse
            public void mouseDragged(MouseEvent e) {
                //get point when still drag
                lastPoint = e.getPoint();
                //dwawline -link 2 point
                graphic.drawLine(firstPoint.x, firstPoint.y, lastPoint.x, lastPoint.y);
                //set new first point is existing last point at pointer
                firstPoint = lastPoint;
            }
        });
    }

    private void actionButton(FormSimplePain view) {
        //-- Set color pen(mouse) to Black by get background btnBlack and
        //setBorder when user focus(white) or lost focus(grey)
        view.getBtnBlack().addActionListener((ActionEvent e) -> {
             //getBackground on button click
            painColor = view.getBtnBlack().getBackground();
            //set color for pen by button's background
            graphic.setColor(painColor);
             //setBorder button when select
            setBorder(view, view.getBtnBlack());
        });

        view.getBtnRed().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnRed().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnRed());
        });

        view.getBtnGreen().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnGreen().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnGreen());
        });

        view.getBtnBlue().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnBlue().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnBlue());
        });

        view.getBtnNeon().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnNeon().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnNeon());
        });

        view.getBtnMagenta().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnMagenta().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnMagenta());
        });

        view.getBtnYellow().addActionListener((ActionEvent e) -> {
            painColor = view.getBtnYellow().getBackground();
            graphic.setColor(painColor);
            setBorder(view, view.getBtnYellow());
        });

        //----------CLEAR-----------
        view.getBtnClear().addActionListener((ActionEvent e) -> {
            view.getPainPanel().repaint();
        });
    }

    // Set border for all button to grey when a button selected and set this
    // button to white border
    private void setBorder(FormSimplePain view, JButton btn) {
        //set all button_border is GRAY
        view.getBtnBlack().setBorder(BORDER_LOST_FOCUS);
        view.getBtnRed().setBorder(BORDER_LOST_FOCUS);
        view.getBtnGreen().setBorder(BORDER_LOST_FOCUS);
        view.getBtnBlue().setBorder(BORDER_LOST_FOCUS);
        view.getBtnNeon().setBorder(BORDER_LOST_FOCUS);
        view.getBtnMagenta().setBorder(BORDER_LOST_FOCUS);
        view.getBtnYellow().setBorder(BORDER_LOST_FOCUS);

        btn.setBorder(BORDER_FOCUS);//set border button selected is white
    }
}
