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
public class ArmouryRoom extends Room {

    public ArmouryRoom(int numero) {
        super(numero);
        roomType = "Armoury";
    }
    
}
