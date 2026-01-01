package org.joseph.Service.Request.Invoice;

import org.joseph.Model.Invoice;
import org.joseph.Service.Request.Request;

public class InvoiceRequest implements Request {
    private final Invoice invoice;

    public InvoiceRequest(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
