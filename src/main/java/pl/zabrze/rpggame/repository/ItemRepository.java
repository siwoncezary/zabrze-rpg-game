package pl.zabrze.rpggame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zabrze.rpggame.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
