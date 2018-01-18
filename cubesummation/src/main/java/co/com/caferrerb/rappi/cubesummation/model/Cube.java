package co.com.caferrerb.rappi.cubesummation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Entidad para Cubo.
 */
@Entity
public class Cube implements Serializable{

    @Id
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Cube() {
    }

    public Cube(int id, Date fechaCreacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
