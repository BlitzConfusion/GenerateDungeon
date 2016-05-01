/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 *
 * Yleisin huonetyyppi. Ei erikoisuuksia.
 */
public class FarmRoom extends Room {

    public FarmRoom(int numero) {
        super(numero);
        roomType = "Farm";
    }
    
}
