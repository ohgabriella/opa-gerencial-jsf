package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.ProdutoDao;
import model.Produto;

@ManagedBean
@ApplicationScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private ProdutoDao produtoDao= new ProdutoDao();
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String cadastrarUsuarioRedirect() {
		return "listar.xhtml";
	}
	
	public void salvarProduto() {
		if(produto.getId() == null) {
			produtoDao.salvar(produto);
			produto = null;
			System.out.println("produto salvo " + produto);
			
		}else {
			produtoDao.atualizar(produto);
		}
	}
	
	public void removerProduto(Long id) {
		System.out.println(id);
		produtoDao.remover(id);
	}
	
	public void atualizarProduto() {
		produtoDao.atualizar(produto);
		System.out.println("produto atualizado " + produto);
	}
	
	public Produto buscarProduto(Long id) {
		System.out.println(produtoDao.buscar(id));
		return produtoDao.buscar(id);
	}
	
	public List<Produto> listarProduto(){
		produtos = produtoDao.listar();
		return produtos;
	}
	

}
