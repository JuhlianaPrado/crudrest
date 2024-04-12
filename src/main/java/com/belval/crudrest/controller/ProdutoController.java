package com.belval.crudrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.belval.crudrest.model.Produto;
import com.belval.crudrest.repository.ProdutoRepository;

@RestController
public class ProdutoController {

//	private static List<Produto> listaProdutos = new ArrayList<>();
//	private static Integer proxId = 1;
	
	private static ProdutoRepository repository = 
			new ProdutoRepository();
	

	static {
//		Produto prod = new Produto(1, "Pão", "Pão Francês", 0.5);
//		listaProdutos.add(prod);
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> obterProdutos() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}

	//curl POST http://localhost:8080/produtos -H "Content-Type: application/json; Charset=utf-8" -d @produto-mortadela.json
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
		
		repository.add(produto);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(produto);
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Object> buscarProdutoPorId(@PathVariable Integer id) {
		
		Produto produto = repository.findById(id);
		
		if(produto == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Produto não encontrado.");
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(produto);
	}
	

	
	
}
