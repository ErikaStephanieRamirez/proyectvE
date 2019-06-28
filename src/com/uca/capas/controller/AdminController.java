package com.uca.capas.controller;

import javax.servlet.http.HttpServletResponse;
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

import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Usuario;
import com.uca.capas.dto.EditarPeliculaDTO;
import com.uca.capas.service.PeliculaService;
import com.uca.capas.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PeliculaService peliculaservice;
	
	@RequestMapping("/admin/main")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/main");
		return mav;
	}
	
	@RequestMapping("/admin/usuario")
	public ModelAndView usuario_admin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuarios", usuarioService.findUsers());
		mav.setViewName("admin/usuario");
		return mav;
	}
	
	@RequestMapping(value = "/admin/user/status",method = RequestMethod.POST)
	@ResponseBody
	public String obtener_estado(@RequestParam(name = "userId") Integer id, 
			HttpServletResponse response){
		String res = null;
		Usuario user = usuarioService.getById(id);
		if(user.getEstado_usuario() == true) {
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "activo";
		} else if(user.getEstado_usuario() == false) {
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "inactivo";
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);//400
			res = "error";
		}
		return res;
	}
	
	@RequestMapping(value = "/admin/user/status/inactive",method = RequestMethod.POST)
	@ResponseBody
	public String cambiar_inactivo(@RequestParam(name = "userId") Integer id, 
			@RequestParam(name = "message") String msg,
			HttpServletResponse response){
		String res = null;
		Usuario user = usuarioService.getById(id);
		if(user == null) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);//502
			res = "fallo_descativar";
		} else {
			usuarioService.inactivarUsuario(id, msg+" ");
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "ok";
		}
		return res;
	}
	
	@RequestMapping(value = "/admin/user/status/active",method = RequestMethod.POST)
	@ResponseBody
	public String cambiar_activo(@RequestParam(name = "userId") Integer id, 
			HttpServletResponse response){
		String res = null;
		Usuario user = usuarioService.getById(id);
		if(user == null) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);//502
			res = "fallo_activar";
		} else {
			usuarioService.activarUsuario(id);
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "ok";
		}
		return res;
	}
	
	@RequestMapping("/admin/pelicula")
	public ModelAndView pelicula_admin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("peliculas", peliculaservice.findAll());
		mav.setViewName("admin/pelicula");
		return mav;
	}
	
	@RequestMapping(value = "/admin/movie/status",method = RequestMethod.POST)
	@ResponseBody
	public String obtener_estado_pelicula(@RequestParam(name = "movieId") Integer id, 
			HttpServletResponse response){
		String res = null;
		Pelicula movie = peliculaservice.getById(id);
		if(movie.getEstado_pel() == true) {
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "activo";
		} else if(movie.getEstado_pel() == false) {
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "inactivo";
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);//400
			res = "error";
		}
		return res;
	}
	
	@RequestMapping(value = "/admin/movie/status/inactive",method = RequestMethod.POST)
	@ResponseBody
	public String cambiar_inactivo_pelicula(@RequestParam(name = "movieId") Integer id, 
			HttpServletResponse response){
		String res = null;
		Pelicula movie = peliculaservice.getById(id);
		if(movie == null) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);//502
			res = "fallo_desactivar";
		} else {
			peliculaservice.inactivarPelicula(id);
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "ok";
		}
		return res;
	}
	
	@RequestMapping(value = "/admin/movie/status/active",method = RequestMethod.POST)
	@ResponseBody
	public String cambiar_activo_pelicula(@RequestParam(name = "movieId") Integer id, 
			HttpServletResponse response){
		String res = null;
		Pelicula movie = peliculaservice.getById(id);
		if(movie == null) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);//502
			res = "fallo_activar";
		} else {
			peliculaservice.activarPelicula(id);
			response.setStatus(HttpServletResponse.SC_OK);//200
			res = "ok";
		}
		return res;
	}
	
	@RequestMapping(value = "/admin/movie/view", method = RequestMethod.POST)
	public ModelAndView pelicula_admin_view(@RequestParam(name = "movieId") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("peliculaDTO", peliculaservice.getPeliculaDTO(id));
		mav.setViewName("admin/peliculaEditar");
		return mav;
	}
	
	@RequestMapping(value = "/admin/movie/edit", method = RequestMethod.POST)
	public ModelAndView pelicula_admin_view(@Valid @ModelAttribute("peliculaDTO") EditarPeliculaDTO peliculaDTO, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("admin/peliculaEditar");
		}else {
			peliculaservice.actualizarPelicula(peliculaDTO);
			ModelAndView mav2 = new ModelAndView("redirect:/admin/pelicula");
			return mav2;
		}
		return mav;
	}
	
	@RequestMapping(value = "/admin/movie/new")
	public ModelAndView pelicula_admin_new() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("peliculaDTO", new EditarPeliculaDTO());
		mav.setViewName("admin/peliculaNueva");
		return mav;
	}
	
	@RequestMapping(value = "/admin/movie/add", method = RequestMethod.POST)
	public ModelAndView pelicula_admin_add(@Valid @ModelAttribute("peliculaDTO") EditarPeliculaDTO peliculaDTO, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("admin/peliculaNueva");
		}else {
			peliculaservice.agregarPelicula(peliculaDTO);
			ModelAndView mav2 = new ModelAndView("redirect:/admin/pelicula");
			return mav2;
		}
		return mav;
	}
	
}
