import java.util.Scanner;
import java.util.regex.Matcher;
public class Lab_08_GetMethodical
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String firstName = getNonZeroLengthString(in, "Enter your first name ");
        System.out.println("\n You said your first name was: " + firstName);
        boolean confirm = getYNConfirm(in, "Enter a Y/N to continue: ");

         int num = getInt(in, "Enter a number");
        System.out.println("You said the number is: " + num);

        /**double num = getDouble(in,"Enter any real number");
        System.out.println("\n You said your number was:" + num);

        int val = getRangedInt(in,"Enter a number between"  ,25, 100);
        System.out.println("You said your number was:" + val);

        double val = getRangedDouble(in, "Enter a number between" , 2, 375);
        System.out.println("\nYou said your number was:" + val);

        String phone = getRegExString(in, "Enter your phone number", "^\\d{3}-\\d{3}-\\d{4}$");
        System.out.println("You said your phone number was:" + phone);*/

    }
        //End of Main

    //Method definitions

    /**
     * Gets a string from the user that has to be at least one character or more
     *
     * @param pipe Scanner to use for input set to the console with System.in
     * @param prompt the prompt for the user the methods adds ":" and uses System.print
     *               ranged methods get a "...[low - high]:"
     * @return After looping until the user enters something a non zero String...
     */
    public static String getNonZeroLengthString(Scanner pipe, String prompt)
    {
        String nonZeroLength = "";

        do {
            System.out.print("\n" + prompt +":");
            nonZeroLength = pipe.nextLine();

            if(nonZeroLength.length() == 0)

            {
                System.out.println("\nYou must provide some valid input");
            }

        }while (nonZeroLength.length() == 0);

        return nonZeroLength;

    }

    /** Gets a valid integer or real number
     *
     * @param pipe Scanner the user has for input
     * @param prompt is the information the user is prompted for
     * @return is good information that was input by the user
     */

   public static int  getInt(Scanner pipe, String prompt) {
       int value = 0;
       String trash = "";
       boolean done = false;

       do {

           System.out.print("\n" + prompt + ":");

           if (pipe.hasNextInt()) {
               value = pipe.nextInt();
               pipe.nextLine(); //Clearing the buffer
               done = true; // if user puts in valid input

           } else {
               trash = pipe.nextLine();
               System.out.println("\nYou must enter a valid number: " + trash);  // only if the user puts in invalid input
           }
       } while (!done);

       return value;
   }

    /** Gets a valid double integer, real number, or decimal
     *
     * @param pipe Scanner the user has for input
     * @param prompt is the information the user is prompted for
     * @return is good information that was input by the user
     */

    public static double  getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        String trash = "";
        boolean done = false;

        do {

            System.out.print("\n" + prompt + ":");

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); //Clearing the buffer
                done = true; // if user puts in valid input

            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid number: " + trash);  // only if the user puts in invalid input
            }
        } while (!done);

        return value;
    }

    /**
     * Get a number within a range
     * @param pipe Scanner the user needs for input
     * @param prompt information that user needs to enter
     * @param low lowest part of the range
     * @param high highest part of the range
     *  return only happens if user gives good input
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); //Clears the buffer
                if (value >= low && value <= high)
                    done = true;
                else
                    System.out.println("\nYou entered a number out of range [" + low + " - " + high + "] not: " +value);

            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid number not: " + trash);
            }
        }while (!done);

        return value;
    }
    /**
     * Get a valid double integer, number or decimal within a range
     * @param pipe Scanner the user needs for input
     * @param prompt information that user needs to enter
     * @param low lowest part of the range
     * @param high highest part of the range
     *  return only happens if user gives good input
     */
    public static double getRangedDouble(Scanner pipe, String prompt, int low, int high)
    {
        double value = 0.0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); //Clears the buffer
                if (value >= low && value <= high)
                    done = true;
                else
                    System.out.println("\nYou entered a number out of range [" + low + " - " + high + "] not: " +value);

            } else {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid number not: " + trash);
            }
        }while (!done);

        return value;
    }

    /**
     * Gets a string within a pattern
     * @param pipe Gets the input from the user
     * @param prompt Tells the user the information that is needed
     * @param regExPattern is the pattern of the information that is needed
     * return only if the user provides valid input
     */

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String info = "";
        boolean haveInfo = false;

        do {

            System.out.print(prompt + ":");
            //input data and test if it is correct
            info = pipe.nextLine();
            if (info.matches(regExPattern)) {
                haveInfo = true;
            } else {
                System.out.println("\nEnter valid information and not: " + info);
            }

        }while(!haveInfo);

        return info;

    }

    /**
     * Gets Y/N to continue whether it is upper or lower case
     *
     * @param pipe This gets the users input
     * @param prompt This prompts the user for the input
     *
     */

    public static boolean getYNConfirm(Scanner pipe, String prompt)

    {
        final String opt1 = "y";
        final String opt2 = "n";
        boolean done = false;


        do{
            System.out.print(prompt +  "["+ opt1 + "/" + opt2 + "]:");
             String ans = pipe.nextLine();
             if(opt1.equalsIgnoreCase(ans)) {
                 done = true;
             }else if
             (opt2.equalsIgnoreCase(ans)){

                   break;}



        }while (!done);


        return done;
    }
}

