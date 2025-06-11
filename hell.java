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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> a=new ArrayList<>();
        ListNode t=head,temp=head;
        while(t!=null){
            a.add(t.val);
            t=t.next;
        }
        Collections.sort(a);
        for(int i=0;i<a.size();i++){
            temp.val=a.get(i);
            temp=temp.next;
        }
        return head;
    }
}
