import java.io.*;
import java.util.*;

public class PrimeNumberGenerator
{ 
  int st; 
  ArrayList<Integer> isprime = new ArrayList<Integer>(); 
  
  public static void main (String args[])
  {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    in.close();
    int Val = Integer.parseInt(input);
    PrimeNumberGenerator NGen = new PrimeNumberGenerator(Val);
    //System.out.println("\n"+ NGen.GetNextPrime()+ " " + NGen.GetNextPrime()+ " " + NGen.GetNextPrime());
    System.out.println("\n"+ NGen.GetNextPrime());
  }
  PrimeNumberGenerator(int start) 
                
  {  
   
    int i; int n=100000;

    
        boolean Array [] = new boolean [100000000];
      
        this.st = start;
      
        for (i=2; i<100000000; i++) 
        {
          Array[i] = true;
        }
        Array[0] = false;
        Array[1] = false;

        for (i = 2; i < n; ++i) 
        {
          if (Array[i]) 
          {
              for (int j = 2; i * j < n; ++j) 
              {
                  Array[i * j] = false;
              }
          }
        }
      
        for (i = 2; i < 100000; i++)
          if (Array[i]) isprime.add(i);
    

      int startMas = (int)Math.round(Math.sqrt(start));
      int endMas = start+100;
      //System.out.println(endMas);
      //boolean Array [] = new boolean [endMas];
      //int dis2=startMas;
        //this.st = start;
      
        /*for (i=startMas; i< endMas; i++) 
        {
          Array[i] = true; //заполняем массив
        }
        Array[0] = false;
        Array[1] = false;
        */  
        for (i = startMas; i < endMas; ++i) 
        {
          if (Array[i]) 
          {
              for (int j = 2; i * j < startMas; ++j) 
              {
                  Array[i * j] = false;
              }
          }
        }
      
       
        
      
        for (i = startMas; i < endMas; i++)
          if (Array[i]) isprime.add(i);
    
   

  }

  int GetNextPrime()
 
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
    
  }

}