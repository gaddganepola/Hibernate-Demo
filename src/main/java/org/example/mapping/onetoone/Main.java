package org.example.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle();
        v1.setId(1);
        v1.setBrand("Toyota");
        v1.setRegistrationNo("ASD - 1234");

        Driver d1 = new Driver();
        d1.setId(101);
        d1.setName("Ruwan");
        d1.setVehicle(v1);

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.mapping.onetoone.Driver.class);
        config.addAnnotatedClass(org.example.mapping.onetoone.Vehicle.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        session.persist(v1);
        session.persist(d1);

        t.commit();

        session.close();
        sf.close();
    }
}
