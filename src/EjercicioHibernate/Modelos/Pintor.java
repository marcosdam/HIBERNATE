package EjercicioHibernate.Modelos;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Mapeado JPA (@Entity representada en @Table (nombre pintor) -> ANTES DE DECLARAR LA CLASE
@Entity
@Table(name = "Pintor")
public class Pintor implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id_pintor")
    private int id_pintor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "numero_cuadros")
    private int numero_cuadros;

    // 1 agente puede llevar a muchos pintores (1 pintor puede ser llevado por 1 agente)    N:1
    @ManyToOne
    @JoinColumn(name = "id_agente")     // Clave ajena
    private Agente agente;
    public Agente getAgente() {
        return agente;
    }
    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    // 1 estudio tendrá 1 pintor y 1 pintor tendrá 1 estudio    1:1
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Estudio estudio;
    public Estudio getEstudio() {
        return estudio;
    }
    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    // 1 cuadro tiene 1 pintor y 1 pintor muchos cuadros    1:N
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pintor")     // Clave ajena
    @IndexColumn(name = "id_x_pintor")  // Índice
    private List<Cuadro> cuadros;
    public List<Cuadro> getCuadros() {
        return cuadros;
    }
    public void setCuadros(List<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    public Pintor() {
    }

    public Pintor(int id, String nombre, String apellido1, String apellido2, int numeroCuadros) {
        this.id_pintor = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numero_cuadros = numeroCuadros;
    }

    public int getId_pintor() {
        return id_pintor;
    }

    public void setId_pintor(int id_pintor) {
        this.id_pintor = id_pintor;
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

    public int getNumero_cuadros() {
        return numero_cuadros;
    }

    public void setNumero_cuadros(int numeroCuadros) {
        this.numero_cuadros = numeroCuadros;
    }

    @Override
    public String toString() {
        return " Id: " + id_pintor +
                " Nombre: " + nombre + '\'' +
                " Apellido 1: " + apellido1 + '\'' +
                " Apellido 2: " + apellido2 + '\'' +
                " Número de Cuadros: " + numero_cuadros;
    }
}
