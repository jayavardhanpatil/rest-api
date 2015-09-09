package com.jay.Restful.Rest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jay.Restful.Db.DatabaseClass;
import com.jay.Restful.Rest.model.Profile;

public class ProfileService {

	private Map<String, Profile> Profiles = DatabaseClass.getprofiles();
	
	
	
	public ProfileService() {
		Profiles.put("Jayavardhan", new Profile(1L,"Jay","Jayavardhan","patil"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(Profiles.values());
	}

	public Profile getProfile(String profilename) {
		return Profiles.get(profilename);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(Profiles.size() + 1);
		Profiles.put(profile.getFirstname(), profile);
		return profile;
	}
	
	public Profile UpdateProfile(Profile profile){
		if (profile.getFirstname().isEmpty()){
			return null;
		}
		Profiles.put(profile.getFirstname(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profilename){
		return Profiles.remove(profilename);
	}

	
}
