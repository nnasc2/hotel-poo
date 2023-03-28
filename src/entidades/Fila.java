package entidades;

import java.util.ArrayList;
import java.util.List;

public class Fila<Objeto> {

    private List<Objeto> fila;
    private int f = 0;
    private int t = 0;

    public Fila(int size){
        t = size;
    }
    public List<Objeto> getFila() {
        return fila;
    }

    public void insert(Objeto objeto) {
        if(f == 0){
            fila.set(f, objeto);
        }
        f++;
    }

    public void remove() {
        if(!empty()) {
            for(int i = 0; i < f; i++) {
                if(i+1 < f) {
                    fila.set(i, fila.get(i+1));
                } else if(i+1 == t) {
                    fila.remove(i);
                }
            }
        }
    }

    public boolean empty() {
        if(f == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return f;
    }

    public Objeto front() {
        return fila.get(0);
    }

}








