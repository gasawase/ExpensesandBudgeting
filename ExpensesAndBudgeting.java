import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author summergasaway
 */
public class ExpensesAndBudgeting 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int weeks = 0;
        int hours = 0;
        double total = 0.0;
        double newTotal = 0.0;
        double rentCost = 0.0;
        double utilitiesCost = 0.0;
        double groceriesCost = 0.0;
        double newNameCost = 0.0;
        double expenseTotal = 0.0;
        double finalTotal = 0.0;
        boolean othersQ;
        boolean doIt = false;
        String nameCost;
        
        Scanner in = new Scanner (System.in);
        
        stars();
        System.out.println();
        System.out.println("   Welcome to Budgeting!!");
        stars();
        System.out.println();
        
        hours = SafeInput.getRangedInt(in, "How many hours did you work this pay period? ", 0, 80 );
        
        total = profit(hours);
       // for (int cnt = 0; cnt < 17; cnt++)
        //{
           // total = profit(hours) * cnt;
        //}
        System.out.println("Your total is: $" + total);
        System.out.println();
        
        System.out.println("How much are your expenses this month?");
        
        System.out.print("Rent: $");
        rentCost = in.nextDouble();
        expenseTotal = expenseTotal + rentCost;
        
        System.out.print("Utilites: $");
        utilitiesCost = in.nextDouble();
        expenseTotal = expenseTotal + utilitiesCost;
        
        System.out.print("Groceries: $");
        groceriesCost = in.nextDouble();
        expenseTotal = expenseTotal + groceriesCost;
        
        othersQ = SafeInput.getYNConfirm(in, "Do you have any other expenses?");
        
        if (othersQ == true)
        {
            do
            {
                System.out.print("What is another expense? ");
                nameCost = in.nextLine();
                System.out.print(nameCost + ": $");
                newNameCost = in.nextDouble();
                expenseTotal = expenseTotal + newNameCost;
                othersQ = SafeInput.getYNConfirm(in, "Do you have any other expenses?");
                
                if (othersQ == true)
                {
                    doIt = false;
                }
                else
                {
                    doIt = true;
                }
            }while(!doIt);
        }
        System.out.println();
        stars();
        finalTotal = total - expenseTotal;
        System.out.println();
        System.out.printf("Your total amount of spending money is: $", finalTotal);
        System.out.println();
        
    }
    private static void stars()
    {
        for (int cnt = 0; cnt < 30; cnt++)
        {
           System.out.print("*"); 
        }
        
    }
    private static void equals()
    {
        for (int cnt = 0; cnt < 30; cnt++)
        {
           System.out.print("="); 
        }         
    }  
    private static double profit (int hours)
    {
        double PAY = 10.00;
        double TAX_AND_BEN = .126;
        double income;
        double profit = 0;
        double totalTax = 0;
        
        income = PAY*hours;

        totalTax = income*TAX_AND_BEN;
        
        profit = income - totalTax;
        
        return profit;
    }
    
}
