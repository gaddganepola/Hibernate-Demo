package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchData {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();

        Session session = sf.openSession();

        Student s = session.byId(Student.class).load(3);

        session.close();
        sf.close();

        System.out.println(s);


    }
}
