/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 * Huonetyyppi. Laitetaan jos mitään muuta ei jäljellä tai epävalideja.
 *
 */
public class CaveRoom extends Room {

    public CaveRoom(int numero) {
        super(numero);
        roomType = "Cave";
    }
    
}
