package apresentacao;

import java.util.Scanner;

import classes.*;
import negocios.SistemaBiblioteca;

public class Principal {
    private static Scanner in = new Scanner(System.in);
    private static SistemaBiblioteca sis = new SistemaBiblioteca();

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("\nMenu principal");
            System.out.println("Opcoes:n"
                    + "1. Professores\n"
                    + "2. Alunos\n"
                    + "3. Pessoas\n"
                    + "4. Sair");
            int op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    professores();
                    break;
                case 2:
                    alunos();
                    break;
                case 3:
                    pessoas();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Codigo nao reconhecido");
            }
        }
        in.close();
    }

    private static void alunos() {


    }

    private static void professores() {
        System.out.println("Opcoes:\n"
                + "1. Mostrar todos os professores\n"
                + "2. Mostrar professores por salario\n"
                + "3. Cadastrar professor");
        int op = in.nextInt();
        in.nextLine();
        switch (op) {
            case 1:
                for (Professor professor : sis.listaProfessores()) {
                    System.out.printf(professor.toString());
                }
            case 2:
                System.out.println("Salario maior ou igual a:");
                for (Professor professor : sis.listaProfessoresSalario(in.nextInt())) {
                    System.out.println(professor.toString());
                }
                in.nextLine();
            case 3:
                System.out.println("Nome:");

        }
    }


}
