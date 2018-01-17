package co.com.caferrerb.rappi.cubesummation.model;

import javax.persistence.*;

@Entity
@NamedQuery(name="Point.queryByCoordinates",query="select p from Point p where p.x between :x1 and :x2 AND p.y between :y1 and :y2 AND p.z between :z1 and :z2 AND cube.id:=idCube" )
public class Point {

    @Id
    private String id;

    /**
     * Coordenadas.
     */
    private int x;
    private int y;
    private int z;

    /**
     * valor de la coordenada
     */
    private int w;


    @ManyToOne
    @JoinColumn
    private Cube cube;


    public Point() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }


    public Cube getCube() {
        return cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }
}
