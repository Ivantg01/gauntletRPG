package utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

/**
 * class to store several util functions
 *
 * @author Iván Torrijos
 *
 */

public class Utils {

    /**
     * Parses an integer from a String and control any exception
     * @param number number to convert
     * @return a valid integer converted from the String
     */
    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Writes in a text document the actual date and the sentence given
     * @param s String to save in the text document
     */
    public static void writeLog(String s){
        FileWriter fichero=null;
        PrintWriter pw=null;
        Date date = new Date();
        try {
            fichero = new FileWriter("Logs.txt",true);
            pw = new PrintWriter(fichero);
            pw.print(date);
            pw.println(" "+s);
            pw.flush();
            fichero.close();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
