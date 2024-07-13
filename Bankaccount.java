import java.io.*;
import java.util.*;
public class Bankaccount
{
    int accno;
    String name;
    int balance;
    int pn;
    static int p;
    Scanner s=new Scanner(System.in);
    public void createacc()
    {
        System.out.print("Enter Account Holder Name:");
        name=s.nextLine();
        System.out.print("Enter Account Initial Deposit Balance:");
        balance=s.nextInt();
	    System.out.print("Enter Account Pin to keep secure your account:");
	    pn=s.nextInt();
        Random r=new Random();
        accno=r.nextInt(10000)+1;
    }
    public static void main(String[] args)
    {
        int k,an,i,j,pin;
        Scanner s=new Scanner(System.in);
        Bankaccount[] b=new Bankaccount[10];
        System.out.println("Welcome for Banking with ORUGANTI BANK OF INDIA!!!");
        while(true)
        {
            System.out.println("\n\nEnter 1 to Create New Account");
            System.out.println("Enter 2 to Deposit Amount");
            System.out.println("Enter 3 to Withdraw Amount");
            System.out.println("Enter 4 to Check Current Balance and details Check");
            System.out.println("Enter 5 to Change your Pin");
            System.out.println("Enter 6 to display All accounts details");
            System.out.println("Enter 7 to Close Account");
            System.out.println("Enter 8 to stop");
            System.out.print("Enter Your Choice:");
            k=s.nextInt();
            Atmmachine atm=new Atmmachine();
            switch(k)
            {
                case 1:
                    b[p]=new Bankaccount();
                    b[p].createacc();
                    System.out.printf("===Account Created Successfully and your Account Number is %d===\n",b[p].accno);
                    p++;
                    break;
                case 2:
                    System.out.print("Enter Account Number to deposit Amount:");
                    an=s.nextInt();
                    atm.deposit(b,an,p);
                    break;
                case 3:
                    System.out.print("Enter Account Number to withdraw Amount:");
                    an=s.nextInt();
                    System.out.print("Enter Your ATM Pin Number:");
		            pin=s.nextInt();
                    atm.withdrawl(b,an,p,pin);
                    break;
                case 4:
                    System.out.print("Enter Account Number to Check Amount:");
                    an=s.nextInt();
                    atm.balancecheck(b,an,p);
                    break;
                case 5:
                    System.out.print("Enter Account Number to Change Pin Number:");
                    an=s.nextInt();
                    atm.changepin(b,an,p);
                    break;
                case 6:
                    if(p==0)
                    System.out.println("No Data to be Displayed!!!");
                    else
                    {
                        System.out.println("Acc_NO\tName\tBalance\tATM_Pin");
                        for(i=0;i<p;i++)
                        System.out.printf("%d\t%s\t%d\t%d\n",b[i].accno,b[i].name,b[i].balance,b[i].pn);
                    }
                    break;
                case 7:
                    System.out.print("Enter Account Number to Close account:");
                    an=s.nextInt();
                    for(i=0;i<p;i++)
                    {
                        if(b[i].accno==an)
                        {
                            for(j=i;j<p-1;j++)
                            {
                                b[j].accno=b[j+1].accno;
                                b[j].name=b[j+1].name;
                                b[j].balance=b[j+1].balance;
                            }
                            p--;
                        }
                    }
                    System.out.println("Account Closed Successfully");
                    break;
                case 8:
                    System.out.print("Thank You for Banking with OBI!!!");
                    System.exit(0);
                default:
                System.out.println("Enter a Correct Choice!!!");
            }
        }
    }
}
class Atmmachine
{
    public void deposit(Bankaccount[] b,int an,int p)
    {
           Scanner s=new Scanner(System.in);
           int cash,flag=0,i;
           System.out.print("Enter Amount to be Deposited:");
           cash=s.nextInt();
           for(i=0;i<p;i++)
           {
               if(b[i].accno==an)
               {
                   b[i].balance=b[i].balance+cash;
                   flag=1;
                   break;
               }
           }
           if(flag==1)
           System.out.println("Deposited Successfully into the Account");
           else
           System.out.println("Deposition Reversal Occurred!!!");
    }
     public void withdrawl(Bankaccount[] b,int an,int p,int pin)
    {
           Scanner s=new Scanner(System.in);
           int cash,flag=0,i;
           for(i=0;i<p;i++)
           {
               if(b[i].accno==an)
               {
                   if(pin==b[i].pn)
		    {
			System.out.print("Enter Amount to be Withdrawl:");
           		cash=s.nextInt();	
                       if(b[i].balance>=cash)
                       {
                           b[i].balance=b[i].balance-cash;
                           flag=1;
                       }
                       break;
		           }
		           else{
		               System.out.println("You Have Entered Your Pin Wrongly!!!");
		           }
               }
           }
           if(flag==1)
           System.out.println("Withdrawl Successfully from the Account");
           else if(flag==0)
           System.out.println("Withdrawl Failure Occurred!!!");
    }
     public void balancecheck(Bankaccount[] b,int an,int p)
    {
        int i,flag=0,pi,temp=0;
        Scanner s=new Scanner(System.in);
        for(i=0;i<p;i++)
        {
           if(b[i].accno==an)
           {
               temp=1;
               System.out.print("Enter your ATM Pin for checking Balance:");
               pi=s.nextInt();
               if(pi==b[i].pn)
               {
                   System.out.println("Acc_NO\tName\tBalance");
                   System.out.printf("%d\t%s\t%d\n",b[i].accno,b[i].name,b[i].balance);
                   flag=1;
               }
               else
               {
                   System.out.println("You have Entered a wrong Pin!!!");
                   break;
               }
           }
        }
        if(flag==1)
        System.out.println("Displayed Information Successfully");
        if(temp==0)
        System.out.println("Account Not Found!!!");
    }
    public void changepin(Bankaccount[] b,int an,int p)
    {
        int oldpin,i,t,t1,flag=0,temp=0;
        Scanner s=new Scanner(System.in);
        for(i=0;i<p;i++)
        {
            if(b[i].accno==an)
            {
                temp=1;
                System.out.print("Enter your old Pin Number:");
                oldpin=s.nextInt();
                if(oldpin==b[i].pn)
                {
                    if(flag!=0 && flag!=1)
                    System.out.println("Second Chance for Changing Pin Now!!!");
                    System.out.print("Enter Your New Pin Number:");
                    t=s.nextInt();
                    System.out.print("Again Enter your Pin Number to Confirm:");
                    t1=s.nextInt();
                    if(t==t1)
                    {
                        b[i].pn=t;
                        System.out.println("Pin Has Changed Successfully!!!");
                    }
                    else
                    {
                        System.out.println("Enter your New Pin correctly!!!");
                        flag++;
                        if(flag==2)
                        {
                            System.out.println("You have Reached Your Maximum Attempts for this Session!!!");
                            break;
                        }
                        i--;
                        continue;
                    }
                }
                else
                {
                    flag++;
                    System.out.println("Entered Wrong Pin Number!!!");
                    if(flag==2)
                    {
                        System.out.println("You have Reached Your Maximum Attempts for this Session!!!");
                        break;
                    }
                    i--;
                }
            }
        }
        if(temp==0)
        System.out.println("Entered Account Number is Wrong!!!");
    }
}