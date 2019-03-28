/**
 * created by zl on 2019/3/28 13:15
 */
public class simple_171_ExcelSheetColumnNumber
{
    public int titleToNumber(String s)
    {
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); ++i) {
            tmp = s.charAt(i) - 'A' + 1;
            sum = 26 * sum + tmp;
        }
        return sum;
    }
}
