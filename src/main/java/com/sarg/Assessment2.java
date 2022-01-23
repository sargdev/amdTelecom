package com.sarg;

public class Assessment2 {

    /**
     * Accepts an integer and calculates the sum of its digits.
     * If the sum is greater than 9 repeats the calculation of the sum of its digits until we get sum < 10.
     * @param num the integer that we calculate the sum of its digits. If num is negative the function calculates the
     *            absolute value.
     * @return the sum of the integer digits. Sum is always positive even if the num is negative.
     */
    public int digitSum(int num){
        num = Math.abs(num);
        int sum = 0;
        while(num != 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        if(sum < 10) {
            return sum;
        }
        return digitSum(sum);
    }
}
