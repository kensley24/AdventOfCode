import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class files{

	public static void main(String[] args){

		try {

			Scanner scanner = new Scanner(new File("lines.txt"));

			String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

			int total = 0;

			while (scanner.hasNextLine()) {

				String next = scanner.nextLine();
				//the array of numbers in the line 
				int[] num = new int[next.length()];
				//counter for num
				int j = 0;
				//the number to be counted
				int thisNum = 0;

				//System.out.println(next);
				for(int i = 0; i < next.length(); i++){



					int ascValue = next.charAt(i);
					if(ascValue >= 48 && ascValue <= 57){
						//k = 0;
						num[j] = next.charAt(i) - '0';
						j++;
					}

					else{
			
						//looping each numbe in numbers
						for(int l = 0; l < numbers.length; l++){
							//if there's a matching first letter than we proceed to process the word
							boolean isMatch = false;
							//if there is a match for the first letter
							if(ascValue == numbers[l].charAt(0)){
								isMatch = true;
								//loop through the number 
								for(int h = 1; h < numbers[l].length(); h++){
									//bounds check
									if(i+h < next.length()){
										//checking each charater in numbers[l] to see if there's a match
										if(next.charAt(i+h) != numbers[l].charAt(h)){
											isMatch = false;
										}										
									}
									else{
										isMatch = false;
									}

								}
								if(isMatch){
									//System.out.println(numbers[l]);
									num[j] = l+1;
									j++;
								}
							}
						}

						
						
					}


					
				}
				/*
				System.out.println();
				for(int k = 0; k < j; k++){
					System.out.print(num[k]);
					System.out.print(',');
				}
				System.out.println();
				*/

				thisNum = (num[0] * 10) + num[j-1];
				//System.out.println(thisNum);
				total += thisNum;

			}
			System.out.println(total);

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}