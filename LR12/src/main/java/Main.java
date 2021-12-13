import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Items.class)
//                .buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//
//        try{
//            session = factory.getCurrentSession();
//
//            for(int i = 0; i<10; i++){
//                session = factory.getCurrentSession();
//                Items item = new Items();
//                item.setVal(0);
//                session.beginTransaction();
//                session.save(item);
//                session.getTransaction().commit();
//            }
//
//        }
//
//        finally {
//            factory.close();
//            session.close();
//        }


        // Flow
        for (int i = 0; i<8;i++){
            Thread flow = new Thread(new Run());
            flow.start();
        }
    }
}
