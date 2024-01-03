import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//(This took 30 minutes to run don't do this)
public class dayFive{
    public static void main(String args[]){
        //storing seed numbers
        ArrayList<Long> seedNumbers = new ArrayList<Long>();
        //2d array to store the grids 
        //( outer arrray grid number inner array all values: in one array but calculated in 3s)
        ArrayList<ArrayList<Long>> seedSoil = new ArrayList<ArrayList<Long>>();
        //ArrayList<ArrayList<Long>> firstLine = new ArrayList<ArrayList<Long>>();
        try {

			Scanner scanner = new Scanner(new File("input.txt"));

            String firstLine = scanner.nextLine();
            char p = firstLine.charAt(0);
            long n = 0;
            //getting seed numbers and storing them 
            for(int i = 0; i < firstLine.length(); i++){
                n = 0;
                p = firstLine.charAt(i);
                while(p >= 48 && p <= 57){
                    n = n * 10;
                    n += (p - '0');
                    i++;
                    if(i < firstLine.length()){	
                        p = firstLine.charAt(i);
                    }
                    else{
                        break;
                    }             
                }

                if(n > 0){
                    seedNumbers.add(n);
                }
                
            }


            int arrCounter = -1;
            long numCount = 0;
            //getting and storing all grid data
			while (scanner.hasNextLine()) {
                
                String next = scanner.nextLine();
                
                //if number
                if(next.length() > 0 && next.charAt(0) >= 48 && next.charAt(0) <= 57){

                    char ptr = next.charAt(0);
                    long num = 0;
                    
                    for(int j = 0; j < next.length(); j++){
                        num = 0;
                        ptr = next.charAt(j);
                        while(ptr >= 48 && ptr <= 57){
							num = num * 10;
							num += (ptr - '0');
							j++;
							if(j < next.length()){	
								ptr = next.charAt(j);
							}
							else{
								break;
							}
							
						}

                        seedSoil.get(arrCounter).add(num);
                       
                        numCount ++;

                    }
                }
                else if(next.length() == 0){
                    numCount = 0;
                    arrCounter ++;
                    seedSoil.add(new ArrayList<Long>());
                    
                }
                
            }

            /* 
			System.out.print('[');
			for(int i = 0; i < arrCounter+1; i++){
				//finalTotal += card.get(i);
                System.out.println(i);
                for(int j = 0; j < seedSoil.get(i).size(); j++){
                    System.out.print(seedSoil.get(i).get(j));
                    System.out.print(',');
                }
                System.out.println();
				
				
			}
			System.out.println(']');
            */
        
        
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        //looping through each seed number to find smallest location 
        long source = 0;
        long dest = 0;
        long shortest = 0;
        for(int s = 0; s < seedNumbers.size(); s+=2){
            long count = 0;
            for(long t = seedNumbers.get(s); t < (seedNumbers.get(s) + seedNumbers.get(s+1)); t++){
                //System.out.println(t);
                source = seedNumbers.get(s) + count;
                count ++;
                for(int j = 0; j < seedSoil.size(); j++){
                    dest = 0;
                    for(int k = 0; k < seedSoil.get(j).size(); k+=3){
                        if(source >= seedSoil.get(j).get(k+1) && source < (seedSoil.get(j).get(k+1) + seedSoil.get(j).get(k+2))){
                            dest = seedSoil.get(j).get(k) + (source - seedSoil.get(j).get(k+1));
                        }

                    }
                    if(dest == 0){
                        dest = source;
                    }

                    source = dest;
                    
                }
                if(shortest == 0 || dest < shortest){
                    shortest = dest;
                }
            }

        }

        System.out.printf("Shortest: %d\n", shortest);

    }
}