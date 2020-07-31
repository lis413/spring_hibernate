package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserCarSeries(int series1) {
     // TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("From User where car.series = :ser ").setParameter("ser", series1);
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("From User where car.series = 2 ");
      List<User> list = ((Query<User>) query).list();
      if (list.size() > 0) {
         User user = list.get(0);
         return user;
      } else { return null;
      }

   }


}
