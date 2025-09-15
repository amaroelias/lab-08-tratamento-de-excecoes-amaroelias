package com.ufpb.GestorRepositorios.repositories;
import com.ufpb.GestorRepositorios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
