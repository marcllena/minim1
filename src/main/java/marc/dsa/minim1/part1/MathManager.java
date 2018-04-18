package marc.dsa.minim1.part1;

import java.util.List;

public interface MathManager {

    public int realitzarOperacio(Operacio operacio,String alumne,String institut);
    public int procesarOperacio();
    public List<Operacio> llistatOperacionsInstitut(String institut);
    public List<Operacio> llistatOperacionsAlumne(String alumne,String institut);
    public List<Institut> llistatInstituts();

}
