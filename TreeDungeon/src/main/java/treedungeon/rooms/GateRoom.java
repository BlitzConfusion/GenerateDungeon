/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 *
 * Alkuhuone. Tästä Dungeon alkaa.
 */
public class GateRoom extends Room {

    /**
     * Note to self: poista vanhempi.
     * @param vanhempi
     * @param numero 
     */
    public GateRoom(int numero) {
        super(numero);
        roomType = "the Gate";
    }
    
}
