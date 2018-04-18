package marc.dsa.minim1.part1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.log4j.Logger;

public class MathManagerImpl implements MathManager {
    //2.1 Trio LinkedListper Instituts on guardare de cada institus els alumnes. Per buscar els alumnes demanare el institut
    //Pels operacions trio una cua com a estructura FIFO
    private List<Institut> instituts;
    private Queue<Operacio> operacions;

    //2.3 Ens demanen que la fachada s'implementin com un Singleton
    private static ProductManagerImpl ourInstance;


    public static ProductManagerImpl getInstance() {
        if (ourInstance==null)
            ourInstance = new ProductManagerImpl();
        return ourInstance;
    }

    private MathManagerImpl(){
        instituts= new LinkedList<Institut>();
        operacions= new LinkedList<Operacio>();
    }

    public static void clear(){
        ourInstance = new ProductManagerImpl();
    }
    //2.4 Ens demane mostrar la informació amb Log4J
    final static Logger log = Logger.getLogger(ProductManagerImpl.class);

    //Apart de les funcions demanades implemento:
    public void afagirInstitut(Institut institut)
    {
        instituts.add(institut);
    }


    public int buscarInstitut(String nom){
        log.info("Petició de Buscar Institut"+nom);
        int i=0;
        boolean encontrado=false;
        while(!encontrado&&i<instituts.size()){
            if(instituts.get(i).getNom().equals(nom))
                encontrado=true;
            else
                i++;

        }
        if(encontrado)
            return i;
        else return -1;
    }
    public Alumne buscarAlumne(String nom,String institut){
        log.info("Peticio de buscar de"+nom+"del Institut"+institut);
        int ins = buscarInstitut(institut);
        if(ins!=-1) {
            List<Alumne> alumnes = instituts.get(ins).getAlumnes();
            int i = 0;
            boolean encontrado = false;
            while (!encontrado && i < alumnes.size()) {
                if (alumnes.get(i).getNom().equals(nom))
                    encontrado = true;
                else
                    i++;

            }
            if (encontrado)
                return alumnes.get(i);
            else return null;
        }
        else return null;
    }

    //Operacions demanades
    public int realitzarOperacio(Operacio operacio,String alumne,String institut){
        log.info("Petició de Operacio de "+alumne+" Operacio"+operacio.toString());
        Alumne user = buscarAlumne(alumne,institut);
        if(user!=null) {
            operacions.add(operacio);
            user.getOperacions().add(operacio);
            log.info("Operacio anterior realitzada");
            return 0;
        }
        else{
            log.fatal("El alumne que ha fet el pedido no existeix, cancelem la operacio");
            return -1;
        }
    };
    public int procesarOperacio(){
            log.info("Procesem la primera operacio");
            Operacio operacio = operacions.poll();
            int res;
            if(operacio!=null){
                res = operacio.procesar();
                log.info("Procesem la primera operacio. Resultat"+res);

            }
            else{
                log.error("No hi ha cap operacio per procesar");
                res = -1;
            }
        return res;

    }
    public List<Operacio> llistatOperacionsInstitut(String institut){
        log.info("Llistat de operacions per institut de"+institut);
        int ins = buscarInstitut(institut);
        if(ins!=-1) {
            List<Operacio> operacions= instituts.get(ins).operacionsAlumnes();
            log.info("Resultat"+operacions.toString());
            return operacions;
        }
        else{
            log.error("No s'ha trobat el institut");
            return null;
        }
    }
    public List<Operacio> llistatOperacionsAlumne(String alumne,String institut){
        log.info("Llistat de operacions per institut de"+alumne+"del Institut"+institut);
        Alumne user = buscarAlumne(alumne,institut);
        if(user!=null) {
            List<Operacio> operacions= user.getOperacions();
            log.info("Resultat"+operacions.toString());
            return operacions;
        }
        else{
            log.fatal("El alumne no existeix");
            return null;
        }
    }
    public List<Institut> llistatInstituts(){
        log.info("Ordenar Instituts per Operacions");
        //Fem el nostre comparador per Operacions descendenment
        Comparator<Institut> Comparador2 = new Comparator<Institut>() {
            public int compare(Institut o1, Institut o2) {
                if(o1.operacionsAlumnes().size()<= o2.operacionsAlumnes().size())
                    return 0;
                else return -1;
            }
        };
        instituts.sort(Comparador2);
        log.info("Resultat al ordenar la llista:"+instituts.toString());
        return instituts;
    }
}
