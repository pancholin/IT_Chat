package Server.Port;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Response;

import Server.DB.Bean.Friend;
import Server.DB.Bean.FriendGroupList;
import Server.DB.Bean.FriendList;
import Server.DB.Bean.User;


@Path("/Friends")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface FriendPort {
	  
	@POST
	@Path("/friend")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response addFriend( Friend friend);
	
	
	@GET
	@Path("/getFriendByUserId/{user_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public FriendList getFriendByUserId(@PathParam("user_id") int user_id);
	
	@DELETE
	@Path("/friend/{user_id}/{friend_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response deleteFriend(@PathParam("user_id") int user_id,@PathParam("friend_id") int friend_id);
	
	@PUT
	@Path("/friend")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response modifiedFriend(Friend friend);
	
	
	
}
