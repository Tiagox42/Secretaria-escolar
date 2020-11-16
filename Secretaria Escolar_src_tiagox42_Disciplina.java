package tiagox42;

public class Disciplina {

    // Atributos
    private int codigoDisciplina;
    private String nome;
    private int cargaHorariaGeral;

    // Propriedades

    public int getCodigoDisciplina() { return this.codigoDisciplina; }
    public void setCodigoDisciplina(int value) {
        if (value != 0)
            this.codigoDisciplina = value;
    }

    public String getNome() { return this.nome; }
    public void setNome(String value) {
        if (value != null)
            this.nome = value;
    }

    public int getCargaHorariaGeral() { return this.cargaHorariaGeral; }
    public void setCargaHorariaGeral(int value) {
        if (value != 0)
            this.cargaHorariaGeral = value;
    }

    // Construtores
    public Disciplina() {
        this.codigoDisciplina = 0;
        this.nome = "";
        this.cargaHorariaGeral = 0;
    }

    public Disciplina(int codigoDisciplina, String nome, int cargaHorariaGeral) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.cargaHorariaGeral = cargaHorariaGeral;
    }

    //Métodos




}
