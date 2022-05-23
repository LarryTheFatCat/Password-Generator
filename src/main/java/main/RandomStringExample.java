package main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomStringExample {

    public static void getAlphaNumericString(int n) {

        // length is bounded by 256 Chars as per the Ascii Table (2^8).
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        // Look and Feel is set to Windows 11 (On Windows Only)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a StringBuffer to store the result
        String randomString = new String(array, StandardCharsets.UTF_8);
        StringBuilder r = new StringBuilder();


        // Append first 20 alphanumeric characters
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    || (ch >= '!' && ch <= '+')
                    && (n > 0)) {
                r.append(ch);
                n--;
            }
        }
        int r7 = JOptionPane.showConfirmDialog(null, "Would you like to generate a password?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if(r7 == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Your new password is " + r, "Password Generator", JOptionPane.QUESTION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry to hear you won't be creating one...");
        }
        // Use OptionPane to show the options
        int r2 = JOptionPane.showConfirmDialog(null, "Would you like it copied to your clipboard?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if (r2 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Copying to clipboard...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Copied to clipboard!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            sendToClipBoard(r);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        }

        // Ask if you want to see the amount of chars inside the file
        int r3 = JOptionPane.showConfirmDialog(null, "Would you like to see the amount of characters in the file before you create a file?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if (r3 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "There are a total of " + r.length() + " characters in this string.", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        }


        int r1 = JOptionPane.showConfirmDialog(null, "Would you like it as a file?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if (r1 == JOptionPane.YES_OPTION) {
            if(!new File("Password Generator-info.json").exists()) {
                JOptionPane.showMessageDialog(null, "File not Found, Creating file...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                try (PrintWriter o = new PrintWriter("Password Generator-info.json", String.valueOf(StandardCharsets.UTF_8))) {
                    o.println(r);
                    o.println("There are a total of " + r.length() + " characters in this string.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Checking...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                JOptionPane.showMessageDialog(null, "File already, please delete the file and then re-run the program!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            }
            // Ask if you want to see the location of Password Generator-info.json file.
            int r4 = JOptionPane.showConfirmDialog(null, "Would you like to see the location of the file?", "Password Generator", JOptionPane.YES_NO_OPTION);
            if (r4 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "The file is located at: " + new File("Password Generator-info.json").getAbsolutePath(), "Password Generator", JOptionPane.QUESTION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            }
            // Open the file that already exists.
            int r5 = JOptionPane.showConfirmDialog(null, "Would you like to open the file?", "Password Generator", JOptionPane.YES_NO_OPTION);
            if (r5 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Opening file...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                try {
                    Desktop.getDesktop().open(new File("Password Generator-info.json"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Canceling save...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Canceled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);

            System.exit(0);
        }

        // end of method getAlphaNumericString.
    }

    // Method to copy the generated String to the clipboard.
    private static void sendToClipBoard(StringBuilder stringBuilder) {
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // Main method
    public static void main(String[] args) {
        getAlphaNumericString(20);
        // Thread sleeps after 142 nanoseconds it wakes up and prints the generated String.
        try {
            Thread.sleep(142);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
/*


        String fileExtension = JOptionPane.showInputDialog("Enter file extension.");
        if(fileExtension.equals("")){
            JOptionPane.showMessageDialog(null, "No file extension entered. Defaulting to .txt");
            fileExtension = ".txt";
            try{
                PrintWriter writer = new PrintWriter("randomString" + fileExtension, "UTF-8");
                writer.println(r);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try{
                PrintWriter writer = new PrintWriter("randomString" + fileExtension, "UTF-8");
                writer.println(r);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 */