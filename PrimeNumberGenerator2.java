//генератор простых чисел

import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
    public class PrimeNumberGenerator
            
        {
            public int start; 
            public boolean SecondStart = false;
            public static void main (String[] args) throws IOException 
            {   System.out.print("Введите число: ");
                InputStreamReader isr = new InputStreamReader( System.in ) ;
                BufferedReader buffer = new BufferedReader( isr ) ;
                String input = "" ;
                try
                    {
                    input = buffer.readLine() ;
                    buffer.close() ;
                    }
                catch ( IOException e )
                    { System.out.println( "Произошла ошибка ввода" ); }
                int Val = Integer.parseInt(input);
                System.out.println( "\nСпасибо, вы набрали " + Val) ;
                PrimeNumberGenerator NGen = new PrimeNumberGenerator(Val);
                System.out.println(Val + " " + NGen.GetNextPrime());
                System.out.println("Второй запуск генератора " + NGen.GetNextPrime());
            }
            public PrimeNumberGenerator(int start) 
                
            {   this.start = start;//через переменную start получаем число справа от которого надо получить ближайшее простое
                this.SecondStart = false;//в эту переменную записываем что первый запуск уже был
            }

            public int GetNextPrime() 
            {
                int f = 0;
                int [] a  = new int [start*2]; //создаем массив
                for (int i = 0; i < start*2; i++)
                    a[i] = i; //Заполняем массив из N элементов целыми числами подряд от 0 до Start+2.
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
        
    
      
  

