import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Random;

public class Run implements Runnable {

    @Override
    public void run() {
        Random rnd = new Random();

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Items.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Thread.sleep(5);
            for (int i = 0; i < 1000; i++) {
                int r = rnd.nextInt(10) + 1;
                session = factory.getCurrentSession();
                session.beginTransaction();
                session.createQuery("update Items set val = val + 1 where id = " + r).executeUpdate();
                try{
                    session.getTransaction().commit();
                }
                catch  (OptimisticLockException e)  {
                    session.getTransaction().rollback();
                    e.printStackTrace();
                }

            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();

        }
        finally {
            factory.close();
            session.close();
        }

    }
}
