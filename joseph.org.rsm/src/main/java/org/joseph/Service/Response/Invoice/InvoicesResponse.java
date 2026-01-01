package org.joseph.Service.Response.Invoice;

import org.joseph.Model.Invoice;
import org.joseph.Service.Response.Response;

import java.util.List;

public class InvoicesResponse implements Response {
    private final List<Invoice> invoices;

    public InvoicesResponse(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
