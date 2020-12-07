package EjercicioHibernate.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Estudio")
public class Estudio implements Serializable {
    // Mapeado JPA de los atributos (@Id -> @Column (nombre id) / @Column (nombre apellido1) etc
    @Id
    @Column(name = "id_estudio")
    private int id_estudio;
    @Column(name = "lugar_de_trabajo")
    private String lugar_de_trabajo;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;
    @Column(name = "codigo_postal")
    private int codigo_postal;
    @Column(name = "localidad")
    private String localidad;

    // 1 pintor tendrá 1 estudio (y 1 estudio tendrá 1 pintor)
    @OneToOne(cascade = CascadeType.ALL)
    // Relacionamos las dos tablas (clases) por sus claves primaria -> @PrimaryKeyJoinColumn
    @PrimaryKeyJoinColumn
    private Pintor pintor;
    public Pintor getPintor() {
        return pintor;
    }
    public void setPintor(Pintor pintor) {
        this.pintor = pintor;
    }

    public Estudio() {
    }

    public Estudio(int id_estudio, String lugar_de_trabajo, String calle, int numero, int codigo_postal, String localidad) {
        this.id_estudio = id_estudio;
        this.lugar_de_trabajo = lugar_de_trabajo;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.localidad = localidad;
    }

    public int getId_estudio() {
        return id_estudio;
    }

    public void setId_estudio(int id_estudio) {
        this.id_estudio = id_estudio;
    }

    public String getLugar_de_trabajo() {
        return lugar_de_trabajo;
    }

    public void setLugar_de_trabajo(String lugar_de_trabajo) {
        this.lugar_de_trabajo = lugar_de_trabajo;
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

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return " Id del estudio: " + id_estudio +
                " Lugar de trabajo: " + lugar_de_trabajo + '\'' +
                " Calle: " + calle + '\'' +
                " Número: " + numero +
                " Código Postal: " + codigo_postal +
                " Localidad: " + localidad;
    }
}
