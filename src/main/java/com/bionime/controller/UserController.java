package com.bionime.controller;

import com.bionime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 上传excel页面
	 */
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}
	
	
	@RequestMapping("/import")
	@ResponseBody
	public String excelImport(@RequestParam(value="filename") MultipartFile file, HttpSession session){
		Map<String, Object> result1=new HashMap<>();
		int result = 0;
		try {
			result = userService.addUser(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result > 0){
			return "excel文件数据导入成功！";
		}else{
			return "excel数据导入失败！";
		}
		
	}
	

}
