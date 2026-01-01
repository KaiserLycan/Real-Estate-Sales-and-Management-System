package org.joseph.Service.Response.RealEstate;

import org.joseph.Model.Lot;
import org.joseph.Service.Response.Response;

public class LotResponse implements Response {
    private final Lot lot;

    public LotResponse(Lot lot) {
        this.lot = lot;
    }

    public Lot getLot() {
        return lot;
    }
}
