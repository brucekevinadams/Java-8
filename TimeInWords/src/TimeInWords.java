import java.io.*;
import java.util.*;

public class TimeInWords {

@SuppressWarnings("unused")
static String timeInWords(int h, int m) {
       String hours[]={"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        String tenMinutes[]={"twenty","thirty", "forty", "fifty"};
        String teenMinutes[]={"fourteen", "thirteen", "twelve", "eleven"};
                String teenMinutes2[]={"sixteen", "seventeen", "eighteen", "nineteen"};
                String currentTime;
                
               if(m==00)
          {
           currentTime=hours[h-1]+" o' clock";
            return currentTime;
          }
                else if(m==1)
        {
       currentTime="one minute past "+hours[m-1];
        return currentTime;
        }
                
                
                 else if(m==59)
                {
                currentTime="one minute to "+hours[h-1];
        return currentTime;
                }
                  else if(m==39)
                {
                currentTime="twenty one minute to "+hours[h-1];
        return currentTime;
                }
                  
               else if(m<13)
        {
       currentTime=hours[h-1]+" minutes past "+hours[m-1];
        return currentTime;
        }
        else if(m==14)
        {
       currentTime=hours[h-1]+" past fourteen minutes";
        return currentTime;
        }
         else if(m==13)
        {
          currentTime=hours[h-1]+" past thirteen minutes";
           return currentTime;
        }
        else if (m==15)
        {
         currentTime="quarter past "+hours[h-1];
          return currentTime;
        }
        else if(m<20)
        {
        currentTime=hours[h-1]+" minutes past "+hours[m-16];
        
         return currentTime;
        }
        else if(m<30)
        {
            double d=30-m;
            double k=10-d;
            
        currentTime="twenty "+hours[(int)k-1]+" minutes past "+hours[h-1];
         return currentTime;
        }
        else if(m==30)
        {
       currentTime="half past "+hours[h-1];
        return currentTime;
        }
        else if (m==20)
        {
          currentTime=hours[h-1]+" minutes past twenty";
           return currentTime;
        }
        else if (m==40)
        {
         currentTime="twenty minutes to "+hours[h];
          return currentTime;
        }
         else if (m==50)
        {
            currentTime="ten minutes to "+hours[h];
             return currentTime;
        }
        
         else if(m<30)
         { 
            currentTime=hours[h-1]+" minutes past twenty "+hours[m-1];
             return currentTime;
         
         }
         else if(m<40){
            double d=40-m;
            double k=10-d;
            
        currentTime="twenty "+hours[(int)d-1]+" minutes to "+hours[h];
         return currentTime;
         }
         else if(m<45){
          
       currentTime=teenMinutes2[m-22]+" minutes to "+hours[h];
        return currentTime;
         }
         else if(m==45)
         {
          currentTime="quarter to "+hours[h];
           return currentTime;
         }
         else if (m<50)
         {
           int e=61-m;
         currentTime=teenMinutes[e-13]+" minutes to "+hours[h];
          return currentTime;
         }
        
          else if (m==50)
        {
         currentTime="ten minutes to "+hours[h];
          return currentTime;
        }
        
          else if (m<60)
         {
            int e=60-m;
        currentTime=hours[e-1]+" minutes to "+hours[h];
         return currentTime;
         }
          
        
       
        return "Hiba";
    }   

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("timeToWords.txt"));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        
        System.out.println(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}