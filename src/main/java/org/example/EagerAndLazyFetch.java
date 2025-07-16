package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class EagerAndLazyFetch {
    public static void main(String[] args) {

        Vehicle v1 = new Vehicle();
        v1.setId(1);
        v1.setBrand("Toyota");
        v1.setRegistrationNo("ASD - 1234");

        Vehicle v2 = new Vehicle();
        v2.setId(2);
        v2.setBrand("Isusu");
        v2.setRegistrationNo("CAY - 2569");

        Vehicle v3 = new Vehicle();
        v3.setId(3);
        v3.setBrand("Tata");
        v3.setRegistrationNo("LG - 2569");

        Driver d1 = new Driver();
        d1.setId(101);
        d1.setName("Nuwan");
        d1.setVehicles(Arrays.asList(v1, v2));

        Driver d2 = new Driver();
        d2.setId(102);
        d2.setName("Kasun");
        d2.setVehicles(Arrays.asList(v3));

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.Driver.class);
        config.addAnnotatedClass(org.example.Vehicle.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        session.persist(v1);
        session.persist(v2);
        session.persist(v3);
        session.persist(d1);
        session.persist(d2);

        t.commit();

        System.out.println("------------------------------------------");

//        d1 = session.byId(Driver.class).load(101);
//        System.out.println(d1);

        session.close();

        session = sf.openSession();
        d1 = session.byId(Driver.class).load(101);
//        System.out.println(d1);
        session.close();
        sf.close();

    }
}
