package tiagox42;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Aluno {

    // Atributos
    private int idAluno;
    private String nome;
    private String sobrenome;
    private char sexo;
    private Calendar nascimento;
    private int idade;

    // Propriedades
    public int getIdAluno() {
        return this.idAluno;
    }


    public void setIdAluno(int value) {
        if (value < 0)
            this.idAluno = value;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String value) {
        if (value != null)
            this.nome = value;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String value) {
        if (value != null)
            this.sobrenome = value;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char value) {
        if (value == 0)
            this.sexo = value;
    }

    public String getNascimento() {
        DateFormat data = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = data.format(nascimento.getTime());
        return dataFormatada;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
        setIdade();
    }

    public void setIdade() {
        this.idade = calculaIdade();
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int value) {
        if (value != 0)
            this.idade = value;
    }

    // Construtores

    public Aluno() {
        this.idAluno = 0;
        this.nome = "";
        this.sobrenome = "";
        this.sexo = 0;
        this.nascimento = null;
    }

    public Aluno(int idAluno, String nome, String sobrenome, char sexo, Calendar nascimento) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.nascimento = nascimento;
    }

    // Métodos

    private int calculaIdade() {
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < nascimento.get(Calendar.MONTH)) {
            idade--;
        } else {
            if (hoje.get(Calendar.MONTH) == nascimento.get(Calendar.MONTH)
                    && hoje.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }
        return idade;
    }

}
