package org.example.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateStudents {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Ruwan");
        s1.setAge(15);
        s1.setGrade(10);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Dayan");
        s2.setAge(16);
        s2.setGrade(11);

        Student s3 = new Student();
        s3.setId(3);
        s3.setName("Migara");
        s3.setAge(16);
        s3.setGrade(11);

        Student s4 = new Student();
        s4.setId(4);
        s4.setName("Migara");
        s4.setAge(16);
        s4.setGrade(11);

        Student s5 = new Student();
        s5.setId(5);
        s5.setName("Aruna");
        s5.setAge(10);
        s5.setGrade(5);

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.hql.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);
        session.persist(s5);

        t.commit();

        session.close();
        sf.close();


    }
}
