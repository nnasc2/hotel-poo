package entidades;

import java.util.ArrayList;
import java.util.List;

public class Fila<T> {

    private List<T> fila;
    private int f = 0;
    private int t = 0;

    public Fila(int size){
        fila = new ArrayList<>();
        t = size;
    }
    public List<T> getFila() {
        return fila;
    }

    public void insert(T element) {
        if(f == 0){
            int index = f;
            fila.set(index, element);
        }
        f++;
    }

    public T remove() {
        if(!empty()) {
            for(int i = 0; i < f; i++) {
                T element = fila.get(0);
                if(i+1 < f) {
                    fila.set(i, fila.get(i+1));
                } else if(i+1 == t) {
                    fila.remove(i);
                }
                return element;
            }
        }
        return null;
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

    public T front() {
        return fila.get(0);
    }

}








