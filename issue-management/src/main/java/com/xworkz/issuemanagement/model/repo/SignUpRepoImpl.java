package com.xworkz.issuemanagement.model.repo;

import com.xworkz.issuemanagement.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

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

//            TypedQuery<SignUpDTO> typedQuery = entityManager.createQuery(query, SignUpDTO.class);
//            typedQuery.setParameter("email", email);
//            typedQuery.setParameter("password", password);
//            return typedQuery.getSingleResult();

//        } catch (NoResultException   e) {
//            e.printStackTrace();
//            entityTransaction.rollback();

        } catch (NoResultException e) {
            System.out.println("No user found with the provided email and password");
            return null;
        } finally {
            entityManager.close();
        }

    }

    //count the failed attempts
    @Override
    public SignUpDTO findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("select c from SignUpDTO c where email=:email");
            query.setParameter("email", email);

            List<SignUpDTO> resultList = query.getResultList();
            if (resultList.isEmpty()) {
                return null;
            } else if (resultList.size() == 1) {
                return resultList.get(0);
            } else {
                throw new NonUniqueResultException("Multiple results found for email: " + email);
            }
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public boolean update(SignUpDTO signUpDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            entityManager.merge(signUpDto);
            tx.commit();
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            tx.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

}

