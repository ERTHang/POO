package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.PessoaJuridica;

public class PessoaJuridicaDAO {


	private static PessoaJuridicaDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement sqlupdate;
	private PreparedStatement menorid;
	private PreparedStatement maiorid;
    private PreparedStatement sqlall;

	public static PessoaJuridicaDAO getInstance() {
		if (instance == null) {
			instance = new PessoaJuridicaDAO();
		}
		return instance;
	}

	private PessoaJuridicaDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into pessoajuridica values (?, ?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from pessoajuridica where id = ?");
			sqlupdate = conn.prepareStatement("update pessoajuridica set nomepj = ?, endereco = ?, numfuncionario = ? where id = ?");
			sqlselect = conn.prepareStatement("select * from pessoajuridica where id = ?");
			menorid = conn.prepareStatement("select min(id) from pessoajuridica");
			maiorid = conn.prepareStatement("select max(id) from pessoajuridica");
      		sqlall = conn.prepareStatement("select id from pessoajuridica");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<PessoaJuridica> getPessoas(){
        ResultSet rs;
        ArrayList<PessoaJuridica> pessoas = new ArrayList<PessoaJuridica>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                pessoas.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
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

	public PessoaJuridica delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PessoaJuridica select(int code) {
		ResultSet rs;
        PessoaJuridica emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new PessoaJuridica();
                emp.setId(rs.getInt(1));
                emp.setCnpj(rs.getString(2));
				emp.setNomePJ(rs.getString(3));
				emp.setEndereco(rs.getString(4));
                emp.setNumFuncionarios(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(PessoaJuridica pessoajuridica) {
		try {
            sqlinsert.setInt(1, pessoajuridica.getId());
            sqlinsert.setString(2, pessoajuridica.getCnpj());
            sqlinsert.setString(3, pessoajuridica.getNomePJ());
            sqlinsert.setString(4, pessoajuridica.getEndereco());
            sqlinsert.setInt(5, pessoajuridica.getNumFuncionarios());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int id, String cnpj, String nomePJ, String Endereco, int numFuncionarios) {
		try {
            sqlinsert.setInt(1, id);
            sqlinsert.setString(2, cnpj);
            sqlinsert.setString(3, nomePJ);
            sqlinsert.setString(4, Endereco);
            sqlinsert.setInt(5, numFuncionarios);
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, String nome, String endereco, int numFuncionarios) {
		try {
			sqlupdate.setString(1, nome);
			sqlupdate.setString(2, endereco);
			sqlupdate.setInt(3, numFuncionarios);
			sqlupdate.setInt(4, id);
			sqlupdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
