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
    public ListNode swapNodes(ListNode head, int k) {
        int jump1=k-1;
        int length=0;
        ListNode curr=head;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        ListNode n1=head;
        ListNode n2=head;
        int counter=0;
        while(counter<jump1){
            counter++;
            n1=n1.next;
        }
        int jump2=length-k;
        counter=0;
        while(counter<jump2){
            counter++;
            n2=n2.next;
        }
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
        
        return head;
    }
}