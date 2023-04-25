package enums;

public enum QuartoEnum {
    INDIVIDUAL ("Quarto Individual", 1), DUPLO ("Quarto Duplo", 2), TRIPLO ("Quarto Triplo", 3), QUADRUPLO ("Quarto Quádruplo", 4);
    private int ocupacaoMaxima;
    private String descricao;

    QuartoEnum(String descricao, int ocupacaoMaxima) {
        this.ocupacaoMaxima = ocupacaoMaxima;
        this.descricao = descricao;
    }

    public int getOcupacaoMaxima() {
        return this.ocupacaoMaxima;
    }

    public String getDescricao() {return this.descricao;}
}
