package co.com.caferrerb.rappi.cubesummation.bussiness;

import co.com.caferrerb.rappi.cubesummation.model.Point;
import co.com.caferrerb.rappi.cubesummation.persistence.DAOPoint;

import javax.persistence.EntityManager;
import java.util.List;

public class CubeBusiness {


    private DAOPoint dao;

    /**
     * Crea un punto
     * @param p
     */
    public void agregarPunto(Point p){
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
    public Long sumarArea(int x1, int x2, int y1, int y2, int z1, int z2 ){
        List<Point> puntos=dao.consultarPuntos(x1,y1,z1,x2,y2,z2);

        long sum=0;
        for (Point p:puntos) {
            sum+=p.getW();
        }

        return sum;
    }


}
