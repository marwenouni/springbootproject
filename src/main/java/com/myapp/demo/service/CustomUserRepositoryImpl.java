package com.myapp.demo.service;

import com.myapp.demo.Repository.CustomUserRepository;
import com.myapp.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User customFindMethod(Long id) {
        return (User) entityManager.createQuery("FROM User u WHERE u.id = :id")
          .setParameter("id", id)
          .getSingleResult();
    }
}