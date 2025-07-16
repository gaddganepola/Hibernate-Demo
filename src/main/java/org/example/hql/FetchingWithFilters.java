package org.example.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchingWithFilters {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.hql.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        int age = 16;

        Query<Student> query1 = session.createQuery("from Student where age = ?1", Student.class);
        query1.setParameter(1, age);
        List<Student> students = query1.getResultList();
        System.out.println("Query 1: " + students);

        Query<Student> query2 = session.createQuery("from Student where age = ?1 and name = ?2", Student.class);
        query2.setParameter(1, age);
        query2.setParameter(2, "Dayan");
        List<Student> students1 = query2.getResultList();
        System.out.println("Query 2: " + students1);

        Query<Integer> query3 = session.createQuery("select id from Student where age = ?1 and name = ?2", Integer.class);
        query3.setParameter(1, age);
        query3.setParameter(2, "Dayan");
        List<Integer> students2 = query3.getResultList();
        System.out.println("Query 3: " + students2);

        Query<Integer> query4 = session.createQuery("select id from Student where age = ?1", Integer.class);
        query4.setParameter(1, age);
        List<Integer> students3 = query4.getResultList();
        System.out.println("Query 4: " + students3);



        session.close();
        sf.close();
    }
}
