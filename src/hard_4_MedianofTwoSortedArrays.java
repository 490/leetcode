/**
 * created by zl on 2019/4/9 14:19
 */
public class hard_4_MedianofTwoSortedArrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)   //保证数组1一定最短
            return findMedianSortedArrays(nums2,nums1);
        int L1 = 0,L2 = 0,R1 = 0,R2 = 0,c1 = 0,c2 = 0,lo = 0, hi = 2*n;  //我们目前是虚拟加了'#'所以数组1是2*n长度
        while(lo <= hi)   //二分
        {
            c1 = (lo+hi) / 2;  //c1是二分的结果
            c2 = m+n- c1;
            L1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1-1)/2];   //Li = (Ci-1)/2 , Ri = Ci/2
            R1 = (c1 == 2*n) ? Integer.MAX_VALUE : nums1[c1/2];
            L2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2-1)/2];
            R2 = (c2 == 2*m) ? Integer.MAX_VALUE : nums2[c2/2];

            if(L1 > R2)
                hi = c1-1;
            else if(L2 > R1)
                lo = c1+1;
            else
                break;
        }
        return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
    }
}
