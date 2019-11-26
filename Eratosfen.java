import java.util.Arrays;
import java.io.*;
import java.util.*;


public class Eratosfen {
    boolean[] primes;
    int n;
    public Eratosfen(int n) {
        int nSqrt=(int)Math.round(Math.sqrt(n));
        primes=new boolean[nSqrt+1];
        
        
    }
    public void fillSieve() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        boolean isprime;
        int nSqrt=(int)Math.round(Math.sqrt(primes.length));
        System.out.print(nSqrt);
        for (int i = 2; i < nSqrt; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < nSqrt; ++j) {
                    primes[i * j] = false;
                }
            }
        }
        //System.out.println(Arrays.toString(primes));
        for (int i=0;i<nSqrt;i++)
        { if (primes[i]==true) System.out.print(i+" ");}
        System.out.println();
        //System.out.print(primes[nSqrt]);
        isprime = true;
        // ѕроверить, делитс€ ли число без остатка.
        int i=n;
        for (i=n; i<n+4; i++) 
        {
            for (int j = 2; j < primes.length; j++)
                // ≈сли число делитс€ без остатка, оно простое
                if (primes[j]==true && ((n%j) == 0)) isprime = false;
    
            if(isprime)
                System.out.println (i + " is prime.");
        }
    }
    
    public static void main (String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        int Val = Integer.parseInt(input);
        Eratosfen NGen = new Eratosfen(Val);
        NGen.fillSieve();
        
    }

}