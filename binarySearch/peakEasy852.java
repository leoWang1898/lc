/*
Let's call an array A a mountain if the following properties hold:
(1)A.length >= 3
(2)There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, 
return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
*/

class Solution {
    /*O(n)solution.
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 0; i < A.length - 2; i++){
            if(A[i] < A[i + 1] && A[i + 1] > A[i + 2]) return i + 1;
        }
        return 0;
    }
    */
    
    //The key is at the peak point A[mid] > A[mid + 1] && A[mid] > A[mid - 1]
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while( low < high){
            int mid = low + (high - low) / 2;
            if(A[mid - 1] < A[mid] && A[mid + 1] < A[mid]){
                return mid;
            }
            //Uphill
            if(A[mid] > A[mid - 1] && A[mid] < A[mid + 1]){
                low = mid + 1;
            }
            //Downhill
            if(A[mid] < A[mid - 1] && A[mid] > A[mid + 1]){
                high = mid;
            }
        }
        return low;
    }
}