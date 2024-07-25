package g7_sena_hibernate.test;

import g7_sena_hibernate.dao.TratamientoDAO;
import g7_sena_hibernate.dao.GenericoDAO;
import g7_sena_hibernate.domain.Tratamiento;
import java.util.List;

public class TestFull extends GenericoDAO {

    public static void main(String[] args) {
        TestFull prueba1 = new TestFull();
        prueba1.mostarTratamientos();
        System.out.println("Llamado a la función insertar");
        prueba1.insertarTratamiento();
        System.out.println("Llamado a consultar ID 3");
        prueba1.obtenerTratamientoPorId(3);
        System.out.println("LLamado a modificar");
        prueba1.modificarTratamientoPorId(3);
        System.out.println("LLamado a Eliminar");
        prueba1.eliminarTratamientoPorId(13);
    }

    public void mostarTratamientos() {
        System.out.println("___________________________Listar Tratamientos_________________________:");
        // Estado Transitorio
        TratamientoDAO tratamientoDAOListar = new TratamientoDAO();
        List<Tratamiento> tratamientos = tratamientoDAOListar.listar();
        for (Tratamiento c : tratamientos) {
            System.out.println("Tratamiento: " + c.getNombre_tratamiento() + ", Precio: " + c.getPrecio_tratamiento());
        }
    }

    public void insertarTratamiento() {
        System.out.println("___________________________Insertar Tratamiento_________________________:");

        // Estado Transitorio
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setNombre_tratamiento("Tratamiento Final");
        tratamiento.setPrecio_tratamiento(255000);

        try {
            em = getEntityManager();
            // Estado Persistente - Inicio de la transacción
            em.getTransaction().begin();
            em.persist(tratamiento); // Persistencia del nuevo tratamiento en la base de datos
            em.getTransaction().commit(); // Confirmación de la transacción
        } catch (Exception e) {
            if (em == null) {
                e.printStackTrace(System.out);
            }
        } finally {
            em.close(); // Estado Detached - Cierre del EntityManager
        }
        System.out.println("Nuevo Tratamiento = " + tratamiento);
    }

    public void obtenerTratamientoPorId(int id) {
        System.out.println("___________________________Obtener Tratamiento ID: " + id + "_________________________:");

        // Estado Transitorio
        em = null;
        try {
            em = getEntityManager();
            // Estado Persistente - Búsqueda del Tratamiento por su ID
            Tratamiento tratamiento = em.find(Tratamiento.class, id);
            if (tratamiento != null) {
                System.out.println("tratamiento: " + tratamiento);
            } else {
                System.out.println("No se encontró un tratamiento con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close(); // Estado Detached - Cierre del EntityManager
            }
        }
    }

    public void modificarTratamientoPorId(int id) {
        System.out.println("___________________________Modificar Tratamiento ID: " + id + "_________________________:");

        // Estado Transitorio
        em = null;
        try {
            em = getEntityManager();
            // Estado Persistente - Inicio de la transacción
            em.getTransaction().begin();
            Tratamiento tratamiento = em.find(Tratamiento.class, id); // Búsqueda del tratamiento por su ID

            if (tratamiento != null) {
                tratamiento.setNombre_tratamiento("DEMO");
                tratamiento.setPrecio_tratamiento(30.000);
                em.merge(tratamiento); // Actualización del tratamiento en la base de datos
                em.getTransaction().commit(); // Confirmación de la transacción
                System.out.println("Tratamiento a modificar " + tratamiento);
            } else {
                System.out.println("No se encontró un tratamiento con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback en caso de error
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close(); // Estado Detached - Cierre del EntityManager
            }
        }
    }

    public void eliminarTratamientoPorId(int id) {
        System.out.println("___________________________Eliminar Tratamiento ID: " + id + "_________________________:");

        // Estado Transitorio
        em = null;
        try {
            em = getEntityManager();
            // Estado Persistente - Búsqueda del tratamiento por su ID
            Tratamiento tratamiento = em.find(Tratamiento.class, id);
            if (tratamiento != null) {
                em.getTransaction().begin();
                em.remove(em.merge(tratamiento)); // Eliminación del tratamiento de la base de datos
                em.getTransaction().commit(); // Confirmación de la transacción
                System.out.println("Datos eliminados = " + tratamiento);
            } else {
                System.out.println("No se encontró un tratamiento con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close(); // Estado Detached - Cierre del EntityManager
            }
            closeEntityManagerFactory();
        }
    }
}
