/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.treedungeon;

import java.util.Scanner;
import treedungeon.selfarray.IntArray;



/**
 *
 * Main-luokka genroinnin käynnistämiselle halutuilla parametreilla.
 */
public class TreeDungeon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Tree tree = treeGeneration();
        if (tree != null) {
            IntArray array = new IntArray(tree.getDungeonSize());
            tree.root.asetaVirta();
            for(int i = 0; i < tree.getDungeonSize(); i++) {
                array.lisaa(tree.getRoomDistance(i));
                
            }
            array.printInfo();
        }
    }
    /**
     * Metodi pyörittää generointia niin akuan kuin käyttäjä haluaa, jonka jälkeen
     * homma loppuu huoneiden etäisyyden Gatesta listaamiseen.
     * @return 
     */
    private static Tree treeGeneration() {
        Scanner reader = new Scanner(System.in);
        Tree tree = null;
        boolean jatka = true;
        System.out.println("Welcome to DungeonGenerator.");
        while (jatka) {
            System.out.println("Enter the number of Rooms: ");
            int n = readerNext();
            System.out.println("Enter the random seed: ");
            int m = readerNext();
            tree = new Tree(n, m);
            System.out.println("Your Dungeon has been Generated:");
            System.out.println("");
            tree.writeDungeon();
            System.out.println("");
            System.out.println("Press 0 to end, press anything else to begin anew: ");
            int k = readerNext();
            if (k == 0) {
                return tree;
            }
        }
        return tree;
    }
    private static int readerNext() {
        Scanner reader = new Scanner(System.in);
        while(!reader.hasNextInt()) {
                System.out.println("Incorrect input, try again.");
                reader.next();
            }
        return reader.nextInt();
    }
}
