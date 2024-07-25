package g7_sena_hibernate.dao;

import static g7_sena_hibernate.dao.GenericoDAO.em;
import g7_sena_hibernate.domain.Tratamiento;

import jakarta.persistence.Query;
import java.util.List;


public class TratamientoDAO extends GenericoDAO {

    public List<Tratamiento> listar() {
        String consulta = "SELECT c FROM Tratamiento c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Tratamiento tratamiento) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tratamiento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
      public void actualizar(Tratamiento tratamiento) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(tratamiento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
        public void eliminar(Tratamiento tratamiento) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(tratamiento));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
       
     
        public Object buscarPorID (Tratamiento tratamiento){
        em = getEntityManager();
        return em.find(Tratamiento.class, tratamiento.getId_tratamiento());
        }

   
    
    
        
        
        
}