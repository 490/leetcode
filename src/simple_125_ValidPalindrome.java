/**
 * created by zl on 2019/3/28 9:58
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class simple_125_ValidPalindrome
{
    public boolean isPalindrome(String s)
    {
        if(s==null||s.length()==0||s.length()==1)
            return true;
        s = s.toLowerCase();

        if(s==null||s.length()==0||s.length()==1)
            return true;
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<p2)
        {
            if(!(s.charAt(p1)>='a' && s.charAt(p1)<='z')&&
                    !(s.charAt(p1)>='0' && s.charAt(p1)<='9'))
            {
                p1++;
                continue;
            }
            if(!(s.charAt(p2)>='a' && s.charAt(p2)<='z')&&
                    !(s.charAt(p2)>='0' && s.charAt(p2)<='9'))
            {
                p2--;
                continue;
            }

            if(s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
}
