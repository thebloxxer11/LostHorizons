package net.tb11.LostHorizons.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;


// TODO: Use world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS); in this file
public class EngineersGauntlet extends Item {
    BlockPos storedPos = null;
    public EngineersGauntlet(Settings settings){
        super(settings);
    }
    //Link Mode
    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        return ActionResult.SUCCESS;
    }

}
