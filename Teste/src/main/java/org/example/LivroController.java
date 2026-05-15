package main.java.org.example;

import com.example.api.model.Livro;
import com.example.api.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    // GET
    @GetMapping
    public List<Livro> listar() {
        return repository.listar();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Integer id) {
        return repository.buscarPorId(id);
    }

    // POST
    @PostMapping
    public String salvar(@RequestBody Livro livro) {

        repository.salvar(livro);

        return "Livro cadastrado!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {

        repository.deletar(id);

        return "Livro deletado!";
    }
}
