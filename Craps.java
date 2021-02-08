/**
 * Write a description of class Craps here.
 *
 * @author Ben Knell
 * @version 2021-2-2
 */

import java.util.Scanner;

public class Craps
{
    private double dieRoll;

    public static void main(String[] args)
    {
        System.out.println("Let's play craps!");
        System.out.println("Do you need instructions (y/n)?");
        Scanner in1 = new Scanner(System.in);
        String response = in1.next();
        if (response.substring(0,1).equalsIgnoreCase("y"))
        {
            System.out.println("1. Roll two six-sided dice and add the numbers rolled together.");
            System.out.println("On first roll, a 7 or an 11 wins, and a 2, 3, or 12 loses");
            System.out.println("If you roll another number you don't win or lose and that number becomes the 'point.'");
            System.out.println("You continue to roll the two dice again until: ");
            System.out.println("a.  you roll the 'point' again and win!");
            System.out.println("b. you roll a 7 and lose.");
        }
        System.out.print("Press <Enter> to roll...");
        Scanner in2 = new Scanner(System.in);
        String pause = in2.nextLine();

        boolean cont = true;
        boolean didTheyWin = true;
        while (cont == true)
        {
            Die d1 = new Die();
            Die d2 = new Die();
            int total = d1.roll() + d2.roll();

            if (total == 7 || total == 11)
            {
                System.out.println("rolled: " + total);
                didTheyWin = true;
            }
            else if (total == 2 || total == 3 || total == 12)
            {
                System.out.println("rolled: " + total);
                didTheyWin = false;
            }
            else
            {
                int winPoint = total;
                System.out.println("your point is " + total);
                int lossPoint = 7;
                while (total != lossPoint && total != winPoint)
                {
                    total = d1.roll() + d2.roll();
                    System.out.println("rolled: " + total);
                }
                if (total == winPoint)
                {
                    //System.out.println(total);
                    didTheyWin = true;
                }
                else
                {
                    //System.out.println(total);
                    didTheyWin = false;
                }
            }
            if (didTheyWin == true)
            {
                System.out.println("Congratulations! You won! Play again?");
            }
            else
            {
                System.out.println("Oh no! You lost.");
            }
            System.out.println("Play again (y/n)?");
            Scanner in3 = new Scanner(System.in);
            String replay = in3.next();
            if (response.substring(0,1).equalsIgnoreCase("n"))
            {
                cont = false;
            }
        }
    }
}
