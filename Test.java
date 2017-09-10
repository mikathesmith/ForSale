/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsale;

import java.util.ArrayList;

import javax.smartcardio.Card;

import java.util.*;
import java.lang.*;

/**
 *
 * @author MichaelAlbert
 */
public class Test {
    private static double averageRemaining;
    private static ArrayList<Integer> cards = new ArrayList<Integer>();
    private static double averageCard;
    private static ArrayList<Card> cardvalue;
    private static int roundsleft = 5;
    private static  int range;
    private static int pLeft = 5;
    private static final int HIGH_RANGE = 23;
    private static final int LOW_RANGE =16;
    private static final Random random = new Random();
    private static final int CHEQUE_RANGE = 6; 
    private static int index30,index29,index28,index27,index2, index1;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ran = random.nextInt(2);
        Strategy s = new Strategy(){
            
            @Override
            public int bid(PlayerRecord p, AuctionState a){
                
                cardvalue = a.getCardsInAuction();
                for(int i = 0 ; i < cardvalue.size() ; i++){
                    cards.add(cardvalue.get(i).getQuality());
                }
                Collections.sort(cards);
                Collections.reverse(cards);
                
                range = cards.get(0)- cards.get(cards.size()-1);
                roundsleft = 5;
                for(int i = 0; i < cards.size() ; i++){
                    averageCard += cards.get(i);
                }
                averageCard = averageCard/6;
                
                
                if(p.getCash() > 0 && roundsleft > 0){
                    averageRemaining = p.getCash() /roundsleft;
                    roundsleft--;
                }
                
                if(p.getCash() > 0 && roundsleft > 0){
                    averageRemaining = p.getCash() /roundsleft;
                    roundsleft--;
                }
                ArrayList<PlayerRecord> playersize = a.getPlayersInAuction();
                pLeft = playersize.size();
                
                
                if(p.getCash() == 0){
                    return -1;
                }
                
                //if 3 people have pulled out on low cards and high bid drop out
                else if(pLeft <3 && cards.get(0) < 25 && a.getCurrentBid() > 5){
                    return -1;
                }
                //if card is 30 and have 6 or more dollars left bid 6
                
                else if(cards.indexOf(30) != -1 && 6 <= p.getCash()){
                    return 6;
                }
                //if card is 30 and have less than 6 dollars bid remaining cash.
                else if(cards.indexOf(30) != -1 ){
                    return p.getCash();
                }
                //if card is 29 and have 5 or more dollars left bid 5
                else if(cards.indexOf(29) != -1 && 5 <= p.getCash()){
                    return 5;
                }
                //if card is 29 and have less than 7 dollars bid remaining cash
                else if(cards.indexOf(29) != -1 ){
                    return p.getCash();
                }
                //if card is 28 and have 6 or more dollars left bid 6
                else if(cards.indexOf(28) != -1 && 4 <= p.getCash()){
                    return 4;
                }
                //if card is 28 and have less than 6 dollars bit remaining cash
                else if(cards.indexOf(28) != -1){
                    return p.getCash();
                }
                //if bid is too high pull out
                else if(a.getCurrentBid() >= 6){
                    return -1;
                }
                //if high cards with low range pull out
                else if(range < LOW_RANGE && 28 > cards.get(0) && cards.get(0) > 25){
                    return -1;
                }
                //if middle range cards and low remaining cash per turn pull out
                
                else if(cards.get(cards.size()-1) > 6 && cards.get(0) < 25  && averageRemaining < 3.5){
                    return -1;
                }
                //if the cards are greater than 6 and range is low pull out
                else if(cards.get(cards.size()-1) > 6 && range  < LOW_RANGE){
                    return -1;
                }
                
                //if 3 low cards and atleast 1 high card and current bid less than 5 plus 1 to current bid
                else if(cards.get(cards.size()-3) < 10 && cards.get(0) >= 25 && a.getCurrentBid() < 5){
                    return 1+ a.getCurrentBid();
                }
                //base cases
                
                
                /*low average betting round*/
                if (range > HIGH_RANGE && averageCard < 12){
                    if(a.getCurrentBid() < 4){
                        return 4;
                    }
                }
                if (LOW_RANGE < range  && range < HIGH_RANGE && averageCard < 12) {
                    if(a.getCurrentBid() <= 4){
                        return 4;
                    }
                }
                if (range < LOW_RANGE && averageCard < 12){
                    if(a.getCurrentBid() <= 2){
                        return 2;
                    }
                }
                /*high average betting round*/
                if (range > HIGH_RANGE && averageCard > 18){
                    if(a.getCurrentBid() <= 3){
                        return 4;
                    }
                }
                if (LOW_RANGE < range && range < HIGH_RANGE && averageCard > 18) {
                    if(a.getCurrentBid() <= 3){
                        return 4;
                    }
                }
                if (range < LOW_RANGE && averageCard > 18){
                    if(a.getCurrentBid() <= 1){
                        return 2;
                    }
                }
                
                
                /** average betting round */
                if (range > HIGH_RANGE && 12 < averageCard && averageCard < 18) {
                    if(a.getCurrentBid() <= 6){
                        return 3;
                    }
                }
                if (LOW_RANGE < range  && range < HIGH_RANGE && 12 < averageCard  && averageCard < 18) {
                    if(a.getCurrentBid() <= 4){
                        return 2;
                    }
                }
                if (LOW_RANGE > range && 12 < averageCard && averageCard < 18) {
                    if(a.getCurrentBid() <= 2){
                        return 2;
                    }
                }
                
                /** default to catch any mistakes */
                if (range < LOW_RANGE){
                    if(p.getCash() > 4){
                        return 2;
                    }
                } else if (LOW_RANGE <= range && range <= HIGH_RANGE) {
                    if (p.getCash() > 5){
                        return 3;
                    }
                } else {
                    if (p.getCash() > 6){
                        return 1+a.getCurrentBid();
                    }
                }
                return -1;
            }
            
            
            
            @Override
            public Card chooseCard(PlayerRecord p, SaleState s) {
        			ArrayList<Card> myCurrentHand = p.getCards(); //the houses that I've bought in phase 1
        			ArrayList<Integer> cards= new ArrayList<Integer>();  
        			ArrayList<Integer> chequesLeft= s.getChequesRemaining();  //the cheques that are still left in the deck

                    for (int i = 0 ; i < myCurrentHands().size()-1 ; i++){
                        if(myCurrentHand(i).getQuality().indexOf(30) != -1){
                            index30=i;
                        }
                        if(myCurrentHand(i).getQuality().indexOf(29) != -1){
                            index29=i;
                        }
                        if(myCurrentHand(i).getQuality().indexOf(28) != -1){
                            index28=i;
                        }
                        if(myCurrentHand(i).getQuality().indexOf(27) != -1){
                            index27=i;
                        }
                        if(myCurrentHand(i).getQuality().indexOf(2) != -1){
                            index2=i;
                        }
                        if(myCurrentHand(i).getQuality().indexOf(1) != -1){
                            index1=i;
                        }
                    }

        			for(Card c : myCurrentHand){ //fill hand with card integer values 
        				cards.add(c.getQuality());
        			}
                    Collections.sort(cards);
                    
                    
                    //Collections.reverse(cards); 
        			
                    ArrayList<Integer> cheques = s.getChequesAvailable(); //6 cheques played this round
                    Collections.sort(cheques); //sorted in ascending order of value
                    
                    
                    if(cards.indexOf(30) != -1 && cheques.contains(15)){
                    	if (cards.indexOf(29) != -1) { //also have a 29
                    		 if(chequesLeft.contains(15)) { // this is the first 15
                                 return myCurrentHand.get(index29); //play 29 on first 15 cheque - cards.get(29);
                                 //return myCurrentHand.get(Card.getQuality(29);
                             } else{
                                 return myCurrentHand.get(index30); //play 30 on second 15 cheque 
                             }
                    	}else{ //dont have a 29
                    		 if (ran == 0) {
                                 if (chequesLeft.contains(15)) { // play 30 on first 15
                                 	return myCurrentHand.get(index30);
                                 }
                             } else{ // r == 1
                            	 if (!chequesLeft.contains(15)) { // play 30 on second 15
                                  	return myCurrentHand.get(index30);
                                  }
                            	 
                             }
                    	}
                    }
                    
                    //check if we have a 29
                    if (cards.indexOf(29) != -1) {
                            if (cheques.contains(15) && !chequesLeft.contains(15)) { // second 15
                                return myCurrentHand.get(index29); //wait for the second 15 cheque
                            }
                    }

                    //check if we have a 28
                    if (cards.indexOf(28) != -1) {
                        if (cheques.contains(14)) { // first 14
                            return myCurrentHand.get(index28); // play 28 on first 14
                        }
                    }

                    //check if we have a 27
                    if (cards.indexOf(27) != -1) {
                        if (cheques.contains(14) && !chequesLeft.contains(14)) { // second 14
                            return myCurrentHand.get(index27); // play 27 on second 14
                        }
                    }

                    // check if we have a 2 and not a 1
                    if (cards.indexOf(2) != -1 && cards.indexOf(1) == -1) {
                        if (cheques.get(0) >= 6) { // lowest cheque value is 6
                            return myCurrentHand.get(index2);
                        }
                    }

                    // check if we have a 1 and not a 2
                    if (cards.indexOf(1) != -1 && cards.indexOf(2) == -1) {
                        if (cheques.get(0) >= 6) { // lowest cheque value is 6
                            return myCurrentHand.get(index1);
                        }
                    }

                    if(cheques.contains(0)){
                        return myCurrentHand.get((myCurrentHand.size()/2)+1); //return middle card
                    }


                    //Generic method 
                    int chequeRange = cheques.get(cheques.size()-1) - cheques.get(0); //range between highest and lowest cheque
                    if(chequeRange < CHEQUE_RANGE){ //low range
                        return myCurrentHand.get(0); // play lowest card
                    }else{ //high range
                        if (cheques.get(5)  == 13) { // check if highest cheque is a 13
                            return myCurrentHand.get(myCurrentHand.size()-1); // play highest card
                        } else {
                            return myCurrentHand.get((myCurrentHand.size()/2)+1); //return middle card
                        }
                    }

               // System.out.println(p.getCards());
                return p.getCards().get((int) (Math.random()*p.getCards().size()));
            }
        };
        
        
        // A null strategy - never bid, always play your top card.
        Strategy flop = new Strategy() {
            
            @Override
            public int bid(PlayerRecord p, AuctionState a) {
                return -1;
            }
            
            @Override
            public Card chooseCard(PlayerRecord p, SaleState s) {
                return p.getCards().get(0);
            }
            
        };
        
        // A random strategy - make a random bid up to your amount remaining,
        // choose a rand card to sell.
        Strategy r = new Strategy() {
            
            @Override
            public int bid(PlayerRecord p, AuctionState a) {
                return (int) (1 + (Math.random()*p.getCash()));
            }
            
            @Override
            public Card chooseCard(PlayerRecord p, SaleState s) {
                return p.getCards().get((int) (Math.random()*p.getCards().size()));
            }
            
        };
        
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i < 2; i++) {
            players.add(new Player("flop" + ((char) ('A' + i)), flop));
            players.add(new Player("R"+ ((char) ('A' + i)), r));
            players.add(new Player("Our"+ ((char) ('A' + i)), s));
        }
        GameManager g = new GameManager(players);
        g.run();
        System.out.println(g.getLog());
    }
}
