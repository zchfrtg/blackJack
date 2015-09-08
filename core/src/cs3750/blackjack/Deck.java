package cs3750.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Deck {
	List<Card> cards = new ArrayList<Card>();
	List<Card> deltCards = new ArrayList<Card>();
	
	public Deck(Texture cardSheet) {
		TextureRegion[][] tmp = TextureRegion.split(cardSheet, cardSheet.getWidth()/13, cardSheet.getHeight()/4);
		
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 13; j++){
				Sprite s = new Sprite(tmp[i][j]);
				Card c = new Card(i, j, s);
				cards.add(c);
			}
		}
	}
	
	public void Shuffle(){
		Collections.shuffle(cards);
	}
	
	public void listCards(){
		for(Card c : cards){
			System.out.println(c.toString());
		}
	}
	
	public void listCardsInPlay() {
		for(Card c : deltCards){
			System.out.println(c.toString());
		}		
	}
	
	public void dealCard(int xPos, int yPos){
		Card c = cards.get(0);
		cards.remove(0);
		deltCards.add(c);
		c.SetPosition(xPos, yPos);
	}

	public void draw(SpriteBatch batch) {
		for(Card c : deltCards){
			c.draw(batch);
		}
		
	}


}
