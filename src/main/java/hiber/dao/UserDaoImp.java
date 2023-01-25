package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;
   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
   }
   @Override
   public User UserCar(String modelCar, int seriesCar) {

      Car car = sessionFactory.getCurrentSession().createQuery("from Car where model = : param1 AND series = :param2", Car.class).
              setParameter("param1", modelCar).
              setParameter("param2", seriesCar).
              uniqueResult();

      User user = car.getUser();
      return user;
   }

}
