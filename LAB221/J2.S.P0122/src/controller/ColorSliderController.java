/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import javax.swing.event.ChangeEvent;
import view.FormColorSlider;

/**
 *
 * @author vanhv
 */
public class ColorSliderController {

//declare red , green ,blue to get RGB value from JSlider
    private int redValue;
    private int greenValue;
    private int blueValue;

    public ColorSliderController(FormColorSlider view) {
        //Set title 
        view.setTitle("Colors Slider");
        //Set location to center screen
        view.setLocationRelativeTo(null);
        //Show Application
        view.setVisible(true);
        
        //Set default red, green , blue value by Jslider value
        redValue = view.getRedSlider().getValue();
        greenValue = view.getGreenSlider().getValue();
        blueValue = view.getBlueSlider().getValue();

        //Set text to show value default of Jslider
        view.getRedTxt().setText(" R = " + redValue);
        view.getGreenTxt().setText(" G = " + greenValue);
        view.getBlueTxt().setText(" B = " + blueValue);

        //Set backgroundcolor when run app
        view.getColorPanel().setBackground(new Color(redValue, greenValue, blueValue));
        
        //JSliders action
        actionChangeColor(view);
    }

    /**
     * Add action for Red,Green,Blue JSlider . Change background color JPanel
     * while dragging JSlider
     *
     * @param view object of <code> FormColorSlider </code>
     */
    private void actionChangeColor(FormColorSlider view) {

        // Add action change color for Red JSlider
        view.getRedSlider().addChangeListener((ChangeEvent e) -> {
            //Get value of red slider if has change
            redValue = view.getRedSlider().getValue();
            //Set background color for ColorPanel (R,G,B)
            view.getColorPanel().setBackground(new Color(redValue, greenValue, blueValue));
            //Update text red slider value
            view.getRedTxt().setText(" R = " + redValue);
        });
        // Add action change color for Green JSlider
        view.getGreenSlider().addChangeListener((ChangeEvent e) -> {
            //Get value of green slider if has change
            greenValue = view.getGreenSlider().getValue();
            //Set background color for ColorPanel (R,G,B)
            view.getColorPanel().setBackground(new Color(redValue, greenValue, blueValue));
            //Update text green slider value
            view.getGreenTxt().setText(" G = " + greenValue);
        });
        // Add action change color for Blue JSlider
        view.getBlueSlider().addChangeListener((ChangeEvent e) -> {
            //Get value of blue slider if has change
            blueValue = view.getBlueSlider().getValue();
            //Set background color for ColorPanel (R,G,B)
            view.getColorPanel().setBackground(new Color(redValue, greenValue, blueValue));
            //Update text blue slider value
            view.getBlueTxt().setText(" B = " + blueValue);
        });
    }
}
