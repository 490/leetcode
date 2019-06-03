/**
 * created by zl on 2019/6/3 9:45
 */
public class medium_365_WaterandJugProblem
{
    public boolean canMeasureWater(int x, int y, int z)
    {
        if(x + y < z)
        {
            return false ;
        }
        int gcd = gcd(x,y) ;
        if(gcd == 0)
        {
            return z == 0 ;
        }
        return z % gcd == 0 ;
    }

    private int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a ;
        }
        return gcd(b,a%b);
    }
}
