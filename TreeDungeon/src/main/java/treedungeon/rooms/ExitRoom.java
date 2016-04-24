/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 *
 * Viimeisenä lisättävä huone. Dungeon alustavasti valmis tämän jälkeen.
 */
public class ExitRoom extends Room {

    /**
     * 
     * Huone on ilmeisesti aina oleellinen läpikulun kannalta. Täten dungeon = true.
     */
    public ExitRoom(int numero, int paino) {
        super(numero, paino);
        roomType = "the Exit";
        dungeon = true;
    }
    
}
