package co.com.caferrerb.rappi.cubesummation.persistence;

import co.com.caferrerb.rappi.cubesummation.model.Cube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Date;

/**
 * DAO de la entidad cubo
 */
@Component
public class DAOCube {

    @Autowired
    private EntityManager em;

    /**
     * metodo para crear un cubo
     * @param cube
     */
    public void crear(Cube cube){
        cube.setFechaCreacion(new Date());
        em.persist(cube);
    }


    /**
     * metodo para buscar un cubo
     * @param id
     * @return
     */
    public Cube buscar(int id){
        return em.find(Cube.class,id);
    }
}
