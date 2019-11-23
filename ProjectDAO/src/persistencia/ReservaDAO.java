package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Reserva;

/**
 * ReservaDAO
 */
public class ReservaDAO {

    private static ReservaDAO instance = null;
    private PreparedStatement sqldelete;
    private PreparedStatement sqlinsert;
    private PreparedStatement sqlselect;
    private PreparedStatement sqlall;
    private PreparedStatement menorid;

    public static ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    private ReservaDAO() {
        Connection conn = Conexao.getConexao();
        try {
            sqlinsert = conn.prepareStatement(
                    "insert into reserva (numreserva, data_voo, hora_voo, preco, classe_voo, ida_e_volta, id_volta, id_cidade_origem, id_cidade_destino, id_cliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sqldelete = conn.prepareStatement("delete from reserva where id = ?");
            sqlselect = conn.prepareStatement("select * from reserva where id = ?");
            menorid = conn.prepareStatement("select min(id) from reserva");
            sqlall = conn.prepareStatement("select id from reserva");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Reserva> getReservas(){
        ResultSet rs;
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        try {
            rs = sqlall.executeQuery();
            while(rs.next()){
                reservas.add(select(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
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

    public Reserva delete(int code) {
        try {
            sqldelete.setInt(1, code);
            sqldelete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Reserva select(int code) {
        ResultSet rs;
        Reserva emp = null;
        try {
            sqlselect.setInt(1, code);
            rs = sqlselect.executeQuery();
            if (rs.next()) {
                emp = new Reserva();
                emp.setId(rs.getInt("id"));
                emp.setNumreserva(rs.getInt("numreserva"));
                emp.setDataVoo(rs.getDate("data_voo"));
                emp.setHoraVoo(rs.getTime("hora_voo"));
                emp.setPreco(rs.getDouble("preco"));
                emp.setClasseVoo(rs.getString("classe_voo"));
                emp.setIdVolta(rs.getInt("id_volta"));
                emp.setIdOrigem(rs.getInt("id_cidade_origem"));
                emp.setIdDestino(rs.getInt("id_cidade_destino"));
                emp.setIdCliente(rs.getInt("id_cliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void insert(Reserva reserva) {
        try {
            sqlinsert.setInt(1, reserva.getNumreserva());
            sqlinsert.setDate(2, reserva.getDataVoo());
            sqlinsert.setTime(3, reserva.getHoraVoo());
            sqlinsert.setDouble(4, reserva.getPreco());
            sqlinsert.setString(5, reserva.getClasseVoo());
            sqlinsert.setBoolean(6, reserva.isIdaEvolta());
            sqlinsert.setInt(7, reserva.getIdVolta());
            sqlinsert.setInt(8, reserva.getIdOrigem());
            sqlinsert.setInt(9, reserva.getIdDestino());
            sqlinsert.setInt(10, reserva.getIdCliente());
            sqlinsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}