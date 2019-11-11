package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Trecho;

/**
 * TrechoDAO
 */
public class TrechoDAO {

    private static TrechoDAO instance = null;
    private PreparedStatement sqldelete;
    private PreparedStatement sqlinsert;
    private PreparedStatement sqlselect;
    private PreparedStatement menorid;

    public static TrechoDAO getInstance() {
        if (instance == null) {
            instance = new TrechoDAO();
        }
        return instance;
    }

    private TrechoDAO() {
        Connection conn = Conexao.getConexao();
        try {
            sqlinsert = conn.prepareStatement(
                    "insert into trecho (num_trecho, duracao, data_partida, data_chegada, hora_partida, hora_chegada, classe_voo, num_poltrona, id_proximo_trecho, id_aero_origem, id_aero_destino, id_reserva) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sqldelete = conn.prepareStatement("delete from trecho where id = ?");
            sqlselect = conn.prepareStatement("select * from trecho where id = ?");
            menorid = conn.prepareStatement("select min(id) from trecho");
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

    public Trecho delete(int code) {
        try {
            sqldelete.setInt(1, code);
            sqldelete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Trecho select(int code) {
        ResultSet rs;
        Trecho emp = null;
        try {
            sqlselect.setInt(1, code);
            rs = sqlselect.executeQuery();
            if (rs.next()) {
                emp = new Trecho();
                emp.setId(rs.getInt("id"));
                emp.setNumtrecho(rs.getInt("num_trecho"));
                emp.setDuracao(rs.getInt("duracao"));
                emp.setDatapartida(rs.getDate("data_partida"));
                emp.setDatachegada(rs.getDate("data_chegada"));
                emp.setHorachegada(rs.getTime("hora_chegada"));
                emp.setHorapartida(rs.getTime("hora_partida"));
                emp.setClassevoo(rs.getString("classe_voo"));
                emp.setNumpoltrona(rs.getInt("num_poltrona"));
                emp.setIdproximotrecho(rs.getInt("id_proximo_trecho"));
                emp.setIdaeroorigem(rs.getInt("id_aero_origem"));
                emp.setIdaerodestino(rs.getInt("id_aero_destino"));
                emp.setIdreserva(rs.getInt("id_reserva"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public void insert(Trecho trecho) {
        try {
            sqlinsert.setInt(1, trecho.getNumtrecho());
            sqlinsert.setInt(2, trecho.getDuracao());
            sqlinsert.setDate(3, trecho.getDatapartida());
            sqlinsert.setDate(4, trecho.getDatachegada());
            sqlinsert.setTime(5, trecho.getHorapartida());
            sqlinsert.setTime(6, trecho.getHorachegada());
            sqlinsert.setString(7, trecho.getClassevoo());
            sqlinsert.setInt(8, trecho.getNumpoltrona());
            sqlinsert.setInt(9, trecho.getIdproximotrecho());
            sqlinsert.setInt(10, trecho.getIdaeroorigem());
            sqlinsert.setInt(11, trecho.getIdaerodestino());
            sqlinsert.setInt(12, trecho.getIdreserva());
            sqlinsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}