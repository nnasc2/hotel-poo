package enums;

public enum SexoEnum {

    Masculino("Masculino", 0),Feminino("Feminino", 1);
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
          case 0 -> SexoEnum.Masculino;
          case 1 -> SexoEnum.Feminino;
          default -> null;
        };
    }
}
