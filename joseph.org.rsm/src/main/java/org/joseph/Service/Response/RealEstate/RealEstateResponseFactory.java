package org.joseph.Service.Response.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Model.Lot;

import java.util.List;

public class RealEstateResponseFactory {
    public static BlockResponse makeBlockResponse(Block block) { return new BlockResponse(block); }
    public static BlocksResponse makeBlocksResponse(List<Block> blocks) { return new BlocksResponse(blocks); }
    public static LotResponse makeLotResponse(Lot lot) { return new LotResponse(lot); }
    public static LotsResponse makeLotsResponse(List<Lot> lots) { return new LotsResponse(lots); }
}
