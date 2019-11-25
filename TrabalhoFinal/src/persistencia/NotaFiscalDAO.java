package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.NotaFiscal;

public class NotaFiscalDAO {


	private static NotaFiscalDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static NotaFiscalDAO getInstance() {
		if (instance == null) {
			instance = new NotaFiscalDAO();
		}
		return instance;
	}

	private NotaFiscalDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into notafiscal values (?, ?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from notafiscal where id = ?");
			sqlselect = conn.prepareStatement("select * from notafiscal where id = ?");
			menorid = conn.prepareStatement("select min(id) from notafiscal");
			maiorid = conn.prepareStatement("select max(id) from notafiscal");
      		sqlall = conn.prepareStatement("select id from notafiscal");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<NotaFiscal> getNotas(){
        ResultSet rs;
        ArrayList<NotaFiscal> notas = new ArrayList<NotaFiscal>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                notas.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
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

	public NotaFiscal delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public NotaFiscal select(int code) {
		ResultSet rs;
        NotaFiscal emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new NotaFiscal();
				emp.setId(rs.getInt(1));
				emp.setNumProtocolo(rs.getInt(2));
				emp.setCnpj(rs.getString(3));
				emp.setValor(rs.getDouble(4));
                emp.setIdPJ(rs.getInt(5));
                emp.setIdContribuinte(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(NotaFiscal notafiscal) {
		try {
            sqlinsert.setInt(1, notafiscal.getId());
			sqlinsert.setInt(2, notafiscal.getNumProtocolo());
            sqlinsert.setString(3, notafiscal.getCnpj());
			sqlinsert.setDouble(4, notafiscal.getValor());
            sqlinsert.setInt(5, notafiscal.getIdPJ());
            sqlinsert.setInt(6, notafiscal.getIdContribuinte());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, int numProtocolo, String cnpj, double valor, int idpj, int idContribuinte) {
		try {
            sqlinsert.setInt(1, id);
			sqlinsert.setInt(2, numProtocolo);
            sqlinsert.setString(3, cnpj);
			sqlinsert.setDouble(4, valor);
			sqlinsert.setInt(5, idpj);
			sqlinsert.setInt(6, idContribuinte);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
