
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

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

public class dayTwo{

	public static void main(String[] args){

		int total = 0;
		int gameNumber = 0;
		int pwr = 0;

		try {

			Scanner scanner = new Scanner(new File("input.txt"));

			while (scanner.hasNextLine()) {

				int i = 8;
				String next = scanner.nextLine();

				gameNumber++;
				System.out.println(gameNumber);

				if(gameNumber - 10 >= 0){
					if(gameNumber - 100 >= 0){
						i = 10;
					}
					else{
						i = 9;
					}
					
				}

				char ptr = next.charAt(i);
				int r = 0;
				int g = 0; 
				int b = 0;
				int minr = 0;
				int ming = 0;
				int minb = 0;
				boolean valid = true;

				for(int j = i ; j < next.length(); j++){
					ptr = next.charAt(j);

					if(ptr == ';'){
						if(r > minr){
							minr = r;
						}
						if(g > ming){
							ming = g;
						}
						if(b > minb){
							minb = b;
						}
						r = 0;
						g = 0; 
						b = 0;
					}
					
					if(ptr >= 48 && ptr <= 57 ){
						int num = 0;
						while(ptr >= 48 && ptr <= 57){
							num = num * 10;
							num += (ptr - '0');
							j++;
							ptr = next.charAt(j);
						}

						j = j+1;
						ptr = next.charAt(j);

						if(ptr == 'r'){
							r += num;

							j = j + 2;

						}
						else if(ptr == 'g'){
							g += num;
							j = j + 4;

						}
						else if(ptr == 'b'){
							b += num;
							j = j + 3;
						}

						ptr = next.charAt(j);


					}

				}

				if(r > minr){
					minr = r;
				}
				if(g > ming){
					ming = g;
				}
				if(b > minb){
					minb = b;
				}


				pwr = minr * minb * ming;
				System.out.println(pwr);
				
				total = total + pwr;


			}

		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.printf("final total: %d", total);

	}
}