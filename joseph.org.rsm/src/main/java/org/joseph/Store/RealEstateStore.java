package org.joseph.Store;

import org.joseph.Model.Block;
import org.joseph.Model.Lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RealEstateStore {
    public static List<Block> blockStore = new ArrayList<>();

    public static void setBlock(List<Block> blocks) { blockStore = blocks; }
    public static List<Block> getBlock() { return blockStore; }

    public static void addBlock(Block newBlock) { blockStore.add(newBlock); }
    public static void deleteBlock(Block block) { blockStore.removeIf( b -> b.getBlockID() == block.getBlockID());}

    public static void addLot(Block block, Lot newLot) {
        Optional<Block> optBlock = blockStore.stream().filter(b -> b.getBlockID() == block.getBlockID()).findFirst();
        optBlock.ifPresent(b -> b.getLots().add(newLot));
    }

    public static void deleteLot(Block block, Lot lot ) {
        Optional<Block> optBlock = blockStore.stream().filter(b -> b.getBlockID() == block.getBlockID()).findFirst();
        optBlock.ifPresent(b -> b.getLots().removeIf(l -> l.getLotID() == lot.getLotID()));
    }

    public static void udpateLot(Block block, Lot lot) {
        Optional<Block> optBlock = blockStore.stream().filter(b -> b.getBlockID() == block.getBlockID()).findFirst();
        optBlock.ifPresent(b -> {
            Optional<Lot> optLot = b.getLots().stream().filter(l -> l.getLotID() == lot.getLotID()).findFirst();
            optLot.ifPresent(l -> {
                l.setPrice(lot.getPrice());
                l.setHouse(lot.getHouse());
                l.setImageURL(lot.getImageURL());
            });
        });
    }
}
