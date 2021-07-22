/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 18/07/2021    1.0            Vanhv   
 */
package controller;

/**
 *
 * @author vanhv
 */
public class Main {

    public static void main(String[] args) {
        Validation v = new Validation();
        while (true) {
            String first = (v.getDate("Please enter the first date : "));
            String second = (v.getDate("Please enter the second date : "));
            System.err.println(v.compareDate(first, second));
        }
    }

}
