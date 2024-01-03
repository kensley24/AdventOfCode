import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
 

/*
From: advent of code Day 3

Problem: given an input file with even width of strings, if there is a '*' with exactly
2 numbers adjacent to it, multiply the numbers and get the sum of all multiplied numbers

example: 

467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..

-multiply (497 * 35) + (755 * 598) 
-total = 467835

*/ 

public class dayThreeP2 {
    // to handle exceptions include throws
    
    static boolean checkNum(char c){
        if(c >= 48 && c <= 57){
            return true;
        }
        return false;
    }

    static boolean isValid(char[][] doubleArr, int i, int j){
        if(i >= 0 && i < doubleArr.length && j >= 0 && j < doubleArr[0].length){
            return true;
        }
        return false;

    }
    

    public static void main(String[] args)
        throws IOException
    {

        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
       
        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        //converting it to a double array to access rows and columns
        char[][] doubleArray = new char[array.length][array[0].length()];
        //for error checking
        int[][] doubleArrayStars = new int[array.length][array[0].length()];
  
        //putting data int the array
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length(); j++){
                doubleArray[i][j] = array[i].charAt(j);    
            }
        }

        int height = array.length;
        int width = array[0].length();
        //to count the numbers in the stars
        int total = 0;
        //to make a unique id for each star
        int starNum = 0;
        //to see how many numbers a star is touching
        int starCount = 0;
        //total amount
        int totalStar = 0;

        //looping through array to find stars
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){

                starCount = 0;
                total = 0;

                //found a star
                if(doubleArray[i][j] == 42){
                    //assign new id
                    starNum ++;
                    //check stars perimater 
                    for(int k = -1; k <= 1; k++){
                        for(int l = -1; l <= 1; l++){
                            //checking if coordinate is valid
                            if(isValid(doubleArray, i+k, j+l)){
                                //checking if coordinate is a number
                                if(checkNum(doubleArray[i+k][j+l])){
                                    //error checking (to not count the same number twice)
                                    if(doubleArrayStars[i+k][j+l] != starNum){

                                        //to track amount of numbers adjacent to star
                                        starCount ++;

                                        //getting what the number is
                                        int beginning = j+l;
                                        int end = j+l;
                                        int numCount = 0;

                                        while(isValid(doubleArray, i+k, beginning) && checkNum(doubleArray[i+k][beginning])){

                                            beginning--;
                                        }

                                        while(isValid(doubleArray, i+k, end) && checkNum(doubleArray[i+k][end])){
                                            end++;
                                        }

                                        beginning +=1;

                                        numCount = end - beginning;
                                        int num = 0;
                                        
                                        //getting real number from string
                                        for(int h = numCount; h > 0; h--){

                                            num += (((doubleArray[i+k][end - h]) - '0') * Math.pow(10, h-1));
                                        }
                                        if(starCount == 1){
                                            total = num;
                                        }
                                        else{
                                            total *= num;
                                        }
                                        
                                        //to not double count
                                        for(int m = 0; m < numCount; m++){
                                            doubleArrayStars[i+k][beginning +m] = starNum;
                                        }                                     


                                    }
                                }

                            }


                        }  
                        
                    }      

                }

                if(starCount == 2){
                    totalStar += total;
                }


            }

        }

        System.out.println(totalStar);


        

    }
}