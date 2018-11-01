package interoperability;

import business.Service;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/account")
public class AccountEndPoint {

    @Inject
    private Service service;

    @Path("/getAllAccounts")
    @GET
    @Produces({ "application/json" })
    public String getAccounts(){return service.getAllAccounts();}

    @Path("/createAccount")
    @POST
    @Produces({"application/json"})
    public String createAccount(String account){
        return service.createAccount(account);
    }

    @Path("/test")
    @POST
    @Produces({"application/json"})
    public String test(String str){
        return str + str;
    }


    @Path("/getAccountById/{accNum}")
    @GET
    @Produces({"application/json"})
    public String getAccountById(@PathParam("accNum") String accNum){
        return service.getAccountById(accNum);
    }

    @Path("/deleteAccount")
    @POST
    @Produces({"application/json"})
    public String deleteAccount(String accNum){
        return service.deleteAccount(accNum);
    }

    @Path("/updateAccount")
    @PUT
    @Produces({"application/json"})
    public String updateAccount(String account){
        return service.updateAccount(account);
    }

}
