package com.example.apiproject.ApiPackage;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class User {
    public String _id;
    public String id;
    public String name;
    public String email;
    public String phone;
    public List<String> organisationId;
}
