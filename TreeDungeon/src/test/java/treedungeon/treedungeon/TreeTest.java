/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon.treedungeon;

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
public class TreeTest {
    
    public TreeTest() {
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
     * Test of setSeed method, of class Tree.
     */
    @Test
    public void testCreateDungeon() {
        System.out.println("Create a Dungeon");
        Tree tree = new Tree(10, 1);
        assertTrue("the Gate".equals(tree.root.getType()));
    }
    @Test
    public void testMinSize() {
        System.out.println("Test Dungeon minimum size");
        Tree tree = new Tree(-1, 1);
        assertTrue(tree.getDungeonSize() == 15);
    }
    @Test
    public void testMaxSize() {
        System.out.println("Test Dungeon maximum size");
        Tree tree = new Tree(300, 1);
        assertTrue(tree.getDungeonSize() == 256);
    }
    @Test
    public void testGateLevel() {
        System.out.println("Check that the Gate is at level 0.");
        Tree tree = new Tree(1, 1);
        assertTrue(tree.root.getLevel() == 0);
    }
    @Test
    public void testExitplaced() {
        System.out.println("Check that the Exit has been placed.");
        Tree tree = new Tree(1, 1);
        assertTrue(tree.root.isBetweenExits());
    }
    @Test
    public void testDungeonRandom() {
        System.out.println("Check that 'random' gets correct value");
        Tree tree = new Tree(10, 101);
        assertTrue(tree.random == 101);
    }
    @Test
    public void testRandomNoNegative() {
        System.out.println("Check that 'random' gets non-negative value");
        Tree tree = new Tree(10, -101);
        assertTrue(tree.random == 101);
    }
    @Test
    /**
     * This test has an issue in that the Nexus can have been set to 0 to begin
     * with. That will be remedied later.
     */
    public void testNexusPlaced() {
        System.out.println("Create a Dungeon, and check that Nexus has been placed");
        Tree tree = new Tree(10, 1);
        assertEquals(tree.nexus, 0);
    }
    @Test
    public void testNoRoomtypesUnused() {
        Tree tree = new Tree(256, 1);
        assertTrue(tree.barracks < 5 && tree.farms < 5 && tree.libraries < 5 &&
                tree.treasures < 5);
    }
    @Test
    public void testNoVoid() {
        Tree tree = new Tree(256, 1);
        assertTrue(tree != null);
    }
}
