/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

//Just need to compare nums[mid] with nums[high]
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]) // 说明mid还在左边
                low = mid + 1;
            else // mid已经在右边
                high = mid;
        }
        return nums[low];
    }
}