/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

//Using two stacks to save the val and pre and current to scan, fakehead to set pre.val as 0 in the first round.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode pre = new ListNode(0);//fakehead
        while(!s1.isEmpty() || !s2.isEmpty()){
            int val= pre.val;
            if(!s1.isEmpty()) val += s1.pop();
            if(!s2.isEmpty()) val += s2.pop();
            ListNode node = new ListNode(val/10);
            pre.val = val%10;
            node.next = pre;
            pre = node;
        }
        return pre.val == 0 ? pre.next : pre;
    }
}