package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Cliente;

/**
 * ClienteDAO
 */
public class ClienteDAO {


	private static ClienteDAO instance = null;
	private PreparedStatement sqldelete;
	private PreparedStatement sqlinsert;
	private PreparedStatement sqlselect;
	private PreparedStatement menorid;
    private PreparedStatement sqlall;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	private ClienteDAO() {
		Connection conn = Conexao.getConexao();
		try {
			sqlinsert = conn.prepareStatement("insert into cliente (cpf, nome, endereco, telefone) values (?, ?, ?, ?)");
			sqldelete = conn.prepareStatement("delete from cliente where id = ?");
			sqlselect = conn.prepareStatement("select * from cliente where id = ?");
			menorid = conn.prepareStatement("select min(id) from cliente");
      		sqlall = conn.prepareStatement("select id from cliente");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Cliente> getClientes(){
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                clientes.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
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

	public Cliente delete(int code) {
		try {
			sqldelete.setInt(1, code);
			sqldelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cliente select(int code) {
		ResultSet rs;
		Cliente emp = null;
		try {
			sqlselect.setInt(1, code);
			rs = sqlselect.executeQuery();
			if (rs.next()) {
				emp = new Cliente();
				emp.setId(rs.getInt("id"));
                emp.setNome(rs.getString("nome"));
                emp.setCpf(rs.getString("cpf"));
                emp.setEndereco(rs.getString("endereco"));
                emp.setTelefone(rs.getInt("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void insert(Cliente cliente) {
		try {
            sqlinsert.setString(1, cliente.getCpf());
			sqlinsert.setString(2, cliente.getNome());
            sqlinsert.setString(3, cliente.getEndereco());
            sqlinsert.setInt(4, cliente.getTelefone());
			sqlinsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
