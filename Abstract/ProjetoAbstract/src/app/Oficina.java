package app;

import java.util.ArrayList;
import java.util.Random;

public class Oficina {
    Random rnd = new Random();
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Veiculo proximo() {
        int opt = rnd.nextInt(2);
        if (opt == 0) {
            return getAutomovel();
        } else {
            return getBicicleta();
        }
    }

    public void manutencao(Veiculo v) {
        try {
            System.out.println();
            v.listarVerificacoes();
            System.out.print("Verificando");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            System.out.println();
            v.ajustar();
            System.out.print("Limpando");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            System.out.println();
            v.limpar();
            if(v instanceof Automovel){
                System.out.print("Trocando oleo");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println(".");
                ((Automovel) v).trocarOleo();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Bicicleta getBicicleta() {
        Bicicleta aux = new Bicicleta();
        aux.setMarca(getMarcaBicicleta());
        aux.setModelo(rnd.nextInt(6) + 1);
        aux.setAno(rnd.nextInt(30) + 1990);
        aux.setCor(getCor());
        aux.setnMarchas(rnd.nextInt(rnd.nextInt(27) + 1));
        aux.setTamQuadro(rnd.nextInt(5) + 15);
        aux.setTipoFreio(getFreioBicicleta());
        veiculos.add(aux);
        return aux;
    }

    public Automovel getAutomovel() {
        Automovel aux = new Automovel();
        aux.setMarca(getMarcaAutomovel());
        aux.setModelo(rnd.nextInt(6) + 1);
        aux.setAno(rnd.nextInt(30) + 1990);
        aux.setCor(getCor());
        aux.setCombustivel(getCombustivel());
        aux.setPotencia(rnd.nextInt(200) + 100);
        aux.setNportas((rnd.nextInt(1) == 0) ? 2 : 4);
        veiculos.add(aux);
        return aux;
    }
    

    private String getCombustivel() {
        int opt = rnd.nextInt(6);
        switch (opt) {
            case 0:
                return "Etanol";
            case 1:
                return "Gas";
            case 2:
                return "Diesel";
            case 3:
                return "Eletricidade";
            default:
                return "Gasolina";
        }
    }

    private String getMarcaAutomovel() {
        int opt = rnd.nextInt(7);
        switch (opt) {
            case 0:
                return "Nissan";
            case 1:
                return "Toyota";
            case 2:
                return "Volkswagen";
            case 3:
                return "Ford";
            case 4:
                return "Honda";
            case 5:
                return "Hyundai";
            default:
                return "Chevrolet";
        }
    }

    private String getFreioBicicleta() {
        int opt = rnd.nextInt(4);
        switch (opt) {
            case 0:
                return "V-Brake";
            case 1:
                return "Cantilever";
            case 2:
                return "Freio a disco mecanico";
            default:
                return "Freio a disco hidraulico";
        }
    }

    private String getCor() {
        int opt = rnd.nextInt(7);
        switch (opt) {
            case 0:
                return "Branco";
            case 1:
                return "Vermelho";
            case 2:
                return "Azul";
            case 3:
                return "Cinza";
            case 4:
                return "Preto";
            case 5:
                return "Amarelo";
            default:
                return "Laranja";
        }
    }

    private String getMarcaBicicleta() {
        int opt = rnd.nextInt(7);
        switch (opt) {
            case 0:
                return "Trek";
            case 1:
                return "Cervelo";
            case 2:
                return "Giant";
            case 3:
                return "Caloi";
            case 4:
                return "Cannondale";
            case 5:
                return "Pinarello";
        
            default:
                return "Bianchi";
        }
    }

}