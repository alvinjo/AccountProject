package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import persistence.domain.Account;

import javax.enterprise.inject.Default;
import java.io.IOException;
import java.util.Map;


public class AccountToJSON {

    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, Account> accountMap;

    public AccountToJSON(){

    }

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

    public <T> T jsonToObj(String json, Class<T> aClass){

        try {
            return mapper.readValue(json, aClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
