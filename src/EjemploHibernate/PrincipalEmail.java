package EjemploHibernate;

import EjemploHibernate.Models.Email;
import EjemploHibernate.Models.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PrincipalEmail {
    public static void main(String[] args) {
        // Establecer conexión con el mapeo ORM que intermedia entre Java y la BD
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // Abrir la sesión para trabajar con la base de datos
        Session session = sessionFactory.openSession();

        // Crear profesor con VARIOS correos
        Profesor p = new Profesor(93,"María", "Sánchez", "García");
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(6, "maria@cieep.com", p));
        emails.add(new Email(5, "maria@gmail.com", p));
        emails.add(new Email(4, "maria.profesor@gmail.com", p));

        // Añadirle la lista al profesor
        p.setEmails(emails);

        //
        // Comenzar transacciones
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }
}
