package classes;

class Aluno{
    private String nome;
    public double[] notas = new double[4];
    private double media;

    public void setNome(String Nome){
        this.nome = Nome;
    }

    public void setNota(int pos, Double Nota){
        this.notas[pos] = Nota;
    }

    public double getNota(int pos){
        return this.notas[pos];
    }

    public String getNome(){
        return this.nome;
    }

    public void setMedia(){
        this.media = 0;
        for (double i : this.notas) {
            this.media += i;
        }
        this.media /= 4;
    }

    public double getMedia(){
        return this.media;
    }
}