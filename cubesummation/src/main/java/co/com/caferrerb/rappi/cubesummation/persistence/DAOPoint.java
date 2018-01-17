package co.com.caferrerb.rappi.cubesummation.persistence;

import co.com.caferrerb.rappi.cubesummation.model.Point;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOPoint {

    private EntityManager em;


    /**
     * Metodo para persistir un punto
     * @param p
     */
    public void crear(Point p){
        p.setId(p.getX()+"-"+p.getY()+"-"+p.getZ());
        em.persist(p);
    }

    /**
     * Metodo para determinar los puntos entre dos coordenadas.
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @param z1
     * @param z2
     * @return lista de puntos.
     */
    public List<Point> consultarPuntos(int x1, int x2, int y1, int y2, int z1, int z2){
        Query q=em.createNamedQuery("Point.queryByCoordinates");
        q.setParameter("x1",x1);
        q.setParameter("y1",y1);
        q.setParameter("z1",z1);
        q.setParameter("x2",x2);
        q.setParameter("y2",y2);
        q.setParameter("z2",z2);

        return q.getResultList();


    }
}
