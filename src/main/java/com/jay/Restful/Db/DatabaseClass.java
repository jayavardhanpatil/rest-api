package com.jay.Restful.Db;

import java.util.HashMap;
import java.util.Map;

import com.jay.Restful.Rest.model.Message;
import com.jay.Restful.Rest.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessage(){
		return messages;
	}
	
	public static Map<String, Profile> getprofiles(){
		return profiles;
	}
}
