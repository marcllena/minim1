package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;

public class Alumne {
    String nom;
    List<Operacio> operacions;

    public Alumne(String nom) {
        this.nom = nom;
        this.operacions = new LinkedList<Operacio>();
    }

    public Alumne() {
    }

    public String getNom() {
        return nom;
    }

    public List<Operacio> getOperacions() {
        return operacions;
    }

    public void setOperacions(List<Operacio> operacions) {
        this.operacions = operacions;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", operacions=" + operacions +
                '}';
    }
}
