package com.Techno.Techno.Repository;

import com.Techno.Techno.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
