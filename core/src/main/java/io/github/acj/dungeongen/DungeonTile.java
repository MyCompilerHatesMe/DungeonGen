package io.github.acj.dungeongen;


import com.badlogic.gdx.graphics.Color;

public class DungeonTile {

    private TileType type;

    DungeonTile(TileType type) {
        this.type = type;
    }

    public Color getColor() {
        return type.getColor();
    }

    public void setType(TileType type) {
        this.type = type;
    }
}
