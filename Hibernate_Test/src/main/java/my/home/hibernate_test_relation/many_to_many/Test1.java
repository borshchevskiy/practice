package my.home.hibernate_test_relation.many_to_many;

import my.home.hibernate_test_relation.many_to_many.entity.Child;
import my.home.hibernate_test_relation.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section footballSection = new Section("Football");
//
//            Child child1 = new Child("Vanya", 5);
//            Child child2 = new Child("Pavlik", 6);
//            Child child3 = new Child("Kolya", 7);
//
//            footballSection.addChildToSection(child1);
//            footballSection.addChildToSection(child2);
//            footballSection.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(footballSection);
//
//            session.getTransaction().commit();

            //----------------------------------------------------------

//            session = factory.getCurrentSession();
//
//            Section basketballSection = new Section("Basketball");
//            Section chessSection = new Section("Chess");
//            Section danceSection = new Section("Dance");
//
//            Child child1 = new Child("Igor", 10);
//
//            child1.addSectionToChild(basketballSection);
//            child1.addSectionToChild(chessSection);
//            child1.addSectionToChild(danceSection);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();

            //----------------------------------------------------------

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class,1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();

            //----------------------------------------------------------

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();

            //----------------------------------------------------------

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 4);
//
//            session.delete(section);
//
//            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
