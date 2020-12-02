package com.bionime.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService {
	
	public Map<String, Object> addUser(MultipartFile file) throws Exception;

}
