/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.selfarray;

/**
 * Tämä luokka säilöö tiedon siitä kuinka kaukana gatesta kukin huone on.
 * Listalla on maksimikoko jottei tapahdu yllätyksiä huoneiden määrässä.
 * Listalla on nykyinen koko kertomassa paljonko sisältöä on nyt.
 */
public class IntArray {
    private final int maxSize;
    private int size = 0;
    private final int[] array;

    /**
     * Konstruktori
     * @param huonemaara kertoo minkä kokoista Arrayta halutaan.
     */
    public IntArray(int huonemaara) {
        maxSize = huonemaara;
        array = new int[huonemaara];
    }
    /**
     * Lisää luvun Array:hyn
     * @param etaisyys on lisättävä luku.
     * @throws Exception jos Array on jo täynnä. Näin ei pitäisi voida käydä.
     */
    public void lisaa(int etaisyys) throws Exception {
        if (size >= maxSize) {
            throw new Exception("IntArray on täynnä jo, sinulla on liikaa huoneita");
        }
        array[size++] = etaisyys;

    }
    /**
     * Palauttaa arvon haetulta paikalta. Nimetty huoneeksi, koska konteksti.
     * @param huone on paikka jolta lukua haetaan.
     * @return luku joka paikalta saatiin.
     */
    public int get(int huone) {
        if (huone < 0 || huone >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[huone];
    }
    /**
     * Palauttaa nykyisen koon Arraylle.
     * @return koko.
     */
    public int size() {
        return size;
    }
    /**
     * Printtaa auki etäisyydet.
     */
    public void printInfo() {
        for (int i = 0; i < size; i++) {
            System.out.println("Huone numero " + i + " on " + get(i) + 
                    ":n käytävän päässä Gatesta.");
        }
    }
    
}
