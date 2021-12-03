package dao;
import model.Pintura;
import java.sql.SQLException;
import java.util.ArrayList;

public class PinturaDAO extends ConnectionDAO{

    boolean sucesso = false;

    //DAO - DATA ACESS OBJECT
    public boolean inserirPintura(Pintura pintura) {
        connectToDB();
        String sql = "INSERT INTO Pintura (nomeP, autorP, anoP, tecnica) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pintura.getNome());
            pst.setString(2, pintura.getAutor());
            pst.setInt(3, pintura.getAno());
            pst.setString(4, pintura.getTecnica());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                 con.close();
                 pst.close();
            } catch (Exception exc) {
                System.out.println("Erro: " + exc.getMessage());
                exc.printStackTrace();
            }
        }

        return sucesso;
    }

    public boolean atualizarPintura(int id, Pintura pintura) {
        connectToDB();
        String sql = "UPDATE Pintura SET nomeP=?, autorP=?, anoP=?, tecnica=?, id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pintura.getNome());
            pst.setString(2, pintura.getAutor());
            pst.setInt(3, pintura.getAno());
            pst.setString(4, pintura.getTecnica());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deletarPintura(int id) {
        connectToDB();
        String sql = "DELETE FROM Pintura where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Pintura> buscarPinturaSemFiltro() {
        ArrayList<Pintura> listaDePintura = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM pintura";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Pinturas: ");
            while (rs.next()) {
                Pintura pinturaAux = new Pintura();
                pinturaAux.setNome(rs.getString("nomeP"));
                pinturaAux.setAutor(rs.getString("autorP"));
                pinturaAux.setAno(rs.getInt("anoP"));
                pinturaAux.setTecnica(rs.getString("tecnica"));
                System.out.println("nome = " + pinturaAux.getNome());
                System.out.println("autor = " + pinturaAux.getAutor());
                System.out.println("ano = " + pinturaAux.getAno());
                System.out.println("tecnica = " + pinturaAux.getTecnica());
                System.out.println("--------------------------------");
                listaDePintura.add(pinturaAux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return listaDePintura;
    }


}
