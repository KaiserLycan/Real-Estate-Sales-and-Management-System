package org.joseph.Model;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private int blockID;
    private List<Lot> lots;

    public Block (int blockID) {
        this.blockID = blockID;
        this.lots = new ArrayList<>();
    }

    public int getBlockID() { return blockID; }
    public List<Lot> getLots() { return lots; }
}
