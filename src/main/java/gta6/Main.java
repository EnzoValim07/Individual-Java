package gta6;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonagemDAO dao = new PersonagemDAO();
        int opcao;

        do {
            System.out.println("\n=== GTA VI - Registro de Personagens ===");
            System.out.println("1 - Cadastrar personagem");
            System.out.println("2 - Cadastrar criminoso");
            System.out.println("3 - Listar todos");
            System.out.println("4 - Buscar por nome");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();
                        dao.inserir(new Personagem(nome, cidade));
                        System.out.println("Personagem cadastrado!");
                    }
                    case 2 -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();
                        System.out.print("Nível de procurado (1-5): ");
                        int nivel = Integer.parseInt(sc.nextLine());
                        System.out.print("Crime principal: ");
                        String crime = sc.nextLine();
                        dao.inserir(new Criminoso(nome, cidade, nivel, crime));
                        System.out.println("Criminoso cadastrado!");
                    }
                    case 3 -> mostrar(dao.listar());
                    case 4 -> {
                        System.out.print("Nome para buscar: ");
                        mostrar(dao.buscarPorNome(sc.nextLine()));
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void mostrar(List<Personagem> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nada encontrado.");
            return;
        }
        lista.forEach(System.out::println);
    }
}
