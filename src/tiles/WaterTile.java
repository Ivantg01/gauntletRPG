package tiles;

import gfx.Asset;

/**
 * class to store a sprite for water solid
 *
 * @author Iván Torrijos
 *
 */
public class WaterTile extends Tile{

    public WaterTile(int id) {
        super(Asset.water, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
