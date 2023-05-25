package enums;

public enum SexoEnum {

    MASCULINO("Masculino", 1), FEMININO("Feminino", 2);
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

    public static SexoEnum intToSexoEnum(int index){
        return switch(index){
          case 1 -> SexoEnum.MASCULINO;
          case 2 -> SexoEnum.FEMININO;
          default -> null;
        };
    }
}
