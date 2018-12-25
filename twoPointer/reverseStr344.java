/*
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
*/
//A low pointer and a high pointer swap
class Solution {
    public String reverseString(String s) {
        char[] sc = s.toCharArray(); //转换成char[]数组方便操作
        int low = 0;
        int high = sc.length - 1;
        while(low < high){ //不用担心奇数偶数问题，和这里的等号，不影响
            char temp = sc[low];
            sc[low] = sc[high];
            sc[high] = temp;
            low++;
            high--;
        }
        return new String(sc); //没有char[] to String的api，所以用构造方法实现
    }
}