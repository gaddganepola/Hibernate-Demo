package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {
        Laptop l = new Laptop();
        l.setBrand("Dell");
        l.setRam(8);
        l.setModel("XPS");

        Car c = new Car();
        c.setId(1);
        c.setName("Toyota");
        c.setBrand("Camry");
        c.setColor("Red");
        c.setLaptop(l);


        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.Car.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();
        session.persist(c);
        t.commit();

        c = session.byId(Car.class).load(1);
        System.out.println(c);

        session.close();
        sf.close();
    }
}
