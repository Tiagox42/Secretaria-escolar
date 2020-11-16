package tiagox42;

import java.util.ArrayList;

public class Matricula {

    private int aluno;
    private int disciplinas;
    private ArrayList<DisciplinaPratica> disciplinaPraticas;

    private short anoLetivo;
    private byte serie;
    private float notaPrimeiroBimestre = 0.0f;
    private float notaSegundoBimestre = 0.0f;
    private float notaTerceiroBimestre = 0.0f;
    private float notaQuartoBimestre = 0.0f;
    private boolean aprovado = false;
    private int media;

    public Matricula() {

    }

    public short getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(short anoLetivo) {
        if (anoLetivo > 0){
        this.anoLetivo = anoLetivo;}
    }

    public byte getSerie() {
        return serie;
    }

    public void setSerie(byte serie) {
        if (serie >0){
        this.serie = serie;}
    }

    public float getNotaPrimeiroBimestre() {
        return notaPrimeiroBimestre;
    }

    public void setNotaPrimeiroBimestre(float notaPrimeiroBimestre) {
        if (notaPrimeiroBimestre > 0.0f){
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;}
    }

    public float getNotaSegundoBimestre() {
        return notaSegundoBimestre;
    }

    public void setNotaSegundoBimestre(float notaSegundoBimestre) {
        if (notaSegundoBimestre > 0.0f){
        this.notaSegundoBimestre = notaSegundoBimestre;}
    }

    public float getNotaTerceiroBimestre() {
        return notaTerceiroBimestre;
    }

    public void setNotaTerceiroBimestre(float notaTerceiroBimestre) {
        if (notaTerceiroBimestre > 0.0f){
        this.notaTerceiroBimestre = notaTerceiroBimestre;}
    }

    public float getNotaQuartoBimestre() {
        return notaQuartoBimestre;
    }

    public void setNotaQuartoBimestre(float notaQuartoBimestre) {
        if (notaQuartoBimestre > 0.0f){
        this.notaQuartoBimestre = notaQuartoBimestre;}
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }


    public int getAluno() {
        return aluno;
    }

    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    public int getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(int disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<DisciplinaPratica> getDisciplinaPraticas() {
        return disciplinaPraticas;
    }

    public void setDisciplinaPraticas(ArrayList<DisciplinaPratica> disciplinaPraticas) {
        this.disciplinaPraticas = disciplinaPraticas;
    }

    public Matricula(short anoLetivo, byte serie, int aluno, int disciplina) {
        this.aluno = aluno;
        this.disciplinas = disciplinas;
        this.disciplinaPraticas = disciplinaPraticas;
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
        this.notaSegundoBimestre = notaSegundoBimestre;
        this.notaTerceiroBimestre = notaTerceiroBimestre;
        this.notaQuartoBimestre = notaQuartoBimestre;
        this.aprovado = aprovado;
        this.media = media;
    }

//    public Matricula(short anoLetivo, byte serie, Aluno aluno, ArrayList<DisciplinaPratica> disciplinaPraticas) {
//        this.aluno = aluno;
//        this.disciplinas = disciplinas;
//        this.disciplinaPraticas = disciplinaPraticas;
//        this.anoLetivo = anoLetivo;
//        this.serie = serie;
//        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
//        this.notaSegundoBimestre = notaSegundoBimestre;
//        this.notaTerceiroBimestre = notaTerceiroBimestre;
//        this.notaQuartoBimestre = notaQuartoBimestre;
//        this.aprovado = aprovado;
//        this.media = media;
//    }

    public float maiorNota(){
        float op1 = 0.0f;
        float op2 = 0.0f;
        float maior = 0.0f;
        if (notaPrimeiroBimestre > notaSegundoBimestre){
            op1 = notaPrimeiroBimestre;} else {op1 = notaSegundoBimestre;}
        if (notaTerceiroBimestre > notaQuartoBimestre) {
            op2 = notaTerceiroBimestre;} else {op2 = notaQuartoBimestre;}
        if (op1 > op2) {maior = op1;} else {maior = op2;}

        return maior;
    }

    public float menorNota(){
        float op1 = 0.0f;
        float op2 = 0.0f;
        float menor = 0.0f;
        if (notaPrimeiroBimestre < notaSegundoBimestre){
            op1 = notaPrimeiroBimestre;} else {op1 = notaSegundoBimestre;}
        if (notaTerceiroBimestre < notaQuartoBimestre) {
            op2 = notaTerceiroBimestre;} else {op2 = notaQuartoBimestre;}
        if (op1 < op2) {menor = op1;} else {menor = op2;}

        return menor;
    }

    public float media(float[] notas){
        float resultado = 0.0f;
        for(int i = 0; i < notas.length; i++){
            resultado += notas[i]; }
        return resultado / notas.length;
    }

    public float mediaPonderada(float[] notas, int pesos[]){
        float resultado = 0.0f;
        int peso = 0;
        for(int i = 0; i < notas.length; i++){
            peso += pesos[i];
            resultado += (notas[i] * pesos[i]);
        }
        resultado = resultado / peso;
        return resultado;
    }
    private void verificaNotas(){
        if(media > 7){
            setAprovado(true);
        }
    }

}
