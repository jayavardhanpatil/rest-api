package com.jay.Restful.Rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injection")
//@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class injectDemoResource {
	
	@GET
	@Path("annotation")
	public String getParamusingAnnotation(@MatrixParam("param") String matrixparam,
										  @HeaderParam("authSessionID") String header,
										  @CookieParam("name") String cookie){
		return "Metrix param = "+ matrixparam + " header Param : "+ header +" Cookie is  "+cookie;
	}
	
	@GET
	@Path("context")
	public String getParamContext(@Context UriInfo uriinfo,@Context HttpHeaders headers){
		String path = uriinfo.getAbsolutePath().toString();
		String coockies = headers.getCookies().toString();
		return "test :: "+ path +" and cookies are"+ coockies;
	}
	
}
