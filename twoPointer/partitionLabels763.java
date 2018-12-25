/*
A string S of lowercase letters is given. We want to partition this string into 
as many parts as possible so that each letter appears in at most one part, 
and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/

//This is kind like a intervel question the key is we found the last position for every character and,
//those last positions are include in one character's last position we part it as one partition
class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] sc = S.toCharArray();
        int l = S.length();
        int[] last = new int[26]; //because only lowercase
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < l; i++){
            last[sc[i] - 'a'] = i;
        }
        int index = 0;
        int begin = 0;
        for(int i = 0; i < l; i++){
            //to find one index is the max of all scaned character and the index is now i
            index = Math.max(last[sc[i] - 'a'], index);
            if(index == i){
                list.add(i - begin + 1);
                begin = i + 1;
            }
        }
        return list;
    }
}