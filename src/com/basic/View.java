package com.basic;

import java.util.Arrays;

import static com.basic.Operation.*;
import static com.basic.Util.*;

public class View {

    static void viewShowTodo(){
        boolean isYes = true;
        boolean isValid = true;

        do{

            Util.clearConsole();
            System.out.println("\n----- Todo App -----");

            showTodo();

            System.out.println("\nMenu :" +
                    "\n1. Add Todo" +
                    "\n2. Delete Todo" +
                    "\n3. Exit");
            String userInput = input("Masukkan Pilihan Anda");

            switch (userInput) {
                case "1" -> {
                    viewAddTodo();
                }
                case "2" -> {
                    viewDeleteTodo();
                }
                case "3", "x" ->{
                    System.out.println("good bye...");
                    isYes = false;
                    break;
                }
                default -> {
                    System.out.println("Input anda tidak valid\n");
                }
            }
        }while(isYes);
    }

    static void viewAddTodo() {
        System.out.println("\nADD TODO");

        boolean isContinue = true, isValid = false;
        while (isContinue) {
            String kegiatan = input("Masukkan Kegiatan (tekan x jika batal)");

            if (!kegiatan.equalsIgnoreCase("x")) {
                addTodo(kegiatan);
                isValid = true;
            } else {
                System.out.println("dibatalkan...");
                return;
            }

            if (isValid) {
                isContinue = getYes("tambah lagi");
            }
        }
        System.out.println("Data ditambahkan");
    }

    static void viewDeleteTodo(){
        System.out.println("\nDELETE TODO");

        boolean isContinue = true, isValid = false, isNull = false;
        String[] temp = getData();

        while(isContinue) {

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    isNull = false;
                    break;
                }else{
                    isNull = true;
                }
            }

            if (!isNull) {

                showTodo();
                String input = input("Masukkan nomor kegiatan (tekan x jika batal)");

                if (!input.equalsIgnoreCase("x")) {
                    int index = Integer.parseInt(input);
                    deleteTodo(index);
                    isValid = true;

                } else {
                    System.out.println("dibatalkan...");
                    return;
                }

                if (isValid) {
                    for (int i = 0; i < temp.length; i++) {
                        if (temp[i] != null) {
                            isNull = false;
                            break;
                        } else {
                            isNull = true;
                        }
                    }
                    if (!isNull) {
                        isContinue = getYes("hapus lagi");
                    }
                }else{
                    return;
                }

            }else{
                System.out.println("Data tidak ditemukan");
                return;
            }
        }
        System.out.println("Data dihapus");
    }







}
