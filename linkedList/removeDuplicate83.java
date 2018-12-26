/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2
*/

//judge if head.val = head.next.val and using a inner whileloop to solve one kind # a time
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = head;
        while(fake != null){
            int temp = fake.val;
            while(fake != null && fake.next != null && fake.next.val == temp){
                fake.next = fake.next.next;
            }
            fake = fake.next;
        }
        return head;
    }
}