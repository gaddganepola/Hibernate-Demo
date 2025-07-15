package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.Student.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Student s = new Student();
        s.setId(9);
        s.setName("Nimesh");
        s.setAge(20);

        Student s1 = session.byId(Student.class).load(1);
        System.out.println("Before Update: " + s1);
        s1.setName("Dayan");

        Transaction transaction = session.beginTransaction();
        session.merge(s);
        session.merge(s1);
        transaction.commit();

        s1 = session.byId(Student.class).load(1);
        System.out.println("After Update: " + s1);

        session.close();
        sf.close();

    }
}
