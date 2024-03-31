package org.example.lab3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBackPack2 {
    private static BackPack backPack;
    public int[] weights;
    public int[] values;
    public int capacity;
    public int expected;

    @BeforeClass
    public static void initTest() {
        backPack = new BackPack();
    }

    @Test
    public void test01() {
        weights = new int[]{2, 3, 4, 5};
        values = new int[]{3, 4, 5, 6};
        capacity = 8;
        expected = 10;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test02() {
        weights = new int[]{1, 2, 3};
        values = new int[]{60, 100, 120};
        capacity = 0;
        expected = 0;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test03() {
        weights = new int[]{4};
        values = new int[]{3};
        capacity = 5;
        expected = 3;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test04() {
        weights = new int[]{2, 3, 4, 5};
        values = new int[]{40, 30, 50, 20};
        capacity = 1;
        expected = 0;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test05() {
        weights = new int[]{2, 3, 4, 5};
        values = new int[]{3, 4, 5, 6};
        capacity = 15;
        expected = 18;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test06() {
        weights = new int[]{3, 3, 3};
        values = new int[]{5, 5, 5};
        capacity = 9;
        expected = 15;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test07() {
        weights = new int[]{2, 3, 4};
        values = new int[]{1, 2, 3};
        capacity = -5;
        expected = 0;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test08() {
        weights = new int[]{-2, 3, 4};
        values = new int[]{1, 2, 3};
        capacity = 10;
        expected = 6;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test09() {
        weights = new int[]{2, 3, 4};
        values = new int[]{1, -2, 3};
        capacity = 10;
        expected = 4;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test10() {
        weights = new int[]{};
        values = new int[]{};
        capacity = 10;
        expected = 0;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test11() {
        weights = new int[]{10, 20, 30};
        values = new int[]{60, 100, 120};
        capacity = 30;
        expected = 160;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test12() {
        weights = new int[]{10, 20, 30};
        values = new int[]{60, 100, 120};
        capacity = 31;
        expected = 160;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test13() {
        weights = new int[]{1, 2, 3, 4, 5};
        values = new int[]{10, 40, 30, 50, 20};
        capacity = 10;
        expected = 130;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test14() {
        weights = new int[]{1, 2, 3, 4, 5};
        values = new int[]{10, 40, 30, 50, 20};
        capacity = 15;
        expected = 150;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
    @Test
    public void test15() {
        weights = new int[]{1, 2, 3, 4, 5};
        values = new int[]{10, 40, 30, 50, 20};
        capacity = 16;
        expected = 150;
        int result = backPack.backPack(capacity, weights, values);
        assertEquals(expected, result);
    }
}
