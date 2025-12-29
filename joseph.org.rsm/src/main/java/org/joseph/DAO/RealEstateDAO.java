package org.joseph.DAO;

import org.joseph.Model.Block;
import org.joseph.Model.House;
import org.joseph.Model.Lot;
import org.joseph.Model.Types.HouseType;
import org.joseph.Model.Types.LotType;
import org.joseph.Model.Types.PurchaseStatus;
import org.joseph.Store.RealEstateStore;
import org.joseph.Store.UserStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RealEstateDAO extends AbstractDAO {
    private final String[] columns = new String[] {
            "blockId",
            "lotId",
            "ownerID",
            "lotType",
            "lotPrice",
            "lotSize",
            "lotImage",
            "housePrice",
            "houseImage",
            "houseType",
            "lotStatus"
    };

    public RealEstateDAO (String fileName) {
        super(fileName);
    }

    public String[] getColumns() { return columns; }


    protected void  readData() {
        List<String[]> data = new ArrayList<>();
        List<Block> blocks = new ArrayList<>();

        try (Scanner reader = new Scanner(database)) {

            if(reader.hasNextLine()) {
                reader.nextLine();
            }

            while(reader.hasNextLine()) {
                data.add(reader.nextLine().split(","));
            }
        }
        catch (IOException ex) {
            System.out.println("Error: Cannot read file.");
            ex.printStackTrace();
        }

        if(data.isEmpty())  return;

        // Create the Real Estate data object.
        for(String[] datum : data) {
            int blockId = Integer.parseInt(datum[0]);
            int lotId = Integer.parseInt(datum[1]);
            LotType lotType = LotType.fromString(datum[3]);
            float lotPrice = Float.parseFloat(datum[4]);
            float lotSize = Float.parseFloat(datum[5]);
            String lotImage = datum[6];
            PurchaseStatus status = PurchaseStatus.fromString(datum[10]);
            int ownerId = -1;
            float housePrice = -1;
            String houseImage = null;
            HouseType houseType = null;

            if(!datum[2].isEmpty() && !datum[2].isBlank()) {
                ownerId = Integer.parseInt(datum[2]);
            }

            if(
                !datum[7].isEmpty() && !datum[7].isBlank() &&
                !datum[8].isEmpty() && !datum[9].isEmpty()
            ) {
                housePrice = Float.parseFloat(datum[7]);
                houseImage = datum[8];
                houseType = HouseType.fromString(datum[9]);
            }

            //Check if the block is already in the list.
            Block block = blocks.stream().filter(b -> b.getBlockID() == blockId).findFirst().orElse(new Block(blockId));
            if(!blocks.contains(block)) blocks.add(block);
            Lot lot = new Lot(lotId, lotSize, lotType);
            lot.setOwner(UserStore.getInstance().getUser(ownerId));
            lot.setPrice(lotPrice);
            lot.setImageURL(lotImage);
            if(houseType != null && housePrice >= 0) {
                House house = new House(houseType);
                house.setFixedPrice(housePrice);
                house.setImage(houseImage);
                lot.setHouse(house);
            }
            block.getLots().add(lot);
        }

        RealEstateStore.getInstance().setBlock(blocks);
    }

    protected void writeData() {
        List<Block> blocks = RealEstateStore.getInstance().getBlock();
        List<String[]> data = new ArrayList<>();

        for(Block block : blocks) {
            String[] datum = new String[columns.length];

            if(block.getLots().isEmpty()) {
                datum[0] = String.valueOf(block.getBlockID());
                data.add(datum);
                continue;
            }

            for (Lot lot: block.getLots()) {
                datum[0] = String.valueOf(block.getBlockID());
                datum[1] = String.valueOf(lot.getLotID());
                datum[3] = lot.getLotType() != null ? lot.getLotType().toString() : " ";
                datum[4] = String.valueOf(lot.getPrice());
                datum[5] = String.valueOf(lot.getSize());
                datum[6] = lot.getImageURL();
                datum[10] = lot.getStatus().toString();

                if(lot.getOwner() != null) {
                    datum[2] = String.valueOf(lot.getOwner().getID());
                }
                else {
                    datum[2] = " ";
                }

                if(lot.getHouse() != null) {
                    datum[7] = String.valueOf(lot.getHouse().getFixedPrice());
                    datum[8] = lot.getHouse().getImageURL();
                    datum[9] = lot.getHouse().getHouseType().toString();
                }
                else {
                    datum[7] = " ";
                    datum[8] = " ";
                    datum[9] = " ";
                }

                data.add(datum);
            }

        }


        try(FileWriter writer = new FileWriter(database)) {
            writer.append(String.join(",", columns)).append("\n");
            for(String[] datum : data) {
                writer.append(String.join(",", datum)).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error cannot write data to " + database.getPath());
            e.printStackTrace();
        }
    }
}
