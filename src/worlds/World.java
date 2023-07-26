package worlds;

import entities.*;
import handler.Handler;
import tiles.Tile;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * class to store static maps of the game
 * Each map is an array of integers and each integer is the identifier of each tile
 * Player can move inside each map or world and move from a world to another
 *
 * @author Iván Torrijos
 *
 */

public class World {
    private Handler handler;
    private int width, height;
    private int[][] tableTiles;
    private int x;
    private int y;

    private ArrayList<Entity> entities;

    /**
     * Constructor of the World class
     * @param handler
     */
    public World(Handler handler){
        this.handler = handler;
        createWorldEnemies(handler);
    }

    /**
     * time process to make any process before drawing
     */
    public void tick(){
    }

    /**
     * time process to draw anything needed
     */
    public void render(Graphics g){
        for(int i=0; i < width; i++){
            for(int j=0; j < height; j++){
                getTile(i,j).render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
            }
        }
    }

    /**
     * Get the tile object of the coordinates i,j
     * @param i coordinate i
     * @param j coordinate j
     * @return the tile object
     */
    public Tile getTile(int i, int j){
        if (i < 0 || j < 0 || i >= width || j >= height)
            return Tile.grassTile;

        Tile t = Tile.tiles[tableTiles[i][j]];
        if (t==null)
            return Tile.dirtTile;  //default tile
        return t;
    }

    /**
     * Load a world map using its x,y coordinates on the universe of worlds
     * @param _x coordinate x of the table of worlds
     * @param _y coordinate y of the table of worlds
     */
    public void loadWorld(int _x, int _y){
        String[] tokens = UNIVERSE[_x][_y].split("\\s+");
        x=_x;
        y=_y;
        width = Utils.parseInt(tokens[0]);   //map size
        height = Utils.parseInt(tokens[1]);

        System.out.println("Loading world=("+x+","+y+")");
        tableTiles = new int[width][height];
        for(int i=0; i < width; i++){
            for(int j=0; j < height; j++){
                tableTiles[i][j] = Utils.parseInt(tokens [(i + j * width) + 2]);
            }
        }
    }

    /**
     * Create the enemies of the game in the different world maps<br>
     *     An enemy is created in a specific word
     * @param handler handler to access game objects
     */
    public void createWorldEnemies(Handler handler) {
        //add enemy to the world tiles
        Entity goblin = new Goblin(handler, 6 *Tile.TILEWIDTH, 4* Tile.TILEHEIGHT, 1, 1);
        Entity skeleton = new Skeleton(handler, 4 *Tile.TILEWIDTH, 4* Tile.TILEHEIGHT, 1, 2);
        Entity ghost1 = new Ghost(handler, 8 *Tile.TILEWIDTH, 4* Tile.TILEHEIGHT, 0, 3);
        Entity ghost2 = new Ghost(handler, 8 *Tile.TILEWIDTH, 4* Tile.TILEHEIGHT, 2, 3);

        entities = new ArrayList<Entity>();
        entities.add(goblin);
        entities.add(skeleton);
        entities.add(ghost1);
        entities.add(ghost2);
    };

    /**
     * Used to check if there are still enemies in any world
     * @return true is there is some enemy active; true is all enemies are not active
     */
    public boolean stillEnemiesAlive() {

        for (Entity e: entities) {
            if (e instanceof Enemy) {
                if (((Enemy) e).isActive() == true)
                    return false;
            }
        }
        return true;
    }

