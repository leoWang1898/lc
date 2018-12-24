/*
744. Find Smallest Letter Greater Than Target
Given a list of sorted characters letters containing only lowercase letters, 
and given a target letter target, find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
*/
/*
!!!This is a very important question
Smallest Greater Than
if(letters[mid] "<=" target) //小于等于
    low = mid + 1;
else
	high = mid;

Smallest Equal to or Greater Than
if(letters[mid] "<" target) //小于
    low = mid + 1;
else
	high = mid;

Biggest Less Than
if(letters[mid] "<=" target) //小于等于
    low = mid + 1;
else
	high = mid;
return low - 1; //nums[low - 1] is biggest less than

Biggest Equal to or Less Than
if(letters[mid] "<" target) //小于
    low = mid + 1;
else
	high = mid;
return low - 1 //nums[low - 1] is biggest equal to or less than

The four questions are very classic in BS questions!!!
*/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length - 1]) return letters[0];//because letters also wrap around
        int low = 0;
        int high = letters.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(letters[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return letters[low];
    }
}