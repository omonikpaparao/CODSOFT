import java.io.*;
import java.util.*;
class  NumberGuess{
    int i,j,omprnumber,n,g,w;
    static int won,gp;
    double score;
    Scanner s=new Scanner(System.in);
    public static void main(String[] args) {
        NumberGuess h=new NumberGuess();
        h.func();
    }
    public void func(){
        System.out.println("[ Game Description: You Have to find a Magic Number which is from 1 to 100 in range ]");
        System.out.print("How many times you will Play the Game???:");
        n=s.nextInt();
        for(i=0;i<n;i++)
        {
            gp++;
            Random r=new Random();
            omprnumber=r.nextInt(100)+1;
            System.out.printf("Game %d is Started!!!\n",i+1);
            System.out.println("You will have 7 Chances to Guess Magic Number!!!");
            for(j=0;j<7;j++)
            {
                System.out.printf("Enter Your Guess %d Here:",j+1);
                g=s.nextInt();
                if(g==omprnumber)
                {
                    System.out.println("Your Guess is Correct!!!");
                    won++;
                    j=0;
                    break;
                }
                else if(g<omprnumber)
                    System.out.println("Your Guess is too Low!!!");
                else
                    System.out.println("Your Guess is too High!!!");
            }
            if(j!=0)
            {
                System.out.printf("You have Failed!!!\nThe Magic Number is %d\n",omprnumber);
            }
            if(i!=n-1)
            {
                System.out.print("Do You want to continue??(1/0):");
                w=s.nextInt();
                if(w!=1)
                break;
            }
        }
        System.out.println("You Have Completed Your Attempts!!!");
        score=((won*0.1)/(gp*0.1))*100;
        System.out.println("Your Score Percentage is "+score+"%");
        System.out.print("Thank You For Playing!!!");
    }
}
