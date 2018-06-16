package HuffmanEncoder;

/**
 * Resources for all the classes in this jar.
 *
 * @author Machetazo
 * @version 0.1 December 2016
 */
public class Res{

    /**
     * ANSI color escape codes.
     */
    /** Reset color. */
    public static final String ANSI_RESET = "\u001B[0m";
    /** Black. */
    public static final String ANSI_BLACK = "\u001B[30m";
    /** Red. */
    public static final String ANSI_RED = "\u001B[31m";
    /** Green. */
    public static final String ANSI_GREEN = "\u001B[32m";
    /** Yellow. */
    public static final String ANSI_YELLOW = "\u001B[33m";
    /** Blue. */
    public static final String ANSI_BLUE = "\u001B[34m";
    /** Purple. */
    public static final String ANSI_PURPLE = "\u001B[35m";
    /** Cyan. */
    public static final String ANSI_CYAN = "\u001B[36m";
    /** White. */
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Message types. Used by the JOptionPane to determine what icon to display
     * and possibly what behavior to give based on the type.
     */
    /** Used for error messages. */
    public static final int  ERROR_MESSAGE = 0;
    /** Used for information messages. */
    public static final int  INFORMATION_MESSAGE = 1;
    /** Used for warning messages. */
    public static final int  WARNING_MESSAGE = 2;
    /** Used for questions. */
    public static final int  QUESTION_MESSAGE = 3;
    /** No icon is used. */
    public static final int   PLAIN_MESSAGE = -1;

}
