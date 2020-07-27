//***********************************************************
//  AverageOfIntegers.java
//
//  Dustin Kaban 
//  July 27th, 2020
//
//  This class reads a series of 10 integers from the user and prints
//  their average.  If a NumberFormatException is thrown it displays
//  an error message.
//***********************************************************

import java.util.Scanner;

public class AverageOfIntegers
{
    //Variables to store integer information
    private int[] integerArray;
    private int integerCount;
    private int sum;

    //Constructor
    public AverageOfIntegers(int integerCount)
    {
        this.integerCount = integerCount;
    }

    //Reads the integers inputted by the user, throws an exception if not an integer
    public void readUserInputtedIntegers()
    {
        //initialize the array to the integerCount size
        integerArray = new int[integerCount];

        //Scanner class for user input
        Scanner scanner = new Scanner(System.in);

        //variables needed for looping
        int validIntegersInputted = 0;
        int inputValue;

        //A loop to allow the user to input integerCount amount of ints
        while(validIntegersInputted < integerCount)
        {
            try
            {
                System.out.print("Enter an integer: ");
                //Read the input as a string and cast it as an integer
                inputValue = Integer.parseInt(scanner.nextLine());
                integerArray[validIntegersInputted] = inputValue;
                sum += inputValue;
                validIntegersInputted++;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Input is not a valid integer, please try again");
            }
        }
    }

    //Calculates the average of the inputted integers
    public double getAverage()
    {
        return (double)sum/integerCount;
    }

    public static void main(String[] args)
    {
        //Creates an AverageOfIntegers objects and tests functionality
        AverageOfIntegers averageOfIntegers = new AverageOfIntegers(10);
        averageOfIntegers.readUserInputtedIntegers();
        System.out.println("The Average of the integers is: "
                + averageOfIntegers.getAverage());
    }
}
