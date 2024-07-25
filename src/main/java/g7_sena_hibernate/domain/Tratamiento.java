package g7_sena_hibernate.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tratamiento implements Serializable {

    @Id
    private int id_tratamiento;

    private String nombre_tratamiento;
    private double precio_tratamiento;

    @OneToMany(mappedBy = "tratamiento")
    private List<Visita> visitas;

    public Tratamiento() {
    }

    public Tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getNombre_tratamiento() {
        return nombre_tratamiento;
    }

    public void setNombre_tratamiento(String nombre_tratamiento) {
        this.nombre_tratamiento = nombre_tratamiento;
    }

    public double getPrecio_tratamiento() {
        return precio_tratamiento;
    }

    public void setPrecio_tratamiento(double precio_tratamiento) {
        this.precio_tratamiento = precio_tratamiento;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }

    
    @Override
    public String toString() {
        return "Tratamiento{" + "id_tratamiento=" + id_tratamiento + ", nombre_tratamiento=" + nombre_tratamiento + ", precio_tratamiento=" + precio_tratamiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id_tratamiento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tratamiento other = (Tratamiento) obj;
        return this.id_tratamiento == other.id_tratamiento;
    }

}
