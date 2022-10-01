package org.acme.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.User;

@Path("/user")
public class UserService {
    @GET
    @Path("/add/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public User addUser(@PathParam("name") String name){
        User u = new User();
        u.setName(name);
        u.persist();
        return u;
    }

    @GET
    @Path("/list/")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<User> listUser(){
        return User.listAll();
    }
}
