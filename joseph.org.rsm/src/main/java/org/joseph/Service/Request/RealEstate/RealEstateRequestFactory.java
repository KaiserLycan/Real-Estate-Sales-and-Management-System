package org.joseph.Service.Request.RealEstate;

import org.joseph.Model.Block;
import org.joseph.Model.Lot;

public class RealEstateRequestFactory {
    public static LotRequest makeLotRequest(Block block, Lot lot) { return new LotRequest(block, lot); }
    public static BlockRequest makeBlockRequest(Block block) { return  new BlockRequest(block); }

}
