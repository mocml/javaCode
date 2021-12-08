/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import view.CalculatorForm;

/**
 *
 * @author vanhv
 */
public class Main {

    static final int SCALE = 2;

    public static void main(String[] args) {

        CalculatorForm frm = new CalculatorForm();
        frm.setTitle("Calculator");
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        CalculatorController cn = new CalculatorController(frm);
//        System.out.println(invert(invert(new BigDecimal("9"))));
//        System.out.println(1/(1 /(double) 9));
        System.out.println("Running...");
    }

    public static BigDecimal invert(BigDecimal d) {
        return divide(BigDecimal.ONE, d);
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {

        return dividend.divide(divisor, SCALE, RoundingMode.HALF_EVEN);
    }
}
