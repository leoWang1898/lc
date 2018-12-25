/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
*/

//Main difference with 349 is the duplicate of result, I tried BS but did not figure out. 
//Two pointer is quite stright forward, you just need to scan two Array using two pointer.
//But sort is necessary before the scaning.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        List<Integer> list = new ArrayList<>();
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                list.add(nums1[index1]);
                index1++;
                index2++;
            }
            else if(nums1[index1] < nums2[index2]){
                index1++;
            }
            else{
                index2++;
            }
        }
        //No list to Array api, so belowing is transforming list to Array;
        int i = 0;
        int[] result = new int[list.size()];
        for(int n : list){
            result[i++] = n;
        }
        return result;
    }
}