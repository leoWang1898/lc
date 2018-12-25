/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

//Using a index to point next non-zero position, another index to find non-zero number
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[fast] == 0)
                fast++;
            else{
                nums[slow++] = nums[fast++];
            }
        }
        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}