package forsale;
import java.util.*;




public abstract class GamePlay implements Strategy{
	
	public static void main(String[]args){
		 
		//bid - Phase 1
		
		//chooseCard - Phase 2
	}
	
	public Card chooseCard(PlayerRecord p, SaleState s){
		ArrayList<Card> myCurrentHand = p.getCards(); //the houses that I've bought in phase 1 - order these? 
		ArrayList<Integer> cheques = s.getChequesAvailable(); //6 cheques played this round, one of 
		//which I select to sell one of my houses for 
		
	//	Card c = new Card(30, "Space station"); 
		
		for(Card c : myCurrentHand){
			System.out.println(c.getQuality());
		}
		
		//Check if we have a 30
		//if(myCurrentHand.indexOf(new Card(30)) != -1){ //we have a 30
			
	//	}
		
		//check if we have a 29
		
		
		//if getChequesAvailable from salestate includes a 30, then... 
			//look at hand - getCardsInHand and see if we have a getQuality()==30 
		
		//getChequesRemaining
		
		//getCurrentBid
		
		//getPlayersInAuction if this is 1 and no one has played a higher card then your highest
		//then play highest card 
		
		return myCurrentHand.get(0); //return a Card to play 
	}
	
	public int bid(PlayerRecord p, AuctionState a){
		return 1; 
	}
	
}