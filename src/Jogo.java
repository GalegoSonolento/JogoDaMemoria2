public class Jogo {
    private Nivel[] level;
    private Jogador[] players;

    //Inicializa todos os níveis do jogo antes de começar
    public Jogo(int quantJogadores, int quantNiveis){
        level = new Nivel[quantNiveis];
        for (int i=0; i<level.length; i++){
            level[i] = new Nivel(i+1);
            level[i].inicializaNivel(quantJogadores);
        }
        criaJogador(quantJogadores);
    }
    //Essa classe eu usei para conseguir chamar os métodos da classe jogo na classe Principal.
    //Esse método tem apenas a função de iniciação e não é mais usado depois disso.
    public Jogo(){
    }
    /*Esse é o método que imprime todo o mapa do jogo (com os id's das casas)*/
    public void imprimeCenario(){
        for (int i=0; i< level.length; i++){
            System.out.print("Nível "+level[i].getIdLvl()+" - ");
            level[i].imprimeFase();
            System.out.println(" ");
        }
    }
    /*Esse método vai preencher a array de jogadores (completamente) com todos os jogadores que joga*/
    public void criaJogador(int quantJogadores){
        players = new Jogador[quantJogadores];
        for (int i=1; i<=quantJogadores; i++){
            players[i-1] = new Jogador(Teclado.leString("Digite o nome do jogador: "), i);
        }
    }
    /*Esse é o método que executa as jogadas dos jogadores e analisa se eles cehgaram ou não ao final do jogo.
    * Muitas vezes ele só funciona até a metade, já que só roda todo o código qunado o jogador termina o jogo
    *propriamente.*/
    public boolean executaJogada(Jogador j){
        System.out.println("====================");
        boolean acertou = false;
        for (int i=0; i< level.length; i++){
            System.out.print("Nível "+(i+1)+" - ");
            level[i].getCasaImp();
            System.out.println(" ");
            int opcao = Teclado.leInt("Digíte o número da casa que deseja escolher: ");
            while (true)
                if (opcao < 1 || opcao > level[i].getCasa().length)
                    opcao = Teclado.leInt("Valor inválido. Digite novamente!");
                else break;
            for (int k=0; k<level[i].getCasa().length; k++)
                if (k == opcao-1)
                    if (j.getId() == level[i].getCasa()[k] && i == level.length-1){
                        System.out.println("⠀⠀⠀⠀⠀⠀⢹⣄⣿⣦⣼⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⠿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⢸⣿⠟⠋⠀⠀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⢠⣟⣁⣴⡄⠀⠀⠀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⢿⠛⢉⣠⠀⠀⠀⠀⠸⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠈⣿⣿⠏⠀⠀⠀⠀⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠸⡇⠀⠀⠀⠀⠀⠀⠀⢹⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⣧⣤⣶⠖⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⢻⡉⠁⠀⣀⣤⠀⠀⠀⠀⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⠛⠛⠛⠁⠀⠀⠀⠀⠘⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣦⣤⣶⠿⠀⣀⣤⣤⣶⣿⣿⠒⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠁⢀⣴⣿⣿⣿⣿⣿⣿⣿⡄⣤⣾⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⣹⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⣿⣿⣿⣿⣿⡿⠃⠀⠀⠻⣿⣿⣿⣿⣿⣿⠛⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⠿⠿⣿⠟⠁⠀⠀⠀⠀⠈⠻⢿⣿⣿⡇⢰⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠉⠉⠁⢞⣿⠈⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣳⡄⠀⠀⠀⣠⣴⣾⣯⠖⠀⠀⠀⠀⠀⠹⡇⣰⣿⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠛⠉⢻⣿⣶⣆⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⢧⢉⠇⠈⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⢀⡴⠟⢻⡉⢿⠀⠀⣠⡤⠀⢀⡀⠀⠀⠀⠀⣾⡞⠀⠀⠀⠈⠳⣄⡀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⢀⡴⣋⣤⣀⣰⠏⠀⠀⢸⠳⣼⣦⣴⣿⣿⣿⡿⠛⠀⠀⢀⣼⠟⠀⠀⠀⠀⠀⠀⠈⠙⢦⡀⠀⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⢠⣏⣴⣿⣿⣿⣿⠀⠀⢀⣿⣶⣿⣿⣿⡋⠭⠀⠀⠀⠀⣠⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⠀⠀⠀⠀"+"\n"+
                                           "⠀⠀⠀⢀⣴⠿⠛⠛⠛⢿⣿⣿⣶⣾⣿⣿⣿⣿⣿⣿⠿⣶⣶⣴⣶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⠀⠀⠀"+"\n"+
                                           "⠀⠀⠠⣿⣁⣀⡀⠀⢀⣠⣽⣿⠿⠿⠿⣿⣿⣿⣿⠏⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡄⠀⠀"+"\n"+
                                           "⠀⠀⠀⠈⠉⣻⠇⠀⠘⠋⠁⣀⣀⣤⣴⠾⠟⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢷⠀⠀"+"\n"+
                                           "⠀⠀⢀⣴⠟⠋⠀⢠⣶⡾⠿⠛⣛⣩⣤⣤⣤⡿⠀⠀⠀⠀⠀⠀⠀⢀⣰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠀⠘⡆⠀"+"\n"+
                                           "⠀⠀⠸⣧⡀⠀⣀⠀⠀⣠⣶⠟⠛⠉⠉⠉⣽⠃⠀⠀⠀⠀⢀⣤⠾⠛⢉⡇⠀⠀⢀⣤⣶⠖⠀⠀⠀⠀⠀⠀⢸⠀⠀⢹⡀"+"\n"+
                                           "⠀⠀⠀⠈⠛⠛⢻⡆⠀⠈⠀⣠⣶⠶⠿⢾⡟⠀⠀⠀⣠⡾⠟⠁⣠⠖⠋⣷⣠⣾⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀⠀⣇"+"\n"+
                                           "⠀⠀⠀⠀⠀⣠⣼⠇⠀⠀⠀⠉⠀⢀⣀⣿⠃⠀⢠⠚⠉⢀⡴⠟⠁⠀⢀⣸⣿⣀⣤⣶⣶⣦⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⡿"+"\n"+
                                           "⠀⠀⠀⠀⣾⠋⠀⠀⠀⠀⠀⠀⠐⠛⢻⡟⠀⠀⢸⣠⡶⠋⠀⠀⣠⡶⠟⠉⣿⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⡼⠁"+"\n"+
                                           "⠀⠀⠀⠀⠻⣦⣤⣤⣄⠀⠀⠀⠀⠀⣿⠃⠀⠀⠈⠉⠀⣀⡴⠟⠉⠀⢀⣠⣿⣷⢀⣤⣴⡶⠄⠀⠀⠀⠀⠀⠀⠀⢿⠁⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠈⣿⡀⢀⣀⣴⣾⡏⠀⠀⠀⢀⣤⣾⠋⠀⠀⣀⡴⠛⠁⠀⢻⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⣀⣿⠿⠛⠉⢸⣿⠇⠀⠀⠀⠈⡏⢿⣀⣴⠞⠉⠀⠀⣀⡴⠚⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡇⠀"+"\n"+
                                           "⠀⠀⠀⢀⣤⠶⠛⠉⠀⠀⠀⠀⣼⡿⠀⠀⠀⠀⠀⠙⠼⠋⠁⠀⢀⣤⠞⠉⠀⠀⢻⣤⡾⠷⠆⠀⠀⠀⠀⠀⠀⠀⠀⣷⠀"+"\n"+
                                           "⠀⣠⡾⠋⠁⠀⣠⣴⠿⠛⣻⡿⢿⡇⠀⠀⠀⠀⠀⠀⠀⣠⣴⡞⠋⠀⠀⠀⢀⡤⠿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀"+"\n"+
                                           "⣰⠏⠀⠀⠀⠘⣋⣡⠶⠛⠁⠀⢸⡇⠀⠀⠀⠀⠀⢠⢺⠋⢻⡷⣀⣀⣤⠞⠋⠀⠀⣿⣆⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⣿⠀"+"\n"+
                                           "⠙⠷⠶⠶⠶⠛⠉⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⢣⣣⣀⠳⡽⠋⠀⠀⠀⢀⣴⢿⣿⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⣿⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠀⠀⠀⠀⠀⠀⠀⠀⠙⠓⠋⠀⠀⣀⣠⡶⠋⠀⣼⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡏⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⢫⣿⢿⡀⠀⣠⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀"+"\n"+
                                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠘⠊⠙⠙⠚⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠀⠀");
                        System.out.println("Você venceu o jogo!");
                        try{
                            Thread.sleep(500);
                        }catch(Exception e){}
                        acertou = true;
                    }
                    else if (j.getId() == level[i].getCasa()[k]){
                        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡈⠛⢉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⢿⣿⣿⣿⣿⣿⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⢰⣿⡏⠀⢸⣿⣿⣿⣿⡇⢸⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⣼⣿⠁⠀⢸⣿⣿⣿⣿⠁⠀⠙⠻⢿⣿⣶⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠛⠋⠀⠀⠸⣿⣿⣿⡏⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⠙⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣦⠈⢿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡟⠀⠀⠻⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⠟⠁⠀⠀⠀⠘⢿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⢾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠈⢻⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                        System.out.println("Você passou para o próximo nível!");
                        try{
                            Thread.sleep(500);
                        }catch(Exception e){}
                        acertou = true;
                    }
                    else acertou = false;
            if (!acertou) {
                System.out.println("                                   ██"+"\n"+
                                    "                                ██▒▒██"+"\n"+
                                    "                                ██▒▒██"+"\n"+
                                    "                        ████████▒▒██"+"\n"+
                                    "                    ████▒▒▒▒▒▒██████"+"\n"+
                                    "                ████▒▒▒▒▒▒████▒▒▒▒▒▒██"+"\n"+
                                    "              ██▒▒▒▒▒▒██████▒▒▒▒▒▒▒▒██"+"\n"+
                                    "            ██▒▒██████▒▒▒▒██▒▒▒▒▒▒▒▒██"+"\n"+
                                    "          ██████▒▒██▒▒▒▒▒▒██▒▒▒▒▒▒██"+"\n"+
                                    "      ██████▒▒▒▒▒▒██▒▒▒▒██▒▒▒▒▒▒▒▒██"+"\n"+
                                    "      ██▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒██"+"\n"+
                                    "        ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██"+"\n"+
                                    "          ██████▒▒▒▒▒▒▒▒▒▒████"+"\n"+
                                    "                ██████████");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   "     ⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   "     ⠀⠀⠀⢀⣤⣴⣾⣿⣿⡿⠿⠿⠿⠟⠛⠛⠻⠿⠿⠿⢿⣿⣿⣷⣦⣤⡀⠀⠀⠀"+"\n"+
                                   "     ⠀⢀⣼⣿⡿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⢿⣿⣧⡀⠀"+"\n"+
                                   "     ⠀⢸⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⡇⠀"+"\n"+
                                   "     ⠀⠈⢻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠁⠀"+"\n"+
                                   "     ⠀⠀⠀⠈⠛⠳⢦⣤⣄⣀⣀⡀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⣤⡴⠞⠛⠁⠀⠀⠀"+"\n"+
                                   "     ⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                                   " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("Você errou a casa!");
                try{
                    Thread.sleep(500);
                }catch(Exception e){}
                break;
            }
        }
        return acertou;
    }
    /*Esse método alterna entre os jogadores durante a partida.*/
    public void rodaJogo(){
        //Colocar o método de imprimir cenário aqui
        boolean perdeu = true;
        do {
            for (int i=0; i< players.length; i++){
                System.out.println("====================");
                System.out.println("Rodada do jogador "+players[i].getNome());
                if (executaJogada(players[i])){
                    players[i].setVitorias(players[i].getVitorias()+1);
                    perdeu = false;
                    break;
                }
            }
        }while (perdeu);
    }
    //Apenas a imagem que eu usei para enfeitar a aba de regras do jogo.
    public void imagemImprimeRegras(){
        System.out.println("         ,..........   ..........,"+"\n"+
                           "     ,..,'          '.'          ',..,"+"\n"+
                           "    ,' ,'            :            ', ',"+"\n"+
                           "   ,' ,'             :             ', ',"+"\n"+
                           "  ,' ,'              :              ', ',"+"\n"+
                           " ,' ,'............., : ,.............', ',"+"\n"+
                           ",'  '............   '.'   ............'  ',"+"\n"+
                           " '''''''''''''''''';''';''''''''''''''''''"+"\n"+
                           "                    '''");
    }
    //Imprime as regras do jogo caso o jogador queira lê-las.
    public void imprimeRegras(){
        imagemImprimeRegras();
        System.out.println("----- Regras do Jogo -----"+"\n"+
                "- É muito simples, cada jogador pode pisar em apenas 3 casas dentre todas as do nível."+"\n"+
                "Por exemplo, em um jogo com 2 jogadores, existirão 6 casas por nível, então cada jogador apenas pode pisar em 3 dentre as seis disponíveis."+"\n"+
                "- As casas são sorteadas dentro de cada nível individualmente."+"\n"+
                "- O objetivo é atravessar todos os níveis para ser o vencedor."+"\n"+
                "Mas caso estiver no meio do caminho e errar uma casa, voltará desde o início."+"\n"+
                "Para realizar uma partida com jogadores diferentes, é necessário reiniciar o jogo"+"\n"+
                ""+"\n"+"Bom jogo!");
    }
    /*Menu do jogo. Fiz basicamente o mesmo estilo do trab do grau A. Nada de muito especial, mas ele serve como
    *um controle do jogo.*/
    public void menu(){
        imagemDoMenu();
        int escolha = -1;
        do{
            System.out.println("Bem vindo ao menu da memória 2!"+"\n"+
                    "O que deseja fazer em seguida?"+"\n"+
                    "1 - Regras"+"\n"+
                    "2 - Começar"+"\n"+
                    "3 - Créditos"+"\n"+
                    "4 - Sair");
            for (int i=0; i<players.length; i++){
                System.out.println("Vitórias "+players[i].getNome()+": "+players[i].getVitorias());
            }
            escolha = Teclado.leInt("Digite sua opção [apenas números]: ");
            if (escolha == 1){
                imprimeRegras();
                System.out.println(" "+"\n");
                char opcao = Teclado.leChar("Deseja voltar ao menu? [qualquer tecla/N] ");
                if (opcao == 'N') break;
            }
            else if (escolha == 2){
                rodaJogo();
                char opcao = Teclado.leChar("Deseja voltar ao menu para jogar novamente? [qualquer tecla/N] ");
                if (opcao == 'N') break;
            }
            else if (escolha == 3){
                creditos();
                char opcao = Teclado.leChar("Deseja voltar ao menu para jogar novamente? [qualquer tecla/N] ");
                if (opcao == 'N') break;
            }
            else if (escolha == 4) {
                break;
            }
        }while (true);
        imagemFinal();
        System.out.println("Até breve!");
    }
    //Apenas a imagem usada para terminar o jogo e desligá-lo.
    public void imagemFinal(){
        System.out.println("⠀⠀⠀⠀⠀⠀⢀⣤⣚⣛⡶⣒⡁⠐⠦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⡾⠃⣀⠈⠉⡀⠈⠳⡀⠘⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⢸⠃⢸⣿⠀⣼⡇⠀⠀⢣⠀⠈⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⣀⠤⠖⠚⠒⠺⢧⡀⠙⠁⠀⠀⡜⠀⠀⠣⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⢀⠞⢣⠀⡠⠄⠀⠀⠀⠈⠦⠤⠤⠊⠀⠀⠀⠀⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠸⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠦⠀⠀⠀⣀⢼⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠈⠓⠤⢄⣀⣀⣀⡀⠤⠒⠁⠀⣀⠔⡶⠻⢥⠼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠈⠁⠒⢒⠏⠈⠉⠀⠀⢷⠤⠮⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⠀⠀⢀⠀⢈⢆⣀⣼⡒⠒⠲⢤⣀⠀⣠⠔⢆⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠈⢧⠀⠙⢜⣆⠑⣄⠀⠀⠈⡝⡄⠀⠈⡄"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⢰⠋⢃⠀⠀⢀⡀⠬⠂⠀⠈⡏⢦⡀⠑⠢⠔⠁⡸⠀⢀⠁"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⢀⠼⠤⢸⡄⠀⡏⠀⠀⠀⠀⠰⡁⠀⠉⠒⠒⠒⠈⠀⠀⡸⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠈⢇⣀⡀⠘⣦⡞⠀⠀⠀⠀⢠⠟⠀⠀⠀⠀⠀⠠⠀⡰⠁⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡩⠭⠤⠿⣲⢖⣒⠚⢫⣀⣀⣀⣀⡀⢀⡧⠊⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⢰⠉⠀⠀⠀⠀⠈⡠⠤⠛⠛⠦⡀⠀⠀⠈⣹⠀⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠘⣄⠀⠀⠀⠀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⡆⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠀⠸⡉⠒⠒⠒⠳⣄⠀⠀⠀⠀⠀⠀⠀⢀⣠⠃⠀⠀⠀⠀"+"\n"+
                           "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⢧⣈⣉⣀⣈⣉⠭⠝⠒⠊⠀⠀⠀⠀⠀");
    }
    //Método que pede e informa a quantidade de jogadores.
    public int quantPlayers(){
        int quantPlayers = Teclado.leInt("Digite quantos jogadores jogarão [2-500]: ");
        if (quantPlayers<2 || quantPlayers > 500){
            while (quantPlayers<2 || quantPlayers > 500){
                quantPlayers = Teclado.leInt("Valor inválido. Digite a quantidade de jogadores novamente: ");
            }
        }
        return quantPlayers;
    }
    //Método que pede e informa a quantidade de níveis para serem jogados.
    public int quantNiveis(){
        int quantNiveis = Teclado.leInt("Digite quantos níveis serão jogados: ");
        if (quantNiveis < 1){
            while (quantNiveis<1){
                quantNiveis = Teclado.leInt("Valor inválido. Digite a quantidade de níveis novamente: ");
            }
        }
        return quantNiveis;
    }
    //Aba de cráditos do jogo
    public void creditos(){
        System.out.println("Henrique Vinícius Haag"+"\n"+
                "2022"+"\n"+
                "Trabalho de algorítimos e programação: fundamentos - Universidade do Vale do Rio dos Sinos (Unisinos) - RS"+"\n"+
                "Projeto realizado dentro das normas impostas pela matéria"+"\n"+
                "Todos os direitos reservados®");
    }
    //Imagem que usei no menu para enfeitá-lo
    public void imagemDoMenu() {
        System.out.println("______  ________________   ______  __   "+"\n"+
                " ___   |/  /__  ____/__  | / /_  / / /   "+"\n"+
                " __  /|_/ /__  __/  __   |/ /_  / / /    "+"\n"+
                " _  /  / / _  /___  _  /|  / / /_/ /     "+"\n"+
                " /_/  /_/  /_____/  /_/ |_/  |____/      ");
    }
    //Arte ASCII para a tela inicial de introdução
    public void titulo(){
        System.out.println("      ██╗ ██████╗  ██████╗  ██████╗     ██████╗  █████╗     ███╗   ███╗███████╗███╗   ███╗ ██████╗ ██████╗ ██╗ █████╗     ██████╗"+"\n"+
                           "      ██║██╔═══██╗██╔════╝ ██╔═══██╗    ██╔══██╗██╔══██╗    ████╗ ████║██╔════╝████╗ ████║██╔═══██╗██╔══██╗██║██╔══██╗    ╚════██╗"+"\n"+
                           "      ██║██║   ██║██║  ███╗██║   ██║    ██║  ██║███████║    ██╔████╔██║█████╗  ██╔████╔██║██║   ██║██████╔╝██║███████║     █████╔╝"+"\n"+
                           " ██   ██║██║   ██║██║   ██║██║   ██║    ██║  ██║██╔══██║    ██║╚██╔╝██║██╔══╝  ██║╚██╔╝██║██║   ██║██╔══██╗██║██╔══██║    ██╔═══╝"+"\n"+
                           " ╚█████╔╝╚██████╔╝╚██████╔╝╚██████╔╝    ██████╔╝██║  ██║    ██║ ╚═╝ ██║███████╗██║ ╚═╝ ██║╚██████╔╝██║  ██║██║██║  ██║    ███████╗"+"\n"+
                           "  ╚════╝  ╚═════╝  ╚═════╝  ╚═════╝     ╚═════╝ ╚═╝  ╚═╝    ╚═╝     ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝    ╚══════╝");
    }
    //Arte ASCII para a saída prematura do jogo
    public void mongus(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣷⣶⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣾⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⡟⠁⣰⣿⣿⣿⡿⠿⠻⠿⣿⣿⣿⣿⣧⠀⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⠏⠀⣴⣿⣿⣿⠉⠀⠀⠀⠀⠀⠈⢻⣿⣿⣇⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⢀⣠⣼⣿⣿⡏⠀⢠⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⡀⠀⠀"+"\n"+
                "⠀⠀⠀⣰⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡇⠀⠀"+"\n"+
                "⠀⠀⢰⣿⣿⡿⣿⣿⣿⡇⠀⠘⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⢀⣸⣿⣿⣿⠁⠀⠀"+"\n"+
                "⠀⠀⣿⣿⣿⠁⣿⣿⣿⡇⠀⠀⠻⣿⣿⣿⣷⣶⣶⣶⣶⣶⣿⣿⣿⣿⠃⠀⠀⠀"+"\n"+
                "⠀⢰⣿⣿⡇⠀⣿⣿⣿⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀"+"\n"+
                "⠀⢸⣿⣿⡇⠀⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠛⠉⢉⣿⣿⠀⠀⠀⠀⠀⠀"+"\n"+
                "⠀⢸⣿⣿⣇⠀⣿⣿⣿⠀⠀⠀⠀⠀⢀⣤⣤⣤⡀⠀⠀⢸⣿⣿⣿⣷⣦⠀⠀⠀"+"\n"+
                "⠀⠀⢻⣿⣿⣶⣿⣿⣿⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣦⡀⠀⠉⠉⠻⣿⣿⡇⠀⠀"+"\n"+
                "⠀⠀⠀⠛⠿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠈⠹⣿⣿⣇⣀⠀⣠⣾⣿⣿⡇⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣦⣤⣤⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⠿⠋⠉⠛⠋⠉⠉⠁⠀⠀⠀⠀"+"\n"+
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠁");
        System.out.println("Ok. Até a próxima.");
    }
}
