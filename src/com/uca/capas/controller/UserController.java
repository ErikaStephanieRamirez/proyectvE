package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.service.UsuarioService;

@Controller
public class UserController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/user/main")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
}
