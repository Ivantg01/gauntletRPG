package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class for storing sprites of all tiles
 * Each tile has a single identifier and can be solid or not. Players can not move into solid tiles
 *
 * @author Iván Torrijos
 *
 */
public class Tile {
    //STATIC TILE ARRAY
    public static Tile[] tiles = new Tile[64];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);
    public static Tile waterTile = new WaterTile(3);
    public static Tile dirtinGrassTile = new DirtinGrass(4);
    public static Tile rockinGrassTile = new RockinGrass(5);
    public static Tile rockWall1Tile = new RockWall1Tile(6);
    public static Tile rockWall2Tile = new RockWall2Tile(7);
    public static Tile bush = new BushTile(8);
    public static Tile brick = new BrickTile(9);
    public static Tile floorGold = new FloorGoldTile(10);
    public static Tile treasure = new TreasureTile(11);

    //CLASS
    public static final int TILEWIDTH= 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    /**
     * Constructor store the sprite with an identifier
     * @param texture image of the tile
     * @param id identier to assign to the tile
     */
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    /**
     * time process to make any process before drawing
     */
    public void tick() {
    }

    /**
     * time process to draw anything needed
     */
    public void render (Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    /**
     * Define the default tile as not solid
     * @return false = not solid
     */
    public boolean isSolid(){
        return false;
    }

    /**
     * Get the Id of the current tile
     * @return
     */
    public int getId() {
        return id;
    }

}
