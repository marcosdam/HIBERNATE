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

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Crear objetos para insertar en BD
        Agente agente1 = new Agente(1, "Miguel López Pérez", 2);

        Pintor pintor1 = new Pintor(1, "Paco", "Fernández", "Sánchez", 5);
        Pintor pintor2 = new Pintor(1, "María", "Gómez", "Martínez", 7);

        Estudio estudio1 = new Estudio(1, "Planta baja", "Avenida Valladolid", 30, 46020, "Valencia" );
        Estudio estudio2 = new Estudio(1, "Plaza del barrio", "Emilio Baró0", 3, 46020, "Valencia" );

        pintor1.setEstudio(estudio1);
        pintor2.setEstudio(estudio2);

        Cuadro cuadro1 = new Cuadro(1, "Loquesea", 1992);
        Cuadro cuadro2 = new Cuadro(2, "Blablabla", 1951);
        Cuadro cuadro3 = new Cuadro(3, "Trambólico", 1934);
        Cuadro cuadro4 = new Cuadro(4, "Locura", 1894);


        List<Cuadro> cuadros1 = new ArrayList<>();
        cuadros1.add(cuadro1);
        cuadros1.add(cuadro2);
        pintor1.setCuadros(cuadros1);

        List<Cuadro> cuadros2 = new ArrayList<>();
        cuadros2.add(cuadro3);
        cuadros2.add(cuadro4);
        pintor2.setCuadros(cuadros2);

        List<Pintor> pintores = new ArrayList<>();
        pintores.add(pintor1);
        pintores.add(pintor2);

        agente1.setPintores(pintores);
        //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 1. Guardar o actualizar objeto en la BD (sesión)
        session.beginTransaction();
        session.saveOrUpdate(agente1);
        session.getTransaction().commit();
        session.close();

        // SELECT PINTORES
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Pintor> misPintores = session.createQuery("from Pintor").list();
        for (Pintor p: misPintores){
            System.out.println(p.toString());
        }


        // 2. Leer (CAST del objeto)
        /*
        // session.beginTransaction();
        Pintor pintor1 = (Pintor)session.get(Pintor.class, 12);
        System.out.println(pintor1.toString());
        session.close();
        */

        // 3. ACTUALIZAR
        /*
        session.beginTransaction();
        session.update(new Pintor(12, "Javi", "Pérez", "García", 8, new Agente(12, "Mario", pintores2)));
        session.getTransaction().commit();
        session.close();
        */

        // 4. ELIMINAR
        /*
        session.beginTransaction();
        session.delete(pintor);
        session.getTransaction().commit();
        session.close();
        */

        /*
        // 5. GUARDAR (ACTUALIZAR SI YA EXISTE)
        Pintor pintor = new Pintor(11, "Miguel", "Simón", "Castro", 4, new Agente(12, "Mario", pintores2));
        session.beginTransaction();
        session.saveOrUpdate(pintor);
        session.getTransaction().commit();
        session.close();
        */
    }
}
