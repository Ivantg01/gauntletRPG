package tiles;

import gfx.Asset;

/**
 * class to store a sprite for a rock wall bottom part solid
 *
 * @author Iván Torrijos
 *
 */
public class RockWall2Tile extends Tile{
    public RockWall2Tile(int id){
        super(Asset.rockWall2, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
