package org.joseph.Service.Request.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Service.Request.Request;

public class BlockRequest implements Request {
    private final Block block;


    public BlockRequest(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
