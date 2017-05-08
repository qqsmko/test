package com.jmr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class welcomeController {

	@RequestMapping("welcome")
    public ModelAndView welcome(){
		ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("welcome");
        return mav;
	}
}
