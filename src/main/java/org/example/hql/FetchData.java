package org.example.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchData {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.hql.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        //SELECT * FROM student WHERE id = 3 - SQL
        //from Student - HQL
        Query<Student> query = session.createQuery("from Student where age = 16", Student.class);
        List<Student> students = query.getResultList();

        System.out.println(students);

        session.close();
        sf.close();
    }
}
