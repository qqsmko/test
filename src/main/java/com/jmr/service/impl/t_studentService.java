package com.jmr.service.impl;

import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmr.IDao.t_studentMapper;
import com.jmr.model.t_student;
import com.jmr.service.It_studentService;;

@Service
public class t_studentService implements It_studentService {
	@Autowired
    t_studentMapper t;
	
    public List<t_student> list(){
        return t.selectAll();
    };
	
    public t_student getOne(int num){
    	return t.selectByPrimaryKey(num);
    }
    
    public void setOnesState(int num){
    	t_student temp;
    	temp = t.selectByPrimaryKey(num);
    	int statex = temp.getState();
    	if(statex==1) statex=2;
    	else statex = 1;
    	temp.setState(statex);
    	t.updateByPrimaryKey(temp);
    }
    
    public void deleteOne(int num){
    	t.deleteByPrimaryKey(num);
    }
    
    public void updateOne(String studentid,String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate){
    	
    	t_student temp = new t_student();
    	Integer id = Integer.parseInt(studentid);
    	temp.setStudentid(id);
    	if(name==""){
    		temp.setName(null);
    	}else{
    		temp.setName(name);
    	}
    	if(gender==""){
    		temp.setGender(null);
    	}else{
    		short genderb = Short.parseShort(gender);
    	temp.setGender(genderb);
	    	try{
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    		Date birthdayb = sdf.parse(birthday);
	    		temp.setBirthday(birthdayb);
	    	}catch(ParseException e){
	    		temp.setBirthday(null);
	    		System.out.println(e.getMessage());
	    	}
    	}
    	if(telephone==""){
    		temp.setTelephone(null);
    	}else{
    		temp.setTelephone(telephone);
    	}
    	if(email==""){
    		temp.setEmail(null);
    	}else{
    		temp.setEmail(email);
    	}
    	if(address==""){
    		temp.setAddress(null);
    	}else{
    		temp.setAddress(address);
    	}
    	if(nation==""){
    		temp.setNation(null);
    	}else{
    		temp.setNation(nation);
    	}
    	if(education==""){
    		temp.setEducation(null);
    	}else{
    		Integer educationb = Integer.parseInt(education);
    		temp.setEducation(educationb);
    	}
    	if(insuredstate==""){
    		temp.setInsuredstate(null);
    	}else{
    		Integer insuredstateb = Integer.parseInt(insuredstate);
    		temp.setInsuredstate(insuredstateb);
    	}
    	temp.setState(null);
    	t.updateByPrimaryKeySelective(temp);
    }
    
    public void insertOne(String name,String gender,String birthday,String telephone,String email,String address,String nation,String education,String insuredstate){
    	
    	t_student temp = new t_student();
    	
    	temp.setStudentid(null);
    	temp.setName(name);
    	short genderb = Short.parseShort(gender);
    	temp.setGender(genderb);
    	try{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Date birthdayb = sdf.parse(birthday);
    		temp.setBirthday(birthdayb);
    	}catch(ParseException e){
    		temp.setBirthday(null);
    		System.out.println(e.getMessage());
    	}
    	temp.setTelephone(telephone);
    	temp.setEmail(email);
    	temp.setAddress(address);
    	temp.setNation(nation);
    	Integer educationb = Integer.parseInt(education);
    	temp.setEducation(educationb);
    	Integer insuredstateb = Integer.parseInt(insuredstate);
    	temp.setInsuredstate(insuredstateb);
    	temp.setState(1);
    	t.insertSelective(temp);
    }
}
