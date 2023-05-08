package teste;

import entidades.Hotel;
import enums.ClassificacaoEnum;
import repositorios.HotelRepositorio;
import servicos.HotelServico;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TesteHotel {
    public static void main(String[] args) throws SQLException {

        HotelServico hotelServico = new HotelServico();

        // Inserção
        /*
        Hotel hotel1 = new Hotel();
        hotel1.setNome("Roland Hotel");
        hotel1.setDescricao("Hotel beira-mar");
        hotel1.setClassificacao(ClassificacaoEnum.QUATRO_ESTRELAS);
        hotel1.setEstado("Pernambuco");
        hotel1.setCidade("Ipojuca");
        hotel1.setRua("João Joaquim");
        hotel1.setBairro("Porto de Galinhas");
        hotel1.setComplemento("");
        hotel1.setNumero(290);
        hotel1.setCnpj("23455121000166");

        String mensagem = hotelServico.cadastrar(hotel1) ? "<hotel> salvo com sucesso!" : "<hotel> não foi salvo!";
        System.out.println(mensagem);
        */

        // Busca
        /*
        List<Hotel> hoteis = hotelServico.listar();

        for( Hotel hotel : hoteis){
            System.out.println("ID: "+ hotel.getId());
            System.out.println("NOME: "+ hotel.getNome());
            System.out.println("DESCRIÇÃO: "+ hotel.getDescricao());
            System.out.println("CLASSIFICAÇÃO: "+ hotel.getClassificacao().getDescricao());
            System.out.println("ESTADO: "+ hotel.getEstado());
            System.out.println("CIDADE: "+ hotel.getCidade());
            System.out.println("RUA: "+ hotel.getRua());
            System.out.println("BAIRRO: "+ hotel.getBairro());
            System.out.println("COMPLEMENTO: "+ hotel.getComplemento());
            System.out.println("NÚMERO: "+ hotel.getNumero());
            String cnpj = hotel.getCnpj();
            System.out.printf("CNPJ: %s.%s.%s/%s-%s", cnpj.substring(0,2), cnpj.substring(2,5),
                    cnpj.substring(5,8), cnpj.substring(8,12), cnpj.substring(12,14));
        }
        */

        // Atualização
        /*
        Hotel hotel2 = new Hotel();
        hotel2.setNome("Roland Hotel");
        hotel2.setDescricao("Hotel beira-mar");
        hotel2.setClassificacao(ClassificacaoEnum.QUATRO_ESTRELAS);
        hotel2.setEstado("Pernambuco ");
        hotel2.setCidade("Ipojuca");
        hotel2.setRua("João Joaquim");
        hotel2.setBairro("Porto de Galinhas");
        hotel2.setComplemento("");
        hotel2.setNumero(290);
        hotel2.setCnpj("23455121000166");

        boolean retorno = HotelRepositorio.getInstance().alterar(1, hotel2);
        String mensagem = retorno ? "Alteração realizada com sucesso!" : "Não foi possível alterar registro!";
        System.out.println(mensagem);
        */

        // Exclusão
        /*
        boolean retorno = HotelRepositorio.getInstance().deletar(1);
        String mensagem = retorno ? "<hotel> deletado com sucesso!" : "<hotel> não foi deletado!";
        System.out.println(mensagem);
        */
    }
}
