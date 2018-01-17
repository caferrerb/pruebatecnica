package co.com.caferrerb.rappi.cubesummation.service;

import co.com.caferrerb.rappi.cubesummation.bussiness.CubeBusiness;
import co.com.caferrerb.rappi.cubesummation.model.Point;
import co.com.caferrerb.rappi.cubesummation.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/cube")
@Component
public class CubeRest {

    @Autowired
    private CubeBusiness cube;


    /**
     * Servicio para actualizar un punto de un cubo.
     * crea el cubo si no existe
     * @param punto punto a actualizar
     * @return
     */
    @POST
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO agregarPunto(@PathParam("id") int id,Point punto){
        cube.agregarPunto(id,punto);
        return new ResponseDTO("OK: actualizado cubo","00","");
    }

    /**
     * Matodo para consultar un volumen del cubo.
     * @param id
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param z1
     * @param z2
     * @return la suma de los punto de ese volumen
     */
    @GET
    @Path("/query/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDTO query(@PathParam ("id") int id,
                             @QueryParam("x1") int x1,
                             @QueryParam("x2")int x2,
                             @QueryParam("y1")int y1,
                             @QueryParam("y2")int y2,
                             @QueryParam("z1")int z1,
                             @QueryParam("z2")int z2){
        long sum=cube.sumarArea(id,x1,y1,x2,y2,z1,z2);
        return new ResponseDTO("OK","00",sum);
    }





}
