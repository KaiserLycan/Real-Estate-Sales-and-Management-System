package org.joseph.Service;

import org.joseph.Service.Request.Invoice.InvoiceRequest;
import org.joseph.Service.Request.Request;
import org.joseph.Service.Response.Invoice.InvoiceResponse;
import org.joseph.Service.Response.Invoice.InvoicesResponse;
import org.joseph.Service.Response.Response;
import org.joseph.Store.InvoiceStore;

import java.sql.SQLOutput;

public class InvoiceService implements IAppService<Request, Response> {
    @Override
    public void add(Request createObject) {
        if(!(createObject instanceof InvoiceRequest)) return;

        try {
            InvoiceStore.getInstance().addInvoice(((InvoiceRequest) createObject).getInvoice());
            System.out.println("Added invoice successfully.");
        }
        catch (Exception exception) {
            System.out.println("Error in adding invoice service.");
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Request updateObject) {
        if(!(updateObject instanceof InvoiceRequest)) return;

        try {
            InvoiceStore.getInstance().updateInvoice(((InvoiceRequest) updateObject).getInvoice());
            System.out.println("Updated invoice successfully.");
        }
        catch (Exception exception) {
            System.out.println("Error in updating invoice service.");
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Request deleteObject) {
        if(!(deleteObject instanceof InvoiceRequest)) return;

        try {
            InvoiceStore.getInstance().deleteInvoice(((InvoiceRequest) deleteObject).getInvoice().getId());
            System.out.println("Deleted invoice successfully.");
        }
        catch (Exception exception) {
            System.out.println("Error in deleting invoice service.");
            exception.printStackTrace();
        }
    }

    @Override
    public Response get(Request getObject) {
        if(!(getObject instanceof InvoiceRequest)) return null;
        InvoiceRequest request = (InvoiceRequest) getObject;

        try {
            if(request.getInvoice() != null) {
                return new InvoiceResponse(InvoiceStore.getInstance().getInvoice(request.getInvoice().getId()));
            }
            else if (request.getInvoice() == null) {
                return new InvoicesResponse(InvoiceStore.getInstance().getInvoice());
            }
            else {
                throw new Exception("Invalid user request");
            }
        }
        catch (Exception exception) {
            System.out.println("Error in getting invoice service.");
            exception.printStackTrace();
            return null;
        }
    }
}
