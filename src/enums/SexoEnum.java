package enums;

public enum SexoEnum {

    MASCULINO("Masculino", 0), FEMININO("Feminino", 1);
    private String descricao;
    private int index;

    SexoEnum(String descricao, int index) {
        this.descricao = descricao;
        this.index = index;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getIndex(){
        return this.index;
    }

    public static SexoEnum binaryToSexoEnum(int index){
        return switch(index){
          case 0 -> SexoEnum.MASCULINO;
          case 1 -> SexoEnum.FEMININO;
          default -> null;
        };
    }
}
