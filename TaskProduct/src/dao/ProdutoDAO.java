package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

import java.sql.ResultSet;

public class ProdutoDAO {
	
	private Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Produto produto) {
			
		String inserir = "INSERT INTO produto "
				+ " (codigo, nome, descricao, valor, estoque) "
				+ " VALUES (?, ?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNomeProduto());
			pst.setString(3, produto.getDescricaoProduto());
			pst.setDouble(4, produto.getValorProduto());
			pst.setInt(5, produto.getEstoqueProduto());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Produto produto) {
		
		String alterar = "UPDATE produto "
				+ "SET nome = ?, descricao = ?, valor = ?, estoque = ? "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getDescricaoProduto());
			pst.setDouble(3, produto.getValorProduto());
			pst.setInt(4, produto.getEstoqueProduto());
			pst.setInt(5, produto.getCodigo());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Produto produto) {
		
		String excluir = "DELETE FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, produto.getCodigo());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
		}
	}
	
	public Produto buscar(int codigo) {
		
		String consultar = "SELECT * FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, codigo);
			ResultSet resultado = pst.executeQuery();
			
			Produto p = new Produto();
			if (resultado.next()) {
				p.setCodigo(codigo);
				p.setDescricaoProduto(resultado.getString("descricao"));
				p.setNomeProduto(resultado.getString("nome"));
				p.setValorProduto(resultado.getDouble("valor"));
				p.setEstoqueProduto(resultado.getInt("estoque"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Produto> listarProdutos() {
		
		String consultar = "SELECT * FROM produto";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Produto> lista = new ArrayList<>();
			while (resultado.next()) {
				Produto p = new Produto();
				p.setCodigo(resultado.getInt("codigo"));
				p.setDescricaoProduto(resultado.getString("descricao"));
				p.setNomeProduto(resultado.getString("nome"));
				p.setValorProduto(resultado.getDouble("valor"));
				p.setEstoqueProduto(resultado.getInt("estoque"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
