package com.jay.Restful.Rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
	@GET
	public String test(){
		return "Sub resource";
	}

	@GET
	@Path("/{commentId}")
	public String GetcommentforId(@PathParam("commentId") long Commentid,
								  @PathParam("messageId") long MessageID){
		return "this is comments for id "+ Commentid+ ", And MessageID is "+MessageID;
	}
}
