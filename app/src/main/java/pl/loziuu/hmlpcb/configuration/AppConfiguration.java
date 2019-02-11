package pl.loziuu.hmlpcb.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.repository.BotResponseRepository;
import pl.loziuu.hmlpcb.repository.ConversationRepository;
import pl.loziuu.hmlpcb.service.ApplicationService;

@Configuration
@EnableMongoRepositories(basePackages = "pl.loziuu")
@EnableAutoConfiguration(exclude = {MongoRepositoriesAutoConfiguration.class})
public class AppConfiguration {
    private final ConversationRepository repository;
    private final BotResponseRepository botResponseRepository;

    public AppConfiguration(ConversationRepository repository, BotResponseRepository botResponseRepository) {
        this.repository = repository;
        this.botResponseRepository = botResponseRepository;
    }

    @Bean
    public ApplicationService applicationService(BotFactory factory) {
        return new ApplicationService(repository, factory);
    }

    @Bean
    public BotFactory botFactory() {
        return new MongoBotFactory(botResponseRepository);
    }
}
