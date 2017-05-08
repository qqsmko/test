package com.jmr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.jmr.service.It_studentService;

@Controller
@RequestMapping("")
public class studentAddConrtoller {
	
	@Autowired
	It_studentService st;
	
	
	@RequestMapping(value="student-add",method=RequestMethod.GET)
    public ModelAndView studentAdd(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
        // 放入jsp路径
        mav.setViewName("student-add");
        return mav;
	}
	
	@RequestMapping(value="student-add/submit",method=RequestMethod.GET)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String nation = request.getParameter("nation");
		String education = request.getParameter("education");
		String insuredstate = request.getParameter("insuredstate");
		st.insertOne(name,gender,birthday,telephone,email,address,nation,education,insuredstate);
		return "{\"success\":true}";
	}
}
