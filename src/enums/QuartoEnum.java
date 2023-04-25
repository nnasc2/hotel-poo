package enums;

public enum QuartoEnum {
    INDIVIDUAL ("Quarto Individual", 1), DUPLO ("Quarto Duplo", 2), TRIPLO ("Quarto Triplo", 3), QUADRUPLO ("Quarto Quádruplo", 4);
    private int index;
    private String descricao;

    QuartoEnum(String descricao, int index) {
        this.index = index;
        this.descricao = descricao;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDescricao() {return this.descricao;}

    public static QuartoEnum intToQuartoEnum(int index){
        return switch (index) {
            case 1 -> QuartoEnum.INDIVIDUAL;
            case 2 -> QuartoEnum.DUPLO;
            case 3 -> QuartoEnum.TRIPLO;
            case 4 -> QuartoEnum.QUADRUPLO;
            default -> null;
        };
    }
}
