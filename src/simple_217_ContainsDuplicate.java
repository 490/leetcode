import java.util.HashSet;
import java.util.Set;

/**
 * created by zl on 2019/3/28 19:47
 */
public class simple_217_ContainsDuplicate
{
    public boolean containsDuplicate(int[] nums)
    {
        if (null == nums || nums.length == 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (Integer num:nums){
            if ( set.contains(num) )
                return true;
            else
                set.add( num );
        }
        return false;
    }
}
