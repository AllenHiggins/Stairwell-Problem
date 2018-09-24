package Models;

import java.util.Arrays;

public class Stairwell {

    private int[] stairWell;

    private int STRIDE;

    /*
    * Create a new Validator object for checking if the values in the array are valid
    * */
    private  Validator validator = new Validator();

    /*
    * Pass in the array of stairwell values and the stride value
    * */
    public Stairwell(int[] stairWell, int STRIDE ){

        this.stairWell = stairWell;

        this.STRIDE = STRIDE;

    }


    /*
    * Method will throw an exception if array is not valid or it is empty
    * */
    public int totalStrides() throws IllegalArgumentException, ArrayIndexOutOfBoundsException {

        /*
        * Throw exception if array is empty
        * */
        if(stairWell.length == 0){
            throw new ArrayIndexOutOfBoundsException("Cannot have an empty array {}");
        }

        /*
        * If the Array contains any negative or zero values or steps > 20
        * or more than 30 flights or stride not between 1 and 4
        * throw an exception as the array is not valid
        * and there is no need to execute the rest of the code
        * */
        if(!validator.validateArray(stairWell, STRIDE)){
            throw new IllegalArgumentException("A negative number (-1) or a zero (0) value is not allowed. " +
                    "Max array value accepted is 20. Max lenght is 30. " +
                    "Stride counter must between 1 and 4.");
        }

        /*
        * If the array is valid
        * init total and the current number of Stair to zero
        * */
        int total = 0, currentStairWellTotal = 0;

        /*
        * Get the number of landings at a cost of 2 each
        * (arrays od length 1 have no landing. we do not count last landing at top of stairwell hence -1)
        * Computation is faster than iterationg
        * take the length of the array -1 and multiply the result by the landing cost (2)
        * e.g: length = 1 => 1-1 = 0 * 2 = 0
        *      length = 2 => 2-1 = 1 *2 = 2
        *      ...
        * */
        int landingsStepTotal = (stairWell.length - 1) * 2;


        /*
        * Sort the Array
        * Quicker to find any negative numbers or a zero instead of iterating through the Array
        * Also useful for checking if the current value is the same as the last
        * No need to recalculate if it is - faster algorithm
        * */
        Arrays.sort(stairWell);

        /*
        * To get each number of stairs in the array and calculate the strides to reach a landing
        * iterate through the array one at a time
        * */
        for (int i = 0; i < stairWell.length; ++i) {


            /*
            * If the value in the current position of the array is the same as the last value
            * hence i > 0
            * no need to calculate it again - simple add the last result onto the total
            * and continue to the next value in the array as their is no need to execute the rest of the code
            * */
            if ((i > 0) && (stairWell[i] == stairWell[i - 1])) {

                total += currentStairWellTotal;

                continue;
            }

            /*
            * Other wise the array value is different
            * now there is a need to get the current number of strides for this stairway
            * */
            currentStairWellTotal = getCurrentStairTotal(stairWell[i]);

            /*
            * Sum up the total number of strides overall
            * */
            total += currentStairWellTotal;
        }

        /*
         * Return the total number of landing costs added with the total number of strides overall
         * The returning int value is the answer
         * */
        return total + landingsStepTotal;
    }

    /*
    * Gets the number of strides for a current stairwell - Not including the landing!
    * Pass in the current stairwell steps amount
    * */
    private int getCurrentStairTotal(int numberOfSteps){

        /*
        * Variables for modulo of stride into stairs and the remainder left over
        * e.g. 17 mod 3 = 5 (5*3 = 15) with 2 remainder
        *   so if there is 17 steps and stride is 3 we can cover 15 steps in 5 counts
        *   plus 1 count for the remainder which is a total of 6
        * */
        int remaindingStrides, evenlyDividedStrides;

        /*
        * Set a minimum stride value ( and any extra stride count - remainder after the modulo )
        * */
        final int MINIMUM_STRIDE = 1, EXTRA_STRIDE_COUNT = 1;


        /*
        * If the number of steps is less than or equal to the number of strides the returning value will always be 1
        * e.g: number of steps is 1
        *      stride is 2
        *      1/2 = 0.5 (floor = 0) but 1 stride must be taken
        *      ans = 1
        *
        *      number of steps is 2
        *      stride is 2
        *      2/2 = 1
        *      ans = 1
        * */
        if( numberOfSteps <= STRIDE){

            return MINIMUM_STRIDE;
        }

        /*
        * If the stride is more than one step at a time preform the modulo calculation
        * otherwise the stride is one step at a time so we can simply return the number of steps
        * as our stride count
        * */
        if(STRIDE > MINIMUM_STRIDE){

            /*
            * Set the remainder e.g 17 mod 3 = 2
            * */
            remaindingStrides = (numberOfSteps%STRIDE);

            /*
            * Set the mod value e.g 3 into 17 = 5.3333
            * floor it to just 5
            * */
            evenlyDividedStrides = Math.floorDiv(numberOfSteps,STRIDE);


            /*
            * Returning the calculation
            *
            * If there are remaining steps add 1
            * e.g 17 mod 3 = 2
            *     17 / 3 = 5
            *     5+1=6 (the remaining steps (2) can be covered in one stride )
            * */
            if(remaindingStrides > 0 ){

                return evenlyDividedStrides + EXTRA_STRIDE_COUNT;
            }

            /*
            * Otherwise there are no remaining steps
            * */
            return evenlyDividedStrides;
        }

        /*
        * If stride to take is equal to 1 (Greater than the MINIMUM_STRIDE )
        * simply return the number of steps in the current stairwell
         * */
        return numberOfSteps;
    }

}
