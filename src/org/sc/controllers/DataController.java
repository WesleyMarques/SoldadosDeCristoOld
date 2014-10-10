package org.sc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.lavieri.modelutil.cep.WebServiceCep;


public class DataController {

    

    public DataController() {
    }
    
    public static Map<String, String> getLogradouroInfo(String cep) throws IllegalArgumentException{
    	Map<String, String> info = new HashMap<String, String>();
    	if (!ConnectionController.isConnected()) {
    		throw new IllegalArgumentException("Sem conexão");    					
		}else{
			 WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
			 if (webServiceCep.wasSuccessful()) {
				 info.put("logradouro", webServiceCep.getLogradouroFull());
				 info.put("cidade", webServiceCep.getCidade());
				 info.put("bairro", webServiceCep.getBairro());
				 info.put("uf", webServiceCep.getUf());
				 info.put("pais", "Brasil");				 
			}
		}
    	return info;    	
    }
    
    public static int getNewRegistryCode(){
    	return 0;    	
    }
    
    public static String getWarName(String name){
    	return "";
    }
}
