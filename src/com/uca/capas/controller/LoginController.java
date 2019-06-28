package com.uca.capas.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.dto.UsuarioDTO;
import com.uca.capas.service.DepartamentoService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.PaisService;
import com.uca.capas.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PaisService paisService;
	

	@Autowired
	DepartamentoService departamentoService;
	
	@Autowired
	MunicipioService munService;
	
	@RequestMapping("/user")
	public ModelAndView initMain(HttpServletRequest session) {
		ModelAndView mav = new ModelAndView();
		if(!session.getSession().isNew()){
			mav.setViewName("main");
		}else {
			mav.setViewName("login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/userlogin",method = RequestMethod.POST)
	@ResponseBody
	public String main(@RequestParam(name = "username") String user, @RequestParam(name = "password") String pass,
			HttpServletResponse response, HttpSession session){
		Usuario usuario = usuarioService.findUsuarioyContraseña(user, pass);
		
		if(usuario == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);//404
			return "not found";
		} else if(usuario.getInicio_sesion() == true) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);//409
			return "usuario ya activo";
		} else if(usuario.getEstado_usuario() == false) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);//403
			return usuario.getDescripcion_usuario()+"";
		} else if(usuario.getTipo_usuario() == true) {
			session.setAttribute("admin", usuario);
			usuarioService.user_sesion(true, user, pass);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);//202
			return "admin ok";
		} else {
			session.setAttribute("user", usuario);
			usuarioService.user_sesion(true, user, pass);
			response.setStatus(HttpServletResponse.SC_OK);//200
			return "usuario ok";
		}

	}
	
	@RequestMapping("/logoutAdmin")
	public ModelAndView logoutAdmin(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		Usuario usuario = (Usuario) session.getAttribute("admin");
		usuarioService.user_sesion(false, usuario.getNomusuario(), usuario.getPasword());
		session.removeAttribute("admin");
		return mav;
	}
	
	@RequestMapping("/logoutUser")
	public ModelAndView logoutUser(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		Usuario usuario = (Usuario) session.getAttribute("user");
		usuarioService.user_sesion(false, usuario.getNomusuario(), usuario.getPasword());
		session.removeAttribute("user");
		return mav;
	}
	
	
	//================agregue desde aqui=================================
	@RequestMapping(value="/registrar")
	public ModelAndView registrar() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario",new UsuarioDTO());
		mav.addObject("paises", paisService.findAll());
		mav.addObject("departamentos", departamentoService.findAll());
		mav.addObject("municipios", munService.findAll());
		mav.setViewName("user/registrar");
		return mav;
	}
	
	@RequestMapping(value="/user/add", method = RequestMethod.POST)
	public ModelAndView registrarN(@Valid @ModelAttribute("usuario") UsuarioDTO u,BindingResult result) throws ParseException{
		ModelAndView mav = new ModelAndView("redirect:/");
		if(result.hasErrors()) {
			mav.addObject("paises", paisService.findAll());
			mav.addObject("departamentos", departamentoService.findAll());
			mav.addObject("municipios", munService.findAll());
	    	mav.setViewName("user/registrar");
	       }	
		else {
			
			usuarioService.agregar(u);
			
		}
		return mav;
	}
	
	@RequestMapping("/volverA")
	public ModelAndView volverA() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
}
