# Random String Generator in Java

- Developed with Java 8

# Credit and License 

- LazzzyJava for helping
- https://www.geeksforgeeks.org/java-swing-jdialog-examples/ for some info
- https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java Discovered PrintWriter
  but forgot about it lol, this helped a lot




  # Password Generator + Options


  ## How to use this program
  <p>
  To actually use this program, you need to download the jar file that is in the latest release or build from source code, but first you must install Java8; without that specific java version, you can not actually run this program as it will cause issues and not function properly. 
  </p>

  # How to build from source code
  <p>
  To build from source code, you need to have Java 8 installed, and then you need to download the source code from the latest release, and then you need to open the source code in a Java IDE, and then you need to build the source code, and then you need to run the source code, and then you need to use the program.
  </p>

  # How to use the program
  <p>
  To use the program, you need to download the jar file from the latest release, and then you need to open the jar file, and then you need to use the program.
  </p>

  # Documentation
  <p>
  <code>
    public static final String mn = "Password - Generator";
    public static final String v = "v-1.0";
    public static final String a = "TwoOneTwo";
    public static final String ghAcc = "https://github.com/TwoThreeTwo";
    public static final String ghRepo = "https://github.com/TwoThreeTwo/RandomStringGenerator";
    public static final String fn = "output-information.";

    //   These variables display the: Main Name, Version, Author, GitHub Account, GitHub Repository, and File Name.
  </code>
  <br>
  <code>
      public static void getAlphaNumericString(int n) {
        //   This is the name of our first and only method which contains the code required to actually generate everything.
  </code>
  <br>
  <code>
          // Length is bounded by 59 Character(n-1)
        byte[] array = new byte[59];
        new Random().nextBytes(array);

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
        // All of this code represents the brains of how to generate an actual password, for example ```Byte[] array = new byte[59];``` is the code that actually generates the password, and ```StringBuilder r = new StringBuilder();``` is the code that actually displays the password.
  </code>
  <br>
  <code>
        // Return the resultant string
        System.out.println(r);
        // This is the code that actually displays the password.
</code>
<br>
<code>
        addDashes(r); // Invokes addDashes method
        // This is what is used to invoke the addDashes method which is another method that is outside the getAlphaNumericString method which we will get into later.
</code>
<br>
<code>

        int r7 = JOptionPane.showConfirmDialog(null, "Would you like to generate a password?", mn + " " + v, JOptionPane.YES_NO_OPTION);
        if (r7 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Your new password is " + r, mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry to hear you won't be creating one...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }


        // After 3 seconds, close the JOptionPane and show the next.

        // Use OptionPane to show the options
        int r2 = JOptionPane.showConfirmDialog(null, "Would you like it copied to your clipboard?", mn + " " + v, JOptionPane.YES_NO_OPTION);
        if (r2 == JOptionPane.YES_OPTION) {
            // Set timer so that the password is visible for 3 seconds before being closed automatically (if not clicked).
                JOptionPane.showMessageDialog(null, "Copying to clipboard...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
                sendToClipBoard(r);
            JOptionPane.showMessageDialog(null, "Copied to clipboard!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
            sendToClipBoard(r);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
        }


        // Use OptionPane to show the options
        int r1 = JOptionPane.showConfirmDialog(null, "Would you like it as a file?", mn + " " + v, JOptionPane.YES_NO_OPTION);
        if (r1 == JOptionPane.YES_OPTION) {
            int r8 = JOptionPane.showConfirmDialog(null, "Would you like a custom file extension?", mn + " " + v, JOptionPane.YES_NO_OPTION);
            String fileExtension = null;
            if (r8 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Please enter a actual file extension or else the default check will not work...", mn + " " + v, JOptionPane.PLAIN_MESSAGE);
                fileExtension = JOptionPane.showInputDialog(null, "Enter file extension.", mn + " " + v, JOptionPane.PLAIN_MESSAGE);
                if (fileExtension.equals("")) {
                    JOptionPane.showMessageDialog(null, "No file extension entered. Defaulting to .txt", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "File found, please delete or use a new extension!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);


                } else {
                    JOptionPane.showMessageDialog(null, "Checking...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "File not found, generating new file...", mn + " " + v, JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Created!", mn, JOptionPane.INFORMATION_MESSAGE);

                }


                // Ask if you want to see the location of mn-info.json file.
                int r4 = JOptionPane.showConfirmDialog(null, "Would you like to see the location of the file?", mn + " " + v, JOptionPane.YES_NO_OPTION);
                if (r4 == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "The file is located at: " + new File(fn + fileExtension).getAbsolutePath(), mn + " " + v, JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelled!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
                }


                // Open the file that already exists.
                int r5 = JOptionPane.showConfirmDialog(null, "Would you like to open the file?", mn + " " + v, JOptionPane.YES_NO_OPTION);
                if (r5 == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Opening file...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Desktop.getDesktop().open(new File(fn + fileExtension));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelled!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
                }


            }
        } else {
            JOptionPane.showMessageDialog(null, "Canceling save...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Canceled!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
        }


        // Ask if you want to see the amount of chars inside the file
        int r3 = JOptionPane.showConfirmDialog(null, "Would you like to see the amount of characters in the file before you create a file?", mn + " " + v, JOptionPane.YES_NO_OPTION);
        if (r3 == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "There are a total of " + r.length() + " characters in this string.", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Canceling...", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cancelled!", mn + " " + v, JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"Thank you for using " + mn +  " " + v + "\nThe person who created this program is " + a + "\nThe v this program is currently on is " + v + "\n If you have the JAR file but not the repository, you can check it out here " + ghRepo + "\n The GitHub account that currently made it is " + ghAcc , mn, JOptionPane.QUESTION_MESSAGE);
        System.exit(0);
    } // End of main method for mn.


    // All of these methods here are just to show how if when option is not selected, it will show a message.
<code>

<code>
    // Method to copy the generated String to the clipboard.
    public static void sendToClipBoard(StringBuilder stringBuilder) {
        StringSelection stringSelection = new StringSelection(stringBuilder.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    } // End of sendToClipBoard method.

    // This will have it so when the password is generated, it will take the StringBuilder and then copy it to your clipboard if you want to when the clipboard JDialog is pressed
</code>

<code>
    // Method for every 5 characters to add a - to the string.
    public static void addDashes(StringBuilder stringBuilder) {
        for (int i = 1; i < stringBuilder.length(); i++) {
            if (i % 5 == 0) {
                stringBuilder.insert(i, "-");
            }
        }
    } // End of addDashes method.

    // This will have it so when the password is generated, it will take the StringBuilder and then add a - to every 5 characters.
</code>
<br>

<code>
    // Main method
    public static void main(String[] args) {
        getAlphaNumericString(0);
        // Wakes up after 142 milliseconds.
        try {
            Thread.sleep(142);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    // This is the main method, it uses a thread timer so when the program is launched, it will eventually start after 142 ms.
</code>
  </p>