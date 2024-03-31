package org.example.lab1;

import org.example.lab1.solution.ConcreteSolution;
import org.example.lab2.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestSolu {
    @Test
    public void Test1(){
        ConcreteSolution solution = new ConcreteSolution();
        List<List<Integer>> results = solution.pathSum((new BinaryTree<>(new Integer[]{8, 2, 6, 3, 5, 6, 4, 7, null, 9, 5, null, null, 1, null, null, null, null, null, null, null, 1, null})).root, 20);
        Assert.assertEquals(4, results.size());
        Assert.assertEquals(3, results.get(2).size());
        Assert.assertEquals(5, results.get(3).size());
    }
}
