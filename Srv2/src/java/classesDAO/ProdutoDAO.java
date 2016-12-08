package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import classesTO.Produto;
import util.Conexao;

public class ProdutoDAO
{
	Connection conn;

	public ProdutoDAO()
	{
		conn = new Conexao().Conectar();
	}

	public void salvar(Produto p)
	{
		try
		{
			PreparedStatement ppStmt = conn.prepareStatement("insert into Produto(descricao, marca, valor, unidadeMedida) values (?, ?, ?, ?); ");

			ppStmt.setString(1, p.getDescricao());
			ppStmt.setString(2, p.getMarca());
			ppStmt.setString(3, p.getValor());
			ppStmt.setString(4, p.getUnidadeMedida());

			ppStmt.execute();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}

	public List<Produto> getAll()
	{
		List<Produto> lstAll = new LinkedList<>();
		try
		{
			ResultSet rs = null;
			PreparedStatement ppStmt = conn.prepareStatement("select * from produto;");
			rs = ppStmt.executeQuery();
			while(rs.next())
				lstAll.add(getProduto(rs));

		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return lstAll;
	}

	public Produto getByID(int id)
	{
		Produto p = null;
		try
		{
			ResultSet rs = null;
			PreparedStatement ppStmt = conn.prepareStatement("select * from produto where produto.idProduto = ?;");
			ppStmt.setInt(1, id);
			rs = ppStmt.executeQuery();
			p = getProduto(rs);

		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}

		return p;
	}

	public Produto getProduto(ResultSet rs) throws SQLException
	{
		Produto p = new Produto();

		p.setDescricao(rs.getString("descricao"));
		p.setMarca(rs.getString("marca"));
		p.setValor(rs.getString("valor"));
		p.setUnidadeMedida(rs.getString("unidadeMedida"));

		return p;
	}

	public void removeProduto(int id)
	{
		try
		{
			PreparedStatement ppStmt = conn.prepareStatement("delete from produto where id = '?';");
			ppStmt.setInt(1, id);

			ppStmt.execute();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
