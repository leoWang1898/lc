/*

*/

//Key is to find the length and l/k and l%k and solve with different k and l relationship
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int l = 0;
        ListNode head = root;
        ListNode[] result = new ListNode[k];
        while(head != null){
            head = head.next;
            l++;
        }
        if(k >= l){
            ListNode fake = root;
            int i = 0;
            while(fake != null){
                result[i] = fake;
                fake = fake.next;
                result[i++].next = null;
            }
            while(i < k){
                result[i++] = null;
            }
        }
        else{
            int integer = l/k;
            int remainder = l%k;
            ListNode fake = root;
            int i = 0;
            if(remainder == 0){
                while(fake != null){
                    int count = integer;
                    ListNode dummy = null;
                    while(fake != null && count > 0){
                        if(count == integer){
                            result[i] = fake;
                            dummy = result[i];
                        }
                        else{
                            dummy.next = fake;
                            dummy = dummy.next;
                        }
                        count--;
                        fake = fake.next;
                    }
                    dummy.next = null;
                    i++;
                }
            }
            else{
                while(fake != null){
                    if(remainder > 0){
                        int count = integer + 1;
                        remainder--;
                        ListNode dummy = null;
                        while(fake != null && count > 0){
                            if(count == integer + 1){
                                result[i] = fake;
                                dummy = result[i];
                            }
                            else{
                                dummy.next = fake;
                                dummy = dummy.next;
                            }
                            count--;
                            fake = fake.next;
                        }
                        dummy.next = null;
                        i++;
                    }
                    else{
                        int count = integer;
                        ListNode dummy = null;
                        while(fake != null && count > 0){
                            if(count == integer){
                                result[i] = fake;
                                dummy = result[i];
                            }
                            else{
                                dummy.next = fake;
                                dummy = dummy.next;
                            }
                            count--;
                            fake = fake.next;
                        }
                        dummy.next = null;
                        i++;
                    }
                }
            }
        }
        return result;
    }
}

//Compare to this, my code is just like shit
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next)
            len++;
        int n = len / k, r = len % k; // n : minimum guaranteed part size; r : extra nodes spread to the first r parts;
        ListNode node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;        
    }
}