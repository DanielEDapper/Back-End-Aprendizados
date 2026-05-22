package org.example.Util;

import java.util.Scanner;

public class ViewUtil {
    private static Scanner SC = new Scanner(System.in);

    public static String lerString()
    {
        String valor = SC.nextLine();

        return valor;
    } 
    public static int lerInt()
    {
        int valor = SC.nextInt();
        SC.nextLine();

        return valor;
    } 
    public static double lerDouble()
    {
        double valor = SC.nextDouble();
        SC.nextLine();

        return valor;
    } 
}
