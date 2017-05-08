package com.jmr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.t_student;
import com.jmr.service.It_studentService;

@Controller
@RequestMapping("")
public class studentUpdateConrtoller {
	
	@Autowired
	It_studentService st;
	
	@RequestMapping(value="student-update",method=RequestMethod.GET)
    public ModelAndView studentAdd(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		mav.addObject("id",id);
		
        // 放入jsp路径
        mav.setViewName("student-update");
        return mav;
	}
	
	@RequestMapping(value="student-update/submit",method=RequestMethod.GET)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response){
		String studentid = request.getParameter("studentid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String nation = request.getParameter("nation");
		String education = request.getParameter("education");
		String insuredstate = request.getParameter("insuredstate");
		st.updateOne(studentid, name, gender, birthday, telephone, email, address, nation, education, insuredstate);
		return "{\"success\":true}";
	}
}
