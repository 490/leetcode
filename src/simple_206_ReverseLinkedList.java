/**
 * created by zl on 2019/3/28 19:40
 */
public class simple_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head)
    {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode p = new ListNode(head.val);
        p.next = null;
        while(head.next!=null)
        {
            ListNode n = new ListNode(head.next.val);
            n.next = p;
            p = n;
            head = head.next;
        }
        return p;
    }
}
