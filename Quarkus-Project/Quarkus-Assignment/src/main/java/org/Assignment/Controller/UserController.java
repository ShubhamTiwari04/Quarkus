package org.Assignment.Controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.Assignment.Entity.User;
import org.Assignment.Service.UserService;

import java.util.List;

@ApplicationScoped
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    //http://localhost:8082/q/swagger-ui/

    @Inject
    UserService service;

    //http://localhost:8082/user
    @GET
    public Response getAllData(){
        List<User> users = service.fetchAllData();
        return Response.ok(users).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RegisterUser(User user){
        service.saveData(user);
        return Response.ok("User Registered Successfully").build();
    }
//http:/localhost:8082/user/1
    @DELETE
    @Path("/{id}")
    public Response DeleteUser(@PathParam("id") Long id){
        service.deleteUser(id);
        return Response.ok("User Deleted Successfully").build();
    }

    //http:/localhost:8082/user/2
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UpdateUser(@PathParam("id") Long id, User user){
        User updatedUser = service.updateUserDetails(id, user);
        if (updatedUser != null) {
            return Response.ok("User Updated Successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("User Not Found").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response fetchUserbyId(@PathParam("id") Long id){
        User userById = service.findUserById(id);
        return Response.ok(userById).build();
    }


}
