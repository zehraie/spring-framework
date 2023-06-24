import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class CalculatorParameterizedTest {

    // if you use @ParameterizedTest, no need @Test annotation
    //Value SOurce only Array type primitive
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS","TS"})
    void testCase1(String args){
        assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase2(int number){
        assertEquals(0, number%3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS","TS"})
    //@EmptySource  //empty gonderir as a parameter
    //@NullSource
   // @NullAndEmptySource
    void testCase3(String args){
        assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")      // I need static method will provide data
    void testCase4( String str){
        assertNotNull(str);
    }
//    static String[] stringProvider(){
//        return new String[]{"java", "JS", "TS"};
//    }
//
    private static Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of("java"),
                Arguments.of("JS"),
                Arguments.of("TS")
        );}
  //  ********CSV****** used to run tests that take a comma-separeted values as arguments
    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40","30,10,100"})
    void testCase5(int num1, int num2, int result){
        assertEquals(result,Calculator.add(num1,num2));
    }
    //@CsvFileSource for alot of test data then this provide the data in an external CSV file.
    //each line from the file works as a list of parameters
   @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1,int num2, int result){
       assertEquals(result,Calculator.add(num1,num2));
   }

}
