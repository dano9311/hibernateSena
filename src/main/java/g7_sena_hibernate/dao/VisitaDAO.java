package g7_sena_hibernate.dao;

import static g7_sena_hibernate.dao.GenericoDAO.em;
import g7_sena_hibernate.domain.Visita;
import jakarta.persistence.Query;
import java.util.List;



public class VisitaDAO extends GenericoDAO {

    public List<Visita> listar() {
        String consulta = "SELECT c FROM Visita c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Visita visita) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(visita);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
      public void actualizar(Visita visita) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(visita);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
        public void eliminar(Visita visita) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(visita));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
        public Object buscarPorID (Visita visita){
        em = getEntityManager();
        return em.find(Visita.class, visita.getId_visita());
        }
}