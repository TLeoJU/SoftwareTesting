package org.example.lab3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBackPack {
    private static BackPack backPack;
    public int[] weights;
    public int[] values;
    public int capacity;
    public int expected;

    public TestBackPack(int[] weights, int[] values, int capacity, int expected) {
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
        this.expected = expected;
    }

    @BeforeClass
    public static void initTest() {
        backPack = new BackPack();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 4, 5}, new int[]{3, 4, 5, 6}, 8, 10},
                {new int[]{1, 2, 3}, new int[]{60, 100, 120}, 5, 220},
                {new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50, 220},
                {new int[]{1, 2, 3, 4, 5}, new int[]{10, 40, 30, 50, 20}, 8, 100},
                {new int[]{2, 3, 4, 5}, new int[]{3, 4, 5, 6}, 0, 0},
                {new int[]{}, new int[]{}, 5, 0},
                {new int[]{1}, new int[]{1}, 0, 0},
                {new int[]{1}, new int[]{1}, 1, 1},
                {new int[]{10, 20, 30}, new int[]{60, 100, 120}, 0, 0},
                {new int[]{10, 20, 30}, new int[]{60, 100, 120}, 10, 60},
                {new int[]{10, 20, 30}, new int[]{60, 100, 120}, 30, 160},
                {new int[]{10, 20, 30}, new int[]{60, 100, 120}, 31, 160},
                {new int[]{1, 2, 3, 4, 5}, new int[]{10, 40, 30, 50, 20}, 10, 130},
                {new int[]{1, 2, 3, 4, 5}, new int[]{10, 40, 30, 50, 20}, 15, 150},
                {new int[]{1, 2, 3, 4, 5}, new int[]{10, 40, 30, 50, 20}, 16, 150}
        });
    }

    @Test
    public void test() {
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }

}
