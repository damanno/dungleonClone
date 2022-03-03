/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungleonclone;

/**
 *
 * @author xeldao
 */
public class DungleonClone {

    public static String[] cards = {"H1", "H2", "H3", "H4", "T1", "T2", "T3", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9"};
    public static String[] solution = {"", "", "", "", ""};
    public static int mistakes = 6;
    public static int attempts = 6;

    public static void main(String[] args) {
        // TODO code application logic here
        init();
    }

    public static void input() {

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
        solution[heroPlacer] = cards[(int) (Math.random() * (4 - 1))];
        solution[enemyPlacer] = cards[(int) (Math.random() * (cards.length - 8)+8)];

        //rnd void
        for (int i = 0; i < 5; i++) {
            if ("".equals(solution[i])) {
                solution[i] = cards[(int) (Math .random() * (cards.length - 8)+8)];
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(solution[i] +" ");
        }
        
        
        
    }

}
