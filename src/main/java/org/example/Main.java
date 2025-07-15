package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(004);
        s1.setName("Ruwan");
        s1.setAge(20);

//        Configuration config = new Configuration();
//        config.addAnnotatedClass(org.example.Student.class);
//        config.configure();
//
//        SessionFactory sf = config.buildSessionFactory();

        //Optimize the above code set
        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();

        //Open a session
        Session session = sf.openSession();

        //Begin a transaction
        Transaction transaction = session.beginTransaction();

        //Persist the object/ save
        session.persist(s1);

        //Commit the transaction
        transaction.commit();

        session.close();

        sf.close();

    }
}