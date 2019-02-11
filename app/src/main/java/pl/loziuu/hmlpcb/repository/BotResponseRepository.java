package pl.loziuu.hmlpcb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.loziuu.hmlpcb.repository.model.BotResponseModel;

import java.util.UUID;

public interface BotResponseRepository extends MongoRepository<BotResponseModel, UUID> {
}
