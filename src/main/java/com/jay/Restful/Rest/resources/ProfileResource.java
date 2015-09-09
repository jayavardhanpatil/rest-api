package com.jay.Restful.Rest.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.jay.Restful.Rest.Service.ProfileService;
import com.jay.Restful.Rest.model.Profile;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileservice = new ProfileService();
	
	@GET
	public List<Profile> getprofile(){
		return profileservice.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileservice.addProfile(profile);
		
	}
	
	@PUT
	@Path("/{profilename}")
	public Profile UpdateProfile(@PathParam("profilename") String profilename,Profile profile){
		profile.setFirstname(profilename);
	   return profileservice.UpdateProfile(profile);
	}
	
	@DELETE
	@Path("/{profilename}")
	public void DeleteProfile(@PathParam("profilename") String profilename){
		profileservice.removeProfile(profilename);
	}
	
	@GET
	@Path("/{profilename}")
	public Profile getMessage(@PathParam("profilename") String profilename){
		return profileservice.getProfile(profilename);
	}
	
}
