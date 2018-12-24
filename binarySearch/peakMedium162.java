/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.
*/
/*
TThe neighbors of nums[mid] got the following 4 situations
1，如果num[mid-1] < num[mid] 且 num[mid] < num[mid+1] 则说明，峰值在右半部分。start = mid+1
2，如果num[mid-1] > num[mid] 且 num[mid] > num[mid+1]，则说明，峰值在左半部分。end = mid-1
3，如果num[mid-1] < num[mid] 且 num[mid] > num[mid+1]，则mid处就是峰值。
4，如果num[mid-1] > num[mid] 且 num[mid] < num[mid+1]，则说明该数组不止一个峰值，此时start = mid+1，或者end = mid-1均可。

*/
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}