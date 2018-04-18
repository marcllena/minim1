package marc.dsa.minim1.part1;

import java.util.List;

public class Alumne {
    String nom;
    List<Operacio> operacions;

    public Alumne(String nom, List<Operacio> operacions) {
        this.nom = nom;
        this.operacions = operacions;
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
}
