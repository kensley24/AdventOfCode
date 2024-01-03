import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
 
public class dayTwo {
    // to handle exceptions include throws
    static boolean check(char c){
        if(c != 46 && (c < 48 || c > 57)){
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
  
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length(); j++){
                doubleArray[i][j] = array[i].charAt(j);
                
            }
        }
        int height = array.length;
        int width = array[0].length();
        int total = 0;

        for(int i = 0; i < height; i++){

            for(int j = 0; j < width; j++){
                int numCounter = 0;
                boolean isNumber = false;
                
                while(j < width && doubleArray[i][j] >= 48 && doubleArray[i][j] <= 57){

                    numCounter++;
                    for(int k = -1; k <= 1; k++){
                        for(int l = -1; l <= 1; l++){
                            if(i+k >= 0 && i+k < height && j+l >= 0 && j+l < width){
 
                                if(check(doubleArray[i+k][j+l])){

                                    isNumber = true;
                                }
                            }
                            
                        }

                    }

                    j++;
                }
                if(isNumber){
                    int num = 0;

                    for(int h = numCounter; h > 0; h--){

                        num += (((doubleArray[i][j-h]) - '0') * Math.pow(10, h-1));
                    }
                    total += num;
                    j -= 1;
                }
                
               
            }
        }

        System.out.println(total);
        
        
    }
}