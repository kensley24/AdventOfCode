import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class daySeven1 {
    //compare function 

    //get rank 
    static int getRank(String in){
        int count1 = 0;
        int count2 = 0;
        char charA = 0;
        char charB = 0;

        for(int i = 0; i < in.length(); i++){
            char currChar = in.charAt(i);
            for(int j = i+1; j < in.length(); j++){
                if(in.charAt(j) == charA){
                    count1++;
                }
                else if(currChar == in.charAt(j)){
                    charA = currChar;
                    count1 +=2;
                }
            }
            if(count1 > 0){
                break;
            }
        }

        for(int k = 0; k < in.length(); k++){
            char currChar = in.charAt(k);
            for(int j = k+1; j < in.length(); j++){
                if(in.charAt(j) == charB){
                    count2++;
                }
                else if(currChar != charA && currChar == in.charAt(j) ){
                    charB = currChar;
                    count2 +=2;
                }
            }
            if(count2 > 0){
                break;
            }
        }
        //System.out.printf("charA: %c count1: %d charB: %c count2: %d", charA, count1, charB, count2);

        if(count1 == 5 || count2 == 5){
            return 7;
        }
        else if(count1 == 4 || count2 == 4){
            return 6;
        }
        else if(count1 == 3 || count2 == 3){
            if(count1 == 2 || count2 == 2){
                return 5;
            }
            else if(count1 == 0 || count2 == 0){
                return 4;
            }
        }
        else if(count1 == 2 && count2 == 2){
            return 3;
        }
        else if(count1 == 2 || count2 == 2){
            return 2;
        }
        return 1;
    }

    public static void main(String args[]){

        int k = getRank("12345");
        System.out.println(k);

        ArrayList<Integer> bids = new ArrayList<Integer>();
        ArrayList<String> cards = new ArrayList<String>();
     //create 2 arrays: card(ordered by number)
                    // bid(in same order)
    
        //loop through the file 
        try{

            Scanner scanner = new Scanner(new File("inx.txt"));

            while(scanner.hasNextLine()){

                String next = scanner.nextLine();
                System.out.println(next);
                String[] s = next.split(" ");

                String currCard = s[0];
                String currBid = s[1];
                //System.out.printf("currCard: %s, currBid: %s", currCard, currBid);
                //System.out.println(currCard);
                /* 
                try{

                }
                catch(NumberFormatException e){
                    System.out.println("Not Valid")
                }
                */
                //Integer currBid = Integer.valueOf(s[1]);
                //System.out.printf("currBidLength: %d\n", currBid.length());

                //get and save the rank of the current card
                int currRank = getRank(currCard);
                System.out.printf("cardRank: %d\n", currRank);

                 
                if(cards.size() == 0){
                    cards.add(currCard);
                    //bids.add(currBid);
                }
                else{
                    //int currRank = getRank(currCard);
                    //System.out.println(currRank);
                    int cardSize = cards.size();
                    for(int i = 0; i < cardSize; i++){

                        int rank = getRank(cards.get(i));
                        //System.out.printf("Rank: %d\n", rank);
                        
                        if(currRank < rank){
                            cards.add(i, currCard);
                        }
                        
                    }
                    
                }
                
            
            }
            

            for(String l : cards){
                System.out.println(l);
            }

            
            

            //compare ranks of next card
            //go through card array and use compare function to add the card in order 

            //add the bid in the same place

        //go through bid array and add the bids to get final answer 

        }
        catch(FileNotFoundException e) {
			e.printStackTrace();
		}

        



    }

}
