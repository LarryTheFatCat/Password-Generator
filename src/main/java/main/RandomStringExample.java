package main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomStringExample extends JOptionPane {
    /**
     * Gets alphanumeric string.
     *
     * @return the alphanumeric string
     */
    public static String getAlphaNumericString(int n) {

        JFrame frame = new JFrame("meow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, StandardCharsets.UTF_8);


        // Create a StringBuffer to store the result
        StringBuilder r = new StringBuilder();

        /*
        Append first 20 alphanumeric characters
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
        // check line 62 for code
        sendToClipBoard(r);

        // We can use a dialog to show the output instead of using an ide, much simpler lol...
        JOptionPane.showMessageDialog(frame, r + "\n" + "Generated New Text File Storing information & copied to clipboard!");

        try (PrintWriter out = new PrintWriter("output-info.txt")) {
            out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return the resultant string
        return r.toString();

    }

    private static void sendToClipBoard(StringBuilder stringBuilder){
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void main(String[] args) {
        // size of random alphanumeric string
        int n = 156;
        // Get and display the alphanumeric string
        System.out.println(getAlphaNumericString(n));
    }
}
