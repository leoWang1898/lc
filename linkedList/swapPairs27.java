/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

//Three nodes to sovle old->pre->after, in the first round the old is a fakehead we make
//1.save after.next as temp 
//2.then old->after
//3.then after.pre
//4.then pre->temp
//5.update old = pre pre = temp after = temp.next; 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode after = head.next;
        ListNode result = after;
        ListNode old = new ListNode(8);
        old.next = pre;
        while(pre != null && after != null){
            ListNode temp = after.next;
            old.next = after;
            pre.next = temp;
            after.next = pre;
            old = pre;
            pre = temp;
            if(pre != null) after = pre.next;
            
        }
        return result;
    }
}