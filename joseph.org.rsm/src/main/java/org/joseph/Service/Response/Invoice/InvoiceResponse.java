package org.joseph.Service.Response.Invoice;

import org.joseph.Model.Invoice;
import org.joseph.Service.Response.Response;

public class InvoiceResponse implements Response {
    private final Invoice invoice;

    public InvoiceResponse(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
