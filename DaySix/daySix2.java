import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class daySix2{
 
    static long getNumbers(String input){
        long n = 0;
        int p = 0;
        for(int i = 0; i < input.length(); i++){
            p = input.charAt(i);
            while(p >= 48 && p <= 57){
                n = n * 10;
                n += (p - '0');
                i++;
                if(i < input.length()){	
                    p = input.charAt(i);
                }
                else{
                    break;
                }             
            }    
        }
        return n;
    }
    public static void main(String args[]){
        try{
            int total = 1;
            Scanner scanner = new Scanner(new File("input.txt"));

            String next = scanner.nextLine();
            //System.out.println(next);
            long time = getNumbers(next);
            next = scanner.nextLine();
            long distance = getNumbers(next);
            System.out.printf("distance: %d\n",distance);
            System.out.printf("time: %d\n",time);
            
            long t = 0;
            long calc = 0;
            while(calc <= distance){
                t++;
                calc = (time - t) * t;
            }

            long numBeat = (time - (t*2) + 1);
            System.out.println(numBeat);
            
            
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    }
}