/**
 * created by zl on 2019/3/28 10:50
 */
public class simple_161_IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode n1, ListNode n2)
    {
        if(n1==null || n2==null)
            return null;
        ListNode  longlist= n1;
        ListNode  shortlist= n2;
        int n1_len = 0;
        int n2_len = 0;
        while(n1.next!=null)
        {
            n1 = n1.next;
            n1_len++;
        }
        while(n2.next!=null)
        {
            n2 = n2.next;
            n2_len++;
        }
        //System.out.println(n1_len+","+n2_len);
        int diff = n1_len>n2_len?(n1_len-n2_len):(n2_len-n1_len);

        if(n1_len<n2_len)
        {
            ListNode tmp = shortlist;
            shortlist = longlist;
            longlist = tmp;
        }

        n1 = longlist;
        n2 = shortlist;
        while(diff>0)
        {
            n1 = n1.next;
            diff--;
        }
        // System.out.println("n1.start="+n1.value);
        while(n1!=null && n2!= null&&n1!=n2)
        {
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
}
