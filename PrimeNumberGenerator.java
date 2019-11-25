//генератор простых чисел

import java.io.*;
import java.util.*;

    public class PrimeNumberGenerator
            
        {
            int start;
            boolean SecondStart;
            public static void main (String[] args) 
            {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                in.close();
                int Val = Integer.parseInt(input);
                //System.out.println( "\n—пасибо, вы указали число " + Val) ;
                PrimeNumberGenerator NGen = new PrimeNumberGenerator(Val);
                //System.out.println(Val + " " + NGen.GetNextPrime());
                System.out.println("\n"+ NGen.GetNextPrime() + " " + NGen.GetNextPrime()+" "+NGen.GetNextPrime());
                //System.out.println(NGen.GetNextPrime());
            }
                public PrimeNumberGenerator(int start) 
                
            {   this.start = start;//через переменную start получаем число справа от которого надо получить ближайшее простое
                
                this.SecondStart = false;
                
            }

            public int GetNextPrime() 
            {   
                int f = 0; int LastF=1;
                int [] a  = new int [start*2]; //создаем массив
                for (int i = 0; i < start*2; i++)
                    a[i] = i; //«аполн€ем массив из N элементов целыми числами подр€д от 0 до Start+2.
                for (int p = 2; p < start*2; p++)
                {
                    if (a[p] != 0)
                    {
                    for (int j = p*p; j < start*2; j=j+p)
                        a[j] = 0;
                    }
                }
                for (int i = 0; i < start*2; i++)
                {
                    if ((start< a[i]) && (a[i]!=0) && (LastF != a[i]) )
                    {   
                      
                           f=a[i];
                           break; 
                        }
                }
                LastF = f; //сохран€ем значение
                System.out.println(LastF);
                return f; //возращаем блищайшее справа простое число    
            } 
        }