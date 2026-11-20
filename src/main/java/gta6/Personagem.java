package gta6;

public class Personagem {
    private int id;
    private String nome;
    private String cidade;

    public Personagem(int id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Personagem(String nome, String cidade) {
        this(0, nome, cidade);
    }

    public String getTipo() {
        return "PERSONAGEM";
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCidade() { return cidade; }

    @Override
    public String toString() {
        return "#" + id + " | " + nome + " | " + cidade + " | " + getTipo();
    }
}
