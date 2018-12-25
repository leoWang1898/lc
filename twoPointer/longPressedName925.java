/*
Your friend is typing his name into a keyboard.  
Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  
Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
*/

//The main idea is typed should repeat every character one or more times.
//Pointers sacn each part of the name and corresponding typed.
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int l1 = name.length();
        int l2 = typed.length();
        int index1 = 0;
        int index2 = 0;
        while(index1 < l1 && index2 < l2){
            char c1 = name.charAt(index1);
            char c2 = typed.charAt(index2);
            if(c1 != c2) return false;
            int count = 0;
            while(index1 < l1 && c1 == name.charAt(index1)){
                count--;
                index1++;
            }
            while(index2 < l2 && c2 == typed.charAt(index2)){
                count++;
                index2++;
            }
            if(count < 0)
                return false;
        }
        if(index1 < l1 || index2 < l2) return false;//最后两个字串应该都扫描到终点
        return true;
    }
}