package marc.dsa.minim1.part2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("service")
public class RestService {
    //Per crear els JSON rapidament creo;
    @GET
    @Path("/proba")
    @Produces(MediaType.APPLICATION_JSON)
    public Object proba()
    {
        Object a= new Object();
        return a;
    }
/*
    ProductManagerImpl productManager;

    public RestService(){
        productManager = productManager.getInstance();
    }

    //Apart de les funcions demanades implemento:
    @POST
    @Path("/nouprod")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response afagirProducte(Producto producto)
    {
        productManager.afagirProducte(producto);
        return Response.status(200).build();
    }

    @GET
    @Path("/nou/{nom}")
    @Produces(MediaType.TEXT_HTML)
    public Response afagirUsuari(@PathParam("nom") String nom)
    {
        productManager.afagirUsuari(new Usuario(nom));
        return Response.status(200).build();
    }

    //Funcions Demanades
    @GET
    @Path("/prodpreu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> llistatProductesPreu(){
        return productManager.llistatProductesPreu();
    }

    @GET
    @Path("/prodventes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> llistatProductesVentes(){
        return productManager.llistatProductesVentes();
    }

    @POST
    @Path("/pedido/{nom}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realitzarPedido(Comanda[] comandes,@PathParam("nom") String nom){
        int res =productManager.realitzarPedido(comandes,nom);
        if(res==0)
            return Response.status(200).build();
        else
            return Response.status(204).entity("No existeix el producte").build();
    }

    @GET
    @Path("/servir")
    @Produces(MediaType.TEXT_HTML)
    public Response servirPedido(){
        int res = productManager.servirPedido();
        switch (res){
            case 0: return Response.status(200).build();
            case -1: return Response.status(204).entity("No existeix el producte").build();
            default: return Response.status(204).entity("Cap pedido per servir").build();
        }
    }

    @GET
    @Path("/llistapedidos/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comanda>  llistatPedidosRealitzats(@PathParam("nom") String nom){
        return productManager.llistatPedidosRealitzats(nom);
    }
*/
}
