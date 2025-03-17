import java.util.ArrayList;
import java.util.Date;

class Livro {
    private String titulo;
    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Membro {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
}

class Emprestimo {
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = new Date();
    }

    public String detalhes() {
        return "Livro emprestado: " + livro.getTitulo() + " para " + membro.getNome();
    }
}

class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Membro> membros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
        System.out.println("Livro removido: " + livro.getTitulo());
    }

    public void registrarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("Membro registrado: " + membro.getNome());
    }

    public void emprestarLivro(Livro livro, Membro membro) {
        Emprestimo emprestimo = new Emprestimo(livro, membro);
        emprestimos.add(emprestimo);
        System.out.println(emprestimo.detalhes());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Biblioteca rodando!");

        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro("O Hobbit", "J.R.R. Tolkien", "123456");
        Membro membro1 = new Membro("João", 1, "joao@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.registrarMembro(membro1);
        biblioteca.emprestarLivro(livro1, membro1);
    }
}
