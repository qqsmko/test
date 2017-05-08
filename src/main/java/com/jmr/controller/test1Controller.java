package com.jmr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jmr.model.t_student;

@Controller
@RequestMapping("")
public class test1Controller {

	@RequestMapping("test1")
    public ModelAndView test1(){
		ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("test1");
        return mav;
	}
}
