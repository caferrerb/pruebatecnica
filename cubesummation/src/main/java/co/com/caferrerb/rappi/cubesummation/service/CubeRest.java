package co.com.caferrerb.rappi.cubesummation.service;

import co.com.caferrerb.rappi.cubesummation.bussiness.CubeBusiness;
import co.com.caferrerb.rappi.cubesummation.model.Point;
import co.com.caferrerb.rappi.cubesummation.util.ResponseDTO;

@Path("/cube")
public class CubeRest {

    private CubeBusiness cube;

    @POST
    @Path("/add")
    @Consumes(MediaType.JSON)
    @Produces(MediaType.JSON)
    public ResponseDTO agregarPunto(Point punto){
        cube.agregarPunto(punto);
        return new ResponseDTO("OK","00",null);
    }



}
