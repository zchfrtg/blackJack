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
	
	
	@Override
	public void create () {
		background = new Texture(Gdx.files.internal("Table.png"));
		cardSheet = new Texture(Gdx.files.internal("classic-playing-cards.png"));
		TextureRegion[][] tmp = TextureRegion.split(cardSheet, cardSheet.getWidth()/13, cardSheet.getHeight()/4);
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 13; j++){
				cards[i][j] = new Sprite(tmp[i][j]);
			}
		}
		
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
		cards[1][12].setPosition(593, 140);
		cards[1][11].setPosition(693, 140);
		cards[1][12].draw(batch);
		cards[1][11].draw(batch);
		//end Temp
		batch.end();
	}
	
	@Override
	public void resize(int width, int height){
		
	}
}

