package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import persistence.domain.Account;

import java.util.Map;

public class AccountToJSON {

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Account> accountMap;

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

    public  String objToJson(Object obj){
        String jsonObj = "";

        try {
            jsonObj = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonObj;
    }

}
