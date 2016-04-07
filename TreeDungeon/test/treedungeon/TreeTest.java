/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treedungeon;

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
     * Test of createDungeon method, of class Tree.
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
    
}
