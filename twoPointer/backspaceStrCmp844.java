/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. 
# means a backspace character.

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
*/

//One later # could delete a former character and the # is cumulative. So scaning from tail to head
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder rs = compress(S);
        StringBuilder rt = compress(T);
        return (rt.toString()).equals(rs.toString()); // == compares the address, equals compare the content
    }
    //S and T need same operations to be compressed so write a function to DRY.
    private StringBuilder compress(String S){
        int ls = S.length();
        int index = ls - 1; //scanning from the tail to head
        int counter = 0;
        StringBuilder rs = new StringBuilder();
        //find the first #, all characters at the tail should be appended
        while(index > -1 && S.charAt(index) != '#'){
            rs.append(S.charAt(index));
            index--;
        }

        while(index > -1){
        	// counter to save the # of '#'
            if(index > -1 && S.charAt(index) == '#'){
                counter++;
                index--;
            }
            // one character uses one #
            if(index > -1 && S.charAt(index) != '#'){
                if(counter <= 0){
                    rs.append(S.charAt(index));
                    index--;
                }
                else{
                    counter--;
                    index--;
                }
            }
        }
        return rs;
    }
}