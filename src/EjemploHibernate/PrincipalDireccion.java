package EjemploHibernate;

import EjemploHibernate.Models.Direccion;
import EjemploHibernate.Models.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrincipalDireccion {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        // Crear objetos para insertar en BD
        Direccion direccion = new Direccion(11, "Plaza España", 22, "Valencia", "Valencia");
        Profesor profesor = new Profesor(11, "Adrián","Martínez","García");
        // Asignar dirección al profesor
        profesor.setDireccion(direccion);

        // Comenzar las transacciones donde hacer el CRUD
        session.beginTransaction();


        // 1. Guardar objeto en la BD (sesión)
        session.save(profesor);
        session.getTransaction().commit();
        session.close();


        // 2. Leer (CAST del objeto)
        /*
        // session.beginTransaction();
        Direccion direccion1 = (Direccion)session.get(Direccion.class, 1);
        System.out.println(direccion1.toString());
        session.close();
        */

        // 3. ACTUALIZAR
        /*
        session.beginTransaction();
        session.update(new Direccion(1, "Avenida Valladolid", 3, "Valencia", "Alboraya"));
        session.getTransaction().commit();
        session.close();
        */

        // 4. ELIMINAR
        /*
        session.beginTransaction();
        session.delete(direccion);
        session.getTransaction().commit();
        session.close();
        */

        // 5. GUARDAR (ACTUALIZAR SI YA EXISTE)
        /*
        Direccion direc = new Direccion(1, "Emilio Baró", 67, "Valencia", "Valencia");
        session.beginTransaction();
        session.saveOrUpdate(direc);
        session.getTransaction().commit();
        session.close();
         */
    }
}
