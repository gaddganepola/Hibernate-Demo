package org.example.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
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
        d2.setVehicles(Arrays.asList(v2, v3));

        Driver d3 = new Driver();
        d3.setId(103);
        d3.setName("Nuwan");
        d3.setVehicles(Arrays.asList(v3));

        v1.setDrivers(Arrays.asList(d1));
        v2.setDrivers(Arrays.asList(d1, d2));
        v3.setDrivers(Arrays.asList(d2, d3));


        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.mapping.manytomany.Driver.class);
        config.addAnnotatedClass(org.example.mapping.manytomany.Vehicle.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        session.persist(v1);
        session.persist(v2);
        session.persist(v3);
        session.persist(d1);
        session.persist(d2);
        session.persist(d3);

        t.commit();

        d1 = session.byId(Driver.class).load(101);
        System.out.println(d1);

        session.close();
        sf.close();

    }
}
