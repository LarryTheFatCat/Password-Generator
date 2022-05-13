package main;

import javax.swing.*;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author TwoOneTwo :)
 * Two#6969 <- if you have any questions
 * This is just an example of Char & String Generator.
 */

// TODO: Figure out how to make it so if you close it shows a warning asking if you want to copy it to clipboard postClose.
public class RandomStringExample extends JOptionPane {
    /**
     * Gets alphanumeric string.
     *
     * @return the alphanumeric string
     */
    public static String getAlphaNumericString(int n) {

        JFrame frame = new JFrame("Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        // PrintWriter && JOptionPane both use Try catch... Why not put both in 1 :)), fixed all bugs as well
        try (PrintWriter out = new PrintWriter("output-info.txt")) {
            out.println(r);
            JOptionPane.showConfirmDialog(frame, r + "\n" + "Generated New Text File Storing information!" + "\n" + "Do you want it copied to clipboard?");
        } catch (Exception e) {
            throw new RuntimeException("Interrupted during process...");
        }


        // return the resultant string
        return r.toString();


    }



    public static void main(String[] args) {
        // size of random alphanumeric string
        int n = 156;
        // Get and display the alphanumeric string
        System.out.println(getAlphaNumericString(n));
    }
}
