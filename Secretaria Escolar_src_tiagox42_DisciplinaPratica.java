package tiagox42;

public class DisciplinaPratica extends Disciplina {

    // Construtores
    public DisciplinaPratica() {
        this.setCodigoDisciplina(0);
        this.setNome("");
        this.setCargaHorariaGeral(0);
    }

    public DisciplinaPratica(int codigoDisciplina, String nome, int cargaHorariaGeral) {
        this.setCodigoDisciplina(codigoDisciplina);
        this.setNome(nome);
        this.setCargaHorariaGeral(cargaHorariaGeral);
    }
    private int cargaHorariaPratica;

    public int getCargaHorariaPratica() {
        return cargaHorariaPratica;
    }

    public void setCargaHorariaPratica(int cargaHorariaPratica) {
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public DisciplinaPratica(int cargaHorariaPratica) {
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public DisciplinaPratica(int codigoDisciplina, String nome, int cargaHorariaGeral, int cargaHorariaPratica) {
        super(codigoDisciplina, nome, cargaHorariaGeral);
        this.cargaHorariaPratica = cargaHorariaPratica;
    }
}
