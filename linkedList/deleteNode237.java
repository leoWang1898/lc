/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
Given linked list -- head = [4,5,1,9], which looks like following:
4 -> 5 -> 1 -> 9

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list
             should become 4 -> 1 -> 9 after calling your function.
*/

//This question is weird because the node need to be deleted is given but dont it's previous node
//So it could be done by value pass, the real node which is deleted is node.next
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}