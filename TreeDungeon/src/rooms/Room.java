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
    int level = 0;
    int number;
    String roomType;
    int weight = 0;
    Room parent;
    Room lapsi1;
    Room lapsi2;
    Room extra;
    boolean way;
    boolean dungeon;
    
    /**
     * @param numero antaa tiedon kuinka mones huone on kyseessä.
     * @param paino antaa tiedon kuinka "arvokas" huone on.
     */
    public Room(int numero, int paino) {
        number = numero;
        way = true;
        dungeon = false;
        weight = paino;
        roomType = "void";
    }
    /**
     * setChild pakottaa huoneen laittamaan itselleen lapsen tai delegoimaan
     * tämän tehtävän jollekin omistaan. Way toimii virranjakajana.
     * Lisätessään katsoo että oksista välittömästi painavampi on "keskemmällä".
     * @param uusi on lisättävä huone.
     */
    public void setChild(Room uusi){
        uusi.levelIncrease();
        if (uusi.getType().equals("the Exit")) {
            dungeon = true;
        }
        if (lapsi1 == null) {
            lapsi1 = uusi;
            lapsi1.setParent(this);
            way = false;
        } else if (lapsi2 == null) {
            if ((number % 2 == 0 && lapsi1.getPaino() < uusi.getPaino())
                    || (number % 2 == 1 && lapsi1.getPaino() > uusi.getPaino())) {
                lapsi2 = lapsi1;
                lapsi1 = uusi;
                lapsi1.setParent(this);
                way = false;
            } else {
                lapsi2 = uusi;
                way = true;
            }
            lapsi2.setParent(this);
            
        } else if (way) {
            lapsi1.setChild(uusi);
            way = false;
        } else {
            lapsi2.setChild(uusi);
            way = true;
        }
    }
    
    /**
     * Jos tämä toimisi, metodi tekisi ristiinkytköksiä puussa. Ei toimi.
     * @param gate antaa huoneelle jotain millä etsiä liitospäätä. 
     */
    //public void findConnectable(Room gate) {
        //if (lapsi1 == null) {
            //extra = gate.theOtherEnd();
        //} else { 
            //if (way) {
                //way = false;
                //lapsi1.findConnectable(gate);
            //} else {
                //way = true;
                //lapsi2.findConnectable(gate);
            //}
        //}
    //}
    //Ei toimi. En saa palautettua konkreettista Room extensiota abstraktin sijaan,
    //koska en tiedä mikä spesifi extensio pitäisi palauttaa. Pitää funtsia lisää.
    //private Room theOtherEnd() {
        //Room room = this;
        //if (level < 2) {
            //if (way) {
                //room = lapsi1.theOtherEnd();
            //} else {
                //room = lapsi2.theOtherEnd();
            //}
        //}
        
        //return room;
    //}
    /**
     * antaa tiedon kuinka syvällä ollaan. Lisäreiteille kiinnostavaa.
     * @return level, eli kuinka syvällä mennään.
     */
    public int getLevel() {
        return level;
    }
    /**
     * Nostaa huoneen "kerrossyvyyttä" yhdellä.
     */
    public void levelIncrease() {
        level += 1;
    }
    /**
     * Antaa takaisin stringin huoneen tyypistä.
     * @return roomType String.
     */
    public String getType() {
        return roomType;
    }
    
    /**
     * palauttaa huoneen "arvon", millä katsotaan kuinka lähellä keskustaa 
     * huoneen tulisi olla.
     * @return weight.
     */
    public int getPaino() {
        return weight;
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
     * Asettaa ylimääräisen huoneen extra.
     * @param room 
     */
    public void setExtra(Room room) {
        extra = room;
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
            if (lapsi1 == null && extra == null) {
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
