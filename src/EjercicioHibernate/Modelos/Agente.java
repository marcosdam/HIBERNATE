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
    @Column(name = "numero_pintores")
    private int numero_pintores;

    // 1 agente puede tener muchos pintores (1 pintor será llevado por 1 agente)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_agente")     // Clave ajena
    @IndexColumn(name = "id_x_agente")    // Índice
    private List<Pintor> pintores;
    public List<Pintor> getPintores() {
        return pintores;
    }
    public void setPintores(List<Pintor> pintores) {
        this.pintores = pintores;
    }

    public Agente() {
    }

    public Agente(int id_agente, String nombre, int numero_pintores) {
        this.id_agente = id_agente;
        this.nombre = nombre;
        this.numero_pintores = numero_pintores;
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

    public int getNumero_pintores() {
        return numero_pintores;
    }

    public void setNumero_pintores(int numero_pintores) {
        this.numero_pintores = numero_pintores;
    }

    @Override
    public String toString() {
        return "Id: " + id_agente +
                " Nombre: " + nombre +
                " Número de pintores: " + numero_pintores;
    }
}
