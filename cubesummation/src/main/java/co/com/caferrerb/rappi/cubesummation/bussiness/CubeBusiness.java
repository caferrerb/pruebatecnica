package co.com.caferrerb.rappi.cubesummation.bussiness;

import co.com.caferrerb.rappi.cubesummation.model.Cube;
import co.com.caferrerb.rappi.cubesummation.model.Point;
import co.com.caferrerb.rappi.cubesummation.persistence.DAOCube;
import co.com.caferrerb.rappi.cubesummation.persistence.DAOPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CubeBusiness {

    @Autowired
    private DAOPoint dao;

    @Autowired
    private DAOCube daoCube;

    /**
     * Crea un punto
     * @param p
     */
    public void agregarPunto(int cubeId,Point p){

        Cube cube=daoCube.buscar(cubeId);
        if(cube==null){
            cube=new Cube();
            cube.setId(cubeId);
            daoCube.crear(cube);
        }
        p.setCube(cube);
        dao.crear(p);
    }

    /**
     * Metodo que calcula la suma de los puntos de un volumen del cubo
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param z1
     * @param z2
     * @return
     */
    public Long sumarArea(int idCubo,int x1, int x2, int y1, int y2, int z1, int z2 ){
        List<Point> puntos=dao.consultarPuntos(idCubo,x1,y1,z1,x2,y2,z2);

        long sum=0;
        for (Point p:puntos) {
            sum+=p.getW();
        }

        return sum;
    }


}
