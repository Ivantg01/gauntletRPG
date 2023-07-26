package tiles;

import gfx.Asset;

/**
 * class to store a sprite for a rock wall upper part solid
 *
 * @author Iván Torrijos
 *
 */
public class RockWall1Tile extends Tile{
    public RockWall1Tile(int id){
        super(Asset.rockWall1, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
