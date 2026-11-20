package gta6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    public void inserir(Personagem p) throws SQLException {
        String sql = "INSERT INTO personagem (nome, cidade, tipo, nivel_procurado, crime_principal) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCidade());
            ps.setString(3, p.getTipo());
            if (p instanceof Criminoso c) {
                ps.setInt(4, c.getNivelProcurado());
                ps.setString(5, c.getCrimePrincipal());
            } else {
                ps.setNull(4, Types.INTEGER);
                ps.setNull(5, Types.VARCHAR);
            }
            ps.executeUpdate();
        }
    }

    public List<Personagem> listar() throws SQLException {
        return consultar("SELECT * FROM personagem ORDER BY id", null);
    }

    public List<Personagem> buscarPorNome(String nome) throws SQLException {
        return consultar("SELECT * FROM personagem WHERE nome LIKE ?", "%" + nome + "%");
    }

    private List<Personagem> consultar(String sql, String filtro) throws SQLException {
        List<Personagem> lista = new ArrayList<>();
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            if (filtro != null) ps.setString(1, filtro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cidade = rs.getString("cidade");
                    if ("CRIMINOSO".equals(rs.getString("tipo"))) {
                        lista.add(new Criminoso(id, nome, cidade,
                                rs.getInt("nivel_procurado"), rs.getString("crime_principal")));
                    } else {
                        lista.add(new Personagem(id, nome, cidade));
                    }
                }
            }
        }
        return lista;
    }
}
