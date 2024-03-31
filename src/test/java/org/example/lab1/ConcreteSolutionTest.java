package org.example.lab1;

import org.example.lab1.solution.ConcreteSolution;
import org.junit.*;

import java.util.List;

public class ConcreteSolutionTest {
    public static ConcreteSolution solution;
    public Integer[] nodes;
    public BinaryTree<Integer> tree;
    public List<List<Integer>> results;

    @BeforeClass
    public static void setSolution(){
        solution = new ConcreteSolution();
    }

    @Before
    public void clean(){
        nodes = null;
        tree = null;
        results = null;
    }

    @After
    public void print(){
//        tree.printLevelOrder();
//        System.out.println(results);
    }

    @AfterClass
    public static void cleanSolution(){
        solution = null;
    }

    @Test
    public void test1(){
//        System.out.println("test1:");
        nodes = new Integer[]{null};
        tree = new BinaryTree<>(nodes);
        results = solution.pathSum(tree.root, 0);
        Assert.assertTrue(results.isEmpty());
        Assert.assertEquals(0, results.size());
    }
    @Test
    public void test2(){
//        System.out.println("test2:");
        nodes = new Integer[]{8, 2, 6, 3, 5, 6, 4, 7, null, 9, 5, null, null, 1, null, null, null, null, null, null, null, 1, null};
        tree = new BinaryTree<>(nodes);
        results = solution.pathSum(tree.root, 20);
        Assert.assertEquals(4, results.size());
        Assert.assertEquals(3, results.get(2).size());
        Assert.assertEquals(5, results.get(3).size());
    }
    @Test
    public void test3(){
//        System.out.println("test3:");
        nodes = new Integer[]{3};
        tree = new BinaryTree<>(nodes);
        results = solution.pathSum(tree.root, 3);
        Assert.assertFalse(results.isEmpty());
        Assert.assertEquals("[3]", results.get(0).toString());
    }

}