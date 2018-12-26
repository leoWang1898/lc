/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/

//A fakehead would make it easier, inner while loop to delete continouns val in one time;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(8);
        newHead.next = head;
        ListNode result = newHead;
        while(newHead != null){
            while(newHead.next != null && newHead.next.val == val){
                newHead.next = newHead.next.next;
            }
            newHead = newHead.next;
        }
        return result.next;
    }
}