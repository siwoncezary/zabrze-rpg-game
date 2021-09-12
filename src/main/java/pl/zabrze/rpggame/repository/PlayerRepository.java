package pl.zabrze.rpggame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zabrze.rpggame.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
