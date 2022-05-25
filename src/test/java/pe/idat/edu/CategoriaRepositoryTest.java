package pe.idat.edu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import pe.idat.edu.categoria.Categoria;
import pe.idat.edu.categoria.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Test
	public void testCrearCategoria() {
		Categoria categoriaGuardar = repository.save(new Categoria("Electronicos"));
		assertThat(categoriaGuardar.getId()).isGreaterThan(0);
	}
	

}
