package classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    public int TAM;
    public double mediaTurma;
    ArrayList<Aluno> Alunos = new ArrayList<Aluno>();

    public void receberAlunos() {
        Scanner in = new Scanner(System.in);
        int opt;
        System.out.println("Entrada por:\n" + "1. Texto\n" + "2. Teclado");
        opt = in.nextInt();
        in.nextLine();
        switch (opt) {
            case 1:
                try {
                    entradaTexto();
                } catch (Exception e) {
                    System.out.println("Erro");
                }
                break;
            case 2:
                entradaTeclado();
                break;
            default:
                System.out.println("Comando nao reconhecido");
        }
    }

    private void entradaTeclado() {
        Scanner in = new Scanner(System.in);
        System.out.println("Tamanho da turma:");
        this.TAM = in.nextInt();
        in.nextLine();
        System.out.println("----------Alunos----------");
        for (int i = 0; i < TAM; i++) {
            Aluno aux = new Aluno();
            this.Alunos.add(aux);
            System.out.println("Nome:");
            Alunos.get(i).setNome(in.nextLine());
            System.out.println("Notas:");
            for (int j = 0; j < 4; j++) {
                Alunos.get(i).setNota(j, in.nextDouble());
                in.nextLine();
            }
            Alunos.get(i).setMedia();

        }
        System.out.println("----------turma encerrada----------");
        in.close();
    }

    private void entradaTexto() throws IOException {
        InputStream is = new FileInputStream("texto.txt");
        InputStreamReader isr = new InputStreamReader(is);
        Scanner in = new Scanner(isr);
        this.TAM = in.nextInt();
        in.nextLine();
        for (int i = 0; i < TAM; i++) {
            Aluno aux = new Aluno();
            this.Alunos.add(aux);
            Alunos.get(i).setNome(in.nextLine());
            for (int j = 0; j < 4; j++) {
                Alunos.get(i).setNota(j, in.nextDouble());
                in.nextLine();
            }
            Alunos.get(i).setMedia();
        }
    }

    public void sortArray() {
        Aluno temp;
        for (int i = 1; i < TAM; i++) {
            for (int j = i; j > 0; j--) {
                if (Alunos.get(j).getMedia() > Alunos.get(j - 1).getMedia()) {
                    temp = Alunos.get(j);
                    Alunos.set(j, Alunos.get(j - 1));
                    Alunos.set(j - 1, temp);
                }
            }
        }
    }

    public void printAlunos() throws IOException {
        PrintStream ps = new PrintStream("src/medias.txt");
        sortArray();
        System.out.println("----------Alunos----------");
        ps.println("----------Alunos----------");
        for (Aluno aluno : Alunos) {
            System.out.printf("Aluno: %s, Media: %.2f\n", aluno.getNome(), aluno.getMedia());
            ps.printf("Aluno: %s, Media: %.2f\n", aluno.getNome(), aluno.getMedia());
        }
        System.out.println("----------Media Turma----------");
        ps.println("----------Media Turma----------");
        double totalMediaTurma = 0;
        for (Aluno aluno : Alunos) {
            totalMediaTurma += aluno.getMedia();
        }
        this.mediaTurma = totalMediaTurma / this.TAM;
        System.out.printf("%.2f\n", this.mediaTurma);
        ps.printf("%.2f\n", this.mediaTurma);
    }

}
