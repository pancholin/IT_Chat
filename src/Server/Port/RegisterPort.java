package Server.Port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.Response;

import Server.DB.Bean.User;

@Path("/Registers")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface RegisterPort {
	@POST
	@Path("/register")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response register(User user);


}
