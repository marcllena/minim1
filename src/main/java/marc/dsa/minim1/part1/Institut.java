package marc.dsa.minim1.part1;

import java.util.LinkedList;
import java.util.List;

public class Institut {
    String nom;
    List<Alumne> alumnes;


    public Institut(String nom, List<Alumne> alumnes) {
        this.nom = nom;
        this.alumnes = alumnes;
    }

    public Institut() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(List<Alumne> alumnes) {
        this.alumnes = alumnes;
    }

    public List<Operacio> operacionsAlumnes(){
        List<Operacio> operacions= new LinkedList<Operacio>();
        for(int i=0;i<alumnes.size();i++){
            List<Operacio> operacionsAlumne=alumnes.get(i).getOperacions();
            for(int j=0; j<operacionsAlumne.size();j++){
                operacions.add(operacionsAlumne.get(j));
            }
        }
        return operacions;
    }

    @Override
    public String toString() {
        return "Institut{" +
                "nom='" + nom + '\'' +
                ", alumnes=" + alumnes +
                '}';
    }
}
