/*
The Intersection only appears at the tail.
Like 1 2 3 4 and 6 7 3 4
*/

//tricky part is l1 and l2 are not the same long but l1 + l2 = l2 + l1
//So when we reach the end of l1 we continue to scan l2 and the same for l2.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        //When they become null at the same time, the while loop terminate too
        while(a != b){
            if(a == null) a = headB;
            else a = a.next;
            if(b == null) b = headA;
            else b = b.next;
            
        }
        return a;
    }
}