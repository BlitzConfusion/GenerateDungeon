/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 * Huonetyyppi. Ei erikoisuuksia.
 * 
 */
public class BarracksRoom extends Room {

    public BarracksRoom(int numero, int paino) {
        super(numero, paino);
        roomType = "Barracks";
    }
    
}
