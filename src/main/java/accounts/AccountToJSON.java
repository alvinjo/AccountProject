package accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class AccountToJSON {

    ObjectMapper mapper = new ObjectMapper();
    static Map<String,Account> accountMap;

    public AccountToJSON(Map<String,Account> map){
        this.accountMap = map;
    }
    

    public String toJSON(){
        String jsonObj="";
        try {
            jsonObj = mapper.writeValueAsString(accountMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
