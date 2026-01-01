package org.joseph.Service.Response.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Service.Response.Response;

public class BlockResponse implements Response {
    private final Block block;

    public BlockResponse(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
