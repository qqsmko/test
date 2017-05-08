package com.jmr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.t_student;
import com.jmr.service.It_studentService;

@Controller
@RequestMapping("")
public class t_studentController {
	@Autowired
	It_studentService t;
	
	@RequestMapping("listStudent")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
        List<t_student> cc = t.list();
        
        // 放入转发参数
        mav.addObject("cs", cc);
        // 放入jsp路径
        mav.setViewName("listStudent");
        return mav;
    }
}
