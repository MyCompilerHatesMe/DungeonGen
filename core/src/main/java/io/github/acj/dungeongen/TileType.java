package io.github.acj.dungeongen;

import com.badlogic.gdx.graphics.Color;

public enum TileType {
    FLOOR(Color.BROWN),
    WALL(Color.GRAY);

    private final Color color;

    TileType(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
