//генератор простых чисел

import java.io.*;
import java.util.*;

    public class PrimeNumberGenerator4
            
        {
            int start;
            boolean SecondStart;
            public static void main (String[] args) 
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                in.close();
                int Val = Integer.parseInt(input);
                PrimeNumberGenerator NGen = new PrimeNumberGenerator(Val);
                System.out.println("\n"+ NGen.GetNextPrime() + " " + NGen.GetNextPrime()+" "+NGen.GetNextPrime());
                
            }
                public PrimeNumberGenerator4(int start) 
                
            {   this.start = start;//через переменную start получаем число справа от которого надо получить ближайшее простое
                
                this.SecondStart = false;
                
            }

            public int GetNextPrime() 
            {   
                int f = 0;
                int n=(int)Math.round(Math.sqrt(start));
                System.out.println(n);
                int [] a  = new int [n]; //создаем массив
                for (int i = 0; i <= n; i++)
                    a[i] = i; //Заполняем массив из N элементов целыми числами подряд от 0 до Start+2.
                for (int p = 2; p <= n; p++)
                {
                    if (a[p] != 0)
                    {
                    for (long j = (int)Math.round(Math.sqrt(p)); j <= n; j=j+p)
                        a[(int)j] = 0;
                    }
                }
                for (int i = 0; i <= n; i++)
                {
                    if ((start< a[i]) && (a[i]!=0))
                    {   
                      if (this.SecondStart==false) 
                        {   
                           f=a[i];
                           break; 
                        }
                      else this.SecondStart=false; 
                    }
                }
                this.SecondStart=true; 
                return f; //возращаем блищайшее справа простое число    
            } 
        }