package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Cidade;

public class CidadeDAO {
	private static CidadeDAO instance = null;
	private PreparedStatement deleteCidade;
	private PreparedStatement insertCidade;
	private PreparedStatement selectCidade;
	private PreparedStatement menorid;

	public static CidadeDAO getInstance() {
		if (instance == null) {
			instance = new CidadeDAO();
		}
		return instance;
	}

	private CidadeDAO() {
		Connection conn = Conexao.getConexao();
		try {
			insertCidade = conn.prepareStatement("insert into cidade (nome, estado) values (?, ?)");
			deleteCidade = conn.prepareStatement("delete from cidade where id = ?");
			selectCidade = conn.prepareStatement("select * from cidade where id = ?");
			menorid = conn.prepareStatement("select min(id) from cidade");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public int menorID() {
		ResultSet rs;
		int retorno = 1;
		try {
			rs = menorid.executeQuery();
			rs.next();
			retorno = rs.getInt("min");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Cidade delete(int code) {
		try {
			deleteCidade.setInt(1, code);
			deleteCidade.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cidade select(int code) {
		ResultSet rs;
		Cidade emp = null;
		try {
			selectCidade.setInt(1, code);
			rs = selectCidade.executeQuery();
			if (rs.next()) {
				emp = new Cidade();
				emp.setId(rs.getInt("id"));
				emp.setNome(rs.getString("nome"));
				emp.setEstado(rs.getString("estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public void insert(Cidade cidade) {
		try {
			insertCidade.setString(1, cidade.getNome());
			insertCidade.setString(2, cidade.getEstado());
			insertCidade.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
