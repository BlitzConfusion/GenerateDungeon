/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

/**
 *
 * @author Tatu
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
     * Metodi tekee ristiinkytköksiä puussa. Jos ExitRoom olisi yksi päistä,
     * tai saataisiin null toiseksi pääksi, iteraatio hylätään.
     * @param gate antaa huoneelle puun jolla etsiä liitospäätä. 
     */
    public void findConnectable() {
        if (lapsi1 == null) {
            Room another = backToGate();
            if (another == null || "the Exit".equals(this.getType()) 
                    || "the Exit".equals(another.getType())) {
                return;
            }
            another.setExtra(this);
            setExtra(another);
            another.setExtra(this);
        } else { 
            if (way && lapsi2 != null) {
                lapsi2.findConnectable();
            } else {
                lapsi1.findConnectable();
            }
        }
    }
    /**
     * Metodi kiipeää puuta ylös jotta päästään toista haaraa alas kulkemaan.
     * @return lopulta huone, joka on toisessa haarassa, jos mahdollista.
     */
    private Room backToGate() {
        Room room = null;
        if (parent == null) {
            room = theOtherEnd();
        } else {
            room = parent.backToGate();
        }
        return room;
    }
    /**
     * Metodi etsii lähimmän virranmyötäisen huoneen, jolla ei ole extrakytköstä.
     * Huoneet liian lähellä Gatea hylätään sopimattomina, kuten myös jo lisäkytketyt.
     * @return vaatimukset täyttävä huone.
     */
    private Room theOtherEnd() {
        Room room = this;
        if (level < 2 || extra != null) {
            if (way) {
                way = false;
                room = lapsi1.theOtherEnd();
            } else {
                way = true;
                room = lapsi2.theOtherEnd();
            }
        }
        return room;
    }
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
    }
    /**
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
                if (lapsi1 != null) {
                System.out.print("room " + lapsi1.number + ", which is " 
                        + lapsi1.getType());
                }
            }
            if (lapsi2 != null) {
                System.out.print("; and room " + lapsi2.number + ", which is "
                        + lapsi2.getType());
            }
            if (lapsi1 != null && extra != null) {
                System.out.println(";");
                System.out.print("and ");
            }
            if (extra != null) {
                System.out.print("faraway room " + extra.number + ", which is "
                        + extra.getType());
            }
            
        }
        System.out.println(".");
    }
}