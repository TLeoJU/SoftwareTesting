package org.example.lab3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestBubbleSort2 {
    private static BubbleSort bubbleSort;
    public int[] arrCase;
    public int[] arrExpected;

    @BeforeClass
    public static void initTest() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void test01() {
        arrCase = new int[]{5, 4, 3, 2, 1};
        arrExpected = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test02() {
        arrCase = new int[]{};
        arrExpected = new int[]{};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test03() {
        arrCase = new int[]{1};
        arrExpected = new int[]{1};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test04() {
        arrCase = new int[]{2, 1};
        arrExpected = new int[]{1, 2};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test05() {
        arrCase = new int[]{1, 3, 2};
        arrExpected = new int[]{1, 2, 3};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test06() {
        arrCase = new int[]{6, 5, 3, 7, 2, 8, 1, 4};
        arrExpected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test07() {
        arrCase = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        arrExpected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test08() {
        arrCase = new int[]{1, 2, 3, 4, 5};
        arrExpected = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test09() {
        arrCase = new int[]{5, 4, 3, 2, 1, 0};
        arrExpected = new int[]{0, 1, 2, 3, 4, 5};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test10() {
        arrCase = new int[]{1, 1, 1, 1, 1};
        arrExpected = new int[]{1, 1, 1, 1, 1};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test11() {
        arrCase = new int[]{2, 3, 4, 5, 1};
        arrExpected = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test12() {
        arrCase = new int[]{1, 2};
        arrExpected = new int[]{1, 2};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test13() {
        arrCase = new int[]{1, 1};
        arrExpected = new int[]{1, 1};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test14() {
        arrCase = new int[]{10, 5, 8, 2, 7, 3, 6, 1, 9, 4};
        arrExpected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }
    @Test
    public void test15() {
        arrCase = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        arrExpected = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(arrExpected, bubbleSort.bubbleSort(arrCase));
    }

}
