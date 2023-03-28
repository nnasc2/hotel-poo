package interfaces.servico;

import entidades.Hotel;
import enums.ClassificacaoEnum;

import java.util.List;

public interface IHotelServico {
    void cadastrar(Hotel novoHotel);
    void cadastrar(long id, String nome, String descricao, ClassificacaoEnum classificacaoEnum, String estado, String cidade,
                   String rua, String bairro, String complemento, String numero, String cnpj);
    List<Hotel> listar();
    void alterar(long idHotel, Hotel hotel);
    void deletar(long idHotel);

}
