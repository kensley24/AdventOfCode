import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Advent Of code day One

given an iput, find the sum of the first and last digits of each row 
-the numbers could be written or numerical

ex

input:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen

output: 
29, 83, 13, 24, 42, 14, 76 added together = 281

*/


public class dayOne{

	public static void main(String[] args){

		try {

			Scanner scanner = new Scanner(new File("lines.txt"));

			String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

			int total = 0;

			while (scanner.hasNextLine()) {

				String next = scanner.nextLine();

				//the array of numbers found in 
				//note: this could be done with just first and last int instead of array storage
				int[] num = new int[next.length()];
				//counter for num
				int j = 0;
				//the number to be counted
				int thisNum = 0;

				for(int i = 0; i < next.length(); i++){

					int ascValue = next.charAt(i);

					//found number
					if(ascValue >= 48 && ascValue <= 57){
						num[j] = next.charAt(i) - '0';
						j++;
					}

					else{
						
						//looping each written number in numbers array
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
									num[j] = l+1;
									j++;
								}
							}
						}

						
						
					}


					
				}


				thisNum = (num[0] * 10) + num[j-1];
				total += thisNum;

			}
			System.out.println(total);

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}