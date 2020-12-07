package EjemploHibernate.Models;

import javax.persistence.*;
import java.io.Serializable;
// Mapeado JPA (@Entity representada en @Table (nombre despacho) -> ANTES DE DECLARAR LA CLASE
@Entity
@Table(name = "Despacho")

public class Despacho implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "num_despacho")
    private int num_despacho;
    @Column(name = "piso")
    private int piso;

    // Mapeado de la relación 1:1 entre Profesor y Despacho (relacionados por ID) -> @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamos las dos tablas (clases) por sus claves primaria -> @PrimaryKeyJoinColumn
    @PrimaryKeyJoinColumn
    private Profesor profesor;

    public Despacho() {
    }

    public Despacho(int id, int num_despacho, int piso) {
        this.id = id;
        this.num_despacho = num_despacho;
        this.piso = piso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_despacho() {
        return num_despacho;
    }

    public void setNum_despacho(int num_despacho) {
        this.num_despacho = num_despacho;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return " ID: " + id +
                " Número de despacho: " + num_despacho +
                " Piso: " + piso;
    }
}
