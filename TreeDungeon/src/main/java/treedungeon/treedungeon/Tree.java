/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.treedungeon;

import treedungeon.rooms.*;
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
    int farmweight;
    int barracks;
    int barracksweight;
    int treasures;
    int treasureweight;
    int nexus;
    int nexusweight;
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
        setSeed(seed);
        standardValues(rooms);
        createDungeon();
        extraRoutes();
    }
    /**
     * Asettaa painotuksia ja määriä huoneille.
     */
    private void standardValues(int rooms) {
        room = rooms;
        farmweight = 5;
        nexusweight = 2;
        treasureweight = 3;
        farms = rooms / 3;
        libraries = rooms / 12;
        treasures = rooms / 12;
        barracks = rooms / 6;
        nexus = 1;
        if ((random & 1) == 0) {
            barracksweight = 13;
            libraryweight = 11;
        } else {
            barracksweight = 11;
            libraryweight = 7;
        }
    }
    /**
     * Asettaa randomseedin arvon halutulle välille inputin mukaisesti.
     * @param seed 
     */
    public void setSeed(int seed) {
        if (seed < 0) {
            random = 0 - seed;
        } else {
            random = seed;
        }
        if (random > 10000) {
            random = 10000 + (random % 3);
        }
    }
    /**
     * Metodi luo varsinaisen Dungeonin. Ensiksi Gate, lopuksi Exit.
     * Kysyy chooseRoomilta mitä välihuonetta asetetaan milläkin hetkellä.
     * Asettaa "arvokkaammat" huoneet aina "sisemmäksi" kunkin lapsen osalta 
     * (eli parittomilla oikealle, parillisilla vasemmalle haaralle).
     */
    public void createDungeon() {
        root = new GateRoom(0);
        for(int i = 1; i < room - 1; i++) {
            int chooser = chooseRoom();
            if (chooser == 0) {
                CaveRoom uusi = new CaveRoom(i);
                root.setChild(uusi);
            }
            if (chooser == 1) {
                NexusRoom uusi = new NexusRoom(i);
                root.setChild(uusi);
            }
            if (chooser == 2) {
                TreasureRoom uusi = new TreasureRoom(i);
                root.setChild(uusi);
            }
            if (chooser == 3) {
                BarracksRoom uusi = new BarracksRoom(i);
                root.setChild(uusi);
            }
            if (chooser == 4) {
                LibraryRoom uusi = new LibraryRoom(i);
                root.setChild(uusi);
            }
            if (chooser == 5) {
                FarmRoom uusi = new FarmRoom(i);
                root.setChild(uusi);
            }
        }
        ExitRoom exit = new ExitRoom(room - 1);
        root.setChild(exit);
    }
    /**
     * This lengthy method randomizes an int for createdungeon(), which uses
     * that integer to choose the next room to place.
     * @return int-value that tells createdungeon() what to place next.
     */
    private int chooseRoom() {
        int farm = farms * farmweight;
        int n = nexusweight * nexus;
        int treasure = treasureweight * treasures;
        int libra = libraries * libraryweight;
        int forge = barracks * barracksweight;
        if(farm == 0 && n == 0 && treasure == 0 && libra == 0 && forge == 0 
                && n == 0) {
            return placeCave();
        }
        if (n > farm && n > treasure && n > libra && n > forge) {
            return placeNexus();
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
     * Tekee tarpeelliset muutokset Huoneiden jatkamiselle.
     * @return 
     */
    private int placeCave() {
        farms += 3 + (random % 5);
        libraries += 1 + (random % 2);
        barracks += 2 + (random % 3);
        randomDivision();
        return 0;
    }
    /**
     * Vähentää 'random'-arvoa jakamalla tiettyyn rajaan asti, jolloin 
     * lisää ison arvon siihen ja jatkaa normaalisti.
     */
    private void randomDivision() {
        if (random < 1000) {
            random += 9000 + (random % 3);
        }
        random /= 3;
    }
    /**
     * Tekee tarpeelliset huonemäärämuutokset NexusRoom:n laittamisen takia.
     * @return 
     */
    private int placeNexus() {
        nexus = 0;
        treasures += 3 + (random % 5);
        libraries += 2 + (random % 3);
        barracks += 1 + (random % 2);
        randomDivision();
        return 1;
    }
    /**
     * Tulee muodostamaan ylimääräiset reitit huoneiden välillä puussa.
     * Tällä tavoin vähennetään ennalta-arvattavuutta ja pakittamista Dungeonissa.
     * Ei toimi tällä hetkellä syystä josta en ole varma.
     */
    private void extraRoutes() {
        int jatkot = room / 3;
        for (int i = 0; i < jatkot; i++) {
            root.findConnectable();
        }
    }
    
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
    /**
     * Metodi alkaa etsiä huonetta palauttaakseen sen etäisyyden Gatesta.
     * @param roomNumber on etsitty huone.
     * @return etäisyys Gatesta tai -1 virhetilanteessa.
     */
    public int getRoomDistance(int roomNumber) {
        return root.etsiHuone(roomNumber);
    }
}
