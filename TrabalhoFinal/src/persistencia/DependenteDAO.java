package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Dependente;

public class DependenteDAO {


	private static DependenteDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement sqlupdate;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static DependenteDAO getInstance() {
		if (instance == null) {
			instance = new DependenteDAO();
		}
		return instance;
	}

	private DependenteDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into dependente values (?, ?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from dependente where id = ?");
			sqlupdate = conn.prepareStatement("update dependente set nome = ?, idade = ?, endereco = ? where id = ?");
			sqlselect = conn.prepareStatement("select * from dependente where id = ?");
			menorid = conn.prepareStatement("select min(id) from dependente");
			maiorid = conn.prepareStatement("select max(id) from dependente");
      		sqlall = conn.prepareStatement("select id from dependente");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Dependente> getDependentes(){
        ResultSet rs;
        ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                dependentes.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependentes;
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

	public Dependente delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Dependente select(int code) {
		ResultSet rs;
        Dependente emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Dependente();
				emp.setId(rs.getInt(1));
                emp.setCpf(rs.getString(2));
                emp.setNome(rs.getString(3));
                emp.setIdade(rs.getInt(4));
				emp.setEndereco(rs.getString(5));
				emp.setIdContribuinte(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Dependente dependente) {
		try {
            sqlinsert.setInt(1, dependente.getId());
			sqlinsert.setString(2, dependente.getCpf());
            sqlinsert.setString(3, dependente.getNome());
			sqlinsert.setInt(4, dependente.getIdade());
			sqlinsert.setString(5, dependente.getEndereco());
			sqlinsert.setInt(6, dependente.getIdContribuinte());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, String cpf, String nome, int idade, String endereco, int idContribuinte) {
		try {
            sqlinsert.setInt(1, id);
			sqlinsert.setString(2, cpf);
            sqlinsert.setString(3, nome);
			sqlinsert.setInt(4, idade);
			sqlinsert.setString(5, endereco);
			sqlinsert.setInt(6, idContribuinte);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String nome, int idade, String endereco) {
		try {
			sqlupdate.setString(1, nome);
			sqlupdate.setInt(2, idade);
			sqlupdate.setString(3, endereco);
			sqlupdate.setInt(4, id);
			sqlupdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
