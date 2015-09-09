package com.jay.Restful.Rest.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.jay.Restful.Rest.Service.MessageService;
import com.jay.Restful.Rest.model.Message;
import com.jay.Restful.Rest.resources.beans.BeanParamDemo;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getmessages(@BeanParam BeanParamDemo filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		} else {
			return messageService.getAllMessages();
		}
	}

	@POST
	public Response addMessages(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		Message newMessages = messageService.addmessage(message);
		String newId = String.valueOf(newMessages.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessages)
				.build();
		//return messageService.addmessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message UpdateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.UpdateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void DeleteMessage(@PathParam("messageId") long id) {
		messageService.removemessage(id);
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getmessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}

}
