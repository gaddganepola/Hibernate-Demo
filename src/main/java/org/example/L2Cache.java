package org.example;
import org.example.hql.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class L2Cache {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.hql.Student.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Student s1 = session.byId(Student.class).load(3);
        System.out.println(s1);

        session.close();

        Session session2 = sf.openSession();
        Student s2 = session2.byId(Student.class).load(3);
        System.out.println(s2);

        session2.close();

        sf.close();
    }
}
