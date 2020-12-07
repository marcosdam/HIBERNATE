package EjemploHibernate;

import EjemploHibernate.Models.Despacho;
import EjemploHibernate.Models.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrincipalDespacho {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        // Crear objetos para insertar en BD
        Despacho despacho = new Despacho(12, 123, 1);
        Profesor profesor = new Profesor(12, "Ana","Salinas","Berasategui");
        // Asignar despacho al profesor y viceversa
        profesor.setDespacho(despacho);
        despacho.setProfesor(profesor);

        // Lo mismo con un nuevo profesor y nuevo despacho
        Despacho despacho2 = new Despacho(13, 212, 2);
        Profesor profesor2 = new Profesor(13, "Pedro","Ugarte","Martínez");
        profesor2.setDespacho(despacho2);
        despacho2.setProfesor(profesor2);

        // Comenzar las transacciones donde hacer el CRUD
        session.beginTransaction();


        // 1. Guardar objetos en la BD (sesión)
        // (BIDIRECCIONAL -> al guardar profesor guardas despacho, y al guardar despacho 2 guardas profesor2)
        session.save(profesor);
        session.save(despacho2);

        session.getTransaction().commit();
        session.close();
    }
}
