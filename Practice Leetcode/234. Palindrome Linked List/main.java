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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public int getLength(ListNode head){
        ListNode curr=head;
        int len=0;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        return len;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;
        int size=getLength(head);
        if(size==1){
            return true;
        }
        int i=1;
        while(i<size/2){
            curr=curr.next;
            i++;
        }
        ListNode next=curr.next;
        curr.next=null;
        ListNode head2=reverseList(next);
        while(head!=null){
            if(head.val!=head2.val) return false;
            else{
                head=head.next;
                head2=head2.next;
            }
        }
        return true;
    }
}