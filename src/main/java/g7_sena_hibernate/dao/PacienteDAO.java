package g7_sena_hibernate.dao;

import java.util.List;
import jakarta.persistence.*;
import g7_sena_hibernate.domain.Paciente;

public class PacienteDAO extends GenericoDAO {

    public List<Paciente> mostrar() {
        em = null;
        try {
            em = getEntityManager();
            String consulta = "SELECT a FROM Paciente a";
            Query query = em.createQuery(consulta);
            return query.getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void ingresar(Paciente paciente) {
        em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void modificar(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void eliminar(Paciente paciente) {
        em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(paciente));
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public Paciente buscarPorID(int id) {
        em = null;
        try {
            em = getEntityManager();
            return em.find(Paciente.class, id);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
