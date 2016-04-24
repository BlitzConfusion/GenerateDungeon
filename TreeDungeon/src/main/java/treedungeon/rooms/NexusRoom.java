/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 *
 * Erikoishuone. Laitetaan vain yksi dungeoniin.
 */
public class NexusRoom extends Room {

    public NexusRoom(int numero, int paino) {
        super(numero, paino);
        roomType = "the Nexus";
    }
    
}
