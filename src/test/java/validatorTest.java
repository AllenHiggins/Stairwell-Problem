import Models.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validatorTest {

    int[] theArray;

    Validator validator = new Validator();

    @Test
    void isPositiveInt() {
        assertTrue(validator.validNumberOfStrides(3));
    }

    @Test
    void isPositiveInt2() {
        assertFalse(validator.validNumberOfStrides(-6));
    }

    @Test
    void isPositiveInt3() {
        assertFalse(validator.validNumberOfStrides(0));
    }

    @Test
    void checkSteps() {
        assertFalse(validator.validSteps(0));
    }

    @Test
    void checkSteps2() {
        assertTrue(validator.validSteps(4));
    }

    @Test
    void validateArray() {

        theArray = new int[]{4, 9, 8, 11, 7, 20, 14};

        assertTrue(validator.validateArray(theArray, 2));
    }

    @Test
    void validateArray2() {

        theArray = new int[]{4, 9, 8, 11, -7, 20, -14};

        assertFalse(validator.validateArray(theArray, 2));
    }

    @Test
    void validateArray3() {

        theArray = new int[]{4, 9, 8, 11, 7, 0, 14};

        assertFalse(validator.validateArray(theArray, 2));
    }

    @Test
    void validateArray4() {

        theArray = new int[]{4, 9, 8, 11, 7, 0, 14};

        assertFalse(validator.validateArray(theArray, 5));
    }


    @Test
    void validateArray5() {

        theArray = new int[]{4, 9, 8, 11, 7, 0, 14, 20, 19, 10,4, 9, 8, 11, 7, 0, 14, 20, 19, 10,4, 9, 8, 11, 7, 0, 14, 20, 19, 10,12};

        assertFalse(validator.validateArray(theArray, 3));
    }

    @Test
    void arrayLengthLessOrEqualTo30() {

        theArray = new int[]{4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10};

        assertTrue(validator.validArrayLength(theArray));
    }

    @Test
    void arrayLengthToLong() {

        theArray = new int[]{4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,20};

        assertFalse(validator.validArrayLength(theArray));
    }
}