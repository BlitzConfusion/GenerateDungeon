/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 *
 * Viimeisenä lisättävä huone. Dungeon alustavasti valmis tämän jälkeen.
 */
public class ExitRoom extends Room {

    public ExitRoom(int numero) {
        super(numero);
        roomType = "the Exit";
    }
    
}
