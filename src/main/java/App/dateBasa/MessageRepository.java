package App.dateBasa;

import javax.persistence.Index;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Index> {

}
