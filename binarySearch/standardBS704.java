/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, 
write a function to search target in nums. 
If target exists, then return its index, otherwise return -1.
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low] == target ? low : -1;
    }
}