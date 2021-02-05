package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder[] sachovnice =
                {       new StringBuilder("⬜⚪⬜⚪⬜⚪⬜⚪"),
                        new StringBuilder("⚪⬜⚪⬜⚪⬜⚪⬜"),
                        new StringBuilder("⬜⚪⬜⚪⬜⚪⬜⚪"),
                        new StringBuilder("⬛⬜⬛⬜⬛⬜⬛⬜"),
                        new StringBuilder("⬜⬛⬜⬛⬜⬛⬜⬛"),
                        new StringBuilder("⚫⬜⚫⬜⚫⬜⚫⬜"),
                        new StringBuilder("⬜⚫⬜⚫⬜⚫⬜⚫"),
                        new StringBuilder("⚫⬜⚫⬜⚫⬜⚫⬜")
                };
        StringBuilder[] sachovnice2 =
                {       new StringBuilder("⬜⬛⬜⬛⬜⬛⬜⬛"),
                        new StringBuilder("⬛⬜⬛⬜⬛⬜⬛⬜"),
                        new StringBuilder("⬜⬛⬜⬛⬜⬛⬜⚪"),
                        new StringBuilder("⬛⬜⬛⬜⬛⬜⬛⬜"),
                        new StringBuilder("⬜⬛⬜⬛⬜⬛⬜⬛"),
                        new StringBuilder("⬛⬜⬛⬜⬛⬜⬛⬜"),
                        new StringBuilder("⬜⬛⬜⬛⬜⬛⬜⚫"),
                        new StringBuilder("⬛⬜⬛⬜⬛⬜⬛⬜")
                };
        print_dama(sachovnice);
        int s1;
        int r1;
        int s2;
        int r2;

        boolean pokracuj = true;

        while (pokracuj){
            boolean platne = true;
            do {
                do{
                    System.out.println("bílý hráč zadá souřadnice figurky");
                    platne = true;
                    r1 = sc.nextInt();
                    s1 = sc.nextInt();
                    if (s1 < 1 || s1 > 8 || r1 < 1 || r1 > 8){
                        System.out.println("neplatný tah");
                        platne = false;
                    }
                    if (platne){
                        if (sachovnice[r1-1].charAt(s1-1) != '⚪'){
                            System.out.println("na této pozici není figurka");
                            platne = false;
                        }
                    }
                }while (!platne);
                //do {
                    platne = true;
                    System.out.println("bílý hráč zadá kam táhne");
                    r2 = sc.nextInt();
                    s2 = sc.nextInt();
                    if (s2 < 1 || s2 > 8 || r2 < 1 || r2 > 8 || r2 < r1){
                        System.out.println("neplatný tah");
                        platne = false;
                    }
                    if (platne){
                        if (sachovnice[r2-1].charAt(s2-1) != '⬛'){
                            System.out.println("na tuto pozici nelze táhnout");
                            platne = false;
                        }
                        if (Math.abs(r1-r2)!=1||Math.abs(s1-s2)!=1){
                            if (r1 - r2 == - 2 && s1 - s2 == 2){
                               if (sachovnice[r1].charAt(s1 - 2) == '⚫'){
                                   sachovnice[r1].setCharAt(s1 - 2,'⬛');
                               }
                            }
                            else if (r1 - r2 == - 2 && s1 - s2 == - 2){
                                if (sachovnice[r1].charAt(s1) == '⚫'){
                                    sachovnice[r1].setCharAt(s1,'⬛');
                                }
                            }
                            else {
                                System.out.println("na tuto pozici nelze táhnout");
                                platne = false;
                            }
                        }
                    }
            }while (!platne);

            sachovnice[r1 - 1].setCharAt(s1 - 1,'⬛');
            sachovnice[r2 - 1].setCharAt(s2 - 1,'⚪');
            print_dama(sachovnice);
            if (Vyhral(sachovnice,"bily")){
                pokracuj = false;
                System.out.println("Vyhrál bílý hráč");
            }
            if (pokracuj) {

                do {
                    do {
                    System.out.println("černý hráč zadá souřadnice figurky");
                    platne = true;
                    r1 = sc.nextInt();
                    s1 = sc.nextInt();
                    if (s1 < 1 || s1 > 8 || r1 < 1 || r1 > 8) {
                        System.out.println("neplatný tah");
                        platne = false;
                    }
                    if (platne) {
                        if (sachovnice[r1 - 1].charAt(s1 - 1) != '⚫') {
                            System.out.println("na této pozici není figurka");
                            platne = false;
                        }
                    }
                } while (!platne);
                //do {
                    platne = true;
                    System.out.println("černý hráč zadá kam táhne");
                    r2 = sc.nextInt();
                    s2 = sc.nextInt();
                    if (s2 < 1 || s2 > 8 || r2 < 1 || r2 > 8 || r1 < r2) {
                        System.out.println("neplatný tah");
                        platne = false;
                    }
                    if (platne) {
                        if (sachovnice[r2 - 1].charAt(s2 - 1) != '⬛') {
                            System.out.println("na tuto pozici nelze táhnout");
                            platne = false;
                        }
                        if (Math.abs(r1 - r2) != 1 || Math.abs(s1 - s2) != 1) {
                            if (r1 - r2 == 2 && s1 - s2 == -2) {
                                if (sachovnice[r1 - 2].charAt(s1) == '⚪') {
                                    sachovnice[r1 - 2].setCharAt(s1, '⬛');
                                }
                            } else if (r1 - r2 == 2 && s1 - s2 == 2) {
                                if (sachovnice[r1 - 2].charAt(s1 - 2) == '⚪') {
                                    sachovnice[r1 - 2].setCharAt(s1 - 2, '⬛');
                                }
                            } else {
                                System.out.println("na tuto pozici nelze táhnout");
                                platne = false;
                            }
                        }
                    }
                } while (!platne);
                sachovnice[r1 - 1].setCharAt(s1 - 1, '⬛');
                sachovnice[r2 - 1].setCharAt(s2 - 1, '⚫');
                print_dama(sachovnice);
                if (Vyhral(sachovnice, "cerny")) {
                    pokracuj = false;
                    System.out.println("Vyhrál černý hráč");
                }
            }
        }
    }
    public static void print_dama(StringBuilder[] sachovnice){
        System.out.println("⬜ ❶❷❸❹❺❻❼❽");
        for (int i = 0; i < 8; i++) {
            if (i == 0){
                System.out.print("⓵ ");
            }
            if (i == 1){
                System.out.print("⓶ ");
            }
            if (i == 2){
                System.out.print("⓷ ");
            }
            if (i == 3){
                System.out.print("⓸ ");
            }
            if (i ==4){
                System.out.print("⓹ ");
            }
            if (i == 5){
                System.out.print("⓺ ");
            }
            if (i == 6){
                System.out.print("⓻ ");
            }
            if (i == 7){
                System.out.print("⓼ ");
            }

            System.out.println(sachovnice[i]);
        }
    }
    public static boolean Vyhral(StringBuilder[] sachovnice, String hrac){
        int pocetbilych = 0;
        int pocetcernych = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sachovnice[i].charAt(j) == '⚫'){
                    pocetcernych++;
                }
                if (sachovnice[i].charAt(j) == '⚪'){
                    pocetbilych++;
                }
            }
        }
        if (hrac == "bily"){
            if (pocetcernych == 0){
                return true;
            }
            else return false;
        }
        else if (pocetbilych == 0){
            return true;
        }
        else return false;
    }
}
