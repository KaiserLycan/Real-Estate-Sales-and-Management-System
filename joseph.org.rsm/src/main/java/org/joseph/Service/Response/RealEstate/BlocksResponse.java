package org.joseph.Service.Response.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Service.Response.Response;

import java.util.List;

public class BlocksResponse implements Response {
    private final List<Block> blocks;

    public BlocksResponse(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
