package marc.dsa.minim1.part1;

public class ProductManagerImpl implements ProductManager {
    /*//2.1 Trio LinkedList tant per productes com per usuaris, ja que a la interficie hem especificat llistes
    //Pels pedidos trio una cua com a estructura FIFO
    private List<Producto> productes;
    private List<Usuario> usuaris;
    private Queue <Comanda[]> pedidos;

    //2.3 Ens demanen que la fachada s'implementin com un Singleton
    private static ProductManagerImpl ourInstance;


    public static ProductManagerImpl getInstance() {
        if (ourInstance==null)
            ourInstance = new ProductManagerImpl();
        return ourInstance;
    }

    private ProductManagerImpl(){
       productes= new LinkedList<Producto>();
       usuaris= new LinkedList<Usuario>();
       pedidos= new LinkedList<Comanda[]>();
    }

    public static void clear(){
        ourInstance = new ProductManagerImpl();
    }
    //2.4 Ens demane mostrar la informació amb Log4J
    final static Logger log = Logger.getLogger(ProductManagerImpl.class);

    //Apart de les funcions demanades implemento:
    public void afagirProducte(Producto producte)
    {
        productes.add(producte);
    }

    public void afagirUsuari(Usuario usuario){
        usuaris.add(usuario);
    }

    public int buscarUsuari(String nom){
        int i=0;
        boolean encontrado=false;
       while(!encontrado&&i<usuaris.size()){
            if(usuaris.get(i).getNombre().equals(nom))
                encontrado=true;
            else
                i++;

       }
       if(encontrado)
           return i;
       else return -1;
    }
    public int buscarProducte(String nom){
        int i=0;
        boolean encontrado=false;
        while(!encontrado&&i<productes.size()){
            if(productes.get(i).getNom().equals(nom))
                encontrado=true;
            else
                i++;

        }
        if(encontrado)
            return i;
        else return -1;
    }
    public List<Producto> llistatProductesPreu(){
        log.info("Ordenar Productes per Preu:");
        //Fem el nostre comparador per Preu Ascendement
        Comparator<Producto> Comparador1 = new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                if(o1.getPreu()>= o2.getPreu())
                return 0;
                else return -1;
            }
        };
        productes.sort(Comparador1);
        log.info("Resultat al ordenar la llista:"+productes.toString());
        return productes;
    }
    public List<Producto> llistatProductesVentes(){
        log.info("Ordenar Productes per Ventes:");
        //Fem el nostre comparador per Ventes descendenment
        Comparator<Producto> Comparador2 = new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                if(o1.getVendas()<= o2.getVendas())
                    return 0;
                else return -1;
            }
        };
        productes.sort(Comparador2);
        log.info("Resultat al ordenar la llista:"+productes.toString());
        return productes;
    }
    public int realitzarPedido(Comanda[] comandes,String usuari){
        log.info("Petició de Pedido de "+usuari+" Pedido"+comandes.toString());
        int usr = buscarUsuari(usuari);
        if(usr!=-1) {
            pedidos.add(comandes);
            usuaris.get(usr).afegirPedido(comandes);
            log.info("Pedido anterior realitzat");
            return 0;
        }
        else{
            log.fatal("El usuari que ha fet el pedido no existeix, cancelem el pedido");
            return -1;
        }
    }

    public int servirPedido(){
        log.info("Servim el primer pedido de la llista");
        int res=0;//Tornarem 0 si tot correcte, i -1 si alguna comanda no s'ha pugut realitzar pk no existeix el producte
        //Tornarem -2, si no hi cap pedido per servir
        Comanda[] comandes = pedidos.poll();
        if(comandes!=null)
        for(int i =0; i<comandes.length;i++){
            int prod = buscarProducte(comandes[i].getProducte().getNom());
            if(prod!=-1) {
                int vendes = productes.get(prod).getVendas();
                productes.get(prod).setVendas(vendes+comandes[i].getCantitat());
                log.info("Comanda realitazada "+comandes[i].toString());
            }
            else{
                log.error("El producte "+comandes[i].getProducte().getNom()+" no existeix");
                res = -1;
            }
        }
        else{
            log.error("No hi ha cap pedido per servir");
            res = -2;
        }
        return res;
    }
    public List<Comanda> llistatPedidosRealitzats(String usuari){
        log.info("Pedidos Realitzats pel usuario "+usuari);
        int usr = buscarUsuari(usuari);
        if(usr!=-1) {
            List<Comanda> pedidosRealitzats= usuaris.get(usr).pedidosRealizados;
            log.info("Pedidos realitzats pel usuari: "+pedidos.toString());
            return pedidosRealitzats;
        }
        else{
            log.error("El usuari demanat no existeix");
            return null;
        }
    }
    */
}
