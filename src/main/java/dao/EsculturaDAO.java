package dao;
import model.Escultura;
import java.sql.SQLException;
import java.util.ArrayList;

public class EsculturaDAO extends ConnectionDAO{

    boolean sucesso = false;

    //DAO - DATA ACESS OBJECT
    public boolean inserirEscultura(Escultura escultura) {
        connectToDB();
        String sql = "INSERT INTO Escultura (nomeE, autorE, anoE, material) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, escultura.getNome());
            pst.setString(2, escultura.getAutor());
            pst.setInt(3, escultura.getAno());
            pst.setString(4, escultura.getMaterial());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public boolean atualizarEscultura(int id, Escultura escultura) {
        connectToDB();
        String sql = "UPDATE Escultura SET nomeE=?, autorE=?, anoE=?, material=?, id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, escultura.getNome());
            pst.setString(2, escultura.getAutor());
            pst.setInt(3, escultura.getAno());
            pst.setString(4, escultura.getMaterial());
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

    public boolean deletarEscultura(int id) {
        connectToDB();
        String sql = "DELETE FROM Escultura where id=?";

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

    public ArrayList<Escultura> buscarEsculturaSemFiltro() {
        ArrayList<Escultura> listaDeEscultura = new ArrayList<>();

        connectToDB();

        String sql = "SELECT * FROM escultura";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Esculturas: ");
            while (rs.next()) {
                Escultura esculturaAux = new Escultura();
                esculturaAux.setNome(rs.getString("nomeE"));
                esculturaAux.setAutor(rs.getString("autorE"));
                esculturaAux.setAno(rs.getInt("anoE"));
                esculturaAux.setMaterial(rs.getString("material"));
                System.out.println("nome = " + esculturaAux.getNome());
                System.out.println("autor = " + esculturaAux.getAutor());
                System.out.println("ano = " + esculturaAux.getAno());
                System.out.println("material = " + esculturaAux.getMaterial());
                System.out.println("--------------------------------");
                listaDeEscultura.add(esculturaAux);
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

        return listaDeEscultura;
    }

}
