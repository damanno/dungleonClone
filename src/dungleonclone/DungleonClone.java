/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungleonclone;

import java.util.Scanner;

/**
 *
 * @author xeldao
 */
public class DungleonClone {

    public static String[] cards = {"H1", "H2", "H3", "T1", "T2", "E1", "E2", "E3", "E4"};
    public static String[] solution = {"", "", "", "", ""};
    public static String[][] answers;
    public static int mistakes = 6;
    public static int attempts = 0;
    public static int score = 0;
    public static boolean win = false;

    public static void main(String[] args) {
        // TODO code application logic here
        answers = new String[mistakes][solution.length];
        init();
        rules();
        while (attempts < mistakes) {
            printOptions();
            input();
            check();
            score();
            attempts++;
            System.out.println();
            if (win) {
                attempts = mistakes + 1;
            }
        }
        end();

    }

    //Show options
    public static void printOptions() {
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
        for (int i = 1; i <= cards.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void rules() {
        System.out.println("You have to guess the cards and the disposition of a set");
        System.out.println("RULES: ");
        System.out.println("If the card exists in the set, it will print an ? on its side");
        System.out.println("If the card exists and is in the right place, it will print an * on its side");
        System.out.println("If the card exists does not belong to the set, it will print an X on its side");
        System.out.println("If the card appears more than 1 time, it will print an NUMBER OF TIMES on its side");
    }

    public static void score() {

    }

    public static String errorInput() {
        return "Enter a valid number from 1 to " + cards.length;
    }

    public static void input() {
        int i = 0;
        while (i < 5) {
            Scanner number = new Scanner(System.in);
            System.out.println("Enter card number " + i + " : ");

            int card = 0;
            String userInput = number.nextLine();
            try {
                card = Integer.parseInt(userInput);
                if (card > 0 && card < 10) {
                    System.out.println("Card picked is: " + cards[card - 1]);
                    answers[attempts][i] = cards[card - 1];
                    i++;
                } else {
                    System.out.println(errorInput());
                }
            } catch (Exception e) {
                System.out.println(errorInput());
            }

        }
    }

    public static void end() {
        score();
        if (win) {
            win();
        } else {
            gameOver();
        }
    }

    public static void gameOver() {
        System.out.println("GAME OVER! "); 
        System.out.println("BETTER LUCK NEXT TIME ! " + score); 
    }

    public static void win() {
        System.out.println("YOU DID IT! " + score); 
    }

    public static void check() {
        System.out.println("YOUR CHOISES WERE : ");
        contains();
        System.out.println();
    }

    public static void contains() {
        String result = "x";
        int repeat = 0;
        int winner = 0;
        for (int flag = 0; flag < solution.length; flag++) {
            repeat = 0;
            result = "";
            for (int i = 0; i < solution.length; i++) {
                if (answers[attempts][flag].equals(solution[i])) {
                    repeat++;
                    if (flag == i) {
                        repeat = 0;
                        winner++;
                        result = "*";
                        score += (100*(mistakes-attempts));
                    } else {
                        result = "?";
                        score += (10*(mistakes-attempts));
                    }
                }
            }
            System.out.print(" " + (repeat > 1 ? repeat : "") + result + answers[attempts][flag] + " ");
        }
        win = winner == attempts-1;
    }

    public static void init() {
        boolean ready = false;
        int heroPlacer = (int) (Math.random() * (solution.length - 1));
        int enemyPlacer = heroPlacer;
        while (enemyPlacer == heroPlacer) {
            enemyPlacer = (int) (Math.random() * (solution.length - 1));
        }
        solution[heroPlacer] = cards[(int) (Math.random() * (3 - 1))];
        solution[enemyPlacer] = cards[(int) (Math.random() * (cards.length - 5) + 5)];

        //rnd void
        for (int i = 0; i < 5; i++) {
            if ("".equals(solution[i])) {
                solution[i] = cards[(int) (Math.random() * (cards.length))];
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println();
    }

}
