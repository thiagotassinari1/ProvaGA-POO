package ProvaGA;

import java.util.Scanner;

public class Main {

    public static boolean verificarEscolaExiste(Escola escola) {
        if (escola == null) {
            System.out.println("Crie uma escola primeiro.");
            return false;
        }
        return true;
    }

    public static Escola criarEscola(Scanner sc) {
        System.out.print("Nome da escola: ");
        sc.nextLine();
        String nomeEscola = sc.nextLine().trim();

        System.out.print("CNPJ da escola: ");
        String cnpj = sc.nextLine().trim();

        Escola escola = new Escola(nomeEscola, cnpj);

        return escola;
    }

    public static void adicionarDisciplina(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome da disciplina: ");
        sc.nextLine();
        String nomeDisciplina = sc.nextLine().trim();

        System.out.print("Nome do professor responsável: ");
        String profResponsavel = sc.nextLine().trim();

        escolaCriada.adicionarDisciplina(nomeDisciplina, profResponsavel);
    }

    public static void criarEstudante(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome do estudante: ");
        sc.nextLine();
        String nomeEstudante = sc.nextLine().trim();

        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        String dataNascimento = sc.nextLine().trim();

        escolaCriada.criarEstudante(nomeEstudante, dataNascimento);
    }

    public static void matricularEstudante(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome do estudante para matricular: ");
        sc.nextLine();
        String nomeEstudante = sc.nextLine().trim();

        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = sc.nextLine().trim();

        escolaCriada.matricularEstudante(nomeEstudante, nomeDisciplina);
    }

    public static void adicionarNota(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome do estudante: ");
        sc.nextLine();
        String nomeEstudante = sc.nextLine().trim();

        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = sc.nextLine().trim();

        System.out.print("Nota (6,5): ");
        double nota = sc.nextDouble();

        escolaCriada.adicionarNota(nomeEstudante, nomeDisciplina, nota);
    }

    public static void calcularMedia(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome do estudante: ");
        sc.nextLine();
        String nomeEstudante = sc.nextLine().trim();

        escolaCriada.calcularMedia(nomeEstudante);
    }

    public static void estudantesReprovados(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome da disciplina: ");
        sc.nextLine();
        String nomeDisciplina = sc.nextLine().trim();

        escolaCriada.estudantesReprovados(nomeDisciplina);
    }

    public static void transferirEstudante(Scanner sc, Escola escolaCriada) {
        System.out.print("Nome do estudante: ");
        sc.nextLine();
        String nomeEstudante = sc.nextLine().trim();

        System.out.print("Nome da disciplina para remover: ");
        String disciplinaAntiga = sc.nextLine().trim();

        System.out.print("Nome da nova disciplina: ");
        String disciplinaNova = sc.nextLine().trim();

        escolaCriada.transferirEstudante(nomeEstudante, disciplinaAntiga, disciplinaNova);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Escola escolaCriada = null;

        int escolha = -1;
        while (escolha != 0) {
            System.out.println("\nMenu de opções:");
            System.out.println("1 - Criar escola;");
            System.out.println("2 - Adicionar disciplina;");
            System.out.println("3 - Criar estudante;");
            System.out.println("4 - Matricular estudante;");
            System.out.println("5 - Adicionar nota de estudantes;");
            System.out.println("6 - Calcular média das notas de um estudante;");
            System.out.println("7 - Estudantes reprovados de alguma disciplina;");
            System.out.println("8 - Transferir estudante;");
            System.out.println("0 - Sair.");
            System.out.print("\nEscolha uma opção: ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    escolaCriada = criarEscola(sc);
                    break;
                case 2:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    adicionarDisciplina(sc, escolaCriada);
                    break;
                case 3:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    criarEstudante(sc, escolaCriada);
                    break;
                case 4:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    matricularEstudante(sc, escolaCriada);
                    break;
                case 5:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    adicionarNota(sc, escolaCriada);
                    break;
                case 6:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    calcularMedia(sc, escolaCriada);
                    break;
                case 7:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    estudantesReprovados(sc, escolaCriada);
                    break;
                case 8:
                    if (!verificarEscolaExiste(escolaCriada)) {
                        break;
                    }
                    transferirEstudante(sc, escolaCriada);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");

                    break;
                default:
                    System.out.print("Opção desconhecida.");
                    break;
            }
        }

        sc.close();
    }
}
