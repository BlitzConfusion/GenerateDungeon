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
    int farmweight;
    int armouries;
    int armouryweight;
    int treasures;
    int treasuryweight;
    int nexus;
    GateRoom root;
    
    /**
     * Alustaa puun ja sisältää painotukset. Tällä hetkellä painotuksia vain kahta
     * erilaista ihan vain ilmaisemaan sen toiminnallisuuden, jota ei vielä implementoitu.
     * @param rooms kertoo minkä kokoista Dungeonia luodaan.
     * @param seed randomoi painotuksen. Tällä hetkellä vain kaksi lopputulosta.
     */
    public Tree(int rooms, int seed) {
        if (rooms <= 15) {
            rooms = 15;
        }
        if (rooms >= 256) {
            rooms = 256;
        } 
        room = rooms;
        farmweight = 2;
        treasuryweight = 11;
        farms = rooms / 3;
        libraries = rooms / 12;
        treasures = rooms / 12;
        nexus = 1;
        if ((seed & 1) == 0) {
            armouries = rooms / 3;
            armouryweight = 5;
            libraryweight = 3;
        } else {
            armouries = rooms / 6;
            armouryweight = 3;
            libraryweight = 5;
        }
        createDungeon();
    }
    /**
     * Metodi luo varsinaisen Dungeonin. Ensiksi Gate, lopuksi Exit.
     * Tällä hetkellä, koska huonerandomisaatiota ei ole vielä implementoitu,
     * ainoastaan Armoury:ja luodaan toiminnallisuuden tarkistamiseksi.
     */
    public void createDungeon() {
        root = new GateRoom(0);
        for(int i = 1; i < room; i++) {
            ArmouryRoom toAdd = new ArmouryRoom(i);
            root.setChild(toAdd);
        }
        ExitRoom exit = new ExitRoom(room);
        root.setChild(exit);
    }
    /**
     * Kirjoittaa auki Dungeonin. Ei vielä implementoitu tarkistusta onko reitti
     * takaisin vanhempaan olemassa, eli onko reitti yksisuuntainen.
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
