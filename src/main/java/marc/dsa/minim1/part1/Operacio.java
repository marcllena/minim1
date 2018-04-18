package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.Queue;

public class Operacio{

    String expresio;

    public Operacio(String expresio) {
        this.expresio = expresio;
    }


    public Operacio() {
        Queue<String> expresio=new LinkedList<String>();
    }

    public String getExpresio() {
        return expresio;
    }

    public void setExpresio(String expresio) {
        this.expresio = expresio;
    }


    @Override
    public String toString() {
        return "Operacio{" +
                "expresio='" + expresio + '\'' +
                '}';
    }
}
