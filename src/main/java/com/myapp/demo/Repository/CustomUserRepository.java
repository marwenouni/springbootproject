package com.myapp.demo.Repository;

import com.myapp.demo.entity.User;

public interface CustomUserRepository {
    User customFindMethod(Long id);
}