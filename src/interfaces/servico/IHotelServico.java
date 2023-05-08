package interfaces.servico;

import entidades.Hotel;
import enums.ClassificacaoEnum;

import java.sql.SQLException;
import java.util.List;

public interface IHotelServico {
    boolean cadastrar(Hotel hotel);
    void cadastrar(String nome, String descricao, ClassificacaoEnum classificacaoEnum, String estado, String cidade,
                   String rua, String bairro, String complemento, int numero, String cnpj);
    List<Hotel> listar() throws SQLException;
    void alterar(long idHotel, Hotel hotel) throws SQLException;
    void deletar(long idHotel) throws SQLException;

}
