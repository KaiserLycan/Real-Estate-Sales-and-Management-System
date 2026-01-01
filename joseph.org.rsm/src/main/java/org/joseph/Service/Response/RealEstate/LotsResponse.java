package org.joseph.Service.Response.RealEstate;

import org.joseph.Model.Lot;
import org.joseph.Service.Response.Response;

import java.util.List;

public class LotsResponse implements Response {
    private final List<Lot> lots;

    public LotsResponse(List<Lot> lots) {
        this.lots = lots;
    }

    public List<Lot> getLots() {
        return lots;
    }
}
