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

    // fazer verificação pra caso tente colocar mais disciplinas que o limite
    public void adicionarDisciplina(String nomeDisciplina, String profResponsavel) {

        for (int i = 0; i < disciplinasOferecidas.length; i++) {

            if (disciplinasOferecidas[i] == null) {
                Disciplina novaDisciplina = new Disciplina(nomeDisciplina, profResponsavel);
                disciplinasOferecidas[posicao] = novaDisciplina;
                posicao++;
                System.out.println("Disciplina cadastrada com sucesso!");
                return;
            } else if (nomeDisciplina.equals(disciplinasOferecidas[i].getNome())) {
                System.out.println("Disciplina já cadastrada.");
                return;
            }
        }

    }

    // fazer verificação pra caso tente colocar mais estudantes que o limite
    // colocar pra listar os estudantes criados igual eu fiz com as disciplinas pra
    // ver se ta criando certinho sem duplicar nem nada
    public void criarEstudante(String nomeEstudante, String dataNascimento) {
        for (int i = 0; i < estudantesCriados.length; i++) {

            if (estudantesCriados[i] == null) {
                Estudante novoEstudante = new Estudante(nomeEstudante, dataNascimento);
                estudantesCriados[posicaoEstudantes] = novoEstudante;
                posicaoEstudantes++;
                System.out.println("Estudante criado com sucesso!");
                return;
            } else if (nomeEstudante.equals(estudantesCriados[i].getNome())) {
                System.out.println("Estudante já cadastrado.");
                return;
            }
        }
    }

    public void matricularEstudante(String nomeEstudante, String nomeDisciplina) {
        Disciplina disciplinaEncontrada = null;
        Estudante estudanteEncontrado = null;

        for (int i = 0; i < estudantesCriados.length; i++) {
            if (estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
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
        if (disciplinaEncontrada != null && estudanteEncontrado != null) {
            estudanteEncontrado.matricularEstudante(nomeDisciplina);
            disciplinaEncontrada.matricularEstudante(estudanteEncontrado);
            System.out.println("Estudante matriculado com sucesso!");
        }
    }

    public void adicionarNota(String nomeEstudante, String nomeDisciplina, double nota) {
        boolean encontrouDisciplina = false;
        Estudante estudanteEncontrado = null;

        for (int i = 0; i < estudantesCriados.length; i++) {
            if (estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                encontrouDisciplina = true;
                break;
            }
        }

        if (!encontrouDisciplina) {
            System.out.println("Disciplina não encontrada.");
        } else if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado.");
        } else if (encontrouDisciplina && estudanteEncontrado != null) {
            estudanteEncontrado.adicionarNota(nota, nomeDisciplina);
            System.out.println("Nota adicionada com sucesso!");
            // System.out.println(estudanteEncontrado.getNota());
        }
    }

    public void calcularMedia(String nomeEstudante) {
        Estudante estudanteEncontrado = null;

        for (int i = 0; i < estudantesCriados.length; i++) {
            if (estudantesCriados[i].getNome().equals(nomeEstudante)) {
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

        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i].getNome().equals(nomeDisciplina)) {
                disciplinaEncontrada = disciplinasOferecidas[i];
                break;
            }
        }

        if (disciplinaEncontrada == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        } else {
            disciplinaEncontrada.estudantesReprovados(nomeDisciplina);
        }
    }

    public void transferirEstudante(String nomeDisciplinaAntiga, String nomeEstudante, String nomeDisciplinaNova) {
        Disciplina disciplinaAntiga = null;
        Disciplina disciplinaNova = null;
        Estudante estudanteEncontrado = null;

        // achar disciplina antiga
        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i].getNome().equals(nomeDisciplinaAntiga)) {
                disciplinaAntiga = disciplinasOferecidas[i];
                break;
            }
        }

        // achar disciplina nova
        for (int i = 0; i < disciplinasOferecidas.length; i++) {
            if (disciplinasOferecidas[i].getNome().equals(nomeDisciplinaNova)) {
                disciplinaNova = disciplinasOferecidas[i];
                break;
            }
        }

        // achar estudante
        for (int i = 0; i < estudantesCriados.length; i++) {
            if (estudantesCriados[i].getNome().equals(nomeEstudante)) {
                estudanteEncontrado = estudantesCriados[i];
                break;
            }
        }

        if (disciplinaAntiga == null) {
            System.out.println("Disciplina para remover não encontrada.");
            return;
        }

        if (disciplinaNova == null) {
            System.out.println("Disciplina para adicionar não encontrada.");
            return;
        }

        if (estudanteEncontrado == null) {
            System.out.println("Estudante não encontrado");
        }

        if (disciplinaAntiga != null && disciplinaNova != null && estudanteEncontrado != null) {
            
        }
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
