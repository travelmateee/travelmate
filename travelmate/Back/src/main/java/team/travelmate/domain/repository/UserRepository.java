package team.travelmate.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.travelmate.domain.Entity.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
