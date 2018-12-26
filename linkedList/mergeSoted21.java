/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

//This is a two pointer question. Set a fake head would make it easier.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head = new ListNode(8);
        ListNode result = head;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                head.next = head1;
                head = head.next;
                head1 = head1.next;
            }
            else{
                head.next = head2;
                head = head.next;
                head2 = head2.next;
            }
        }
        //No need of while loop
        if(head1 != null){
            head.next = head1;
        }
        if(head2 != null){
            head.next = head2;
        }
        return result.next;
    }
}