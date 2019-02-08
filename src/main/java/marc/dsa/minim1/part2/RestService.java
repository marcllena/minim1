package marc.dsa.minim1.part2;

import marc.dsa.minim1.part1.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;


@Path("service")
public class RestService {
    //Per crear els JSON rapidament ;
    @GET
    @Path("/proba")
    @Produces(MediaType.APPLICATION_JSON)
    public Operacio proba()
    {
        Operacio op= new Operacio("2X2");
        return op;
    }

    MathManagerImpl mathManager;

    public RestService(){
        mathManager = mathManager.getInstance();
    }

    //Apart de les funcions demanades implemento:
    @POST
    @Path("/nouinsti")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response afagirInstitut(Institut institut)
    {
        mathManager.afagirInstitut(institut);
        return Response.status(200).build();
    }

    //Operacions demanades
    @POST
    @Path("/operacio/{nom}/{institut}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response realitzarPedido(Operacio operacio,@PathParam("nom") String nom,@PathParam("institut") String institut){
        int res = mathManager.realitzarOperacio(operacio,nom,institut);
        if(res==0)
            return Response.status(200).build();
        else
            return Response.status(204).entity("No existeix el alumne").build();
    }

    //http://localhost:8080/myapp/service/procesar
    @GET
    @Path("/procesar")
    @Produces(MediaType.TEXT_HTML)
    public Response servirPedido(){
        int res = mathManager.procesarOperacio();
        return Response.status(200).entity(String.valueOf(res)).build();
    }

    //http://localhost:8080/myapp/service/procesar
    @GET
    @Path("/operacions/{institut}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacio> llistatOperacionsInstitut(@PathParam("institut") String institut){
        return mathManager.llistatOperacionsInstitut(institut);
    }

    //http://localhost:8080/myapp/service/operacions/Marc/UPC
    @GET
    @Path("/operacions/{nom}/{institut}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacio> llistatOperacionsAlumne(@PathParam("nom") String nom,@PathParam("institut") String institut){
        return mathManager.llistatOperacionsAlumne(nom,institut);
    }

    //http://localhost:8080/myapp/service/instituts
    @GET
    @Path("/instituts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Institut> llistatInstituts(){
        return mathManager.llistatInstituts();
    }
}
