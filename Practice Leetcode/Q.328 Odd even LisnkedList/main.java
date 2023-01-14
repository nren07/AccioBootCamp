package VS code.Practice Leetcode.Q.328 Odd even LisnkedList;

public /**
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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(-1);
        ListNode oddHead=odd;

        ListNode curr=head;

        ListNode even=new ListNode(-1);
        ListNode evenHead=even;
        int i=0;
        while(curr!=null){
            if(i%2==0){
                odd.next=curr;
                ListNode next=curr.next;
                curr.next=null;
                curr=next;
                odd=odd.next;
            }
            else{
                even.next=curr;
                ListNode next=curr.next;
                curr.next=null;
                curr=next;
                even=even.next;
            }
            i++;
        }
        odd.next=evenHead.next;
        oddHead=oddHead.next;
        return oddHead;
    }
 } 
