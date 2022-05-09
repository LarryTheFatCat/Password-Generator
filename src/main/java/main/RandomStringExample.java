package main;

import javax.swing.*;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author TwoOneTwo :)
 * Two#6969 <- if you have any questions
 * This is just an example of Char & String Generator.
 * */

// TODO: Figure out how to make it so if you close it shows a warning asking if you want to copy it to clipboard preClose.
public class RandomStringExample {
    /**
     * Gets alphanumeric string.
     *
     * @param n the n
     * @return the alphanumeric string
     */
    public static String getAlphaNumericString(int n) {

        JFrame frame = new JFrame("Password");
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString = new String(array, StandardCharsets.UTF_8);

        // Create a StringBuffer to store the result
        StringBuilder r = new StringBuilder();

        /* Append first 20 alphanumeric characters
        from the generated random String into the result
         */
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Might look chinese but, I need to use this due to null pointer exceptions are appearing for some reason :c
        try {
            JOptionPane.showMessageDialog(frame, r + "\n" + "Successfully copied to your clipboard!" + "\n" + "Generated New Text File Storing information!");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

        try (PrintWriter out = new PrintWriter("output-info.txt")) {
            out.println(r);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        // return the resultant string
        return r.toString();



    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // size of random alphanumeric string
        int n = 156;
        // Get and display the alphanumeric string
        System.out.println(getAlphaNumericString(n));
    }
}
