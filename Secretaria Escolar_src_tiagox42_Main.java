package tiagox42;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Main {
   static Scanner entrada = new Scanner(System.in);
   Aluno aluno = new Aluno();
   String[] disciplinas = new String[5];


    public static void menu() throws ParseException {
        ArrayList<DisciplinaPratica> disciplinas = new ArrayList<>();
        int numeroDisciplinas = 0;
        int opcao1 = 0;
        do {
            System.out.println("----------------Secretaria Escolar-----------------");
            System.out.println("# 1 - Cadastrar Disciplina                       #");
            System.out.println("# 2 - Cadastrar Aluno                            #");
            System.out.println("# 3 - Matricular Aluno                           #");
            System.out.println("# 4 - Lançar Nota                                #");
            System.out.println("# 5 - Mostrar Boletim                            #");
            System.out.println("# 0 - Fechar aplicação                           #");
            System.out.println("--------------------------------------------------");
            opcao1 = entrada.nextInt();

            switch (opcao1){
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    matricularAluno();
                    break;
                case 4:
                    lancarNotas();
                    break;
                case 5:
                    mostrarBoletin();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção incorreta, tente novamente");
            }

        } while (opcao1 !=0);
    }

    public static ArrayList<DisciplinaPratica> cadastrarDisciplina(){
        int tipoDisciplina;
        System.out.println("Digite o típo da disciplina que deseja: [1] Disciplina normal. [2] Disciplina prática.");
        tipoDisciplina = entrada.nextInt();
        int codigoDisciplina = geradorId();
        String nome = "";
        int cargaHoraria = 0;
        int cargaHorariaPratica = 0;
        DisciplinaPratica disciplina = new DisciplinaPratica(codigoDisciplina, nome, cargaHoraria);
        ArrayList<DisciplinaPratica> disciplinas = new ArrayList<>();
        switch (tipoDisciplina) {
            // Disciplina normal
            case 1:
                System.out.println("Complete as informações para concluir o registro: ");
                System.out.println("Digite o nome da disciplina: ");
                nome = entrada.next();
                System.out.println("Digite a carga horária: ");
                cargaHoraria = entrada.nextInt();
                disciplina.setCodigoDisciplina(codigoDisciplina);
                disciplina.setNome(nome);
                disciplina.setCargaHorariaGeral(cargaHoraria);
                disciplinas.add(disciplina);
                System.out.println("O codigo da disciplina " +nome+" é " +codigoDisciplina+".");
                return disciplinas;
            // Disciplina pratica
            case 2:
                System.out.println("Complete as informações para concluir o registro: ");
                System.out.println("Digite o nome da disciplina: ");
                nome = entrada.next();
                System.out.println("Digite a carga horária pratica: ");
                cargaHorariaPratica = entrada.nextInt();
                disciplina.setCodigoDisciplina(codigoDisciplina);
                disciplina.setNome(nome);
                disciplina.setCargaHorariaPratica(cargaHorariaPratica);
                disciplinas.add(disciplina);
                System.out.println("O codigo da disciplina " +nome+" é " +codigoDisciplina);
                return disciplinas;
            default:
                System.out.println("Opção invalida, tente novamente.");
                return null;
        }
    }

    private static Calendar getNascimento() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Digite a data de nascimento no formato de ano-mes-dia Exemplo: 1999-12-25 ");
        String nascimento = entrada.next();
        Calendar data = Calendar.getInstance();
        return data;
    }

    public static int  geradorId(){
        Random gerador = new Random();
        int idAluno = 1;
        for (int i = 0; i < 1; i++)
            idAluno = (gerador.nextInt(101));
        return idAluno;
    }

    public static ArrayList<Aluno> cadastrarAluno() throws ParseException {
        int idAluno = 0;
        idAluno = geradorId();
        String nome = "";
        String sobrenome = "";
        String sexo2 = "";
        System.out.println("Digite o nome do aluno: ");
        nome = entrada.next();
        System.out.println("Digite o sobrenome do aluno: ");
        sobrenome = entrada.next();
        System.out.println("Digite o sexo do aluno: M / F");
        sexo2 = entrada.next();
        char sexo = sexo2.charAt (0);
        Calendar nascimento = getNascimento();
        Aluno aluno = new Aluno(idAluno, nome, sobrenome,sexo,nascimento);
        ArrayList<Aluno> alunos = new ArrayList<>();
        aluno.setIdAluno(idAluno);
        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);
        aluno.setSexo(sexo);
        aluno.setNascimento(nascimento);
        alunos.add(aluno);
        System.out.println("O id do aluno " +nome+" é " +idAluno);
        return alunos;
    }

    public static ArrayList<Matricula> matricularAluno(){
        short anoLetivo = 0;
        byte serie = 0;
        int idAluno = 0;
        int tipoDisciplina = 0;
        System.out.println("Digite o ano letivo do aluno: ");
        anoLetivo = entrada.nextShort();
        System.out.println("Digite a serie do aluno: ");
        serie = entrada.nextByte();
        System.out.println("Digite o id do aluno que deseja fazer a matricula: ");
        idAluno = entrada.nextInt();
        System.out.println("Digite o tipo de disciplina que deseja fazer a matricula: [1] Disciplina normal. [2] Disciplina prática.");
        tipoDisciplina = entrada.nextInt();
        ArrayList<Matricula> matriculas = new ArrayList<>();
        if (tipoDisciplina == 1) {
            int codigoDisciplina = 0;
            System.out.println("Digite o codigo da disciplina: ");
            codigoDisciplina = entrada.nextInt();
            Matricula matricula = new Matricula(anoLetivo, serie, idAluno, codigoDisciplina);
            matricula.setAnoLetivo(anoLetivo);
            matricula.setSerie(serie);
            matricula.setAluno(idAluno);
            matricula.setDisciplinas(codigoDisciplina);
            matriculas.add(matricula);
            return matriculas;

        } else if (tipoDisciplina == 2){
            int codigoDisciplinaPratica = 0;
            System.out.println("Digite o codigo da disciplina pratica: ");
            codigoDisciplinaPratica = entrada.nextInt();
            Matricula matricula = new Matricula(anoLetivo, serie, idAluno, codigoDisciplinaPratica);
            matricula.setAnoLetivo(anoLetivo);
            matricula.setSerie(serie);
            matricula.setAluno(idAluno);
            matricula.setDisciplinas(codigoDisciplinaPratica);
            matriculas.add(matricula);
            return matriculas;
        }
        return null;
    }

    public static void lancarNotas(){
        int idAluno = 0;
        int codigoDisciplina = 0;
        short ano = 0;
        byte bimestre = 0;
        int nota = 0;
        int[] peso = new int[4];
        String aprovado = "Reprovado";
        System.out.println("Digite o id do aluno: ");
        idAluno = entrada.nextInt();
        System.out.println("Digite o codigo da disciplina: ");
        codigoDisciplina = entrada.nextInt();
        System.out.println("Digite o ano letivo: ");
        ano = entrada.nextShort();
        System.out.println("Digite o peso: ");
        peso[0] = entrada.nextInt();
        System.out.println("Digite a nota de 0 a 10: ");
        nota = entrada.nextInt();
        while (nota > 10 && nota <= -1) {
            System.out.println("Nota incorreta");
            System.out.println("Digite a nota novamente, de 0 a 10: ");
            nota = entrada.nextInt();
        }
        System.out.println("Digite o bimestre: ");
        bimestre = entrada.nextByte();
        Matricula matricula = new Matricula(ano,bimestre,idAluno,codigoDisciplina);
            float[] notas = {matricula.getNotaPrimeiroBimestre(), matricula.getNotaSegundoBimestre(), matricula.getNotaTerceiroBimestre(), matricula.getNotaQuartoBimestre()};
            switch (bimestre) {
                case 1:
                    matricula.setNotaPrimeiroBimestre(nota);
                    matricula.media(notas);
                    break;
                case 2:
                    matricula.setNotaSegundoBimestre(nota);
                    matricula.mediaPonderada(notas, peso);
                    break;
                case 3:
                    matricula.setNotaTerceiroBimestre(nota);
                    matricula.media(notas);
                    break;
                case 4:
                    matricula.setNotaQuartoBimestre(nota);
                    matricula.mediaPonderada(notas, peso);
                    break;
                default:
                    System.out.println("Opcão invalida");
            }
    }

    public static void mostrarBoletin(){
        int idAluno = 0;
        int ano = 0;
        Disciplina disciplina = new Disciplina();
        DisciplinaPratica disciplinaPratica = new DisciplinaPratica();
        Matricula matricula = new Matricula();
        System.out.println("ID do aluno :");
        System.out.println(idAluno);
        System.out.println("Disciplina: ");
        System.out.println(disciplina.getNome());
        System.out.println("Carga Horaria: ");
        System.out.println(disciplina.getCargaHorariaGeral());
        System.out.println("Carga Horaria pratica: ");
        System.out.println(disciplinaPratica.getCargaHorariaPratica());
        System.out.println("Nota primeiro bimestre: ");
        System.out.println(matricula.getNotaPrimeiroBimestre());
        System.out.println("Nota segundo bimestre: ");
        System.out.println(matricula.getNotaSegundoBimestre());
        System.out.println("Nota terceiro bimestre: ");
        System.out.println(matricula.getNotaTerceiroBimestre());
        System.out.println("Nota primeiro bimestre: ");
        System.out.println(matricula.getNotaQuartoBimestre());
        System.out.println("Média: ");
        System.out.println(matricula.getMedia());
        System.out.println("Situação: ");
        System.out.println(matricula.isAprovado());
    }

    public static void main(String[] args) throws ParseException {
	// write your code here


        menu();

    }
}
