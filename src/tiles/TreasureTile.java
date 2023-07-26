package tiles;

import gfx.Asset;

/**
 * class to store a sprite for a floor area with a treasure solid
 *
 * @author Iván Torrijos
 *
 */
public class TreasureTile extends Tile{
    public TreasureTile(int id){ super(Asset.treasure, id); }
    @Override
    public boolean isSolid(){
        return true;
    }
}
