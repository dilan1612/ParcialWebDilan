package edu.uptc.parcialwebdilan.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String menssage, HttpStatus status, Object responseObject){
        Map<String, Object> map = new HashMap<>();
        map.put("menssage",menssage);
        map.put("status",status);
        map.put("data",responseObject);

        return new ResponseEntity<Object>(map,status);
    }
}
