/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 * Huoneiden abstrakti luokka.
 * level kertoo kuinka monennes kerros on kyseessä;
 * type antaa stringin aukikirjoitukselle huonetyypistä;
 * parent kertoo vanhemman, jos viittaus poistetaan, yksisuuntainen kulku.
 * lapsi1 oikea oksa, lapsi2 vasen oksa, extra antaa lisäreitin.
 * way kertoo kummalle lapselle seuraavaksi lisätään (tavoitteena sovellettu
 * leveys-lisäys). Way:ta käytetään myöhemmin löytämään ylimääräisten reittien 
 * lisäyskohtia yhdessä level:n kanssa.
 * Dungeon tapahtuu kun ollaan lisäämässä exittiä. Pikareittejä ja-tai reitin-
 * poistoja ei haluta tälle linjalle ilman vakuuksia.
 */
 abstract class Room {
    int level;
    int number;
    String roomType;
    Room parent;
    Room lapsi1;
    Room lapsi2;
    Room extra;
    boolean way;
    boolean dungeon;
    
    /**
     * 
     * @param vanhempi antaa tiedon mikä huone on välittömin juuri.
     * @param numero antaa tiedon kuinka mones huone on kyseessä.
     */
    public Room(int numero) {
        number = numero;
        way = true;
        dungeon = false;
    }
    /**
     * setChild pakottaa huoneen laittamaan itselleen lapsen tai delegoimaan
     * tämän tehtävän jollekin omistaan. Way toimii virranjakajana.
     * @param uusi on lisättävä huone.
     */
    public void setChild(Room uusi){
        if (uusi.getType().equals("the Exit")) {
            dungeon = true;
        }
        if (lapsi1 == null) {
            lapsi1 = uusi;
            lapsi1.setParent(this);
            way = false;
        } else if (lapsi2 == null) {
            lapsi2 = uusi;
            lapsi2.setParent(this);
            way = true;
        } else if (way) {
            lapsi1.setChild(uusi);
            way = false;
        } else {
            lapsi2.setChild(uusi);
            way = true;
        }
    }
    /**
     * antaa tiedon kuinka syvällä ollaan. Lisäreiteille kiinnostavaa.
     * @return level, eli kuinka syvällä mennään.
     */
    public int getLevel() {
        return level;
    }
    /**
     * Antaa takaisin stringin huoneen tyypistä.
     * @return roomType String.
     */
    public String getType() {
        return roomType;
    }
    
    /**
     * Asettaa vanhemman uudelle huoneelle.
     * @param vanhempi on huone joka asetetaan vanhemmaksi.
     */
    public void setParent(Room vanhempi) {
        parent = vanhempi;
    }
    /**
     * Kertoo josko huone on oleellinen uloskäyntien välikululle.
     * @return vastaus tähän kysymykseen.
     */
    public boolean isBetweenExits() {
        return dungeon;
    }
    /**
     * Toimii aukikirjoittajana printInfo:n kanssa.
     */
    public void kulje (){
        printInfo();
        if (lapsi1 != null){
            lapsi1.kulje();
        }
        
        if (lapsi2 != null){
            lapsi2.kulje();
        }
        
    }
    /**
     * Poistaa tältä huoneelta tiedon kuka on vanhempi. Väylä ei toiminnassa
     * tähän suuntaan enää.
     */
    public void killParent(){
        parent = null;
    }/**
     * palauttaa huoneen seuraavan virtaussuunnan. Ei välttämättä tarpeellinen.
     * @return virtaussuunta.
     */
    public boolean getWay() {
        return way;
    }
    /**
     * Tämä metodi kirjoittaa auki muodostetun Dungeonin. Ei vielä huomioi
     * onko reitti auki juuren suuntaan.
     */
    public void printInfo() {
        System.out.print("Room " + number + " is " + roomType + " which leads to " );
        if ("the Exit".equals(roomType)) {
            System.out.print("away from this Dungeon Complex");
        } else {
            if (lapsi1 == null) {
                System.out.print("nowhere");
            } else {
                System.out.print("room " + lapsi1.number + ", which is " 
                        + lapsi1.getType());
            }
            if (lapsi2 != null) {
                System.out.print("; and room " + lapsi2.number + ", which is "
                        + lapsi2.getType());
            }
            if (extra != null) {
                System.out.print("; and room" + extra.number + ", which is "
                        + extra.getType());
            }
            
        }
        System.out.println(".");
    }
}
