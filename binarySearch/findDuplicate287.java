/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.
*/

/*
Two solotions
(1)count the # of numsers, if # <= mid then the duplicat is in [mid + 1, n] else in [1, mid];
(2)映射找环法 http://t.cn/RjR24fe, two pointers, one is slow and the other is fast.
   First while stop when fast(2 steps) = slow(1 step) then fast = 0; second while stop when fast(1 step) = slow(1 step)
*/
class Solution {
    /*
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            int count = 0;
            for(int n : nums){
                if(n <= mid) count++;
            }
            if(count <= mid){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        fast = 0;
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}