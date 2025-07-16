package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateTable {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.Car.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Car c = new Car();
        c.setId(1);
        c.setName("Toyota");
        c.setBrand("Camry");
        c.setColor("Red");

        Transaction t = session.beginTransaction();
        session.persist(c);
        t.commit();

        session.close();
        sf.close();
    }
}
