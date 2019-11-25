package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Contracheque;

public class ContrachequeDAO {


	private static ContrachequeDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static ContrachequeDAO getInstance() {
		if (instance == null) {
			instance = new ContrachequeDAO();
		}
		return instance;
	}

	private ContrachequeDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into contracheque values (?, ?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from contracheque where id = ?");
			sqlselect = conn.prepareStatement("select * from contracheque where id = ?");
			menorid = conn.prepareStatement("select min(id) from contracheque");
			maiorid = conn.prepareStatement("select max(id) from contracheque");
      		sqlall = conn.prepareStatement("select id from contracheque");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Contracheque> getContracheques(){
        ResultSet rs;
        ArrayList<Contracheque> contracheques = new ArrayList<Contracheque>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                contracheques.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracheques;
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

	public Contracheque delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Contracheque select(int code) {
		ResultSet rs;
        Contracheque emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Contracheque();
				emp.setId(rs.getInt(1));
				emp.setNumProtocolo(rs.getInt(2));
				emp.setCnpj(rs.getString(3));
				emp.setValor(rs.getDouble(4));
                emp.setIdContribuinte(rs.getInt(5));
                emp.setIdPJ(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Contracheque contracheque) {
		try {
            sqlinsert.setInt(1, contracheque.getId());
			sqlinsert.setInt(2, contracheque.getNumProtocolo());
            sqlinsert.setString(3, contracheque.getCnpj());
			sqlinsert.setDouble(4, contracheque.getValor());
            sqlinsert.setInt(5, contracheque.getIdContribuinte());
            sqlinsert.setInt(6, contracheque.getIdPJ());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, int numProtocolo, String cnpj, double valor, int idContribuinte, int idpj) {
		try {
            sqlinsert.setInt(1, id);
			sqlinsert.setInt(2, numProtocolo);
            sqlinsert.setString(3, cnpj);
			sqlinsert.setDouble(4, valor);
            sqlinsert.setInt(5, idContribuinte);
            sqlinsert.setInt(6, idpj);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
