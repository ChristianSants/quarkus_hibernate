package org.acme.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Message;
import org.acme.entity.User;

@Path("/message")
@Transactional
public class MessageService {
    @GET
    @Path("/add/{name}/{texto}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public User addMessage(@PathParam("name") String name, @PathParam("text") String text){
        // mensagem
        Message m = new Message();
        m.setText(text);
        m.persist();

        // usuario
        User user = User.find("name", name).firstResult();
        user.addMessage(m);

        return user;
    }

    @GET
    @Path("/list/")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUser(){
        return User.listAll();
    }
}
