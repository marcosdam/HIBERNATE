package EjemploHibernate;

import EjemploHibernate.Models.Despacho;
import EjemploHibernate.Models.Direccion;
import EjemploHibernate.Models.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrincipalProfesor {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        // Crear objetos para insertar en BD
        // 1. Profesor "normal"
        Profesor profesor = new Profesor(14, "José", "Fernández", "Sánchez");

        // 2. Profesor con dirección y despacho
        Profesor profesor1 = new Profesor(15, "Javi", "Roca", "Gómez");
        Despacho despacho1 = new Despacho(15, 232, 5);
        Direccion direccion1 = new Direccion(15, "Emilio Baró", 67,"Valencia", "Benimaclet");
        // Asignar despacho y dirección al profesor y viceversa
        despacho1.setProfesor(profesor1);
        profesor1.setDespacho(despacho1);
        profesor1.setDireccion(direccion1);

        // 3. Profesor sólo con dirección
        Profesor profesor2 = new Profesor(16, "Adolfo", "Sanz", "Sanchis");
        Direccion direccion2 = new Direccion(16, "Avenida Valladolid", 3, "Valencia", "Benimaclet");
        profesor2.setDireccion(direccion2);

        // 4. Profesor sólo con despacho
        Profesor profesor3 = new Profesor(17, "Fran", "San Juan", "Robledo");
        Despacho despacho3 = new Despacho(17, 454, 7);
        profesor3.setDespacho(despacho3);
        despacho3.setProfesor(profesor3);

        // Comenzar las transacciones donde hacer el CRUD
        // session.beginTransaction();


        // 1. Guardar objeto en la BD (sesión)
        session.beginTransaction();
        session.save(profesor);
        session.save(profesor1);
        session.save(profesor2);
        session.save(profesor3);
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
