/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsale;

import java.util.ArrayList;
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
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< HEAD
=======


>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
        
        Strategy s = new Strategy(){
                
                @Override
                public int bid(PlayerRecord p, AuctionState a){
<<<<<<< HEAD
                        cardvalue = a.getCardsInAuction(); 
                        for(int i = 0 ; i < cardvalue.size() ; i++){
                            cards.add(cardvalue.get(i).getQuality());
                             }
                        Collections.sort(cards);
                        Collections.reverse(cards);
=======
                        
                    if(a.getCardsInAuction().size() ==6){
                        cardvalue = a.getCardsInAuction(); 
                        for(int i = 0 ; i < cardvalue.size() ; i++){
                            cards.add(cardvalue.get(i). getQuality());
                        }
                        Collections.sort(cards);  
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
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
<<<<<<< HEAD
                    
                    ArrayList<PlayerRecord> playersize = a.getPlayersInAuction();
                    pLeft = playersize.size();

                    
                    if(p.getCash() == 0){
                        return -1;
                    }
 
=======
                    if(p.getCash() > 0 && roundsleft > 0){
                    averageRemaining = p.getCash() /roundsleft;
                    roundsleft--;
                    }
                    ArrayList<PlayerRecord> playersize = a.getPlayersInAuction();
                    pLeft = playersize.size();


                    if(p.getCash() == 0){
                        return -1;
                    }
             
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                    //if 3 people have pulled out on low cards and high bid drop out
                    else if(pLeft <3 && cards.get(0) < 25 && a.getCurrentBid() > 5){
                        return -1;
                    }
                    //if card is 30 and have 8 or more dollars left bid 8
<<<<<<< HEAD
                    else if(cards.indexOf(30) != -1 && 6 <= p.getCash()){
                        return 6;
                    }
                    //if card is 30 and have less than 8 dollars bid remaining cash.
                    else if(cards.indexOf(30) != -1 ){
                        return p.getCash();
                    }
                    //if card is 29 and have 7 or more dollars left bid 7
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
=======
                    else if(cards.indexOf(30) != -1 && 8 <= p.getCash()){
                        return 8;
                    }
                    //if card is 30 and have less than 8 dollars bid remaining cash.
                    else if(cards.indexOf(30) != -1 ){
                        return p.getCash();
                    }
                    //if card is 29 and have 7 or more dollars left bid 7
                    else if(cards.indexOf(29) != -1 && 7 <= p.getCash()){
                        return 7;
                    }
                    //if card is 29 and have less than 7 dollars bid remaining cash
                    else if(cards.indexOf(29) != -1 ){
                        return p.getCash();
                    }
                    //if card is 28 and have 6 or more dollars left bid 6
                    else if(cards.indexOf(28) != -1 && 6 <= p.getCash()){
                        return 6;
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
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                
                
                    /*high average betting round*/
                    if (range > HIGH_RANGE && averageCard > 18){
<<<<<<< HEAD
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
=======
                        if(a.getCurrentBid() <= 6){
                            return 6;
                        }
                    }
                    if (LOW_RANGE < range && range < HIGH_RANGE && averageCard > 18) {
                        if(a.getCurrentBid() <= 6){
                            return 6;
                        }
                    }
                    if (range < LOW_RANGE && averageCard > 18){
                        if(a.getCurrentBid() <= 4){
                            return 4;
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                        }
                    }
                
                
                    /** average betting round */
                    if (range > HIGH_RANGE && 12 < averageCard && averageCard < 18) {
                        if(a.getCurrentBid() <= 6){
<<<<<<< HEAD
                            return 3;
=======
                            return 5;
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                        }
                    }
                    if (LOW_RANGE < range  && range < HIGH_RANGE && 12 < averageCard  && averageCard < 18) {
                        if(a.getCurrentBid() <= 4){
<<<<<<< HEAD
                            return 2;
=======
                            return 4;
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                        }
                    }
                    if (LOW_RANGE > range && 12 < averageCard && averageCard < 18) {
                        if(a.getCurrentBid() <= 2){
<<<<<<< HEAD
                            return 2;
=======
                            return 4;
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                        }
                    }
                
                    /** default to catch any mistakes */
                    if (range < LOW_RANGE){
                        if(p.getCash() > 4){
<<<<<<< HEAD
                            return 2;
                        }
                    } else if (LOW_RANGE <= range && range <= HIGH_RANGE) {
                        if (p.getCash() > 5){
                            return 3;
=======
                            return 4;
                        }
                    } else if (LOW_RANGE <= range && range <= HIGH_RANGE) {
                        if (p.getCash() > 5){
                            return 5;
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
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
<<<<<<< HEAD
                    System.out.println(p.getCards());
=======
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
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
<<<<<<< HEAD
                for(int i = 0; i < 2; i++) {
=======
                for(int i = 0; i < 3; i++) {
>>>>>>> 6fc1ed680d0c4bfbbab5f99ef6e2c99bc916f094
                    players.add(new Player("flop" + ((char) ('A' + i)), flop));
                    players.add(new Player("R"+ ((char) ('A' + i)), r));
                    players.add(new Player("Our"+ ((char) ('A' + i)), s));
                }
                GameManager g = new GameManager(players);
                g.run();
                System.out.println(g.getLog());
            }

            }
