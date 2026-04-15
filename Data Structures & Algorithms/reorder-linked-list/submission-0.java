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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode mid = getMiddle(head);

        ListNode hs = reverseList(mid.next);
        mid.next=null;

        ListNode hf = head;

        while(hs!=null){
            ListNode temp1=hf.next;
            ListNode temp2=hs.next;

            hf.next=hs;
            hs.next=temp1;

            hf = temp1;
            hs=temp2;
        }
    }
    public ListNode getMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode prev=null;
        ListNode present=head;

        while(present!=null){
            ListNode future = present.next;
            present.next=prev;
            prev=present;
            present=future;
        }
        return prev;
    }
}
