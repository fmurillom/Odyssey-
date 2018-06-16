package HuffmanEncoder;

import java.awt.Toolkit;
import java.util.Scanner;

/**
 * Useful class with commonly used methods for console applications in Java
 *
 * @author Machetazo
 * @version 0.1 December 2016
 */
public class Console{

    /**
     * Writes stuff into console using println().
     *
     * Since the parameter is a string, that string is printed.
     *
     * @param text text that will be printed into console.
     */
    public static void write_(String text){
        System.out.println(text);
    }

    /**
     * Writes stuff into console using print().
     *
     * Since the parameter is a string, that string is printed.
     *
     * @param text text that will be printed into console.
     */
    public static void write(String text){
        System.out.print(text);
    }

    /**
     * Writes stuff into console using println().
     *
     * Since the parameter is a string and a valid ANSI color escape code, that string is printed in that color.
     *
     * @param text text that will be printed into hax.ads.console.
     * @param color color in which the text will be printed into console.
     */
    public static void write_(String text , String color){
        System.out.println(color + text + Res.ANSI_RESET);
    }

    /**
     * Writes stuff into console using print().
     *
     * Since the parameter is a string and a valid ANSI color escape code, that string is printed in that color.
     *
     * @param text text that will be printed into hax.ads.console.
     * @param color color in which the text will be printed into console.
     */
    public static void write(String text , String color){
        System.out.print(color + text + Res.ANSI_RESET);
    }

    /**
     * Writes stuff into console using println().
     *
     * Since parameters are left empty, a blank line is printed.
     */
    public static void write_(){
        System.out.println();
    }

    /**
     * Writes stuff into console using print().
     *
     * Since parameters are left empty, \t (whitespace) is printed.
     */
    public static void write(){
        System.out.print("\t");
    }

    /**
     * Writes stuff into console using println().
     *
     * Since the parameter is an int n, n blank lines are printed.
     *
     * @param blankLines amount of blank lines to be printed into console.
     */
    public static void write_(int blankLines){
        for(int i=0 ; i<blankLines ; i++) {
            System.out.println();
        }
    }

    /**
     * Writes stuff into console using print().
     *
     * Since the parameter is an int n, n \t's (whitespaces) are printed.
     *
     * @param whiteSpace amount of whitespace to print.
     */
    public static void write(int whiteSpace){
        for(int i=0 ; i<whiteSpace ; i++) {
            System.out.print("\t");
        }
    }

    /**
     * Gets a single-line string from console as user input.
     *
     * @return the single-line string entered by the user.
     */
    public static String inputLine(){
        Scanner input = new Scanner( System.in );
        String line = input.nextLine();
        return line;
    }

    /**
     * Gets a single-line string from console as user input.
     *
     * Since parameter is a string, that string is printed as a prompt for the user.
     *
     * @return the single-line string entered by the user.
     */
    public static String inputLine(String prompt){
        Scanner input = new Scanner( System.in );
        write(prompt + " ");
        String line = input.nextLine();
        return line;
    }

    /**
     * Gets a single-line string from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     *
     * @return the single-line string entered by the user.
     */
    public static String inputLine(String prompt , String color){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        String line = input.nextLine();
        return line;
    }

    /**
     * Gets a single-line string from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string, that string is printed as an answer to the user's input.
     *
     * @return the single-line string entered by the user.
     */
    public static String inputLine(String prompt , String color , String answer){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        String line = input.nextLine();
        write_();
        write_(answer);
        return line;
    }

    /**
     * Gets a single-line string from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string and a valid ANSI color escape code, that string is printed in that color as an answer to the user's input.
     *
     * @return the single-line string entered by the user.
     */
    public static String inputLine(String prompt , String color , String answer , String answerColor){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        String line = input.nextLine();
        write_();
        write_(answer , answerColor);
        return line;
    }

    /**
     * Gets an int from console as user input.
     *
     * @return the int entered by the user.
     */
    public static int inputInt(){
        Scanner input = new Scanner( System.in );
        int number = input.nextInt();
        return number;
    }

    /**
     * Gets an int from console as user input.
     *
     * Since parameter is a string, that string is printed as a prompt for the user.
     *
     * @return the int entered by the user.
     */
    public static int inputInt(String prompt){
        Scanner input = new Scanner( System.in );
        write(prompt + " ");
        int number = input.nextInt();
        return number;
    }

