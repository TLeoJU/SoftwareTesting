package org.example.lab3;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class TestBubbleSort {
    private static BubbleSort bubbleSort;
    public int[] arrCase;
    public int[] arrExpected;

    public TestBubbleSort(int[] arrCase, int[] arrExpected) {
        this.arrCase = arrCase;
        this.arrExpected = arrExpected;
    }

    @BeforeClass
    public static void initTest() {
        bubbleSort = new BubbleSort();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{2, 1}, new int[]{1, 2}},
                {new int[]{1, 3, 2}, new int[]{1, 2, 3}},
                {new int[]{6, 5, 3, 7, 2, 8, 1, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5}},
                {new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}},
                {new int[]{2, 3, 4, 5, 1}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{1, 2}, new int[]{1, 2}},
                {new int[]{1, 1}, new int[]{1, 1}},
                {new int[]{10, 5, 8, 2, 7, 3, 6, 1, 9, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}
        });
    }

    @Test
    public void test() {
        int[] result = bubbleSort.bubbleSort(arrCase);
        assertArrayEquals(arrExpected, result);
    }

}
