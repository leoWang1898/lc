/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
Output: 
"apple"
*/

//for every word in the dictionary use two pointers, one for s and one for d[i]
class Solution {
    public String findLongestWord(String s, List<String> d) {
        int ls = s.length();
        String result = "";
        for(String n: d){
            int l = n.length();
            int index1 = 0;
            int index2 = 0;
            while(index2 < l && index1 < ls){
                if(s.charAt(index1) != n.charAt(index2)){
                    index1++;
                }
                else{
                    index1++;
                    index2++;
                }
            }
            if(index2 == l){// Proved at least the d[i] is a valid candidate
                if(result == null){
                    result = n;
                }
                else{
                    //if d[i] has longer length
                    if(l > result.length()){
                        result = n;
                    }
                    //if they have same length do lexicographical order compare with "compareTo"
                    else if(l == result.length()){
                        // return 1 means the lexicographical order result > n, need update result
                        // return 0 means the lexicographical order result = n
                        // return -1 means the lexicographical order result < n
                        if(result.compareTo(n) > 0){
                            result = n;
                        }
                    }
                    //if n.length < result.length, then continue to find a longer one.
                    else{
                        continue;
                    }
                }
            }
        }
        return result;
    }
}