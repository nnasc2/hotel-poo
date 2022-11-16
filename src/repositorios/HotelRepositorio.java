package repositorios;

import entidades.Hotel;
import interfaces.repositorio.IHotelRepositorio;

import java.util.ArrayList;
import java.util.List;

public class HotelRepositorio implements IHotelRepositorio {
    private static HotelRepositorio instance;
    private ArrayList<Hotel> hoteisRepositorio = new ArrayList<Hotel>();

    private HotelRepositorio () {
    }

    public static HotelRepositorio getInstance() {
        if (instance == null) {
            instance = new HotelRepositorio();
        }
        return instance;
    }

    @Override
    public boolean salvar(Hotel hotel) {
        try{
            if (hoteisRepositorio.size() <= 3){
                hoteisRepositorio.add(hotel);
            }
        } catch(Exception e) {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Hotel> listar() {
        return hoteisRepositorio;
    }

    @Override
    public boolean alterar(long hotelId, Hotel hotel) {
        try{
            for (int i = 0; i < hoteisRepositorio.size(); i++) {
                if (hoteisRepositorio.get(i).getId() == hotelId) {
                    hoteisRepositorio.set(i, hotel);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(long hotelId) {
        try{
            for (int i = 0; i < hoteisRepositorio.size(); i++) {
                if (hoteisRepositorio.get(i).getId() == hotelId) {
                    hoteisRepositorio.remove(i);
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }
}
