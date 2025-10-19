package ProvaGA;

public class Escola {
    private String nomeEscola;
    private String cnpj;
    private Disciplina[] disciplinasOferecidas;
    private Estudante[] estudantesCriados;
    private int posicao;
    private int posicaoEstudantes;

    public Escola(String nomeEscola, String cnpj) {
        this.nomeEscola = nomeEscola;
        this.cnpj = cnpj;
        this.disciplinasOferecidas = new Disciplina[10];
        this.estudantesCriados = new Estudante[500];
        this.posicao = 0;
        this.posicaoEstudantes = 0;
    }

    public void adicionarDisciplina(String nomeDisciplina, String profResponsavel) {

        if (posicao < disciplinasOferecidas.length) {
            for (int i = 0; i < posicao; i++) {
                if (disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                    System.out.println("Disciplina já cadastrada.");
                    return;
                }
            }

            Disciplina novaDisciplina = new Disciplina(nomeDisciplina, profResponsavel);
            disciplinasOferecidas[posicao] = novaDisciplina;
            posicao++;
            System.out.println("Disciplina cadastrada com sucesso!");
        } else {
            System.out.println("Não é possível criar mais disciplinas. Limite atingido.");
            return;
        }

    }

    public void criarEstudante(String nomeEstudante, String dataNascimento) {

        if (posicaoEstudantes < estudantesCriados.length) {
            for (int i = 0; i < posicaoEstudantes; i++) {
                if (estudantesCriados[i].getNome().equals(nomeEstudante)) {
                    System.out.println("Estudante já cadastrado.");
                    return;
                }
            }

            Estudante novoEstudante = new Estudante(nomeEstudante, dataNascimento);
            estudantesCriados[posicaoEstudantes] = novoEstudante;
            posicaoEstudantes++;
            System.out.println("Estudante criado com sucesso!");
        } else {
            System.out.println("Não é possível criar mais estudantes. Limite atingido.");
            return;
        }
    }

    public void matricularEstudante(String nomeEstudante, String nomeDisciplina) {
        Disciplina disciplinaEncontrada = null;
        Estudante estudanteEncontrado = null;

        // achar estudante
        for (int i = 0; i < posicaoEstudantes; i++) {
            if (estudantesCriados[i] != null && estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        // achar disciplina
        for (int i = 0; i < posicao; i++) {
            if (disciplinasOferecidas[i] != null && disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                disciplinaEncontrada = disciplinasOferecidas[i];
                break;
            }
        }

        if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado.");
            return;
        }
        if (disciplinaEncontrada == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        if (estudanteEncontrado.estaMatriculado(nomeDisciplina)) {
            System.out.println("O estudante " + nomeEstudante + " já está matriculado em " + nomeDisciplina + ".");
            return;
        }

        estudanteEncontrado.matricularEstudante(nomeDisciplina);
        disciplinaEncontrada.matricularEstudante(estudanteEncontrado);
        System.out.println("Estudante matriculado com sucesso!");
    }

    public void adicionarNota(String nomeEstudante, String nomeDisciplina, double nota) {
        boolean encontrouDisciplina = false;
        Estudante estudanteEncontrado = null;

        // achar estudante
        for (int i = 0; i < posicaoEstudantes; i++) {
            if (estudantesCriados[i] != null && estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        // achar disciplina
        for (int i = 0; i < posicao; i++) {
            if (disciplinasOferecidas[i] != null && disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                encontrouDisciplina = true;
                break;
            }
        }

        if (!encontrouDisciplina) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado.");
            return;
        }

        if (!estudanteEncontrado.estaMatriculado(nomeDisciplina)) {
            System.out.println("O estudante não está matriculado na disciplina informada.");
            return;
        }

        estudanteEncontrado.adicionarNota(nota, nomeDisciplina);
        System.out.println("Nota adicionada com sucesso!");

    }

    public void calcularMedia(String nomeEstudante) {
        Estudante estudanteEncontrado = null;

        // achar estudante
        for (int i = 0; i < posicaoEstudantes; i++) {
            if (estudantesCriados[i] != null && estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado.");
        } else {
            estudanteEncontrado.calcularMedia();
        }
    }

    public void estudantesReprovados(String nomeDisciplina) {
        Disciplina disciplinaEncontrada = null;

        // achar disciplina
        for (int i = 0; i < posicao; i++) {
            if (disciplinasOferecidas[i] != null && disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                disciplinaEncontrada = disciplinasOferecidas[i];
                break;
            }
        }

        if (disciplinaEncontrada == null) {
            System.out.println("Disciplina não encontrada.");
        } else {
            disciplinaEncontrada.estudantesReprovados(nomeDisciplina);
        }
    }

    public void transferirEstudante(String nomeEstudante, String nomeDisciplinaAntiga, String nomeDisciplinaNova) {
        Disciplina disciplinaAntiga = null;
        Disciplina disciplinaNova = null;
        Estudante estudanteEncontrado = null;

        // achar estudante
        for (int i = 0; i < posicaoEstudantes; i++) {
            if (estudantesCriados[i] != null && estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        // achar disciplina antiga
        for (int i = 0; i < posicao; i++) {
            if (disciplinasOferecidas[i] != null && disciplinasOferecidas[i].getNome().equals(nomeDisciplinaAntiga)) {
                disciplinaAntiga = disciplinasOferecidas[i];
                break;
            }
        }

        // achar disciplina nova
        for (int i = 0; i < posicao; i++) {
            if (disciplinasOferecidas[i] != null && disciplinasOferecidas[i].getNome().equals(nomeDisciplinaNova)) {
                disciplinaNova = disciplinasOferecidas[i];
                break;
            }
        }

        if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado.");
            return;
        }

        if (disciplinaAntiga == null) {
            System.out.println("Disciplina para remover não encontrada.");
            return;
        }

        if (disciplinaNova == null) {
            System.out.println("Disciplina para adicionar não encontrada.");
            return;
        }

        disciplinaAntiga.removerEstudante(nomeEstudante);
        disciplinaNova.matricularEstudante(estudanteEncontrado);
        estudanteEncontrado.removerDisciplina(nomeDisciplinaAntiga);
        estudanteEncontrado.matricularEstudante(nomeDisciplinaNova);

        System.out.println("Estudante " + nomeEstudante + " transferido de " + nomeDisciplinaAntiga + " para "
                + nomeDisciplinaNova + " com sucesso!");
    }

    public void listarDisciplinas() {
        System.out.println("\n--- Disciplinas cadastradas ---");

        boolean temDisciplina = false;
        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i] != null) {
                System.out.println(disciplinasOferecidas[i].toString());
                temDisciplina = true;
            }
        }

        if (!temDisciplina) {
            System.out.println("Nenhuma disciplina cadastrada ainda.");
        }
    }

    public void listarEstudantes() {
        System.out.println("\n--- Estudantes cadastrados ---");

        boolean temEstudante = false;
        for (int i = 0; i < estudantesCriados.length; i++) {
            if (estudantesCriados[i] != null) {
                System.out.println(estudantesCriados[i].toString());
                temEstudante = true;
            }
        }

        if (!temEstudante) {
            System.out.println("Nenhum estudante cadastrado ainda.");
        }
    }

    @Override
    public String toString() {
        return "-------------------------" + "\n" +
                "Nome: " + nomeEscola + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "-------------------------";
    }
}
