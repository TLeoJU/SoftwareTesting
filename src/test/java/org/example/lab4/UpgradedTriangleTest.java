package org.example.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpgradedTriangleTest {
    @Test
    public void testClassifyTriangle() {
        UpgradedTriangle triangle = new UpgradedTriangle();

        assertEquals("case01", "EQUILATERAL", triangle.classifyTriangle(5, 5, 5));
        assertEquals("case02", "ISOSCELES", triangle.classifyTriangle(5, 5, 6));
        assertEquals("case03", "ISOSCELES", triangle.classifyTriangle(5, 6, 6));
        assertEquals("case04", "ISOSCELES", triangle.classifyTriangle(6, 5, 6));
        assertEquals("case05", "SCALENE", triangle.classifyTriangle(3, 4, 5));
        assertEquals("case06", "INVALID", triangle.classifyTriangle(1, 4, 5));
        assertEquals("case07", "INVALID", triangle.classifyTriangle(1, 5, 4));
        assertEquals("case08", "INVALID", triangle.classifyTriangle(5, 4, 1));

        assertEquals("case09", "INVALID", triangle.classifyTriangle(0, 0, 0));
        assertEquals("case10", "INVALID", triangle.classifyTriangle(-1, -1, -1));
        assertEquals("case11", "INVALID", triangle.classifyTriangle(-3, -4, -5));
        assertEquals("case12", "INVALID", triangle.classifyTriangle(3, 4, -5));
        assertEquals("case13", "INVALID", triangle.classifyTriangle(-3, 4, 5));
        assertEquals("case14", "INVALID", triangle.classifyTriangle(3, -4, 5));
        assertEquals("case15", "ISOSCELES", triangle.classifyTriangle(1024, 1024, 1));

    }

    @Test
    public void testCalArea() {
        UpgradedTriangle triangle = new UpgradedTriangle();

        assertEquals("case01", 10.825317547305485, triangle.calArea(5, 5, 5), 0.0001);
        assertEquals("case02", 12.0, triangle.calArea(5, 5, 6), 0.0001);
        assertEquals("case03", 6.0, triangle.calArea(3, 4, 5), 0.0001);
        assertEquals("case04", 24.0, triangle.calArea(6, 8, 10), 0.0001);
        assertEquals("case05", 108253.17547305485, triangle.calArea(500, 500, 500), 0.0001);
        assertEquals("case06", 0.0, triangle.calArea(1, 4, 5), 0.0001);
        assertEquals("case07", 0.0, triangle.calArea(0, 4, 5), 0.0001);
        assertEquals("case08", 0.0, triangle.calArea(-1, 4, 5), 0.0001);
        assertEquals("case09", 0.0, triangle.calArea(0, 0, 0), 0.0001);
        assertEquals("case10", 60000.0, triangle.calArea(300, 400, 500), 0.0001);
        assertEquals("case11", 54.0, triangle.calArea(9, 12, 15), 0.0001);
        assertEquals("case12", 6.0, triangle.calArea(5, 3, 4), 0.0001);
        assertEquals("case13", 0.0, triangle.calArea(-1, -1, -1), 0.0001);
        assertEquals("case14", 454046.7268993357, triangle.calArea(1024, 1024, 1024), 0.0001);
        assertEquals("case15", 480000.0, triangle.calArea(1000, 1000, 1200), 0.0001);
    }

}