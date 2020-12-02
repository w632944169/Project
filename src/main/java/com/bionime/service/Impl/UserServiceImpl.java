package com.bionime.service.Impl;

import com.bionime.dao.UserMapper;
import com.bionime.entity.User;
import com.bionime.service.UserService;
import com.bionime.transcation.MyException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> addUser(MultipartFile file) throws Exception{
//		Map<String, Object> result=new HashMap<>();
		List<User> userList = new ArrayList<>();
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println("suffix="+suffix);
		InputStream ins = file.getInputStream();
		Workbook wb = null;
		if(suffix.equals("xlsx")){
			wb = new XSSFWorkbook(ins);
		}else{
			wb = new HSSFWorkbook(ins);
		}
		Sheet sheet = wb.getSheetAt(0);
		if(null != sheet){
			for(int line = 2; line <= sheet.getLastRowNum();line++){
				User user = new User();
				Row row = sheet.getRow(line);
				if(null == row){
					continue;
				}
				if(1 != row.getCell(0).getCellType()){
					throw new MyException("单元格类型不是文本类型！");
				}
				String username = row.getCell(0).getStringCellValue();
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				String password = row.getCell(1).getStringCellValue();
				user.setUsername(username);
				user.setPassword(password);
				userList.add(user);
			}
			for(User userInfo:userList){
				String name = userInfo.getUsername();
				int count = userMapper.selectUser(name);
				if(0 == count){			
					result = userMapper.addUser(userInfo);
				}else{
					result = userMapper.updateUser(userInfo);
				}
			}
		}

		return result;
	}
	
	

}
