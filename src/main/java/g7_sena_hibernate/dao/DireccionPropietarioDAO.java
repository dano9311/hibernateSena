package g7_sena_hibernate.dao;



import g7_sena_hibernate.domain.DireccionPropietario;
import jakarta.persistence.Query;
import java.util.List;

public class DireccionPropietarioDAO extends GenericoDAO {

    public List<DireccionPropietario> listar() {
        String consulta = "SELECT d FROM DireccionPropietario d";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(DireccionPropietario direccionPropietario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(direccionPropietario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
      public void actualizar(DireccionPropietario direccionPropietario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(direccionPropietario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
        public void eliminar(DireccionPropietario direccionPropietario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(direccionPropietario));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
        public Object buscarPorID (DireccionPropietario direccionPropietario){
        em = getEntityManager();
        return em.find(DireccionPropietario.class, direccionPropietario.getIdDireccionPropietario());
        }
}
