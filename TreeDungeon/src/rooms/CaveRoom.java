/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 * Huonetyyppi. Laitetaan jos mitään muuta ei jäljellä tai epävalideja.
 *
 */
public class CaveRoom extends Room {

    public CaveRoom(int numero, int paino) {
        super(numero, paino);
        roomType = "Cave";
    }
    
}
