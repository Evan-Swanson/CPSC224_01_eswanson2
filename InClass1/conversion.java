//Evan Swanson
//Inclass Assignment 1, 1/24/2019
//Distance conversion menu

import java.util.*;
public class conversion
{
   public static void main(String[] args)
   {
      double userDistance = -1;
      int userChoice = 0;
      Scanner keyboard = new Scanner(System.in);
      while(userDistance < 0)
      {
        System.out.println("Enter a distance in meters: ");
        userDistance = keyboard.nextDouble();
        if (userDistance < 0)
            System.out.println("Invalid number: Must be positive\n");
      }
      while(true)
      {
        menu();
        userChoice = keyboard.nextInt();
        if (userChoice == 1)
            showKilometers(userDistance);
        else if (userChoice == 2)
            showInches(userDistance);
        else if (userChoice == 3)
            showFeet(userDistance);
        else if (userChoice == 4)
            System.exit(0);
        else
            System.out.println("\nInvalid option, try again\n");
      }


   }

   public static void showKilometers(double meters)
   {
       System.out.println("\n" + (meters*.001) + " kilometers\n");
   }

   public static void showInches(double meters)
   {
       System.out.println("\n" + (meters*39.37) + " inches\n");
   }

   public static void showFeet(double meters)
   {
       System.out.println("\n" + (meters*3.281) + " feet\n");
   }

   public static void menu()
   {
       System.out.println("1. Convert to kilometers\n2.Convert to inches\n3.Convert to feet\n4.Quit the program");
   }
}
