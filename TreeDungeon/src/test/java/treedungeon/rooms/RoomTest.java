/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.rooms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tatu
 */
public class RoomTest {
    
    public RoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setChild method, of class Room.
     */
    @Test
    public void testSetChild() {
        System.out.println("Katso että oksa laitetaan.");
        GateRoom vanhempi = new GateRoom(1, 2);
        FarmRoom lapsi = new FarmRoom(1, 2);
        vanhempi.setChild(lapsi);
        assertTrue(vanhempi.lapsi1 == lapsi && lapsi.getClass() == FarmRoom.class);
    }
    @Test
    public void testSetTwoChildren() {
        System.out.println("Katso että 2 oksaa laitetaan.");
        GateRoom vanhempi = new GateRoom(0, 2);
        GateRoom lapsi1 = new GateRoom(1, 2);
        GateRoom lapsi2 = new GateRoom(2, 2);
        vanhempi.setChild(lapsi1);
        vanhempi.setChild(lapsi2);
        assertTrue(vanhempi.lapsi1 == lapsi1 && vanhempi.lapsi2 == lapsi2);
    }
    @Test
    public void testSetThreeChildren() {
        System.out.println("Katso että 3 oksaa laitetaan ja oikein päin.");
        GateRoom vanhempi = new GateRoom(0, 2);
        GateRoom lapsi1 = new GateRoom(1, 2);
        GateRoom lapsi2 = new GateRoom(2, 3);
        GateRoom lapsi3 = new GateRoom(3, 1);
        vanhempi.setChild(lapsi1);
        vanhempi.setChild(lapsi2);
        vanhempi.setExtra(lapsi3);
        assertTrue(vanhempi.lapsi1 == lapsi1 && vanhempi.lapsi2 == lapsi2 &&
            vanhempi.extra == lapsi3);
    }
    
    @Test
    public void testSetFurtherBranch() {
        System.out.println("Katso että oksa saa oksan oikein");
        GateRoom vanhempi = new GateRoom(0, 2);
        GateRoom lapsi1 = new GateRoom(1, 2);
        GateRoom lapsi2 = new GateRoom(2, 2);
        GateRoom lapsi3 = new GateRoom(3, 1);
        vanhempi.setChild(lapsi1);
        vanhempi.setChild(lapsi2);
        vanhempi.setChild(lapsi3);
        assertTrue(vanhempi.lapsi1.lapsi1 == lapsi3);
    }
    

    /**
     * Test of getLevel method, of class Room.
     */
    @Test
    public void testLevelIncrease() {
        System.out.println("Katso että kerros tulee oikein.");
        GateRoom room = new GateRoom(0, 0);
        room.levelIncrease();
        assertTrue(room.getLevel() == 1);
    }

    /**
     * Test of levelIncrease method, of class Room.
     */
    @Test
    public void testGetLevel() {
        System.out.println("katso että kerros alustetaan oikein.");
        GateRoom room = new GateRoom(0, 0);
        GateRoom child = new GateRoom(1, 0);
        room.setChild(child);
        assertTrue(room.lapsi1.getLevel() == 1);
    }

    /**
     * Test of getType method, of class Room.
     */
    @Test
    public void testGetType() {
        System.out.println("Katso että huoneen nimi tulee oikein.");
        GateRoom room = new GateRoom(0, 0);
        assertEquals(room.getType(), "the Gate");
    }

    /**
     * Test of getPaino method, of class Room.
     */
    @Test
    public void testGetPaino() {
        System.out.println("Testaa painon asetus");
        GateRoom room = new GateRoom(0, 9);
        assertEquals(9, room.weight);
    }

    /**
     * Test of setParent method, of class Room.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        GateRoom room = new GateRoom(0, 9);
        GateRoom lapsi = new GateRoom(1, 9);
        lapsi.setParent(room);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(lapsi.parent == room);
    }
    public void testSetChildParent() {
        System.out.println("See that Child automatically has a parent.");
        GateRoom room = new GateRoom(0, 9);
        GateRoom lapsi = new GateRoom(1, 9);
        room.setChild(lapsi);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(lapsi.parent == room);
    }
    /**
     * Test of isBetweenExits method, of class Room.
     */
    @Test
    public void testIsBetweenExits() {
        System.out.println("Check that room between exits is marked thus.");
        GateRoom gate = new GateRoom(0, 9);
        LibraryRoom lib = new LibraryRoom(0, 9);
        FarmRoom farmi = new FarmRoom(0, 9);
        ExitRoom end = new ExitRoom(0, 0);
        gate.setChild(lib);
        gate.setChild(farmi);
        gate.setChild(end);
        assertTrue(gate.lapsi1.isBetweenExits() && !gate.lapsi2.isBetweenExits());
    }

    /**
     * Test of kulje method, of class Room.
     */
    

    /**
     * Test of killParent method, of class Room.
     */
    @Test
    public void testKillParent() {
        GateRoom gate = new GateRoom(0, 9);
        LibraryRoom lib = new LibraryRoom(0, 9);
        lib.setParent(gate);
        lib.killParent();
        assertTrue(lib.parent == null);
    }

    /**
     * Test of getWay method, of class Room.
     */
    @Test
    public void testGetWay() {
        System.out.println("Test that way-boolean changes");
        GateRoom gate = new GateRoom(0, 9);
        GateRoom gate2 = new GateRoom(0, 9);
        LibraryRoom lib = new LibraryRoom(0, 9);
        FarmRoom farmi = new FarmRoom(0, 9);
        gate.setChild(farmi);
        gate2.setChild(farmi);
        gate2.setChild(lib);
        assertTrue(!gate.getWay() && gate2.getWay());
    }
    @Test
    public void testGetWayGrandParent() {
        System.out.println("Test that way-boolean changes when grandchildren born.");
        GateRoom gate = new GateRoom(0, 9);
        FarmRoom room = new FarmRoom(0, 9);
        LibraryRoom lib = new LibraryRoom(0, 9);
        FarmRoom farmi = new FarmRoom(0, 9);
        gate.setChild(farmi);
        gate.setChild(room);
        gate.setChild(lib);
        assertTrue(!gate.getWay());
    }
    
}