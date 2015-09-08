package cs3750.blackjack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture background;
	Texture cardSheet;
	Sprite[][] cards = new Sprite[4][13];
	Deck deck;
	boolean deal = true;
	
	
	@Override
	public void create () {
		background = new Texture(Gdx.files.internal("Table.png"));
		cardSheet = new Texture(Gdx.files.internal("classic-playing-cards.png"));
		deck = new Deck(cardSheet);
		deck.Shuffle();
		//deck.listCards();
		
		System.out.println(background.getWidth() + " " + background.getHeight());
		camera = new OrthographicCamera();
		camera.setToOrtho(false, background.getWidth(), background.getHeight());
		batch = new SpriteBatch();
		
	}
	
	@Override
	public void dispose(){
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		//Temp
		if(deal){
			deck.dealCard(593, 140);
			deck.dealCard(693, 140);
			deck.listCardsInPlay();
			deal = false;
		}
		deck.draw(batch);
		//end Temp
		batch.end();
	}
	
	@Override
	public void resize(int width, int height){
		
	}
}

