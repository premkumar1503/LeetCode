class CountGoodArrays
{
    static final int MOD = (int) 1e9 + 7;
    static final int MX = 100000;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static long qpow(long x, int n)
    {
        long res = 1;
        while (n > 0)
        {
            if ((n & 1) == 1)
            {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
    static
    {
        fact[0] = 1;
        for (int i = 1; i < MX; i++)
        {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--)
        {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }
    long comb(int n, int m)
    {
        if (m < 0 || m > n) return 0;
        return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
    }
    public int countGoodArrays(int n, int m, int k)
    {
        if (m == 1) return k == n - 1 ? 1 : 0;
        return (int) ((((comb(n - 1, k) * m) % MOD) * qpow(m - 1, n - k - 1)) % MOD);
    }
}
public class _3405_Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements_
{
    public static void main(String[] args)
    {
        CountGoodArrays sol = new CountGoodArrays();
        int n1 = 4, m1 = 2, k1 = 1;
        System.out.println("Result for n = " + n1 + ", m = " + m1 + ", k = " + k1 + ": " + sol.countGoodArrays(n1, m1, k1));

        int n2 = 5, m2 = 3, k2 = 2;
        System.out.println("Result for n = " + n2 + ", m = " + m2 + ", k = " + k2 + ": " + sol.countGoodArrays(n2, m2, k2));
    }
}

