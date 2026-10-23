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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
       
        while(temp!=null){
            ListNode temp1=temp.next;
            int val=temp.val;
            while(temp1 !=null && val==temp1.val){
                temp1=temp1.next;
            }
            temp.next=temp1; 
            temp=temp1;
        }
        return head;
    }
}