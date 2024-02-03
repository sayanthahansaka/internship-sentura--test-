package com.example.internshipsentura.repo;



import com.example.internshipsentura.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
