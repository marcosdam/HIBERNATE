package EjemploHibernate.Models;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Mapeado JPA (@Entity representada en @Table (nombre profesor) -> ANTES DE DECLARAR LA CLASE
@Entity
@Table(name = "Profesor")

public class Profesor implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;

    // Mapeado de la relación 1:1 entre Profesor y Direccion (relacionados por ID) -> @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamos las dos tablas (clases) por sus claves primaria -> @PrimaryKeyJoinColumn
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // Mapeado de la relación 1:1 entre Profesor y Despacho (relacionados por ID) -> @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamos las dos tablas (clases) por sus claves primaria -> @PrimaryKeyJoinColumn
    @PrimaryKeyJoinColumn
    private Despacho despacho;

    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProfesor")
    @IndexColumn(name = "idX")
    private List<Email> emails;

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Profesor() {
    }

    public Profesor(int id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public String toString() {
        return  " ID: " + id +
                " Nombre: " + nombre +
                " Apellido1: " + apellido1 +
                " Apellido2: " + apellido2 ;
    }
}
