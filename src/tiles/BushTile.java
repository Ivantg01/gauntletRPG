package tiles;

import gfx.Asset;
/**
 * class to store a sprite for a bush solid
 *
 * @author Iván Torrijos
 *
 */

public class BushTile extends Tile{
    public BushTile(int id){
        super(Asset.bush, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

