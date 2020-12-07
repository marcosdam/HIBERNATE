package EjercicioHibernate.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cuadro")
public class Cuadro implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id_cuadro")
    private int id_cuadro;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "anyo_creacion")
    private int anyo_creacion;

    // 1 cuadro tendrá 1 autor (1 autor puede tener muchos cuadros)
    @ManyToOne
    @JoinColumn(name = "id_pintor")
    private Pintor pintor;

    // No es necesario hacer relaciones aquí, ya que ya las hemos hecho en Pintor (clase y xml)
    // No puede existir cuadro sin pintor, pero sí pintorrofesor sin cuadro

    public Cuadro() {
    }

    public Cuadro(int id_cuadro, String nombre, int anyo_creacion, Pintor pintor) {
        this.id_cuadro = id_cuadro;
        this.nombre = nombre;
        this.anyo_creacion = anyo_creacion;
        this.pintor = pintor;
    }

    public int getId_cuadro() {
        return id_cuadro;
    }

    public void setId_cuadro(int id_cuadro) {
        this.id_cuadro = id_cuadro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo_creacion() {
        return anyo_creacion;
    }

    public void setAnyo_creacion(int anyo_creacion) {
        this.anyo_creacion = anyo_creacion;
    }

    public Pintor getPintor() {
        return pintor;
    }

    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    @Override
    public String toString() {
        return " Id del Cuadro: " + id_cuadro +
                " Nombre: " + nombre + '\'' +
                " Año de creación: " + anyo_creacion +
                " Pintor: " + pintor.toString();
    }
}
