package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   public void deleteByName(String name) {
      Session session = sessionFactory.getCurrentSession();
      TypedQuery<Car> query = session.createQuery("from Car where name = :name");
      query.setParameter("name", name);
      Car car = query.getResultList().get(0);
      session.delete(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User getUser(String name, int series) {
       String hql = "from User u where u.car.name = :name and u.car.series = :series";
       TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
       query.setParameter("name", name);
       query.setParameter("series", series);
       User user = query.getResultList().get(0);

       return user;
   }

}
