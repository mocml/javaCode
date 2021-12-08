/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.JTextField;

/**
 *
 *
 * @author vanhv
 */
public class CalculationHandle {

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private final JTextField display;

    private boolean process;//Check process calculation & error
    private boolean reset;// replace new number to screen or not
    private boolean backspace;// can backspace delete if true
    private String operator;// set operator(+,-,*,/) to calculate
    private final String ERROR = "Invalid input"; // Error string show on screen
    private boolean error; // error (sqrt(-9) , 1/0...)

    public CalculationHandle(JTextField display) {
        this.display = display;
        process = false;
        reset = false;
        backspace = false;
        operator = null;
        error = false;
    }

    //Set operator this
    public void setOperator(String operator) {
        this.operator = operator;
    }

    // Get and set number pressed to display or add to behind number string before .Check
    // reset and process to set to "0"
    //Max Length of screen is 16
    public void number(String number) {
        BigDecimal temp;
        String value = number;
        if (process == true || reset == true) {
            display.setText("0");
            process = false;
            reset = false;
        }
        temp = new BigDecimal(display.getText() + value);
        if (display.getText().length() < 16) {
            display.setText(temp + "");
        }
        backspace = true;
    }

    //Convert a String to BigDecimal number
    private BigDecimal isBigDecimal(String strNumber) {
        BigDecimal bigdecimalNumber = new BigDecimal(strNumber);
        return bigdecimalNumber;
    }

    /**
     * Perform check process and operator , if false get and set new value on
     * number press , calculation and set result to screen Set screen is ERROR
     * when miscalculation .Can reset calculate and can perform new operator
     */
    void calculation() {
        try {
            if (process == false) {
                //when no math has been done . set number show on display is first number | can backspace
                if (operator == null) {
                    firstNumber = isBigDecimal(display.getText());
                    backspace = false;
                } else {
                    //after choose a operator => operator !null => input secondnumber is new number on screen
                    //and calculation and then show result to screen if do other operator or press btn result
                    secondNumber = isBigDecimal(display.getText());
                    backspace = false;
                    switch (operator) {
                        case "+":
                            firstNumber = firstNumber.add(secondNumber).round(MathContext.UNLIMITED);
                            break;
                        case "-":
                            firstNumber = firstNumber.subtract(secondNumber);
                            break;
                        case "*":
                            firstNumber = firstNumber.multiply(secondNumber).setScale(16, RoundingMode.HALF_UP);
                            break;
                        case "/":
                            firstNumber = firstNumber.divide(secondNumber, 16, BigDecimal.ROUND_HALF_UP);
                            break;
                    }
                }
                process = true;// process is set = true to press other operator
                display.setText(firstNumber.setScale(14, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString() + "");
            }
        } catch (Exception e) {
            reset = true;// else reset will be set = true to user can press a new number.
            display.setText(ERROR);
            error = true;
        }
    }

    // if has not error, calculation and set operator to null,
    //process = false to do other | reset = true
    void result() {
        if (!error) {
            calculation();
            operator = null;
        } else {
            display.setText(firstNumber.stripTrailingZeros() + "");
        }
        process = false;
        reset = true;
        backspace = false;
        error = false;
    }

    //Cal square root of number on screen
    void sqrt() {
        try {
            BigDecimal txtResult = isBigDecimal(display.getText());
            if (txtResult.doubleValue() >= 0) {
                String txtDisplay = Math.sqrt(txtResult.doubleValue()) + "";
                display.setText(isBigDecimal(txtDisplay).stripTrailingZeros().toPlainString() + "");
                firstNumber = isBigDecimal(txtDisplay).stripTrailingZeros();
                process = false;
                backspace = false;
                reset = true;
            } else {
                display.setText(ERROR);
                error = true;
                process = true;
                backspace = false;
            }
        } catch (Exception e) {
            display.setText(ERROR);
            error = true;
            process = true;
            backspace = false;
        }
    }

    // do percent cal : if operator is (+, - ) cal percent of firstnumber + firstnumber * percent
    // else  firstnumber *  percent;
    void percent() {
        try {
            if (operator == null) {
                display.setText(isBigDecimal("0").divide(isBigDecimal("100")).stripTrailingZeros().toPlainString() + "");
            } else {
                String rs = "0";
                switch (operator) {
                    case "+":
                    case "-":
                        rs = firstNumber.multiply(isBigDecimal(display.getText()).divide(isBigDecimal("100"))).stripTrailingZeros().toPlainString() + "";
                        break;
                    case "*":
                    case "/":
                        rs = isBigDecimal(display.getText()).divide(isBigDecimal("100")).stripTrailingZeros().toPlainString() + "";
                        break;
                }
                display.setText(rs);
            }
            process = false;
        } catch (Exception e) {
            display.setText(ERROR);
            error = true;
        }
        reset = true;
        backspace = false;
    }

    void invert() {
        try {
            double result = isBigDecimal(display.getText()).doubleValue();
            if (result != 0) {
                display.setText(isBigDecimal((1 / (double) result) + "").stripTrailingZeros().toPlainString() + "");
                process = false;
            } else {
                display.setText(ERROR);
                error = true;
            }
        } catch (Exception e) {
            display.setText(ERROR);
            error = true;
        }
        backspace = false;
        process = false;
        reset = true;
    }

    void negate() {
        if (error) {
            backspace = false;
        } else {
            if (display.getText().startsWith("-")) {
                display.setText(display.getText().replace("-", ""));
            } else {
                display.setText("-" + display.getText());
            }
        }
        backspace = true;
        reset = false;
    }

    void backSpace() {
        if (backspace) {
            String txtDisplay = display.getText();
            int txtLen = txtDisplay.length();

            if (txtLen != 1) {
                //-2
                if (txtLen == 2 && txtDisplay.contains("-")) {
                    txtDisplay = "0";
                } else if (txtLen == 4 && txtDisplay.contains("-0")) {//-0.3
                    txtDisplay = "0";
                } else if (txtDisplay.charAt(txtLen - 2) == '.') {
                    //0.123
                    txtDisplay = txtDisplay.substring(0, txtLen - 2);
                } else {
                    //0.
                    txtDisplay = txtDisplay.substring(0, txtLen - 1);
                }
            } else {
                txtDisplay = "0";
            }
            display.setText(txtDisplay);
        }
    }

    //clear screen , set text to 0
    void clearEntry() {
        display.setText("0");
        process = false;
        reset = false;
        backspace = false;
    }

    //clear and set operator to null  to clear all
    void clear() {
        operator = null;
        clearEntry();
    }

    //when a dot contain in string, just have only one dot
    void dot() {
        if (process == true || reset == true) {
            display.setText("0");
            process = false;
            reset = false;
        }
        if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
        process = false;
        reset = false;
    }
}
