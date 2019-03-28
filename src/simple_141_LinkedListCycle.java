/**
 * created by zl on 2019/3/28 10:33
 */
public class simple_141_LinkedListCycle
{
    public boolean hasCycle(ListNode head)
    {
        if(head==null || head.next==null)
            return false;
        ListNode walk = head;
        ListNode run = head;
        while(run.next!=null && run.next.next!=null)
        {
            walk = walk.next;
            run  = run.next.next;
            if(walk==run)
                return true;
        }
        return false;
    }
}
