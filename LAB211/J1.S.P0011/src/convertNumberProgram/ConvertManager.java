package convertNumberProgram;

import java.io.IOException;
import java.math.BigInteger;

/**
 * content class :
 * <p>
 * Bugs : 
 *
 * @author vanhv
 */
public class ConvertManager {

    private final Validate valid = new Validate();
    private final String DECIMAL_VALID = "[0-9]*";
    private final String BINARY_VALID = "[0-1]*";
    private final String HEXADECIMAL_VALID = "[0-9a-fA-F]*";

    //choose option to convert a number to base number.
    protected void convertOption(int convertNumber, int base) throws IOException {
        if (convertNumber == 1) {
            //binary to base
            String binaryNumber = valid.inputCheck(BINARY_VALID);
            if (base == 2) {
                System.out.println("Bin to Dec : " + toDec(binaryNumber, base));
            }
            if (base == 3) {
                System.out.println("Bin to Hex : " + binToHex(binaryNumber));
            }
            if (base == 1) {
                System.out.println("Bin to Bin : " + binToHex(hexToBin(binaryNumber)));
            }
        }
        if (convertNumber == 2) {//decimal to base
            String decNumber = valid.inputCheck(DECIMAL_VALID);
            if (base == 1) {
                System.out.println("Dec to Bin : " + decTo(decNumber, "2"));
            }
            if (base == 3) {
                System.out.println("Dec to Hex : " + decTo(decNumber, "16"));
            }
            if (base == 2) {
                System.out.println("Dec to Dec : " + decTo(decNumber, "10"));
            }
        }
        if (convertNumber == 3) {//hexadecimal to base
            String hexNumber = valid.inputCheck(HEXADECIMAL_VALID);
            hexNumber = hexNumber.toUpperCase();
            if (base == 1) {
                System.out.println("Hex to Bin : " + hexToBin(hexNumber));
            }
            if (base == 2) {
                System.out.println("Hex to Dec : " + toDec(hexNumber, 16));
            }
            if (base == 3) {
                System.out.println("Hex to Hex : " + binToHex(hexToBin(hexNumber)));
            }
        }
    }

    /*
        need convert do decimal number before convert to other base number
        and then have toDec and decTo method.
     */
    //get i  each character in input to pow by indexOf 'i' : >> A-F = 10-15.
    //output = indexOf(input.charAt(i)) * pow(base)^input.leng()-i-1
    //Dec_10 | Hex_16 | Bin_2
    private BigInteger toDec(String input, int base) {

        String numString = "0123456789ABCDEF";
// AB 12 |1012
        BigInteger result = new BigInteger("0");

        for (int i = 0; i < input.length(); i++) {
            //Base : 2 | 10 | 16
            BigInteger bas = new BigInteger(String.valueOf(base));
            //value charAt[i] :
            BigInteger inputValue = new BigInteger(String.valueOf(numString.indexOf(input.charAt(i))));
            //current Index
            BigInteger index = new BigInteger(String.valueOf(input.length() - i - 1));
            //current Pow by Index
            int pow = input.length() - i - 1;
            //calculate : converted += charAt[i]*base^pow 
            String str2 = String.valueOf((bas.pow(pow)).multiply(inputValue));

            result = result.add(new BigInteger(str2));
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertManager cn = new ConvertManager();
        //DECIMAL to HEXA
        //74567682366366435382159012080 | F0F0F0F0F0F0F0F0F0F0F0F0
        System.err.println("dec to hex : " + cn.decTo("4886867631562190709205173015736560", "16"));

        //HEXA to DECIMAL
        System.out.println("dec : " + cn.toDec("F0F0F0F0F0F0F0F0F0F0F0F0F0F0", 16));

    }

    //convert decTO other basenum
    //Dec_10 | Hex_16 | Bin_2
    private String decTo(String decNumberStr, String baseStr) {

        BigInteger decNumber = new BigInteger(decNumberStr);
        BigInteger base = new BigInteger(baseStr);

        long x = decNumber.longValue();
        String convert = "0123456789ABCDEF";
        String otherBase = "";
        if (x == 0) {
            if (base.toString().equals("2")) {
                otherBase = "0";
            }
            if (base.toString().equals("16")) {
                //  otherBase = "0000";
                otherBase = "0";
            }
            if (base.toString().equals("10")) {
                otherBase = "0";
            }
        }
        while (!decNumber.toString().equals("0")) {
            //Get  convert[convertNumber % base] + otherbase.
            otherBase = convert.charAt((decNumber.mod(base).intValue())) + otherBase;
            //Divide when still != 0
            decNumber = decNumber.divide(base);
        }
        return otherBase;
    }

    //binary to hexa : Bin to Dec and then to Hex
    private String binToHex(String binNumber) {
        String decNumber = toDec(binNumber, 2).toString();
        return decTo(decNumber, "16");
    }

    //hexa to bin : Hex to Dec and then to Bin
    private String hexToBin(String hex) {
        String decNumber = toDec(hex, 16).toString();
        return decTo(decNumber, "2");
    }
}
