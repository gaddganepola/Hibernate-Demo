package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(org.example.Student.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Student s = session.byId(Student.class).load(9);

        Transaction transaction = session.beginTransaction();
        session.remove(s);
        transaction.commit();

        session.close();
        sf.close();
    }
}
