package servicos;

import entidades.Hotel;
import enums.ClassificacaoEnum;
import interfaces.servico.IHotelServico;
import repositorios.HotelRepositorio;

import java.util.ArrayList;
import java.util.List;

public class HotelServico implements IHotelServico {

    @Override
    public void cadastrar(Hotel novoHotel) {
        try {
            HotelRepositorio.getInstance().salvar(novoHotel);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar(long id, String nome, String descricao, ClassificacaoEnum classificacaoEnum, String estado, String cidade,
                          String rua, String bairro, String complemento, String numero, String cnpj) {
        try {
            Hotel novoHotel = new Hotel();
            novoHotel.setId(id);
            novoHotel.setNome(nome);
            novoHotel.setDescricao(descricao);
            novoHotel.setClassificacao(classificacaoEnum);
            novoHotel.setEstado(estado);
            novoHotel.setRua(rua);
            novoHotel.setBairro(bairro);
            novoHotel.setComplemento(complemento);
            novoHotel.setNumero(numero);
            novoHotel.setCnpj(cnpj);

            HotelRepositorio.getInstance().salvar(novoHotel);

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override
    public List<Hotel> listar() {
        return HotelRepositorio.getInstance().listar();
    }

    @Override
    public void alterar(long idHotel, Hotel hotel) {
        HotelRepositorio.getInstance().alterar(idHotel, hotel);
    }

    @Override
    public void deletar(long idHotel) {
        HotelRepositorio.getInstance().deletar(idHotel);
    }

    public List<String> listarTodasCidades() {
        List<String> cidades = new ArrayList<>();
        List<Hotel> hoteis = HotelRepositorio.getInstance().listar();
        for (int i = 0; i < hoteis.size(); i++) {
            boolean haIgualdade = false;

            if (cidades.size() == 0) {
                cidades.add(hoteis.get(i).getCidade());
            }
            for (int j = 0; j < cidades.size(); j++) {
                if (hoteis.get(i).getCidade() == cidades.get(j)) {
                    haIgualdade = true;
                }
            }
            if (!haIgualdade) {
                cidades.add(hoteis.get(i).getCidade());
            }

        }
        return cidades;
    }

    public List<String> listarTodosEstados() {
        List<String> estados = new ArrayList<>();
        List<Hotel> hoteis = HotelRepositorio.getInstance().listar();
        for(int i = 0; i < hoteis.size(); i++) {
            boolean haIgualdade = false;

            if(estados.size() == 0) {
                estados.add(hoteis.get(i).getEstado());
            }
            for(int j = 0; j < estados.size(); j++) {
                if (hoteis.get(i).getEstado() == estados.get(j)) {
                    haIgualdade = true;
                }
            }
            if(!haIgualdade) {
                estados.add(hoteis.get(i).getEstado());
            }

        }
        return estados;
    }

    public List<String> listarCidadesPorEstado(String estado) {
        List<String> cidades = new ArrayList<>();
        List<Hotel> hoteis = HotelRepositorio.getInstance().listar();
        for (int i = 0; i < hoteis.size(); i++) {
            if(hoteis.get(i).getEstado() == estado){
                boolean haIgualdade = false;

                if(cidades.size() == 0) {
                    cidades.add(hoteis.get(i).getCidade());
                }
                for(int j = 0; j < cidades.size(); j++) {
                    if(hoteis.get(i).getCidade() == cidades.get(j)) {
                        haIgualdade = true;
                    }
                }
                if(!haIgualdade) {
                    cidades.add(hoteis.get(i).getCidade());
                }
            }

        }
        return cidades;
    }

    public List<Hotel> listarHoteisPorCidade(String cidade) {
        List<Hotel> hoteis = new ArrayList<>();
        List<Hotel> todosHoteis = HotelRepositorio.getInstance().listar();
        for(int i = 0; i < todosHoteis.size(); i++){
            if(todosHoteis.get(i).getCidade() == cidade){
                hoteis.add(todosHoteis.get(i));
            }
        }
        return hoteis;
    }

    public Hotel listarHotelPorId(long idHotel){
        Hotel hotel = new Hotel();
        for (Hotel h: HotelRepositorio.getInstance().listar()) {
            if (h.getId() == idHotel){
                hotel = h;
            }
        }
        return hotel;
    }
}
