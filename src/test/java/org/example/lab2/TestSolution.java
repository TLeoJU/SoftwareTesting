package org.example.lab2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSolution {
    private static Solution solution;
    public int testcase;
    public int expected;
    public static int caseNum;

    public TestSolution(int testcase, int expected) {
        if(++caseNum<3||caseNum>54)System.out.println("TestSolution() case:" + caseNum);
        this.testcase = testcase;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws IOException {
        System.out.println("@Parameterized.Parameters");
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/lab2/testinput.txt"));
        String line;
        List<Object[]> testData = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] params = line.split(",");
            int testcase = Integer.parseInt(params[0]);
            int expected = Integer.parseInt(params[1]);
            testData.add(new Object[]{testcase, expected});
        }
        reader.close();
        return testData;
    }

    @BeforeClass
    public static void initSolution() {
        System.out.println("@BeforeClass");
        solution = new SolutionWithDP();
        caseNum = 0;
    }

    @AfterClass
    public static void cleanSolution() {
        System.out.println("@AfterClass");
        solution = null;
    }

    @Before
    public void initParam() {
        if(caseNum<3||caseNum>54)System.out.println("@Before");
    }

    @After
    public void cleanParam() {
        if(caseNum<3||caseNum>54)System.out.println("@After\n");
    }

    @Test
    public void testSolution() {
        if(caseNum<3||caseNum>54)System.out.println("@Test");
        int result = solution.findLargestProduct(testcase);
        if(caseNum<3||caseNum>54)System.out.println("Result is " + result + ", Expected " + expected);
        assertEquals(expected, result);
    }
}

