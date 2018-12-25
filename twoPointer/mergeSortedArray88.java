/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

//two pointer for two arrays and scan from tail to head can void extra space usage
//one pointer points to the next valid position
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        while(index1 > -1  && index2 > -1){
            if(nums1[index1] < nums2[index2]){
                nums1[index] = nums2[index2];
                index2 --;
                index--;
            }
            else{
                nums1[index] = nums1[index1];
                index1--;
                index--;
            }
        }
        //do not care index1 because the nums1 is used for storage
        while(index2 > -1){
            nums1[index--] = nums2[index2--];
        }
        return;
    }
}