package ProvaGA;

import java.util.Arrays;

public class Estudante {
    private String nomeEstudante;
    private String dataNascimento;
    private String[] disciplinas;
    private double[] notas;
    private int posicao;

    public Estudante(String nomeEstudante, String dataNascimento) {
        this.nomeEstudante = nomeEstudante;
        this.dataNascimento = dataNascimento;
        this.disciplinas = new String[10];
        this.notas = new double[10];
        Arrays.fill(notas, -1);
        this.posicao = 0;
    }

    public String getNome() {
        return this.nomeEstudante;
    }

    public void matricularEstudante(String nomeDisciplina) {
        disciplinas[posicao] = nomeDisciplina;
        notas[posicao] = -1;
        posicao++;
    }

    public void adicionarNota(double nota, String nomeDisciplina) {
        boolean disciplinaEncontrada = false;
        int indiceDisciplinaEncontrada = 0;

        for (int i = 0; i < disciplinas.length; i++) {
            if (nomeDisciplina.equals(disciplinas[i])) {
                disciplinaEncontrada = true;
                indiceDisciplinaEncontrada = i;
                break;
            }
        }

        if (disciplinaEncontrada) {
            notas[indiceDisciplinaEncontrada] = nota;
        }

    }

    public void calcularMedia() {
        int qtdNotas = 0;
        double somaNotas = 0.0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != -1) {
                qtdNotas++;
                somaNotas += notas[i];
            }
        }

        if (qtdNotas <= 0) {
            System.out.println("Não há notas para calcular a média.");
        } else {
            System.out.println("Média do aluno: %.2f".formatted(somaNotas / qtdNotas));
        }
    }

    public double notaDisciplina(String nomeDisciplina) {

        for (int i = 0; i < disciplinas.length; i++) {
            if (nomeDisciplina.equals(disciplinas[i])) {
                return notas[i];
            }
        }

        System.out.println("Estudante não está matriculado na disciplina informada.");
        return -1;

    }

    public void removerDisciplina() {
        
    }

    // public double getNota() {
    // return this.notas[0];
    // }

    @Override
    public String toString() {
        return "-------------------------" + "\n" +
                "Nome: " + nomeEstudante + "\n" +
                "Data nascimento: " + dataNascimento + "\n" +
                "Disciplinas: " + Arrays.toString(disciplinas) + "\n" +
                "Notas: " + Arrays.toString(notas)  + "\n" +
                "-------------------------";
    }
}