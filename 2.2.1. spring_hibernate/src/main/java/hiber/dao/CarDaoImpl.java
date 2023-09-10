package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.persistence.Query;
@Repository
@Transactional

public class CarDaoImpl implements CarDao{

    private SessionFactory sessionFactory;
    @Autowired
    public CarDaoImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public User getByCar(String model, int series) {
        String sql = "FROM User where car.model=:model and car.series =: series";
        Query query = sessionFactory.getCurrentSession()
                .createQuery(sql);
        query.setParameter("model", model);
        query.setParameter("series", series);
        User user = (User) query.getSingleResult();
        return user;
    }
}
