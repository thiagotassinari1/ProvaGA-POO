package ProvaGA;

public class Disciplina {
    private String nomeDisciplina;
    private String profResponsavel;
    private Estudante[] estudantesMatriculados;
    private int posicao;

    public Disciplina(String nomeDisciplina, String profResponsavel) {
        this.nomeDisciplina = nomeDisciplina;
        this.profResponsavel = profResponsavel;
        this.estudantesMatriculados = new Estudante[50];
        this.posicao = 0;

    }

    public String getNome() {
        return this.nomeDisciplina;
    }

    public void matricularEstudante(Estudante estudanteMatriculado) {
        if (posicao < estudantesMatriculados.length) {
            estudantesMatriculados[posicao] = estudanteMatriculado;
            posicao++;
        } else {
            System.out.println("Número máximo de estudantes matriculados atingido.");
        }

    }

    public void estudantesReprovados(String nomeDisciplina) {
        System.out.println("Estudantes reprovados em " + nomeDisciplina + ":");

        boolean reprovado = false;
        for (int i = 0; i < estudantesMatriculados.length; i++) {
            if (estudantesMatriculados[i] != null && estudantesMatriculados[i].notaDisciplina(nomeDisciplina) < 6.0) {
                System.out.println(estudantesMatriculados[i].toString());
                reprovado = true;
            }
        }

        if (!reprovado) {
            System.out.println("Nenhum estudante reprovado.");
        }
    }

    public void removerEstudante(String nomeEstudante) {
        int indiceRemover = -1;

        for (int i = 0; i < estudantesMatriculados.length; i++) {
            if (estudantesMatriculados[i] != null && estudantesMatriculados[i].getNome().equals(nomeEstudante)) {
                indiceRemover = i;
                break;
            }
        }

        if (indiceRemover != -1) {
            // lógica pra arrumar os elementos dentro do array
            for (int i = indiceRemover; i < posicao - 1; i++) {
                estudantesMatriculados[i] = estudantesMatriculados[i + 1];
            }

            // limpar a última posição
            estudantesMatriculados[posicao - 1] = null;
            posicao--;

            System.out.println("Estudante removido da disciplia " + nomeDisciplina + " com sucesso!");
        } else {
            System.out.println("Estudante não encontrado na disciplina " + nomeDisciplina);
        }

    }

    @Override
    public String toString() {
        return "-------------------------" + "\n" +
                "Nome: " + nomeDisciplina + "\n" +
                "Professor: " + profResponsavel + "\n" +
                "Estudantes matriculados: " + estudantesMatriculados +
                "-------------------------";
    }
}
