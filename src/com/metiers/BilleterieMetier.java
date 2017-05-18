package com.metiers;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/billet")
@Produces("application/xml")
public class BilleterieMetier {
	public BilleterieMetier(){
		
	}
	
	@GET
    public Response getTrains() {
        System.out.println("getBillets");

        return Response
          .status(Status.OK)
          .entity(BookTrainBD.getTrains())
          .build();
    }

}
