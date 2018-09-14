package Models;


public class Validator {

    /*
    * Validation Helper Class
    * */
    public Validator(){};


    /*
    *Max array length 30 (30 flights of stairs)
    */
    public boolean validArrayLength(int[] theArray){
        return theArray.length <= 30 ? true : false;
    }

    /*
    * Max steps 20 per flight
    * */
    public boolean validSteps(int stepValue){
        return stepValue > 0 && stepValue <= 20 ? true : false;
    }

    /*
    *Stride 1 - 4 only
    * */
    public boolean validNumberOfStrides(int strideValue){
        return strideValue > 0 && strideValue <=4 ? true : false;
    }

    /*
    * Validate the array by checking if the values are not negative or zero
    * or greater than 20 per flight and the there is no more than 30 flights
    * and strides are between 1 and 4
    * */
    public boolean validateArray(int[] theArray, int strides){

        /*
        * Invalid input if the length is > 30 or the number of strides is not between 1 and 4
        * */
        if(!validArrayLength(theArray) || !validNumberOfStrides(strides)){
            return false;
        }

        /*
        * If the number of steps in a flight are not between 0 and 20
        * the steps are invalid
        * */
        for (int num : theArray ) {
            if(!validSteps(num)){
                return false;
            }
        }

        /*
        * Otherwise we have valid input
        * */
        return true;
    }
}
