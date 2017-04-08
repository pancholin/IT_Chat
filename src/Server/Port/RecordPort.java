package Server.Port;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import Server.DB.Bean.RecordList;

@Path("/Records")
@Consumes({"application/xml","application/json"})
@Produces({"application/xml","application/json"})
public interface RecordPort {
	
	@GET
	@Path("/record/{sender_id}/{receivor_id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public RecordList getAllRecord(@PathParam("sender_id")int sender_id,@PathParam("receivor_id") int receivor_id);
	

}
