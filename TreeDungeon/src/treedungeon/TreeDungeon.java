/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon;



/**
 *
 * Main-luokka genroinnin käynnistämiselle halutuilla parametreilla.
 */
public class TreeDungeon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree tree = new Tree(15, 0);
        tree.writeDungeon();
    }
    
    
}
