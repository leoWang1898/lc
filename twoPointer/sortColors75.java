/*
Given an array with n objects colored red, white or blue, 
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/

//two scan, the first to swap all the 0s to the head then the left part is a standard two pointer problem
class Solution {
    public void sortColors(int[] nums) {
        int index1 = 0;
        int index2 = 0;
        //handle 0s first
        while(index2 < nums.length){
            while(index2 < nums.length && nums[index2] != 0)
                index2++;
            if(index2 < nums.length){
                int temp = nums[index2];
                nums[index2] = nums[index1];
                nums[index1] = temp;
                index1++;
                index2++;
            }
            
        }
        //handle 1s and 2s
        int pointer1 = index1, pointer2 = nums.length - 1;
        while(pointer1 < pointer2){
            // pointer1 < pointer is necessary because you have pointer++ opreation in the while loop
            while(pointer1 < pointer2 && nums[pointer1] == 1)
                pointer1++;
            while(pointer1 < pointer2 && nums[pointer2] == 2)
                pointer2--;
            if(pointer1 < pointer2){
                int temp = nums[pointer1];
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = temp;
                pointer1++;
                pointer2--;
            }
        }
        return;
    }
}