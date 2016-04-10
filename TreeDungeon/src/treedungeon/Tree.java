/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon;

import rooms.*;
/**
 * Puuluokka.
 * Annetaan seedi ja huoneiden määrä. Näiden perusteella luodaan vähintään 15:ta,
 * enintään 256 huoneen dungeon. Niillä huoneilla, joiden määrä vaihtelee, on sekä
 * painoarvo että määrä, joiden perusteella luokka päättää mikä huone seuraavaksi lisätään.
 * Ensimmäinen huone on aina Gate, viimeinen Exit.
 */
public class Tree {
    int room;
    int libraries;
    int libraryweight;
    int farms;
    int barracks;
    int barracksweight;
    int treasures;
    int nexus;
    int random;
    GateRoom root;
    
    /**
     * Alustaa puun ja sisältää painotukset. Tällä hetkellä painotuksia vain kahta
     * erilaista ihan vain ilmaisemaan sen toiminnallisuuden, jota ei vielä implementoitu.
     * @param rooms kertoo minkä kokoista Dungeonia luodaan.
     * @param seed randomoi painotuksen. Tällä hetkellä vain kaksi eriävää
     * painotusta, eikä muita toimintoja.
     */
    public Tree(int rooms, int seed) {
        if (rooms <= 15) {
            rooms = 15;
        }
        if (rooms >= 256) {
            rooms = 256;
        } 
        if (seed < 0) {
            random = 0 - seed;
        } else {
            random = seed;
        }
        room = rooms;
        farms = rooms / 3;
        libraries = rooms / 12;
        treasures = rooms / 12;
        barracks = rooms / 6;
        nexus = 1;
        if ((seed & 1) == 0) {
            barracksweight = 13;
            libraryweight = 11;
        } else {
            barracksweight = 11;
            libraryweight = 7;
        }
        createDungeon();
        //Alla oleva ei toimi nyt syystä josta en ole varma.
        //extraRoutes();
    }
    /**
     * Metodi luo varsinaisen Dungeonin. Ensiksi Gate, lopuksi Exit.
     * Kysyy chooseRoomilta mitä välihuonetta asetetaan milläkin hetkellä.
     * Jos ehtii implementoida, asettaa "arvokkaammat" huoneet aina "sisemmäksi"
     * kunkin lapsen osalta (eli parittomilla oikealle, parillisilla vasemmalle
     * haaralle).
     */
    public void createDungeon() {
        root = new GateRoom(0, 0);
        for(int i = 1; i < room - 1; i++) {
            int chooser = chooseRoom();
            if (chooser == 0) {
                CaveRoom uusi = new CaveRoom(i, 0);
                root.setChild(uusi);
            }
            if (chooser == 1) {
                NexusRoom uusi = new NexusRoom(i, 5);
                root.setChild(uusi);
            }
            if (chooser == 2) {
                TreasureRoom uusi = new TreasureRoom(i, 4);
                root.setChild(uusi);
            }
            if (chooser == 3) {
                BarracksRoom uusi = new BarracksRoom(i, 2);
                root.setChild(uusi);
            }
            if (chooser == 4) {
                LibraryRoom uusi = new LibraryRoom(i, 3);
                root.setChild(uusi);
            }
            if (chooser == 5) {
                FarmRoom uusi = new FarmRoom(i, 1);
                root.setChild(uusi);
            }
        }
        ExitRoom exit = new ExitRoom(room - 1, 0);
        root.setChild(exit);
    }
    /**
     * This lengthy method randomizes an int for createdungeon(), which uses
     * that integer to choose the next room to place.
     * @return int-value that tells createdungeon() what to place next.
     */
    private int chooseRoom() {
        int farm = farms * 5;
        int n = 2 * nexus;
        int treasure = 3 * treasures;
        int libra = libraries * libraryweight;
        int forge = barracks * barracksweight;
        if(farm == 0 && n == 0 && treasure == 0 && libra == 0 && forge == 0 
                && n == 0) {
            farms += 3;
            treasures += 1;
            libraries += 1;
            barracks += 2;
            return 0;
        }
        if (n > farm && n > treasure && n > libra && n > forge) {
            nexus = 0;
            treasures += 1;
            libraries += 3;
            barracks += 3;
            return 1;
        }
        if (treasure > farm && treasure > libra && treasure > forge) {
            treasures -= 1;
            return 2;
        }
        if (forge > farm && forge > libra) {
            barracks -= 1;
            return 3;
        }
        if (libra > farm) {
            libraries -= 1;
            return 4;
        }
        farms -= 1;
        return 5;
    }
    /**
     * Tulee muodostamaan ylimääräiset reitit huoneiden välillä puussa.
     * Tällä tavoin vähennetään ennalta-arvattavuutta ja pakittamista Dungeonissa.
     * Ei toimi tällä hetkellä syystä josta en ole varma.
     */
    //private void extraRoutes() {
        //root.findConnectable(root);
    //}
    
    /**
     * Kirjoittaa auki Dungeonin. Ei vielä implementoitu tarkistusta onko reitti
     * takaisin vanhempaan olemassa, eli onko reitti yksisuuntainen/ei oikeasti olemassa.
     */
    public void writeDungeon() {
        root.kulje();
    }
    /**
     * Palauttaa luodun dungeonin koon.
     * @return koko säilytettynä muuttujassa room.
     */
    public int getDungeonSize() {
        return room;
    }
}
