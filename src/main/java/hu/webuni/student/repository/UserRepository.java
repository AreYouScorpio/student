package hu.webuni.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AirportUser, String> {
}
