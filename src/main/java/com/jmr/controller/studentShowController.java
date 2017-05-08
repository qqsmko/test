package com.jmr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.t_student;
import com.jmr.service.It_studentService;

@Controller
@RequestMapping("")
public class studentShowController {

	String tempId;
	
	@Autowired
	It_studentService st;
	
	@RequestMapping("student-show")
    public ModelAndView studentShow(HttpServletRequest request,HttpServletResponse response){
		tempId = request.getParameter("id");
		ModelAndView mav = new ModelAndView();

		try {
		    int b = Integer.valueOf(tempId).intValue();
		    t_student s = st.getOne(b);
			mav.addObject("s", s);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
        // 放入jsp路径
        mav.setViewName("student-show");
        return mav;
	}
}
