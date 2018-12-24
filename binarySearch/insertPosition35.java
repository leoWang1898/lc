/*
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4
You may assume no duplicates in the array.
*/

//This is a smallest greater than + standard BS = Smallest Equal to or Greater Than question.
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1]) return nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low; 
    }
}