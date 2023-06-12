package edu.idat.pe.evc1.evc1.repository;

import edu.idat.pe.evc1.evc1.entitty.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByFirstNameAndPassword(String firstName, String password);
}
