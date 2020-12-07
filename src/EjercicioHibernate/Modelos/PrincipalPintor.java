package EjercicioHibernate.Modelos;

import EjemploHibernate.Models.Despacho;
import EjemploHibernate.Models.Direccion;
import EjemploHibernate.Models.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PrincipalPintor {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        List<Pintor> pintores, pintores2;
        pintores = new ArrayList<>();
        pintores2 = new ArrayList<>();

        // Crear objetos para insertar en BD
        // 1. Pintor "normal"
        Pintor pintor = new Pintor(11, "José", "Fernández", "Sánchez", 5,
                new Agente(11, "Paco", pintores));

        // 2. Profesor con estudio
        Pintor pintor1 = new Pintor(12, "Javi", "Roca", "Sánchez", 7, new Agente(12, "Mario", pintores2));
        Estudio estudio1 = new Estudio(12, );
        // Asignar estudio al pintor y viceversa
        estudio1.setPintor(pintor1);
        pintor1.setEstudio(estudio1);








        // Comenzar las transacciones donde hacer el CRUD
        // session.beginTransaction();


        // 1. Guardar objeto en la BD (sesión)
        session.beginTransaction();
        session.save(pintor);
        session.save(pintor1);
        session.getTransaction().commit();
        session.close();


        // 2. Leer (CAST del objeto)
        /*
        // session.beginTransaction();
        Profesor profesor1 = (Profesor)session.get(Profesor.class, 1);
        System.out.println(profesor1.toString());
        session.close();
        */

        // 3. ACTUALIZAR
        /*
        session.beginTransaction();
        session.update(new Profesor(1, "Manolo", "Pérez", "García"));
        session.getTransaction().commit();
        session.close();
        */

        // 4. ELIMINAR
        /*
        session.beginTransaction();
        session.delete(profesor);
        session.getTransaction().commit();
        session.close();
        */

        /*
        // 5. GUARDAR (ACTUALIZAR SI YA EXISTE)
        Profesor profe = new Profesor(12, "Ana", "García", "López");
        session.beginTransaction();
        session.saveOrUpdate(profe);
        session.getTransaction().commit();
        session.close();
        */
    }
}
