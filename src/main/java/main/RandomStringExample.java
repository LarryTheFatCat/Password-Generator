package main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomStringExample {
    public static void getAlphaNumericString(int n) {
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        // Create a StringBuffer to store the result
        String randomString = new String(array, StandardCharsets.UTF_8);
        StringBuilder r = new StringBuilder();

        // Append first 20 alphanumeric characters from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    || (ch >= '!' && ch <= '+')
                    && (n > 0))
            {
                r.append(ch);
                n--;
            }
        }
        sendToClipBoard(r);
        // return the resultant string in a JOptionPane.
        JOptionPane.showMessageDialog(null, r + "\n" + "Copied to clipboard & creating file...", "password-output", JOptionPane.INFORMATION_MESSAGE);
        //close the window opening another JOptionPane
        JOptionPane.showMessageDialog(null, "File created successfully", "password-output", JOptionPane.INFORMATION_MESSAGE);

        // Create a file to write the output.
        try (PrintWriter o = new PrintWriter("output-info.txt", String.valueOf(StandardCharsets.UTF_8))) {
            o.println(r);
        } catch (Exception er) {
            throw new RuntimeException(er);
        }

    } // end of method


    // Stores the output in your clipboard...
    private static void sendToClipBoard(StringBuilder stringBuilder) {
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


    public static void main(String[] args) {
        // size of random alphanumeric string
        int n = 50;

        // Nanoseconds thread sleep...
         try {
            Thread.sleep(0, 142);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // call the method
        getAlphaNumericString(n);
    }
}
