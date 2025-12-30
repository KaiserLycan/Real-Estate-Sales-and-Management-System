package org.joseph.Store;

import org.joseph.DAO.RealEstateDAO;
import org.joseph.Model.Block;
import org.joseph.Model.Lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RealEstateStore {

    private static volatile RealEstateStore Instance;
    private List<Block> blockStore = new ArrayList<>();

    private RealEstateStore() {};

    public static RealEstateStore getInstance() {
        if(Instance == null)
            synchronized (RealEstateStore.class) {
                if(Instance == null)
                    Instance = new RealEstateStore();
            }
        return  Instance;
    }

    public void setBlock(List<Block> blocks) { blockStore = blocks; }
    public List<Block> getBlock() { return blockStore; }

    public Block getBlock(int blockId) { return blockStore.stream().filter(b -> b.getBlockID() == blockId).findFirst().orElse(null);}
    public Lot getLot(int blockId, int lotId) {
        Block block = blockStore.stream().filter(b -> b.getBlockID() == blockId).findFirst().orElse(null);
        if(block == null) return null;
        return block.getLots().stream().filter(l -> l.getLotID() == lotId).findFirst().orElse(null);
    }

    public void addBlock(Block newBlock) { blockStore.add(newBlock); }
    public void deleteBlock(Block block) { blockStore.removeIf( b -> b.getBlockID() == block.getBlockID());}

    public void addLot(Block block, Lot newLot) {
        Optional<Block> optBlock = blockStore.stream().filter(b -> b.getBlockID() == block.getBlockID()).findFirst();
        optBlock.ifPresent(b -> b.getLots().add(newLot));
    }

    public void deleteLot(Block block, Lot lot ) {
        Optional<Block> optBlock = blockStore.stream().filter(b -> b.getBlockID() == block.getBlockID()).findFirst();
        optBlock.ifPresent(b -> b.getLots().removeIf(l -> l.getLotID() == lot.getLotID()));
    }

    public void udpateLot(Block block, Lot lot) {
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
