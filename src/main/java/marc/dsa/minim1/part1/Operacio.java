package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.Queue;

public class Operacio implements ReversePolishNotation{
    Queue<String> expresio;

    public Operacio(Queue<String> expresio) {
        this.expresio = expresio;
    }

    public Operacio() {
        Queue<String> expresio=new LinkedList<String>();
    }

    public Queue<String> getExpresio() {
        return expresio;
    }

    public void setExpresio(Queue<String> expresio) {
        this.expresio = expresio;
    }
    public int procesar(){
       return 0;
    }

}
