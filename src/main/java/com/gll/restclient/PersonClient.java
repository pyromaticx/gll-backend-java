package com.gll.restclient;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;

import com.gll.bean.Person;
 
 
public class PersonClient {
 
    public static final String REST_SERVICE_URI = "http://hrboost.herokuapp.com/";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllPerson(){
        System.out.println("Testing listAll Person API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> personMap = restTemplate.getForObject(REST_SERVICE_URI+"/person.json/", List.class);
         
        if(personMap!=null){
            for(LinkedHashMap<String, Object> map : personMap){
                System.out.println("Person : id="+map.get("personId")+", Name="+map.get("personName")+", Email="+map.get("email")+", BirthDay="+map.get("birthDay"));;
            }
        }else{
            System.out.println("No Person exist----------");
        }
    }
     
    /* GET */
    private static void getPerson(){
        System.out.println("Testing getPerson API----------");
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(REST_SERVICE_URI+"/person.json", Person.class);
        System.out.println(person);
    }
     
    /* POST */
    private static void createPerson() {
        System.out.println("Testing create Person API----------");
        RestTemplate restTemplate = new RestTemplate();
     
        Person person = new Person();
        person.setPersonName("Lipi Sharma");
        person.setEmail("lipi@gmail.com");
        person.setBirthDay(new java.util.Date("2003/02/08"));
      
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/createPerson/", person, Person.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updatePerson() {
        System.out.println("Testing update Person API----------");
        RestTemplate restTemplate = new RestTemplate();
        
        Person person = new Person();
        person.setPersonId(2);
        person.setPersonName("Atul");
        person.setEmail("atul@gmail.com");
        person.setBirthDay(new java.util.Date("1964/02/08"));
        
        restTemplate.put(REST_SERVICE_URI+"/person/2", person);
        System.out.println(person);
    }
 
    /* DELETE */
    private static void deletePerson() {
        System.out.println("Testing delete Person API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/person/1");
    }
 
 
    /* DELETE */
    private static void deleteAllPerson() {
        System.out.println("Testing all delete Person API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/person/");
    }
 
    public static void main(String args[]){
    	/*listAllPerson();
        getPerson();*/
        createPerson();
        /*listAllPerson();
        updatePerson();
        listAllPerson();
        deletePerson();
        listAllPerson();
        deleteAllPerson();
        listAllPerson();*/
    }
}