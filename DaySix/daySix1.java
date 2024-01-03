import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class daySix1{

    static void getNumbers(String input, ArrayList<Integer> list){
        int n = 0;
        int p = 0;
        for(int i = 0; i < input.length(); i++){
            n = 0;
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
            if(n > 0){
                list.add(n);
            }
            
        }


    }
    public static void main(String args[]){

        ArrayList<Integer> time = new ArrayList<Integer>();
        ArrayList<Integer> distance = new ArrayList<Integer>();
        try{
            int total = 1;
            Scanner scanner = new Scanner(new File("input.txt"));

            String next = scanner.nextLine();
            System.out.println(next);
            getNumbers(next, time);
            next = scanner.nextLine();
            getNumbers(next, distance);
            //System.out.println(distance.get(0));


            for(int i = 0; i < time.size(); i++){
                int t = 0;
                int calc = 0;
                int numBeat = 0;
                while(calc <= distance.get(i)){
                    t++;
                    calc = (time.get(i) - t) * t;
                }

                numBeat = (time.get(i) - t*2 + 1);

                total *= numBeat;
            }

            System.out.println(total);
            
            
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    }
}