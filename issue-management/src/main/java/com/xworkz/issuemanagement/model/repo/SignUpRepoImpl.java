package com.xworkz.issuemanagement.model.repo;

import com.xworkz.issuemanagement.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class SignUpRepoImpl implements  SignUpRepo{

    public SignUpRepoImpl()
    {
        System.out.println("Creating SignUpRepoImpl");
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public boolean save(SignUpDTO signUpDTO) {
            System.out.println("Running save method in SignUpRepoImpl");
            EntityManager manager = this.entityManagerFactory.createEntityManager();
            EntityTransaction tx = manager.getTransaction();

            try {
                tx.begin();
                manager.persist(signUpDTO);
                //manager.merge(signUpDTO);

                tx.commit();
            } catch (PersistenceException persistenceException) {
                persistenceException.printStackTrace();
                tx.rollback();
            } finally {
                manager.close();
            }
            return true;
        }

    @Override
    public SignUpDTO findByEmailAndPassword(String email, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            String query = "SELECT s FROM SignUpDTO s where s.email=:email AND s.password=:password";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("email", email);
            query1.setParameter("password", password);
            SignUpDTO signUpDTO = (SignUpDTO) query1.getSingleResult();
            System.out.println(signUpDTO);
            entityTransaction.commit();
            return signUpDTO;

        } catch (NoResultException  e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

}

