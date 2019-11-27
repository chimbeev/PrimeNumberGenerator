import java.io.*;
import java.util.*;

public class PNGen
{ 
    int SQRT_MAXN = 100000; // корень из максимального значения N
    int S = 10000;
    boolean nprime [] = new boolean [SQRT_MAXN];
    boolean bl[] = new boolean [S];
    int primes[] = new int [SQRT_MAXN];
    int cnt;
    
  
  public static void main (String args[])
  {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    in.close();
    int Val = Integer.parseInt(input);
    PNGen NGen = new PNGen(Val);
    //System.out.println("\n"+ NGen.GetNextPrime()+ " " + NGen.GetNextPrime()+ " " + NGen.GetNextPrime());
    //System.out.println("\n"+ NGen.GetNextPrime());
  }

  PNGen(int start) 
            
  {  
    
    
    int n=start;
    int nsqrt = (int)Math.sqrt(n);
        for (int i=2; i<=nsqrt; ++i)
            if (!nprime[i]) 
            {
                primes[cnt++] = i;
                if (i * 111 * i <= nsqrt)
                    for (int j=i*i; j<=nsqrt; j+=i)
                        nprime[j] = true;
            }
    
        int result = 0;
        for (int k=0, maxk=n/S; k<=maxk; ++k) 
        {
           // memset (bl, 0, sizeof bl);
            int start1 = k * S;
            for (int i=0; i<cnt; ++i) 
            {
                int start_idx = (start1 + primes[i] - 1) / primes[i];
                int j = Math.max(start_idx,2) * primes[i] - start1;
                for (; j<S; j+=primes[i])
                    bl[j] = true;
            }
            if (k == 0)
                bl[0] = bl[1] = true;
            for (int i=0; i<S && start1+i<=n; ++i)
                if (!bl[i])
                    ++result;
        }
        System.out.println(result);
    }

  int GetNextPrime()
  {     int res1 =0;
      return res1;
  }
 /*
  {   
  
    int res1=1; int i=1; int ind=1;
    if (isprime.contains(this.st)) res1 = this.st; //если число простое то его возвращаем;
    else
    {
      while (this.st > res1)  //ищем ближайшее правое число
      {
        
        if (isprime.contains(this.st+i)) 
        {
      
            ind = isprime.indexOf(this.st+i); //определяем индекс 
            res1 = isprime.get(ind); //считываем следующее число
         
        }
        i=i+1;
      }
    } 
        this.st=res1+1;
        return res1;
    
  } */

}

