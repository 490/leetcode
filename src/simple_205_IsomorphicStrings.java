/**
 * created by zl on 2019/3/28 19:27
 */
public class simple_205_IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t) {
        int [] m1 = new int[256];
        int [] m2 = new int[256];
        for(int i = 0;i < 256;i++)
        {
            m1[i]=-1;
            m2[i]=-1;
        }
        for(int i = 0;i < s.length();i++)
        {
            if(m1[s.charAt(i)]!=m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)]=m2[t.charAt(i)]=i;
        }
        return true;
    }
}
