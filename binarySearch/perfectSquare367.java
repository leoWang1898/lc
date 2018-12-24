/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.
*/

//This is just a standard BS question and the only thing need to care is overflow, so use long not int
class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num/2; //num/2 to reduce one operation each time and prevent from overflowing
        while(low < high){
            long mid = low + (high - low)/2;
            if(mid*mid == num)
                return true;
            else if(mid*mid < num)
                low = mid + 1;
            else
                high = mid;
        }
        return low*low == num ? true : false;
    }
}