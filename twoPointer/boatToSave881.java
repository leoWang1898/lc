/*
The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
*/

//This is actually a greedy problem
//Still the low and high are used, and noticed the very important condition "Each boat carries at most 2 people"
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int low = 0;
        int high = people.length - 1;
        //low <= high not low < high because when odd # people, the middle one need to be cared too
        while(low <= high){
            if(low <= high && people[high] + people[low] <= limit){
                low++;
            }
            result++;
            high--;
        }
        return result;
    }
}