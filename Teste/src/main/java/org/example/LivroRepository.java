package main.java.org.example;

import com.example.api.model.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // INSERT
    public void salvar(Livro livro) {

        String sql = "INSERT INTO livros(titulo, autor) VALUES (?, ?)";

        jdbcTemplate.update(
                sql,
                livro.getTitulo(),
                livro.getAutor()
        );
    }

    // SELECT
    public List<Livro> listar() {

        String sql = "SELECT * FROM livros";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor")
                )
        );
    }

    // SELECT POR ID
    public Livro buscarPorId(Integer id) {

        String sql = "SELECT * FROM livros WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, rowNum) -> new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor")
                )
        );
    }

    // DELETE
    public void deletar(Integer id) {

        String sql = "DELETE FROM livros WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}
