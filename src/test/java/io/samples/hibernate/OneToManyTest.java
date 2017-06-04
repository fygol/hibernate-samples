package io.samples.hibernate;

import io.samples.hibernate.config.SessionFactoryBuilder;
import io.samples.hibernate.model.Role;
import io.samples.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class OneToManyTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SessionFactoryBuilder()
                .entities(User.class, Role.class)
                .build();;
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.close();
    }

    @Test
    public void setupTest() throws Exception {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setName("John");
        user.setRoles(new ArrayList<>());
        Role role = new Role();
//        session.save(role);
        role.setName("guest");
        user.getRoles().add(role);

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
