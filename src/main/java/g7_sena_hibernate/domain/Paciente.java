

package g7_sena_hibernate.domain;



import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Paciente implements Serializable {
    
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int id_paciente;

    private String nombre_paciente;
    private String apellido_paciente;

    @JoinColumn(name = "id_direccionPropietario") //Es opcional el segundo parametro por que se llaman igual en ambas tablas
    @ManyToOne
    private DireccionPropietario direccionPropietario;

    @JoinColumn(name="id_contacto", referencedColumnName = "id_contacto")//Es opcional el segundo parametro por que se llaman igual en ambas tablas
    @ManyToOne
    private Contacto contacto;

    
    @OneToMany(mappedBy = "paciente")
    private List<Visita> visitas;
    
    public Paciente () {
    }

    public Paciente (int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public DireccionPropietario getDireccionPropietario() {
        return direccionPropietario;
    }

    public void setDireccionPropietario(DireccionPropietario direccionPropietario) {
        this.direccionPropietario = direccionPropietario;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Visita> getVisita() {
        return visitas;
    }

    public void setVisita(List<Visita> visita) {
        this.visitas = visita;
    }

   

  

    @Override
    public String toString() {
        return "Paciente{" + "id_paciente=" + id_paciente + ", nombre_paciente=" + nombre_paciente + ", apellido_paciente=" + apellido_paciente + ", direccionPropietario=" + direccionPropietario + ", contacto=" + contacto + '}';
    }

    
    
  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_paciente;
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
        final Paciente other = (Paciente) obj;
        return this.id_paciente == other.id_paciente;
    }

    
    
}
