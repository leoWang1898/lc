/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
/*

//reverse the link and compare one by one.
//reverse from the median could be more time and space saving
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = reverse(findMedian(head));
        while(pointer2 != null){//l2 is shorter than l1 
            if(pointer1.val != pointer2.val)
                return false;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return true;
    }
    private ListNode findMedian(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        ListNode newHead = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = newHead;
            newHead = node;
            node = temp;
        }
        return newHead;
    }
}