package cs.cs3750.team4.blackjack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BlackJackGame extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture background;
	
	@Override
	public void create () {
		background = new Texture(Gdx.files.internal("Table.png"));
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
		batch.end();
	}
	
	@Override
	public void resize(int width, int height){
		
	}
}