    /**
     * World map made of a 2D array where each cell contains the tile ID to be shown on the map<br>
     * The first row contains the size in tiles in each map (width x height)
     */
    public static String WORLD00 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            " 6 6 6 6 6 6 6 6 6 6\n"+   //MAP
            " 7 7 7 7 7 7 7 7 7 7\n"+
            " 8 0 0 0 4 0 0 0 0 0\n"+
            " 8 0 0 0 0 4 0 0 0 0\n"+
            " 8 0 0 0 0 1 0 0 0 0\n"+
            " 8 0 0 0 1 1 0 0 0 0\n"+
            " 8 0 0 0 1 1 0 0 0 0\n"+
            " 8 0 0 0 1 1 0 0 0 0";
    public static String WORLD01 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "6 6 6 6 6 6 6 3 3 3\n"+   //MAP
            "7 7 7 7 6 6 7 3 3 3\n"+
            "0 0 0 0 6 7 3 3 3 3\n"+
            "0 0 0 4 6 3 3 3 3 3\n"+
            "0 0 0 0 6 3 3 3 3 3\n"+
            "0 0 0 0 6 3 3 3 3 3\n"+
            "0 0 0 0 6 6 3 3 3 3\n"+
            "0 0 0 0 6 6 6 3 3 3";
    public static String WORLD02 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "0 0 0 0 0 0 0 0 0 0\n"+   //MAP
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0";
    public static String WORLD10 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "8 0 0 0 1 1 0 0 0 0\n"+   //MAP
            "8 0 4 0 1 1 0 0 0 0\n"+
            "8 0 0 0 1 1 0 0 0 0\n"+
            "8 0 0 1 1 1 1 0 0 0\n"+
            "8 0 0 1 1 1 1 1 1 1\n"+
            "8 0 0 1 1 1 1 0 0 0\n"+
            "8 0 0 0 1 1 0 0 0 0\n"+
            "8 0 0 0 1 1 0 4 0 0";
    public static String WORLD11 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "0 0 0 5 6 6 6 3 3 3\n"+   //MAP
            "0 0 5 0 7 7 6 6 3 3\n"+
            "0 0 0 0 0 0 7 6 6 6\n"+
            "0 0 0 4 0 0 0 7 7 7\n"+
            "1 1 1 1 1 1 1 2 2 2\n"+
            "0 0 0 0 0 0 0 6 6 6\n"+
            "0 4 0 0 5 6 6 6 7 7\n"+
            "0 0 0 0 5 6 6 7 3 3";
    public static String WORLD12 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "3 3 3 3 3 3 3 3 3 6\n"+   //MAP
            "3 3 3 3 3 3 3 3 3 6\n"+
            "6 6 6 6 6 6 6 6 6 6\n"+
            "7 7 7 7 7 7 7 7 7 7\n"+
            "2 2 2 2 2 2 2 2 2 2\n"+
            "6 6 6 6 6 6 6 6 6 6\n"+
            "7 7 7 7 7 7 7 7 7 6\n"+
            "3 3 3 3 3 3 3 3 3 6";
    public static String WORLD20 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "8 0 0 0 1 1 0 0 0 0\n"+   //MAP
            "8 0 0 0 1 1 0 4 0 0\n"+
            "8 0 0 0 1 1 0 0 0 0\n"+
            "8 0 0 0 1 1 1 0 0 0\n"+
            "8 0 0 0 1 1 1 1 1 1\n"+
            "8 0 4 0 1 1 1 0 0 0\n"+
            "6 6 6 6 6 6 6 6 6 6\n"+
            "7 7 7 7 7 7 7 7 7 7";
    public static String WORLD21 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "0 0 0 0 0 6 6 3 3 3\n"+   //MAP
            "0 0 0 0 0 6 6 3 3 3\n"+
            "0 0 0 0 6 6 7 3 3 3\n"+
            "0 0 0 0 6 7 3 3 3 3\n"+
            "0 4 0 0 6 3 3 3 3 3\n"+
            "0 0 0 0 6 3 3 3 3 3\n"+
            "6 6 6 6 6 3 3 3 3 3\n"+
            "7 7 7 7 7 3 3 3 3 3";
    public static String WORLD22 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "0 0 0 0 0 0 0 0 0 0\n"+   //MAP
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0\n"+
            "0 0 0 0 0 0 0 0 0 0";
    public static String WORLD03 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "9 9 9 9 9 9 9 9 9 9\n"+   //MAP
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 9 9 9 2 2 9 9 9 9\n";
    public static String WORLD13 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "9 9 9 9 2 2 9 9 9 9\n"+   //MAP
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "2 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 9 9 9 2 2 9 9 9 9\n";
    public static String WORLD23 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "9 9 9 9 2 2 9 9 9 9\n"+   //MAP
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 9 9 9 9 9 9 9 9 9\n";

    public static String WORLD14 =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            " 9  9  9  9  9  9  9  9  9 9\n"+   //MAP
            " 9 10 10 10 10 10 10 10 10 9\n"+
            " 9 10 10 10 10 11 10 10 10 9\n"+
            " 9 10 10 10 10 10 10 11 10 9\n"+
            "10 10 10 10 10 11 10 11 10 9\n"+
            " 9 10 10 10 10 10 11 10 10 9\n"+
            " 9 10 10 10 10 10 10 10 10 9\n"+
            " 9  9  9  9  9  9  9  9  9 9\n";

    /**
     * This world map is the same than the world 13 with a hidden door open
     */
    public static String WORLD13bis =
            "10 8\n"+         //#COLUMNS #ROWS OF THE MAP
            "9 9 9 9 2 2 9 9 9 9\n"+   //MAP
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "2 2 2 2 2 2 2 2 2 2\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 2 2 2 2 2 2 2 2 9\n"+
            "9 9 9 9 2 2 9 9 9 9\n";

    /**
     * Universe in 2D of maps. <br>
     * Player can move from a map to the connected maps up,down,right,left<br>
     * Solid tiles can block the movement of the player
     */
    public static String[][] UNIVERSE ={
            {WORLD00, WORLD01, WORLD02, WORLD03},
            {WORLD10, WORLD11, WORLD12, WORLD13, WORLD14},
            {WORLD20, WORLD21, WORLD22, WORLD23}
    };

    //GETTERS AND SETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Obtain all entities in the current world
     * @return arraylist with the entities
     */
    public ArrayList<Entity> getWorldEntities() {
        ArrayList<Entity> ret= new ArrayList<Entity>();

        //only for enemies, add them if they are in the current map of the player
        for (Entity e: entities) {
            if (e instanceof Enemy) {
                //skip enemy if enemy world != player world
                if (((Enemy) e).getWorldTileX() != x || ((Enemy) e).getWorldTileY() != y)
                    continue;
            }
            ret.add(e);
        }
        return ret;
    }

    /**
     * Obtain active entities in the current world
     * @return arraylist with the active entities
     */
    public ArrayList<Entity> getWorldActiveEntities() {
        ArrayList<Entity> ret= new ArrayList<Entity>();

        //only for enemies, add them if they are in the current map of the player
        for (Entity e: entities) {
            if (e instanceof Enemy) {
                if (((Enemy) e).isActive() == false)
                    continue;
                //skip enemy if enemy world != player world
                if (((Enemy) e).getWorldTileX() != x || ((Enemy) e).getWorldTileY() != y)
                    continue;
            }
            ret.add(e);
        }
        return ret;
    }

    public void openSecretDoor() {
        handler.getWorld().UNIVERSE[1][3]=handler.getWorld().WORLD13bis;
    }

    public void closeSecretDoor() {
        handler.getWorld().UNIVERSE[1][3]=handler.getWorld().WORLD13;
    }

}
