/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.
*/

//One pointer scan to find next vald number, another points to next valid position.
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        nums[index++] = nums[0];
        //compare nums[i] != nums[i - 1] to avoid i + 1 out of boundary
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}