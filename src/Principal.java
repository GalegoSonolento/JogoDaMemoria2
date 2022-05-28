public class Principal {
    public static void main(String[] args) {
        //Cria o jogo para chamar os métodos iniciais
        Jogo j1 = new Jogo();
        j1.titulo();
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        System.out.println("Nativo de Java!");
        try{
            Thread.sleep(500);
        }catch(Exception e){}
        //Pergunta se quer entrar no jogo e fornecer os dados de jogadores e níveis
        char entrar = Teclado.leChar("Digite 'S' para entrar no jogo! Ou outra tecla para cancelar: ");
        if (entrar == 'S'){
            System.out.println("Bem vindo ao Jogo da Memória 2 nativo de Java!");
            System.out.println("Novo Jogo!");
            //Aponta a variável j1 para um novo objeto de Jogo, que rodará o game propriamente.
            j1 = new Jogo(j1.quantPlayers(), j1.quantNiveis());
            j1.menu();
        }
        else {
            //Roda se o jogador não quiser passar da tela inicial.
            j1.mongus();
        }
    }
}
