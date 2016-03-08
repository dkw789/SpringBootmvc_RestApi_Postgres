package messaging;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByUserNameAndUserName2(String userName, String userName2);
}

