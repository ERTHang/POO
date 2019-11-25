package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Contribuinte;

public class ContribuinteDAO {


	private static ContribuinteDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement sqlupdate;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static ContribuinteDAO getInstance() {
		if (instance == null) {
			instance = new ContribuinteDAO();
		}
		return instance;
	}

	private ContribuinteDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into contribuinte values (?, ?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from contribuinte where id = ?");
			sqlupdate = conn.prepareStatement("update contribuinte set nome = ?, idade = ?, endereco = ?, contabancaria = ? where id = ?");
			sqlselect = conn.prepareStatement("select * from contribuinte where id = ?");
			menorid = conn.prepareStatement("select min(id) from contribuinte");
			maiorid = conn.prepareStatement("select max(id) from contribuinte");
      		sqlall = conn.prepareStatement("select id from contribuinte");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Contribuinte> getContribuintes(){
        ResultSet rs;
        ArrayList<Contribuinte> contribuintes = new ArrayList<Contribuinte>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                contribuintes.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contribuintes;
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

	public Contribuinte delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Contribuinte select(int code) {
		ResultSet rs;
        Contribuinte emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Contribuinte();
				emp.setId(rs.getInt(1));
                emp.setCpf(rs.getString(2));
                emp.setNome(rs.getString(3));
                emp.setIdade(rs.getInt(4));
				emp.setEndereco(rs.getString(5));
				emp.setContaBancaria(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Contribuinte contribuinte) {
		try {
            sqlinsert.setInt(1, contribuinte.getId());
			sqlinsert.setString(2, contribuinte.getCpf());
            sqlinsert.setString(3, contribuinte.getNome());
			sqlinsert.setInt(4, contribuinte.getIdade());
			sqlinsert.setString(5, contribuinte.getEndereco());
			sqlinsert.setInt(6, contribuinte.getContaBancaria());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, String cpf, String nome, int idade, String endereco, int contaBancaria) {
		try {
            sqlinsert.setInt(1, id);
			sqlinsert.setString(2, cpf);
            sqlinsert.setString(3, nome);
			sqlinsert.setInt(4, idade);
			sqlinsert.setString(5, endereco);
			sqlinsert.setInt(6, contaBancaria);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String nome, int idade, String endereco, int contaBancaria) {
		try {
			sqlupdate.setString(1, nome);
			sqlupdate.setInt(2, idade);
			sqlupdate.setString(3, endereco);
			sqlupdate.setInt(4, contaBancaria);
			sqlupdate.setInt(5, id);
			sqlupdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
