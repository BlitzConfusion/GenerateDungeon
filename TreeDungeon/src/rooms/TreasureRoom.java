/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 *
 * Harvinainen huone. Ei muuta erikoista.
 */
public class TreasureRoom extends Room {

    public TreasureRoom(int numero, int paino) {
        super(numero, paino);
        roomType = "Treasury";
    }
    
}
