package pl.loziuu.hmlpcb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.loziuu.hmlpcb.repository.model.ConversationModel;

import java.util.UUID;

@Repository
public interface ConversationRepository extends ReactiveMongoRepository<ConversationModel, UUID> {

}
