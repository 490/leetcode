/**
 * created by zl on 2019/3/28 18:56
 *
 * [1,1] 1
 * [1,2,3] 1
 * [1,2,3] 3
 *
 */
public class simple_203_RemoveLinkedListElements
{
    public ListNode removeElements(ListNode head, int val)
    {
        while (head != null && head.val == val)
        {
            head = head.next;
        }

        if (head == null)
        {
            return null;
        }

        ListNode node = head.next;
        ListNode last = head;
        while (node != null)
        {
            if (node.val == val)
            {
                last.next = node.next;
            } else
            {
                last = node;
            }
            node = node.next;
        }
        return head;
    }
}
