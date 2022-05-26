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

    public static final String mn = "PasswordGenerator";

    public static final String v = "v 1.0";

    public static final String a = "TwoOneTwo";

    public static final String ghAcc = "https://github.com/TwoThreeTwo";

    public static final String ghRepo = "https://github.com/TwoThreeTwo/RandomStringGenerator";
    public static final String fn = "output-information.";
    


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
        if (r7 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Your new password is " + r, mn, JOptionPane.QUESTION_MESSAGE);
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


        // Use OptionPane to show the options
        int r1 = JOptionPane.showConfirmDialog(null, "Would you like it as a file?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if (r1 == JOptionPane.YES_OPTION) {
            int r8 = JOptionPane.showConfirmDialog(null, "Would you like a custom file extension?", "Password Generator", JOptionPane.YES_NO_OPTION);
            String fileExtension = null;
            if (r8 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Please enter a actual file extension or else the default check will not work...", "Password Generator", JOptionPane.PLAIN_MESSAGE);
                fileExtension = JOptionPane.showInputDialog(null, "Enter file extension.", "Password Generator", JOptionPane.PLAIN_MESSAGE);
                if (fileExtension.equals("")) {
                    JOptionPane.showMessageDialog(null, "No file extension entered. Defaulting to .txt");
                    fileExtension = ".txt";
                    try {
                        PrintWriter writer = new PrintWriter(fn + fileExtension, "UTF-8");
                        writer.println(r);
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        PrintWriter writer = new PrintWriter(fn + fileExtension, "UTF-8");
                        writer.println(r);
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (!new File(fn + fileExtension).exists()) {
                    JOptionPane.showMessageDialog(null, "File found, please delete or use a new extension!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Checking...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "File not found, generating new file...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Created!", "Password Generator", JOptionPane.QUESTION_MESSAGE);

                }


                // Ask if you want to see the location of Password Generator-info.json file.
                int r4 = JOptionPane.showConfirmDialog(null, "Would you like to see the location of the file?", "Password Generator", JOptionPane.YES_NO_OPTION);
                if (r4 == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "The file is located at: " + new File(fn + fileExtension).getAbsolutePath(), "Password Generator", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                }


                // Open the file that already exists.
                int r5 = JOptionPane.showConfirmDialog(null, "Would you like to open the file?", "Password Generator", JOptionPane.YES_NO_OPTION);
                if (r5 == JOptionPane.YES_OPTION) {
                    // Check if file has an invalid extension when opening.
                    assert false;
                    if (fileExtension.equals(".meow")) {
                        JOptionPane.showMessageDialog(null, "Invalid file extension, please use a valid file extension.", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Opening file...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                    try {
                        Desktop.getDesktop().open(new File(fn + fileExtension));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
                }


            }
        } else {
            JOptionPane.showMessageDialog(null, "Canceling save...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Canceled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        }
        // Ask if you want to see the amount of chars inside the file
        int r3 = JOptionPane.showConfirmDialog(null, "Would you like to see the amount of characters in the file before you create a file?", "Password Generator", JOptionPane.YES_NO_OPTION);
        if (r3 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "There are a total of " + r.length() + " characters in this string.", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", "Password Generator", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", "Password Generator", JOptionPane.QUESTION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"Thank you for using " + mn +  " " + v + "\nThe person who created this program is " + a + "\nThe v this program is currently on is " + v + "\n If you have the JAR file but not the repository, you can check it out here " + ghRepo + "\n The GitHub account that currently made it is " + ghAcc , "Password Generator", JOptionPane.QUESTION_MESSAGE);
        System.exit(0);
    } // End of main method for Password Generator. 
    

    // Method to copy the generated String to the clipboard.
    private static void sendToClipBoard(StringBuilder stringBuilder) {
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // Main method
    public static void main(String[] args) {
        getAlphaNumericString(20);
        // Wakes up after 142 milliseconds.
        try {
            Thread.sleep(142);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}