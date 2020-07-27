//***********************************************************
//  UniqueTitleChecker.java
//
//  Dustin Kaban T00663749
//  COMP 1231 Module 3 Assignment 3 Question 2
//  July 27th, 2020
//
//  This class reads inputted book titles from a file and writes
//  the titles to an output file verifying that the output
//  information is all unique, removing duplicate titles.
//***********************************************************

import java.io.*;
import java.util.HashSet;

public class UniqueTitleChecker
{
    public static void main(String[] args) throws IOException
    {
        //Create a HashSet to contain all the imported book titles
        HashSet<String> titlesSet = new HashSet<String>();
        String inputFileName = "bookTiles.inp";
        String outputFileName = "uniqueTitles.out";

        BufferedReader reader = null;
        PrintWriter writer = null;

        try
        {
            //Create a reader and writer to input and output the title information
            reader = new BufferedReader(new FileReader(inputFileName));
            writer = new PrintWriter(outputFileName);

            //Read the first line of data
            String data = reader.readLine();

            //Loop through the data until it reaches a null entry
            while (data != null)
            {
                //Add the data to the HashSet we created
                if (titlesSet.add(data))
                {
                    System.out.println(data + " Added.");
                    //Write the data into the new output file
                    writer.println(data);
                }
                else // data was not added to file because it already exists
                {
                    System.out.println(data + " is a duplicate, not added.");
                }

                data = reader.readLine();

            }

            //Display to the user information about the new file
            System.out.println("File created with " + titlesSet.size() + " entries.");

            writer.flush();
            writer.close();
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File does not exist.");
        }
    }
}
