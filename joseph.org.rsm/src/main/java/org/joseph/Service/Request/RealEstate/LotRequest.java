package org.joseph.Service.Request.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Model.Lot;
import org.joseph.Service.Request.Request;

public class LotRequest implements Request {
    private final Block block;
    private final Lot lot;

    public LotRequest(Block block, Lot lot) {
        this.block = block;
        this.lot = lot;
    }

    public Block getBlock() {
        return block;
    }

    public Lot getLot() {
        return lot;
    }
}
