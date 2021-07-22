package convertNumberProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * content class :
 * <p>
 * Bugs :
 *
 * @author vanhv
 */
public class Validate {

    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //to chect option [1-3] (binary, decimal, hexadecimal), 0 to exist
    protected int checkLimit(int a, int b) {
        while (true) {
            try {
                int result = Integer.parseInt(in.readLine());
                if (result < a || result > b) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (IOException | NumberFormatException ex) {
                System.err.println("Input in range [" + a + ", " + b + "] : ");
                System.out.println("Try again.");
            }
        }
    }

    //check input match with valid number in (bin, dec, hex)
    protected String inputCheck(String type) throws IOException {
        String result;
        while (true) {
            result = in.readLine();
            if (result.matches(type)) {
                return result;
            } else {
                System.out.println("Try again.");
            }
        }
    }

}
