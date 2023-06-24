import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @BeforeAll  // before all method have to be static
    static void setUpAll(){
        System.out.println("Before All executed");
    }
    @AfterAll
    static void terDownAll(){
        System.out.println("teardownALl");
    }
    @BeforeEach
    void setUpEach(){
        System.out.println("Before each test it is executed");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("After Each executed");
    }
    @Test
    void testCase1(){
        //fail("not implemented yet");

    }
    @Test
    void testCase2(){
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);
    }
    @Test
    @DisplayName("assertArrayEquals")
    void testCase3(){
       assertArrayEquals(new int[]{1,2,3} ,new int[]{1,2,3}, "Arrays are same");
    }
    @Test
    @DisplayName("assertNotNull and  assertNull")
    void testCase4(){
        String nullString = null;
        String notNullString = "Back";
        assertNotNull(notNullString);
        assertNull(nullString,"Null not variable");

    }

    @Test
    @DisplayName("assertSame and assertNotSame  ")
    void testCase5(){
      Calculator c1 = new Calculator();
      Calculator c2 = c1;
      Calculator c3 = new Calculator();
      assertSame(c1,c2);
      assertNotSame(c1,c3);
    }
    @Test
    void add(){
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }

    @Test // if now exceptio is thrown or if an exception not expected one, test will fail
    @DisplayName("aassertThrow ")
    void add3(){
    assertThrows(IllegalArgumentException.class, () ->Calculator.add3(5,2));
    //assertThrows(IllegalArgumentException.class, () ->Calculator.add3(1,2));
    }
//    @Test
//    void add2(){
//        int actual = Calculator.add(2,3);
//        assertEquals(6,actual,"it is not correct RESULT");
//    }
}

