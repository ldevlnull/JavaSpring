package com.alexcompany.repository;

import com.alexcompany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomUserRepositoryImplement implements CustomUserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteUserById(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> findUserByPhoneAndAge(String phone, int age) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> user = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if(phone != null)
            predicates.add(criteriaBuilder.equal(user.get("phone"), phone));

        if(age != 0)
            predicates.add(criteriaBuilder.equal(user.get("age"), age));

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();

    }
}
