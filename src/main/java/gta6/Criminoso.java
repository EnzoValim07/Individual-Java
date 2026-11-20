package gta6;

public class Criminoso extends Personagem {
    private int nivelProcurado;      // 1 a 5 estrelas
    private String crimePrincipal;

    public Criminoso(int id, String nome, String cidade, int nivelProcurado, String crimePrincipal) {
        super(id, nome, cidade);
        this.nivelProcurado = nivelProcurado;
        this.crimePrincipal = crimePrincipal;
    }

    public Criminoso(String nome, String cidade, int nivelProcurado, String crimePrincipal) {
        this(0, nome, cidade, nivelProcurado, crimePrincipal);
    }

    @Override
    public String getTipo() {
        return "CRIMINOSO";
    }

    public int getNivelProcurado() { return nivelProcurado; }
    public String getCrimePrincipal() { return crimePrincipal; }

    @Override
    public String toString() {
        return super.toString() + " | " + "*".repeat(nivelProcurado) + " | " + crimePrincipal;
    }
}
