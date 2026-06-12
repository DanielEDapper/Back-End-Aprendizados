package com.example.Util;

import java.util.Scanner;

public class Ferramentas 
{

    static Scanner ler = new Scanner(System.in);
    // ------ FAZ INPUT DE DOUBLE E RETORNA ------ //
    public static double lDouble() {

        try {
            double num = ler.nextDouble();
            ler.nextLine();

            return num;
        }catch (Exception e) {

            ler.nextLine(); // Esvazia o buffer

            throw e;
        }
    }

    // ------ FAZ INPUT DE STRING E RETORNA ------ //
    public static String lString() {

        try {
            String t = ler.nextLine();

            return t;
        }catch (Exception e){
            ler.nextLine();

            throw e;
        }
    }

    // ------ FAZ INPUT DE INTEIRO E RETORNA ------ //
    public static int lInteiro() {
        try{
            int num = ler.nextInt();
            ler.nextLine();

            return num;
        } catch(Exception e) {
            ler.nextLine();

            throw e;
        }
    }

    public static String limpaTerminal()
    {
        for(int i = 0; i <= 49; i++)
        {
            return " ";
        }
    }
}
