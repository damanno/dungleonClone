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

    public static String[] cards = {"H1", "H2", "H3", "T1", "T2", "E1", "E2", "E3", "E4", "E5"};
    public static String[] solution = {"", "", "", "", ""};
    public static String[][] answers;
    public static int mistakes = 6;
    public static int attempts = 6;

    public static void main(String[] args) {
        // TODO code application logic here
        init();
        
        
        /*
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Entre com a  carta");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName); 
        */
    }
    
    //Show options
    public static void printOptions() {
    
    }
    
    public static void gameOver() {
    
    }
    
    public static void rules() {
    
    }
    
    public static void score() {
    
    }
    
    public static void input() {
        
    }

    public static void check() {
        
    }
    
    public static void tip() {
        
    }

    public static void init() {
        boolean ready = false;
        int heroPlacer = (int) (Math.random() * (solution.length - 1));
        int enemyPlacer = heroPlacer;
        while (enemyPlacer == heroPlacer) {
            enemyPlacer = (int) (Math.random() * (solution.length - 1));
        }
        solution[heroPlacer] = cards[(int) (Math.random() * (3 - 1))];
        solution[enemyPlacer] = cards[(int) (Math.random() * (cards.length - 5)+5)];

        //rnd void
        for (int i = 0; i < 5; i++) {
            if ("".equals(solution[i])) {
                solution[i] = cards[(int) (Math .random() * (cards.length))];
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(solution[i] +" ");
        }
    }

}
