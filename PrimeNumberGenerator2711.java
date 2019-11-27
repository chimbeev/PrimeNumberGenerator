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

    if (start < n)
    {
        boolean Array [] = new boolean [n];
      
        this.st = start;
      
        for (i=2; i<n; i++) 
        {
          Array[i] = true;
        }
        for (i=4; i<n; i=i+2)  //вычеркиваем все кратные двойке
        {
          Array[i] = false;
        }
        for (i=6; i<n; i=i+3)  //вычеркиваем все кратные тройке
        {
          Array[i] = false;
        }
        for (i=10; i<n; i=i+5)  //вычеркиваем все кратные пятерке
        {
          Array[i] = false;
        }
        for (i=7; i<n; i=i+7)  //вычеркиваем все кратные семерке
        {
          Array[i] = false;
        }
      
        for (i = 2; i < n; i++)
          if (Array[i]) isprime.add(i);
    }
    else //если число больше 100000
    {
      int startMas = (int)Math.round(Math.sqrt(start));
      int endMas = start+100;
      //System.out.println(endMas);
      boolean Array [] = new boolean [endMas];
      int dis2=startMas;
        this.st = start;
      
        for (i=startMas; i<endMas; i++) 
        {
          Array[i] = true; //заполняем массив
        }
        //вычеркиваем кратные двойке, тройке, пятерке числа
        while (dis2<startMas+5)
        { 
          if (dis2%2==0 && Array[dis2]==true)  //проверяем что делится на два без остатка 
          {
            for (i=dis2; i<endMas; i=i+2)  //вычеркиваем все кратные двойке
            {
              Array[i] = false;
            }
          }
          if (dis2%3==0 && Array[dis2]==true)  //проверяем что делится на три без остатка 
          {
            for (i=dis2; i<endMas; i=i+3)  //вычеркиваем все кратные тройке
            {
              Array[i] = false;
            }
          }
          if (dis2%5==0 && Array[dis2]==true)  //проверяем что делится на три без остатка 
          {
            for (i=dis2; i<endMas; i=i+5)  //вычеркиваем все кратные пятерке
            {
              Array[i] = false;
            }
          }
          dis2 = dis2+1;//System.out.println(dis2);System.out.println(endMas);
        } 
       
        
      
        for (i = startMas; i < endMas; i++)
          if (Array[i]) isprime.add(i);
    }
   

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