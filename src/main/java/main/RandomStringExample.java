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

        // Set LaF to match the OS.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        // return the resultant string in a JOptionPane.
        JOptionPane.showMessageDialog(null, r + "\n" + "Click Ok to see your options...", "output", JOptionPane.INFORMATION_MESSAGE);

        // var response to first dialog for options.
        int r2 = JOptionPane.showConfirmDialog(null, "Would you like it copied to your clipboard?", "Output", JOptionPane.YES_NO_OPTION);
        if (r2 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Copying to clipboard...", "Output", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Copied to clipboard!", "Output", JOptionPane.INFORMATION_MESSAGE);
            sendToClipBoard(r);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", "Output", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", "Output", JOptionPane.INFORMATION_MESSAGE);
        }

        // Variable response set to confirm dialog.
        int r1 = JOptionPane.showConfirmDialog(null, "Do you want to see your password on your desktop?.", "Output", JOptionPane.YES_NO_OPTION);
        if (r1 == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Check your Main File Directory!", "Output", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Saved!", "Output", JOptionPane.INFORMATION_MESSAGE);
            try (PrintWriter o = new PrintWriter("output-info.txt", String.valueOf(StandardCharsets.UTF_8))) {
                o.println(r);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Canceling save...", "Output", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Canceled!", "Output", JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
        }
        // end of method
    }

    // Stores the output in your clipboard...
    private static void sendToClipBoard(StringBuilder stringBuilder) {
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


    public static void main(String[] args) {
        getAlphaNumericString(20);
        // Load everything with delay of 142 nanoseconds :P
        try {
            Thread.sleep(0, 142);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}