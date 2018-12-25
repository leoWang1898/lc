/*
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

//Because it is sorted in ascending order, just need two pointers low and high;
//So BS and two pointer are both ok. But two pointer is faster.
class Solution {
    /* binary search
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int index = binarySearch(numbers, target - numbers[i]);
            if(index != i){
                if(numbers[i] + numbers[index] == target){
                    if(i > index)
                        return new int[]{index + 1,i + 1};
                    else
                        return new int[]{i + 1,index + 1};
                }
            }
        }
        
        return new int[]{0,0};
    }
    private int binarySearch(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }*/
    //two pointer
    public int[] twoSum(int[] numbers, int target){
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            if(numbers[low] + numbers[high] < target){
                low++;
            }
            else if(numbers[low] + numbers[high] > target){
                high--;
            }
            else{
                return new int[]{low + 1, high + 1};
            }
        }
        return new int[]{0,0};
    }
}