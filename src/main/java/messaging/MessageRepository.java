package messaging;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MessageRepository extends CrudRepository<Message, Long> {

}

