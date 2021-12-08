/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.CalculatorForm;

/**
 *
 * @author vanhv
 */
public class CalculatorController {

    private final CalculationHandle calculateHandle;

    public CalculatorController(CalculatorForm view) {
        calculateHandle = new CalculationHandle(view.getTxtDisplay());

        pressNumber(view);
        pressMathOperators(view);
        pressMathMethod(view);
        pressMathSymbol(view);
    }

    private void pressNumber(CalculatorForm view) {
        view.getBtnNum0().addActionListener((e) -> {
            calculateHandle.number("0");
        });

        view.getBtnNum1().addActionListener((e) -> {
            calculateHandle.number("1");
        });

        view.getBtnNum2().addActionListener((e) -> {
            calculateHandle.number("2");
        });

        view.getBtnNum3().addActionListener((e) -> {
            calculateHandle.number("3");
        });

        view.getBtnNum4().addActionListener((e) -> {
            calculateHandle.number("4");
        });

        view.getBtnNum5().addActionListener((e) -> {
            calculateHandle.number("5");
        });

        view.getBtnNum6().addActionListener((e) -> {
            calculateHandle.number("6");
        });

        view.getBtnNum7().addActionListener((e) -> {
            calculateHandle.number("7");
        });

        view.getBtnNum8().addActionListener((e) -> {
            calculateHandle.number("8");
        });

        view.getBtnNum9().addActionListener((e) -> {
            calculateHandle.number("9");
        });
    }

    private void pressMathOperators(CalculatorForm view) {
        view.getBtnAdd().addActionListener((e) -> {
            calculateHandle.calculation();
            calculateHandle.setOperator("+");
        });
        view.getBtnSub().addActionListener((e) -> {
            calculateHandle.calculation();
            calculateHandle.setOperator("-");
        });
        view.getBtnMultiple().addActionListener((e) -> {
            calculateHandle.calculation();
            calculateHandle.setOperator("*");
        });
        view.getBtnDivide().addActionListener((e) -> {
            calculateHandle.calculation();
            calculateHandle.setOperator("/");
        });

    }

    private void pressMathMethod(CalculatorForm view) {
        view.getBtnNegate().addActionListener((e) -> {
            calculateHandle.negate();
        });
        view.getBtnSqrt().addActionListener((e) -> {
            calculateHandle.sqrt();
        });
        view.getBtnPercent().addActionListener((e) -> {
            calculateHandle.percent();
        });
        view.getBtnInvert().addActionListener((e) -> {
            calculateHandle.invert();
        });
        view.getBtnResult().addActionListener((e) -> {
            calculateHandle.result();
        });
    }

    private void pressMathSymbol(CalculatorForm view) {
        view.getBtnBackSpace().addActionListener((e) -> {
            calculateHandle.backSpace();
        });
        view.getBtnCE().addActionListener((e) -> {
            calculateHandle.clearEntry();
        });
        view.getBtnC().addActionListener((e) -> {
            calculateHandle.clear();
        });
        view.getBtnDot().addActionListener((e) -> {
            calculateHandle.dot();
        });
    }

}
