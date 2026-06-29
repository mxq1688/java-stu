package com.example.my_java_maven_app.mapper;

import com.example.my_java_maven_app.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    List<User> findAll();

    List<User> findByCriteria(@Param("username") String username,
                              @Param("email") String email);

    Optional<User> findById(@Param("id") Long id);

    int insert(User user);

    int update(User user);

    int deleteById(@Param("id") Long id);
}
