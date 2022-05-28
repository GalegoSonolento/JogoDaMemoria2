public class Jogador {
    private String nome;
    private int id;
    private int vitorias;

    //Métodos de acesso
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getVitorias(){
        return vitorias;
    }
    public void setVitorias(int vitorias){
        this.vitorias = vitorias;
    }
    //Construtor
    public Jogador(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
}
