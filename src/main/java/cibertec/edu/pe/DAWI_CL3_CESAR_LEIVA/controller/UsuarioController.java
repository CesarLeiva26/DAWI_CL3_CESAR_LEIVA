package cibertec.edu.pe.DAWI_CL3_CESAR_LEIVA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.DAWI_CL3_CESAR_LEIVA.model.bd.Usuario;
import cibertec.edu.pe.DAWI_CL3_CESAR_LEIVA.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/loginusuario")
	public String loginusuario() {
		return "usuario/loginusuario";
	}
	@GetMapping("/registrarusuario")
	public String registrarusuario() {
		return "usuario/registrarusuario";
	}
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(
			@ModelAttribute Usuario usuario,
			Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("registroCorrecto",
				true);
		return "usuario/registrarusuario";
	}
}