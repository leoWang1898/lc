/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
*/

//pre and current, in the while loop another node to remenber the current.next
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Iteration. Using a node to remember head.next
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;//
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}

//recursion
class Solution {
	public ListNode reverseList(ListNode head) {
    	return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
    	if (head == null)
        	return newHead;
    	ListNode next = head.next;
    	head.next = newHead;
    	return reverseListInt(next, head);
	}
}