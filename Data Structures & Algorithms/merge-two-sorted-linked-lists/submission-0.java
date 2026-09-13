/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultHead = null;
        ListNode curr1 = list1, curr2 = list2, prev = null;
        if(list1 == null) {
            return list2;
        }else if(list2 == null) {
            return list1;
        } 
        while(curr1!=null && curr2!=null) {
            ListNode curr = null;
            if(curr1.val < curr2.val) {
                curr = curr1;
                curr1 = curr1.next;
            }else {
                curr = curr2;
                curr2 = curr2.next;
            }
            if(resultHead == null) {
                resultHead = curr;
            }else {
                prev.next = curr;
            }
            prev = curr;
        }
        while(curr1!=null) {
            prev.next = curr1;
            prev = curr1;
            curr1 = curr1.next;
        }
        while(curr2!=null) {
            prev.next = curr2;
            prev = curr2;
            curr2 = curr2.next;
        }
        return resultHead;

    }
}