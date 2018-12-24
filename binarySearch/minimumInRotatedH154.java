/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

Duplicate may exist in the array.
*/

//Same as 153 but high-- when nums[mid] == nums[high]
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == nums[high]){
                high--;
            }
            else if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}