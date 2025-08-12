package io.github.acj.dungeongen;

import static io.github.acj.dungeongen.Main.r;

public class DungeonRoom {
    private final int x, y, width, height;
    private final TileType tileType;

    DungeonRoom(boolean isFirstRoom, TileType tileType){

        //x is >= 0, x <= Dungeon.GRID_WIDTH
        //y is >= 0, y <= Dungeon.GRID_HEIGHT

        if(isFirstRoom){
            //ensure the thing is formed somewhere in the middle

            int widthBuffer = Dungeon.GRID_WIDTH/4;
            int heightBuffer = Dungeon.GRID_HEIGHT/4;

            // the buffers help center it, yes i wanted them to sound fancy.
            this.x = r.nextInt(Dungeon.GRID_WIDTH/2)+widthBuffer;
            this.y = r.nextInt(Dungeon.GRID_HEIGHT/2)+heightBuffer;

            this.width = r.nextInt(Dungeon.MAXIMUM_ROOM_SIZE - Dungeon.MINIMUM_ROOM_SIZE + 1) + Dungeon.MINIMUM_ROOM_SIZE;
            this.height = r.nextInt(Dungeon.MAXIMUM_ROOM_SIZE - Dungeon.MINIMUM_ROOM_SIZE + 1) + Dungeon.MINIMUM_ROOM_SIZE;
            //no need to check for overlapping so skipping that;
        } else {

            //placeholders
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
            //normal logic
        }

        this.tileType = tileType;
        Main.dungeon.assignRoom(this);
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public TileType getTileType() {
        return this.tileType;
    }
    public int getCenterX(){
        return (this.x+this.width)/2;
    }
    public int getCenterY(){
        return (this.x+this.height)/2;
    }
}
