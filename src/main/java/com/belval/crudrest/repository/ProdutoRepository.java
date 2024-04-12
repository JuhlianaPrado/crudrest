package com.belval.crudrest.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.belval.crudrest.model.Produto;

//Criar uma classe ProdutoRepository
//Atributos:
//	listaProdutos do tipo List<Produto> :
//		Copie a classe Produto do projeto principal
//	proxId do tipo int : 
//		deve armazenar o proximo ID utlizado no processo de criação de 
//		novo produto
//Métodos:
//	findById:
//		Criar método público findById que retorna o tipo Produto e recebe como parâmetro
//		um Integer id. 
//		Esse método deve retornar o Produto presente em listaProduto cujo o atributo id é
//		igual ao parâmetro passado.
//	removeById:
//		Criar método público removeById que remove o primeiro objeto Produto e 
//		cujo o valor do atributo id é igual ao valor recebido como parâmetro
public class ProdutoRepository {

	private List<Produto> listaProdutos;
	private int proxId;
	
	public ProdutoRepository() {
		this.listaProdutos = new ArrayList<>();
		this.proxId = 1;
	}
	
	public List<Produto> findAll() {
		return new ArrayList<>(listaProdutos);
	}
	
	
//	findById:
//	Criar método público findById que retorna o tipo Produto e recebe como parâmetro
//	um Integer id. 
//	Esse método deve retornar o Produto presente em listaProduto cujo o atributo id é
//	igual ao parâmetro passado.

	public Produto findById(Integer id) {
		for(Produto p : listaProdutos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
//	removeById:
//	Criar método público removeById que remove o primeiro objeto Produto e 
//	cujo o valor do atributo id é igual ao valor recebido como parâmetro
	
	public void removeById(Integer id) {
		Iterator<Produto> it = listaProdutos.iterator();
		while(it.hasNext()) {
			Produto p = it.next();
			if (p.getId().equals(id)) {
				it.remove();
				return;
			}
		}
	}

	public void add(Produto produto) {
		produto.setId(proxId++);
		this.listaProdutos.add(produto);
	}


	
	
	
	
	
	
	
	
}
