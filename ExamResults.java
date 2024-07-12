import java.io.*;
import java.util.*;
public class ExamResults
{
    public static void main(String[] args)
    {
        int i,n;
        String grade;
        int tmarks=0,m;
        double perc=0;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Number of Subjects:");
        n=s.nextInt();
        for(i=1;i<=n;i++)
        {
            System.out.printf("Enter your Subject-%d Marks:",i);
            m=s.nextInt();
            if(m>=0 && m<=100)
            tmarks=tmarks+m;
            else
            {
                System.out.println("Please Re-Enter Your Marks Correctly!!!");
                i--;
            }
        }
        perc=((tmarks*0.1)/(n*100*0.1))*100;
        if(perc>=90 && perc<=100)
        grade="A+";
        else if(perc>=80 && perc<90)
        grade="A";
        else if(perc>=70 && perc<80)
        grade="B";
        else if(perc>=60 && perc<70)
        grade="C";
        else if(perc>=50 && perc<60)
        grade="D";
        else if(perc>=40 && perc<50)
        grade="E";
        else
        grade="Fail";
        System.out.printf("You Have Acheived \n Total Marks= %d out of %d \n Total Percentage= %.2f \n Grade Acheived %s Grade",tmarks,n*100,perc,grade);
    }
}