package EjemploHibernate.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "email")
public class Email implements Serializable {
    // Mapeado JPA
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "direccionCorreo")
    private String direccionMail;
    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    public Email() {
    }

    public Email(int id, String direccionMail, Profesor profesor) {
        this.id = id;
        this.direccionMail = direccionMail;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionMail() {
        return direccionMail;
    }

    public void setDireccionMail(String direccionMail) {
        this.direccionMail = direccionMail;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return " Email -> " +
                " ID: " + id +
                " Direccion eMail: " + direccionMail;
    }
}
