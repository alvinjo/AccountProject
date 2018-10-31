package interoperability;

import business.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/account")
public class AccountEndPoint {

    @Inject
    private Service service;

    @Path("/getAccounts")
    @GET
    @Produces({ "application/json" })
    public String getAccounts(){return service.getAllAccounts();}

}
