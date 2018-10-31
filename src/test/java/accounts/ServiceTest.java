package accounts;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTest {


    @Test
    public void numOfAccountsWithNameTest(){

        Service accService = new Service();
        accService.addAndPutAccount("jon", "smovi", "123");
        accService.addAndPutAccount("jon", "bovi", "124");
        int actual = accService.numOfAccountsWithName("jon");

        Assert.assertEquals(2,actual);
    }



}