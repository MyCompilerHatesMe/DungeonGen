package io.github.acj.dungeongen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    //Config variables
    public final static int WIDTH = 800, HEIGHT = 800;

    ShapeRenderer renderer;

    static Dungeon dungeon;

    //Gen Variables

    static Random r = new  Random();

    @Override
    public void create() {
        dungeon = new Dungeon(10, 10, 5,15 );
        renderer = new ShapeRenderer();
        for(int i = 0; i < 5; i++){
            new DungeonRoom(i==0, TileType.FLOOR);
        }
    }

    @Override
    public void render() {
        screenClear();
        draw();
    }

    public void draw(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        DungeonTile[][] map = dungeon.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j  = 0; j < map[i].length; j++) {
                DungeonTile tile = map[i][j];
                renderer.setColor(tile.getColor());
                renderer.rect(
                    i * Dungeon.GRID_UNIT_WIDTH,
                    j * Dungeon.GRID_UNIT_HEIGHT,
                    Dungeon.GRID_UNIT_WIDTH,
                    Dungeon.GRID_UNIT_HEIGHT
                );
            }
        }
        renderer.end();
    }

    public void screenClear(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
