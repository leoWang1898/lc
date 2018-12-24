/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/

/*
Actually, this problem gets better ways to solve but we are doing BS, so... 
Add before a judgement if the result list already got one. And, the rest part is BS. 
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //need to consider many corner cases
        if(nums1 == null || nums1.length == 0)
            return nums1;
        if(nums2 == null || nums2.length == 0)
            return nums2;
        //actually, only nums2 need to be sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            if(binarySearch(nums2,nums1[i])){
                if(!list.contains(nums1[i]))
                    list.add(nums1[i]);
            }   
        }
        //becasue java has no list to array function so...
        int[] result = new int[list.size()];
        int i = 0;
        for(int n : list){
            result[i++] = n;
        }
        return result;
    }
    private boolean binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low] == target ? true : false;
    }
}