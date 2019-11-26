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
    System.out.println("\n"+ NGen.GetNextPrime()+ " " + NGen.GetNextPrime()+ " " + NGen.GetNextPrime());
    
  }
  PrimeNumberGenerator(int start) 
                
  {  
    int i; int n=10000;
    boolean Array [] = new boolean [n];
   
    this.st = start;
   
    for (i=2; i<n; i++) 
    {
       Array[i] = true;
    }
    for (i=4; i<n; i=i+2)  //����������� ��� ������� ������
    {
      Array[i] = false;
    }
    for (i=6; i<n; i=i+3)  //����������� ��� ������� ������
    {
      Array[i] = false;
    }
    for (i=10; i<n; i=i+5)  //����������� ��� ������� �������
    {
      Array[i] = false;
    }
  
    for (i = 2; i < n; i++)
      if (Array[i]) isprime.add(i);
    // ����� ���� ������� ����� � ��������� �� ���� ����� start �� start+10 ����� ������� �� ��������� ������� �����
    boolean prime = false;
    // ���������, ������� �� ����� ��� �������.
    
    for (i=start; i<start+10; i++) 
    {
        for (int j = 2; j < isprime.size(); j++)
            // ���� ����� ������� ��� �������, ��� �������
            if ((i%isprime.get(j)) == 0) prime = true;

        if(prime)
            System.out.println (i + " is prime.");
    }

  }

  int GetNextPrime()
 
  {   
  
    int res1=1; int i=1; int ind=1;
    if (isprime.contains(this.st)) res1 = this.st; //���� ����� ������� �� ��� ����������;
    else
    {
      while (this.st > res1)  //���� ��������� ������ �����
      {
        
        if (isprime.contains(this.st+i)) 
        {
      
            ind = isprime.indexOf(this.st+i); //���������� ������ 
            res1 = isprime.get(ind); //��������� ��������� �����
         
        }
        i=i+1;
      }
    } 
        this.st=res1+1;
        return res1;
    
  }

}