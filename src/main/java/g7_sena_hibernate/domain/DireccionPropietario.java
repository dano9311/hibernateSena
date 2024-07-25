package g7_sena_hibernate.domain;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class DireccionPropietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccionPropietario")
    private int idDireccionPropietario;
    @Column(name = "calle_direccionPropietario")
    private String calleDireccionPropietario;
    @Column(name = "num_direccionPropietario")
    private String numDireccionPropietario;
    @Column(name = "pais_direccionPropietario")
    private String paisDireccionPropietario;

    public DireccionPropietario() {
    }

    public DireccionPropietario(int idDireccionPropietario) {
        this.idDireccionPropietario = idDireccionPropietario;
    }

    public int getIdDireccionPropietario() {
        return idDireccionPropietario;
    }

    public void setIdDireccionPropietario(int idDireccionPropietario) {
        this.idDireccionPropietario = idDireccionPropietario;
    }

    public String getCalleDireccionPropietario() {
        return calleDireccionPropietario;
    }

    public void setCalleDireccionPropietario(String calleDireccionPropietario) {
        this.calleDireccionPropietario = calleDireccionPropietario;
    }

    public String getNumDireccionPropietario() {
        return numDireccionPropietario;
    }

    public void setNumDireccionPropietario(String numDireccionPropietario) {
        this.numDireccionPropietario = numDireccionPropietario;
    }

    public String getPaisDireccionPropietario() {
        return paisDireccionPropietario;
    }

    public void setPaisDireccionPropietario(String paisDireccionPropietario) {
        this.paisDireccionPropietario = paisDireccionPropietario;
    }

    @Override
    public String toString() {
        return "DireccionPropietario{" + 
                "idDireccionPropietario=" + idDireccionPropietario + 
                ", calleDireccionPropietario=" + calleDireccionPropietario + 
                ", numDireccionPropietario=" + numDireccionPropietario +
                ", paisDireccionPropietario=" + paisDireccionPropietario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idDireccionPropietario;
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
        final DireccionPropietario other = (DireccionPropietario) obj;
        return this.idDireccionPropietario == other.idDireccionPropietario;
    }
    
    

}
