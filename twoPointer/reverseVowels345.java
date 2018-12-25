/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"
*/

//pointer low and high point to vowels and swap
class Solution {
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        int low = 0;
        int high = sc.length - 1;
        String vowels = "aeiouAEIOU";
        while(low < high){
            while(low < high && !vowels.contains(sc[low]+"")){ //contains must be string not character
                low++;
            }
                
            while(low < high && !vowels.contains(sc[high]+"")){
                high--;
            }
            if(low < sc.length && high > -1){
                char temp = sc[low];
                sc[low] = sc[high];
                sc[high] = temp;
                low++;
                high--;
            }
        }
        return new String(sc);// no char[] to String api again!
    }
}