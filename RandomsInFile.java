import java.util.*;         // Needed for IOException
import java.io.*;           // Needed for File I/O classes

//By: Emil Flores / Assignment 3 / File with Random Numbers 

public class RandomsInFile {
    public static void main(String[] args) {
        String outFileName;      // Input File name
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);


        // Get the filename from the user
        System.out.print("Enter the filename to write into: ");
        outFileName = keyboard.nextLine();

        // Checking if the file already exists.
        File file = new File(outFileName);
        if (file.exists()) {
            System.out.println("The file " + outFileName +
                    " already exists. Will re-write its content");
        }

        int lowerLimit = 0; // First Number
        int upperLimit = 0; // Second Number

        // Get the user's input.
        boolean again = true;
        while (again) // input validation loop
        {
            System.out.print("Enter an integer number please: ");
            String str = keyboard.nextLine(); // get a string containing an int number
            str = str.trim(); // remove any extra whitespace from string sides

            try    // trying to convert string to integer, expecting exceptions
            {
                lowerLimit = Integer.parseInt(str);  // conversion.

                if (lowerLimit < 0) {
                    throw new IllegalArgumentException("The Numbers should be positive.");
                }
                // At this point exception may happen.
                // Exception will throw execution into the "catch" block right away
                //If conversion went well, execution continues to the next statement below
                again = false; // stop input validation loop
                // continue with the program
            } catch (Exception e) // handle the exception below
            {
                System.out.println("INPUT ERROR: Please enter a positive integer number!!");
                System.out.println(e.getMessage());
            }
        } // end of validation loop


        // Get the user's input.
        again = true;
        while (again) // input validation loop
        {
            System.out.print("Enter an integer number please: ");
            String str = keyboard.nextLine(); // get a string containing an int number
            str = str.trim(); // remove any extra whitespace from string sides

            try    // trying to convert string to integer, expecting exceptions
            {
                upperLimit = Integer.parseInt(str);  // conversion.

                if (upperLimit < 0) {
                    throw new IllegalArgumentException("The Numbers should be positive.");
                }
                // At this point exception may happen.
                // Exception will throw execution into the "catch" block right away
                //If conversion went well, execution continues to the next statement below
                again = false; // stop input validation loop
                // continue with the program
            } catch (Exception e) // handle the exception below
            {
                System.out.println("INPUT ERROR: Please enter a positive integer number!!");
                System.out.println(e.getMessage());
            }
        } // end of validation loop

        if (upperLimit < lowerLimit) {
            int temp = lowerLimit;
            lowerLimit = upperLimit;
            upperLimit = temp;
        }

        try {
            PrintWriter pw = new PrintWriter(file);
            Random r = new Random();

            for (int i = 0; i < 100; i++) {
                // num stores the number that is between upper and lower limit
                int num = lowerLimit + r.nextInt(upperLimit - lowerLimit + 1);
                // writing to the file
                pw.println(num);
            }
            pw.close();

        } catch (IOException e) { // File manipulations may cause IOExceptions , we would like to handle them
            System.out.printf("ERROR writing to file %s!",outFileName);
            System.out.printf("ERROR Message: %s!\n",e.getMessage());
        }
    }
}