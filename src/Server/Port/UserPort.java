package Server.Port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.Response;

import Server.DB.Bean.User;

@Path("/Users")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface UserPort {
	
	
	
	@PUT
	@Path("/user")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response modifiedUser(User user);
	
	@GET
	@Path("/user/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public User getUserInformation(@PathParam("id") int id);
}
