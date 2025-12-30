package org.joseph.Store;

import org.joseph.Model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceStore {
    private static volatile InvoiceStore Instance;
    private List<Invoice> invoiceStore = new ArrayList<>();

    private InvoiceStore() {}

    public static InvoiceStore getInstance() {
        if(Instance == null) {
            synchronized (InvoiceStore.class) {
                if(Instance == null) {
                    Instance = new InvoiceStore();
                }
            }
        }
        return Instance;
    }

    public void setInvoices(List<Invoice> invoiceStore) { this.invoiceStore = invoiceStore; }
    public List<Invoice> getInvoice() { return invoiceStore; }
    public Invoice getInvoice(int id) { return invoiceStore.stream().filter(i -> i.getId() == id).findFirst().orElse(null);}
    public void deleteInvoice(int id) { invoiceStore.removeIf(i -> i.getId() == id); }
    public void updateInvoice(Invoice invoice) {
        Invoice updateInvoice = invoiceStore.stream().filter(i -> i.getId() == invoice.getId()).findFirst().orElse(null);
        if(updateInvoice == null) return;
        invoiceStore.replaceAll(i -> i.getId() != invoice.getId() ? i : invoice );
    }

}
