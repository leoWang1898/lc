/*
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
*/

//Just two pointers 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode result = even;
        ListNode odd1 = odd;
        ListNode pre = even;
        while(odd != null && even != null){
            if(even.next != null)
                even.next = even.next.next;
            if(odd.next != null)
                odd.next = odd.next.next;
            pre = even; //this is to solve when even = null because we want to contach even and odd
            even = even.next;
            odd = odd.next;
        }
        if(even != null)
            even.next = odd1;
        else
            pre.next = odd1;
        return result;
    }
}