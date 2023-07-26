package tiles;

import gfx.Asset;

/**
 * class to store a sprite for a brick solid
 *
 * @author Iván Torrijos
 *
 */
public class BrickTile extends Tile{
    public BrickTile(int id){
        super(Asset.brick, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}