package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Aeroporto;

/**
 * AeroportoDAO
 */
public class AeroportoDAO {


	private static AeroportoDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement menorid;
    private PreparedStatement sqlall;

	public static AeroportoDAO getInstance() {
		if (instance == null) {
			instance = new AeroportoDAO();
		}
		return instance;
	}

	private AeroportoDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into aeroporto (codigo, nome, id_cidade) values (?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from aeroporto where id = ?");
			sqlselect = conn.prepareStatement("select * from aeroporto where id = ?");
			menorid = conn.prepareStatement("select min(id) from aeroporto");
      		sqlall = conn.prepareStatement("select id from aeroporto");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Aeroporto> getAeroportos(){
        ResultSet rs;
        ArrayList<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                aeroportos.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aeroportos;
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

	public Aeroporto delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Aeroporto select(int code) {
		ResultSet rs;
		Aeroporto emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Aeroporto();
				emp.setId(rs.getInt("id"));
				emp.setNome(rs.getString("nome"));
                emp.setCodigo(rs.getString("codigo"));
                emp.setIdCidade(rs.getInt("id_cidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Aeroporto aeroporto) {
		try {
			sqlinsert.setString(2, aeroporto.getNome());
            sqlinsert.setString(1, aeroporto.getCodigo());
            sqlinsert.setInt(3, aeroporto.getIdCidade());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
