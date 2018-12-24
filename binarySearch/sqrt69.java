/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
向下取整
*/

/*
This is the opposite question of 367 and a equal to or less than question
*/

class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int low = 1;
        int high = x/2;
        while(low < high){
            int mid = low + (high - low)/2;
            if(mid == x/mid) return mid; //division instead of multiplication to avoid overflow
            else if(mid < x/mid) low = mid + 1;
            else high = mid;
        }
        return low - 1;
    }
}