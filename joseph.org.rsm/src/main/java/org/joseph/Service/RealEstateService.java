package org.joseph.Service;
import org.joseph.Model.Lot;
import org.joseph.Service.Request.RealEstate.BlockRequest;
import org.joseph.Service.Request.RealEstate.LotRequest;
import org.joseph.Service.Request.Request;
import org.joseph.Service.Response.RealEstate.RealEstateResponseFactory;
import org.joseph.Service.Response.Response;
import org.joseph.Store.RealEstateStore;

import java.util.ArrayList;
import java.util.List;

public class RealEstateService implements IAppService<Request, Response>{

    @Override
    public void add(Request createObject) {
        if(createObject instanceof BlockRequest) {
            try {
                BlockRequest request = (BlockRequest) createObject;
                RealEstateStore.getInstance().addBlock(request.getBlock());
                System.out.println("Block added successfully");
            }
            catch (Exception exception) {
                System.out.println("Error in adding real estate service");
                exception.printStackTrace();
            }
        }
        else if(createObject instanceof LotRequest) {
            try {
                LotRequest request = (LotRequest) createObject;
                RealEstateStore.getInstance().addLot(request.getBlock(), request.getLot());
                System.out.println("Lot added successfully.");
            }
            catch (Exception exception) {
                System.out.println("Error in adding real estate service");
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void update(Request updateObject) {
        if(!(updateObject instanceof LotRequest)) return;
        try {
            LotRequest request = (LotRequest) updateObject;
            RealEstateStore.getInstance().updateLot(request.getBlock(), request.getLot());
            System.out.println("Lot updated successfully");
        }
        catch (Exception exception) {
            System.out.println("Error in updating real estate service");
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Request deleteObject) {
        try {
            if(deleteObject instanceof BlockRequest) {
                BlockRequest request = (BlockRequest) deleteObject;
                RealEstateStore.getInstance().deleteBlock(request.getBlock());
            }
            else if(deleteObject instanceof LotRequest) {
                LotRequest request = (LotRequest) deleteObject;
                RealEstateStore.getInstance().deleteLot(request.getBlock(), request.getLot());
            }
        }
        catch (Exception exception) {
            System.out.println("Error in deleting Real Estate Service");
            exception.printStackTrace();
        }
    }

    @Override
    public Response get(Request getObject) {
        try {
            if(getObject instanceof BlockRequest){
                BlockRequest request = (BlockRequest) getObject;
                if(request.getBlock() == null) {
                    return RealEstateResponseFactory.makeBlocksResponse(RealEstateStore.getInstance().getBlock());
                }
                else {
                    return RealEstateResponseFactory.makeBlockResponse(RealEstateStore.getInstance().getBlock(request.getBlock().getBlockID()));
                }
            }
            else if(getObject instanceof LotRequest) {
                LotRequest request = (LotRequest) getObject;
                if(request.getBlock() == null && request.getLot() == null) {
                    List<Lot> lots = new ArrayList<>();
                    RealEstateStore.getInstance().getBlock().forEach(b -> {
                        lots.addAll(b.getLots());
                    });
                    return RealEstateResponseFactory.makeLotsResponse(lots);
                }
                else if(request.getLot() != null && request.getBlock() != null) {
                    return RealEstateResponseFactory.makeLotResponse(RealEstateStore.getInstance().getLot(request.getBlock().getBlockID(), request.getLot().getLotID()));
                }
                else {
                    throw new Exception("Incomplete Request. Please fill out all the fields or leave all fields empty to get all.");
                }
            }
            else {
                throw new Exception("Unknown Request");
            }

        }
        catch (Exception exception) {
            System.out.println("Error in getting real estate service");
            exception.printStackTrace();
            return null;
        }
    }
}
