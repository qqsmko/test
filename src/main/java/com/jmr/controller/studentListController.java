package com.jmr.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmr.model.t_student;
import com.jmr.service.It_studentService;

@Controller
@RequestMapping("")
public class studentListController {
	
	@Autowired
	It_studentService st;
	
	String s;
	
	@RequestMapping(value="student-list",method=RequestMethod.GET)
    public ModelAndView studentList(){
		ModelAndView mav = new ModelAndView();
		List<t_student> sl = st.list();
		
        // 放入转发参数
        mav.addObject("sl", sl);
		
        // 放入jsp路径
        mav.setViewName("student-list");
        return mav;
	}
	
	@RequestMapping(value="student-list",method=RequestMethod.POST)
	@ResponseBody
	public String doPost(HttpServletRequest request, HttpServletResponse response){
		s = request.getParameter("id");
		try {
		    int b = Integer.valueOf(s).intValue();
		    st.setOnesState(b);
		    return "{\"success\":true}";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="student-list/delete",method=RequestMethod.POST)
	@ResponseBody
	public String doDelete(HttpServletRequest request, HttpServletResponse response){
		s = request.getParameter("id");
		try {
		    int b = Integer.valueOf(s).intValue();
		    st.deleteOne(b);
		    return "{\"success\":true}";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="student-list/deleteall",method=RequestMethod.POST)
	@ResponseBody
	public String doDeleteAll( @RequestParam (value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    st.deleteOne(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"success\":false}";
			}
		}
		return "{\"success\":true}";
	}
}
