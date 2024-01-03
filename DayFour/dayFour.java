import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
Advent Of Code Day Two

for an input formatted like below, find the largest amount of red,
green and blue in each line and multiply the values together, this
is called a power of a line. add each line's power to a sum and 
get that sum

ex: 
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

*/

public class dayFour{

	public static void main(String[] args){
		int finalTotal = 0;

		ArrayList<Integer> wins = new ArrayList<Integer>();
		ArrayList<Integer> card = new ArrayList<Integer>();
		try {

			Scanner scanner = new Scanner(new File("input.txt"));
			int cardNumber = 0;
			card.add(0);
			while (scanner.hasNextLine()) {
				//System.out.println("has LIne");
				cardNumber ++;
				wins.clear();

				if(card.size() <= cardNumber){
					card.add(0);
				}
			

				String next = scanner.nextLine();
				int j = 0;

				char ptr = next.charAt(j);

				while(ptr != ':'){
					j++;
					ptr = next.charAt(j);
				}

				while(ptr != '|'){
					ptr = next.charAt(j);
					if(ptr >= 48 && ptr <= 57){
						int num = 0;
						while(ptr >= 48 && ptr <= 57){
							num = num * 10;
							num += (ptr - '0');
							j++;
							ptr = next.charAt(j);
						}

						wins.add(num);
						j--;						
					}

					j++;
				}
				/* 
				System.out.print('[');
				for(int i = 0; i < wins.size(); i++){
					System.out.print(wins.get(i));
					System.out.print(',');
				}
				System.out.print(']');
				System.out.println();
				*/

				//System.out.println(j);
				int total = 0;
				for(int k = j; k < next.length(); k++){
					
					
					//System.out.printf("%c", ptr);
					ptr = next.charAt(k);
					//System.out.printf("%c", ptr);

					
					//System.out.printf("out %d ", k);

					if(ptr >= 48 && ptr <= 57){
						//System.out.print("num");
					 
						int num = 0;

						while(ptr >= 48 && ptr <= 57){
							//int l = k;
							num = num * 10;
							num += (ptr - '0');
							k++;
							if(k < next.length()){	
								ptr = next.charAt(k);
								//System.out.printf("%c", ptr);
							}
							else{
								break;
							}
							

						}
						if(wins.contains(num)){
							total ++;
							
							
							/* 
							if(total == 0){
								total = 1;
							}
							else{
								total *= 2;
							}
							*/
							//System.out.printf("num: %d, tot: %d\n", num, total);
						}
						//arr.add(num);


						//System.out.println(num);
						k--;

					}
					

					ptr = next.charAt(k);
					
				}
				/* 
				System.out.print('[');
				for(int i = 0; i < arr.size(); i++){
					System.out.print(arr.get(i));
					System.out.print(',');
				}
				System.out.print(']');
				*/

				//System.out.println(total);

				for(int m = 1; m < total+1; m++){
					
					if((cardNumber + m) > card.size()-1){
						/* 
						for(int g = card.size()-1; g < cardNumber+m; g++){
							card.add(0);
						}
						*/	
						card.add(1 + card.get(cardNumber));
					}
					else{
						int f = card.get(cardNumber+m) + card.get(cardNumber) + 1;
						card.set(cardNumber+m, f);
					}
				}

				//if(total > 0){finalTotal += 1;}
				finalTotal += card.get(cardNumber);
				//System.out.println(finalTotal);
				
				//countedWins.add(total);
				

				//System.out.println();

			}
			System.out.println(card.size());
			for(int i = 0; i < card.size(); i++){
				//finalTotal += card.get(i);
				System.out.print(card.get(i));
				System.out.print(',');
			}
			System.out.print(']');
			finalTotal += cardNumber;

			System.out.println(finalTotal);
			

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
