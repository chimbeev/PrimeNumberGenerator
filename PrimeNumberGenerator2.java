//��������� ������� �����

import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
    public class PrimeNumberGenerator
            
        {
            public int start; 
            public boolean SecondStart = false;
            public static void main (String[] args) throws IOException 
            {   System.out.print("������� �����: ");
                InputStreamReader isr = new InputStreamReader( System.in ) ;
                BufferedReader buffer = new BufferedReader( isr ) ;
                String input = "" ;
                try
                    {
                    input = buffer.readLine() ;
                    buffer.close() ;
                    }
                catch ( IOException e )
                    { System.out.println( "��������� ������ �����" ); }
                int Val = Integer.parseInt(input);
                System.out.println( "\n�������, �� ������� " + Val) ;
                PrimeNumberGenerator NGen = new PrimeNumberGenerator(Val);
                System.out.println(Val + " " + NGen.GetNextPrime());
                System.out.println("������ ������ ���������� " + NGen.GetNextPrime());
            }
            public PrimeNumberGenerator(int start) 
                
            {   this.start = start;//����� ���������� start �������� ����� ������ �� �������� ���� �������� ��������� �������
                this.SecondStart = false;//� ��� ���������� ���������� ��� ������ ������ ��� ���
            }

            public int GetNextPrime() 
            {
                int f = 0;
                int [] a  = new int [start*2]; //������� ������
                for (int i = 0; i < start*2; i++)
                    a[i] = i; //��������� ������ �� N ��������� ������ ������� ������ �� 0 �� Start+2.
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
                return f; //��������� ��������� ������ ������� �����    
            } 
        }
        
    
      
  

