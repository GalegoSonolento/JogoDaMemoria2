public class Teste {
    public static void main(String[] args){
        //Nivel sus = new Nivel(1);
        //sus.inicializaNivel(5);
        Jogo j1 = new Jogo(2, 2);
        //j1.imprimeCenario();
        Jogador jooj = new Jogador("Roberto" , 1);
        System.out.println(j1.executaJogada(jooj));
    }
}
