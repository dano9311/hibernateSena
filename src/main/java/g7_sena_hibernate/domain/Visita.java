package g7_sena_hibernate.domain;


import jakarta.persistence.*;
import java.io.Serializable;


@Entity 
public class Visita implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id_visita;
    
    private String modalidad_visita;
    
    @JoinColumn(name="id_paciente")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name="id_tratamiento")
    @ManyToOne
    private Tratamiento tratamiento;
    
        
  

    public Visita() {
    }

    public Visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public String getModalidad_visita() {
        return modalidad_visita;
    }

    public void setModalidad_visita(String modalidad_visita) {
        this.modalidad_visita = modalidad_visita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Visita{" + "id__visita=" + id_visita + ", modalidad_visita=" + modalidad_visita + ", paciente=" + paciente + ", tratamiento=" + tratamiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_visita;
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
        final Visita other = (Visita) obj;
        return this.id_visita == other.id_visita;
    }

    
    
            

}
