/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertNumberProgram;

import convertNumberProgram.ConvertManager;
import convertNumberProgram.Validate;
import java.io.IOException;

/**
 * content class :
 * <p>
 * Bugs :
 *
 * @author vanhv
 */
public class CovertMain {

    public static void main(String[] args) throws IOException {
        ConvertManager convert = new ConvertManager();
        Validate valid = new Validate();
        do {
            System.out.println("\n===============================");
            System.out.println("1_Binary");
            System.out.println("2_Decimal");
            System.out.println("3_Hexadecimal");
            System.out.println("0_Exit.");
            System.out.println("\t\t-------------------");
            System.out.print("Base in :");
            int value = valid.checkLimit(0, 3);
            if (value == 0) {
                break;
            }
            System.out.print("Base out :");
            int base = valid.checkLimit(0,3);
            if(base==0){
                break;
            }
            System.out.print("Value : ");
            
            convert.convertOption(value, base);
            
        } while (true);
    }
}
