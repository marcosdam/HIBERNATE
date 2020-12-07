package EjemploHibernate.Models;

import javax.persistence.*;
import java.io.Serializable;
// Mapeado JPA (@Entity representada en @Table (nombre direccion) -> ANTES DE DECLARAR LA CLASE
@Entity
@Table(name = "Direccion")

public class Direccion implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre calle) etc
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "provincia")
    private String provincia;

    // No es necesario hacer relaciones aquí, ya que ya las hemos hecho en Profesor (clase y xml)
    // No puede existir dirección sin profesor, pero sí profesor sin dirección

    public Direccion() {
    }

    public Direccion(int id, String calle, int numero, String poblacion, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return " ID: " + id +
                " Calle: " + calle +
                " Número: " + numero +
                " Población: " + poblacion +
                " Provincia: " + provincia;
    }
}
