package com.basic;

import java.util.Scanner;


public class Util {
    static Scanner scan = new Scanner(System.in);

    static String input(String kalimat){
        System.out.print(kalimat + " : ");
        String input = scan.nextLine();
        return input;
    }

    static boolean getYes(String kalimat){
        boolean isYes = false;

        System.out.print("\n" + kalimat + "? (y/n) : " );
        String userInput = scan.nextLine();

        while(!isYes) {
            if (userInput.equalsIgnoreCase("y")) {
                isYes = true;
                break;
            } else if (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
                System.out.println("Input anda tidak valid, mohon masukkan dengan benar.\n");

                System.out.print("\n" + kalimat + "? (y/n) : " );
                userInput = scan.nextLine();
            }else{
                return isYes;
            }
        }
        return isYes;
    }

    static void clearConsole(){
        try {
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else{
                System.out.println("\033\143");
            }
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
