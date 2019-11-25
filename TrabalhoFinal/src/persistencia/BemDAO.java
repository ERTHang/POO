package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Bem;

public class BemDAO {


	private static BemDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static BemDAO getInstance() {
		if (instance == null) {
			instance = new BemDAO();
		}
		return instance;
	}

	private BemDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into bem values (?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from bem where id = ?");
			sqlselect = conn.prepareStatement("select * from bem where id = ?");
			menorid = conn.prepareStatement("select min(id) from bem");
			maiorid = conn.prepareStatement("select max(id) from bem");
      		sqlall = conn.prepareStatement("select id from bem");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Bem> getBens(){
        ResultSet rs;
        ArrayList<Bem> bens = new ArrayList<Bem>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                bens.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bens;
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
    
    public int maiorID() {
		ResultSet rs;
		int retorno = 1;
		try {
			rs = maiorid.executeQuery();
			rs.next();
			retorno = rs.getInt("max");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Bem delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Bem select(int code) {
		ResultSet rs;
        Bem emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Bem();
				emp.setId(rs.getInt(1));
				emp.setNome(rs.getString(2));
				emp.setTipo(rs.getString(3));
				emp.setValor(rs.getDouble(4));
				emp.setIdContribuinte(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Bem bem) {
		try {
            sqlinsert.setInt(1, bem.getId());
			sqlinsert.setString(2, bem.getNome());
            sqlinsert.setString(3, bem.getTipo());
			sqlinsert.setDouble(4, bem.getValor());
			sqlinsert.setInt(5, bem.getIdContribuinte());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, String nome, String tipo, double valor, int idContribuinte) {
		try {
            sqlinsert.setInt(1, id);
			sqlinsert.setString(2, nome);
            sqlinsert.setString(3, tipo);
			sqlinsert.setDouble(4, valor);
			sqlinsert.setInt(5, idContribuinte);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
