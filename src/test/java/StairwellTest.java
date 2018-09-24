import Models.Stairwell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StairwellTest {

    int[] stairs ;

    @Test
    void totalStrides() {

        stairs = new int[]{4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10};

        Stairwell stairwell = new Stairwell(stairs, 2);

        assertEquals(214, stairwell.totalStrides());
    }

    @Test
    void totalStrides1() {

        stairs = new int[]{4, 9, 8, 11, 7, 20, 14};

        Stairwell stairwell = new Stairwell(stairs, 2);

        assertEquals(50, stairwell.totalStrides());
    }

    @Test
    void totalStrides2() {

        stairs = new int[]{17, 17};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(14, stairwell.totalStrides());
    }

    @Test
    void totalStrides3() {

        stairs = new int[]{1};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(1, stairwell.totalStrides());
    }

    @Test
    void totalStrides4() {

        stairs = new int[]{20};

        Stairwell stairwell = new Stairwell(stairs, 1);

        assertEquals(20, stairwell.totalStrides());
    }

    @Test
    void totalStrides5() {

        stairs = new int[]{17, 3};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(9, stairwell.totalStrides());
    }

    @Test
    void totalStrides6() {

        stairs = new int[]{3};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(1, stairwell.totalStrides());
    }

    @Test
    void totalStrides7() {

        stairs = new int[]{2};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(1, stairwell.totalStrides());
    }

    @Test
    void totalStrides8() {

        stairs = new int[]{2,3,1};

        Stairwell stairwell = new Stairwell(stairs, 3);

        assertEquals(7, stairwell.totalStrides());
    }

    @Test
    void isEmptyArray() {

        stairs = new int[]{};

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {

            Stairwell stairwell = new Stairwell(stairs, 2);

            stairwell.totalStrides();
        });
    }

    @Test
    void negativeValueInArray(){

        stairs = new int[]{4, 9, 8, 11, -7, 20, -14};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Stairwell stairwell = new Stairwell(stairs, 2);

            stairwell.totalStrides();
        });
    }

    // max steps 20
    @Test
    void greaterThan20ValueInArray() {

        stairs = new int[]{17,30,22,5,1};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Stairwell stairwell = new Stairwell(stairs, 2);

            stairwell.totalStrides();
        });

    }

    // max length 30 test case needed
    @Test
    void greaterThan30Length() {

        stairs = new int[]{4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,20};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Stairwell stairwell = new Stairwell(stairs, 2);

            stairwell.totalStrides();
        });

    }

    // max stride 1-4 test case needed
    @Test
    void strideGreaterThan4() {

        stairs = new int[]{4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10,4,9,8,11,7,20,14,8,9,10};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Stairwell stairwell = new Stairwell(stairs, 8);

            stairwell.totalStrides();
        });

    }
}