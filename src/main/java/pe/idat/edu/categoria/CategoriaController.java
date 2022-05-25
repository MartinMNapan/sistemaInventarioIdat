package pe.idat.edu.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo) {
		List<Categoria> listarCategorias = repository.findAll();
		modelo.addAttribute("listarCategorias", listarCategorias);
		return "categorias";
	}
	
	@GetMapping("/categorias/nuevo")
	public String mostrarFormularioDeNuevaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());
		return "categoria_formulario";
	}
	
	@PostMapping("/categorias/guardar")
	public String guardarCategoria(Categoria categoria) {
		repository.save(categoria);
		return "redirect:/categorias";
	}

}
