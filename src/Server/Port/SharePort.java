package Server.Port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.Response;

import Server.DB.Bean.Share;
import Server.DB.Bean.ShareList;
import Server.DB.Bean.User;

@Path("/Shares")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface SharePort {
	
	
	
	@POST
	@Path("/share")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response insertShare(Share share); 
	
	
	@GET
	@Path("/share/{user_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public ShareList getShare(@PathParam("user_id") int id);
	
}