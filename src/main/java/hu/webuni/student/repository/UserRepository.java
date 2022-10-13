package hu.webuni.student.repository;

import hu.webuni.student.model.AirportUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AirportUser, String> {
}
