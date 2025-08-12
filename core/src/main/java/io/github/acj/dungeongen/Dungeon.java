package io.github.acj.dungeongen;

import com.badlogic.gdx.utils.Array;

/**
 * The dungeon map and certain related functions
 */
public class Dungeon {
    protected static int GRID_UNIT_WIDTH, GRID_UNIT_HEIGHT;
    protected static int GRID_WIDTH, GRID_HEIGHT;

    protected static int MINIMUM_ROOM_SIZE;
    protected static int MAXIMUM_ROOM_SIZE;

    DungeonTile[][] map;

    Array<DungeonRoom> roomList;


    Dungeon(int gridUnitWidth, int gridUnitHeight, int minRoomSize, int maxRoomSize){

        MINIMUM_ROOM_SIZE = minRoomSize;
        MAXIMUM_ROOM_SIZE = maxRoomSize;

        GRID_UNIT_WIDTH = gridUnitWidth;
        GRID_UNIT_HEIGHT = gridUnitHeight;

        GRID_WIDTH = Main.WIDTH/GRID_UNIT_WIDTH;
        GRID_HEIGHT = Main.HEIGHT/GRID_UNIT_HEIGHT;

        map = new DungeonTile[GRID_WIDTH][GRID_HEIGHT];

        roomList = new Array<>();

        //init map, all walls
        for(int i = 0; i < GRID_WIDTH; i++){
            for(int j = 0; j < GRID_HEIGHT; j++){
                map[i][j] = new DungeonTile(TileType.WALL);
            }
        }
    }

    public void assignRoom(DungeonRoom room){

        int y = room.getY();
        int x = room.getX();
        int width = room.getWidth();
        int height = room.getHeight();
        TileType tileType = room.getTileType();

        for(int i = x; i < x+width; i++)
            for(int j = y; j < y+height; j++)
                if(i >= 0 && i < GRID_WIDTH && j >= 0 && j < GRID_HEIGHT)
                    map[i][j].setType(tileType);

        roomList.add(room);
    }

    public DungeonTile[][] getMap() {
        return map;
    }
}
