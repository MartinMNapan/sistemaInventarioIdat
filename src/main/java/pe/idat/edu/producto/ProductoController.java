package pe.idat.edu.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.idat.edu.categoria.Categoria;
import pe.idat.edu.categoria.CategoriaRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired
	private CategoriaRepository repository2;
	
	@GetMapping("/productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(Model modelo) {
		List<Categoria> listaCategorias = repository2.findAll();
			
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "producto_formulario";
	}
	
	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto) {
		repository.save(producto);
		return "redirect:/";
	}
	
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto> listaProductos = repository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);
		return "productos";
	}
	
	
	
	
	
	

}
