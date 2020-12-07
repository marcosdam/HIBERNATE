package EjercicioHibernate.Modelos;

import org.hibernate.annotations.IndexColumn;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Agente")
public class Agente implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id_agente")
    private int id_agente;
    @Column(name = "nombre")
    private String nombre;

    // 1 agente puede tener muchos pintores (1 pintor será llevado por 1 agente)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_agente")
    @IndexColumn(name = "id_pintor")
    private List<Pintor> pintores;
    public List<Pintor> getPintores() {
        return pintores;
    }
    public void setPintores(List<Pintor> pintores) {
        this.pintores = pintores;
    }

    public Agente() {
    }

    public Agente(int id, String nombre, List<Pintor> pintores) {
        this.id_agente = id;
        this.nombre = nombre;
        this.pintores = pintores;
    }

    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) {
        this.id_agente = id_agente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Id: " + id_agente +
                " Nombre: " + nombre;
    }
}
