package Server.Port;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.Response;

import Server.DB.Bean.Groups;
import Server.DB.Bean.GroupsList;
import Server.DB.Bean.User;

@Path("/Groups")
@Consumes("application/json")
@Produces("application/json")
public interface GroupPort {
	
	@POST
	@Path("/group")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response CreateGroup(Groups group);
	
	@PUT
	@Path("/group")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response ModifyGroup(Groups group);
	
	
	@DELETE
	@Path("/group/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response deleteGroup(@PathParam("id")int group_id);
	
	@GET
	@Path("/getGroupByGroupId/{group_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Groups getGroup(@PathParam("group_id") int group_id);
	
	@GET
	@Path("/getGroupByUserID/{user_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public GroupsList getGroupList(@PathParam("user_id") int user_id);
}
