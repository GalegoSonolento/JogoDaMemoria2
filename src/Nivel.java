public class Nivel {
    private int[] casa;
    private int idLvl;

    // Esse método aqui é o que eu uso para mostrar a fase para o jogador.
    // É o jeito que eu encontrei para mostrar cada fase separademente surante as rodadas.
    public int[] getCasaImp() {
        for (int i=0; i<casa.length; i++){
            System.out.print(" | "+"0"+(i+1));
            if (i == casa.length-1)
                System.out.print(" | ");
        }
        return casa;
    }
    /*Esse é o método que foi pedido para printar todo o mapa na tela.*/
    public int[] imprimeFase(){
        for (int i=0; i<casa.length; i++){
            System.out.print(" | "+casa[i]);
            if (i == casa.length-1)
                System.out.print(" | ");
        }
        return casa;
    }
    // Métodos de acesso
    public int[] getCasa(){
        return casa;
    }

    public void setCasa(int[] casa) {
        this.casa = casa;
    }

    public int getIdLvl() {
        return idLvl;
    }

    public void setId(int idLvl) {
        this.idLvl = idLvl;
    }

    //Construtor da classe
    public Nivel(int idLvl){
        this.idLvl = idLvl;
    }

    //Método para criar o campo de um nível.
    public void inicializaNivel(int quantJogadores){
        casa = new int[quantJogadores * 3];
        int min = 1;
        int max = quantJogadores;
        int range = (max - min) + 1;
        for (int i=0; i<casa.length; i++)
            while (true){
                int numCasa = (int)(Math.random() * range) + min;
                int cont = 0;
                for (int j=0; j<casa.length; j++)
                    if (casa[j] != 0)
                        if (casa[j] == numCasa) cont += 1;
                if (cont < 3){
                    casa[i] = numCasa;
                    cont = 0;
                    break;
                }
            }
    }
}