    /**
     * Gets an int from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     *
     * @return the int entered by the user.
     */
    public static int inputInt(String prompt , String color){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        int number = input.nextInt();
        return number;
    }

    /**
     * Gets an int from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string, that string is printed as an answer to the user's input.
     *
     * @return the int entered by the user.
     */
    public static int inputInt(String prompt , String color , String answer){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        int number = input.nextInt();
        write_();
        write_(answer);
        return number;
    }

    /**
     * Gets an int from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string and a valid ANSI color escape code, that string is printed in that color as an answer to the user's input.
     *
     * @return the int entered by the user.
     */
    public static int inputInt(String prompt , String color , String answer , String answerColor){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        int number = input.nextInt();
        write_();
        write_(answer , answerColor);
        return number;
    }

    /**
     * Gets a double from console as user input.
     *
     * @return the double entered by the user.
     */
    public static double inputDouble(){
        Scanner input = new Scanner( System.in );
        double number = input.nextDouble();
        return number;
    }

    /**
     * Gets a double from console as user input.
     *
     * Since parameter is a string, that string is printed as a prompt for the user.
     *
     * @return the double entered by the user.
     */
    public static double inputDouble(String prompt){
        Scanner input = new Scanner( System.in );
        write(prompt + " ");
        double number = input.nextDouble();
        return number;
    }

    /**
     * Gets a double from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     *
     * @return the double entered by the user.
     */
    public static double inputDouble(String prompt , String color){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        double number = input.nextDouble();
        return number;
    }

    /**
     * Gets a double from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string, that string is printed as an answer to the user's input.
     *
     * @return the double entered by the user.
     */
    public static double inputDouble(String prompt , String color , String answer){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        double number = input.nextDouble();
        write_();
        write_(answer);
        return number;
    }

    /**
     * Gets a double from console as user input.
     *
     * Since parameter is a string and a valid ANSI color escape code, that string is printed in that color as a prompt for the user.
     * Additionally, since parameters include another string and a valid ANSI color escape code, that string is printed in that color as an answer to the user's input.
     *
     * @return the double entered by the user.
     */
    public static double inputDouble(String prompt , String color , String answer , String answerColor){
        Scanner input = new Scanner( System.in );
        write(prompt + " " , color);
        double number = input.nextDouble();
        write_();
        write_(answer , answerColor);
        return number;
    }

    /**
     * Clears the console.
     * Doesn't work during runtime for some reason.
     */
    public static void flush(){
        System.out.print(" \033[H\033[2J");
        System.out.flush();
    }

    /**
     * Ends the application.
     */
    public static void kill(){
        System.exit(0);
    }

    /**
     * Plays an alert sound.
     */
    public static void beep(){
        Toolkit.getDefaultToolkit().beep();
    }

    /**
     * Generates a nice, simple header for a console app.
     *
     * @param title title of the header
     */
    public static void header(String title) {

        int titleLength = title.length() + 2;

        write(3);
        for (int i = 0; i < (titleLength * 3); i++) {
            write("$", Res.ANSI_GREEN);
        }
        write_();
        write(3);
        for (int i = 0; i < titleLength; i++) {
            write("$", Res.ANSI_GREEN);
        }
        write(" " + title + " ", Res.ANSI_WHITE);
        for (int i = 0; i < titleLength; i++) {
            write("$", Res.ANSI_GREEN);
        }
        write_();
        write(3);
        for (int i = 0; i < (titleLength * 3); i++) {
            write("$", Res.ANSI_GREEN);
        }
        write_();
    }

    /**
     * Generates a nice, simple header for a console app.
     *
     * Supports ANSI colors for the title.
     *
     * @param title title of the header.
     * @param color color fo the title.
     */
    public static void header(String title , String color){

        int titleLength = title.length() + 2;

        write(3);
        for(int i=0 ; i<(titleLength*3) ; i++){
            write("$" , Res.ANSI_GREEN);
        }
        write_();
        write(3);
        for(int i=0 ; i<titleLength ; i++){
            write("$" , Res.ANSI_GREEN);
        }
        write(" " + title + " " , color);
        for(int i=0 ; i<titleLength ; i++){
            write("$" , Res.ANSI_GREEN);
        }
        write_();
        write(3);
        for(int i=0 ; i<(titleLength*3) ; i++){
            write("$" , Res.ANSI_GREEN);
        }
        write_();
    }

}
