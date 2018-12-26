/*
We are given head, the head node of a linked list containing unique integer values.
We are also given the list G, a subset of the values in the linked list.
Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:
Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
*/

//If G does not contain node.val it means it is a split point
//set is fatser than list doing search.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int n : G){
            set.add(n);
        }
        while(head != null){
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))){
                result++;
            }
            head = head.next;
        }
        return result;
    }