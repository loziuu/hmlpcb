package pl.loziuu.hmlpcb.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.core.bot.CommandReply;
import pl.loziuu.hmlpcb.core.bot.InMemoryBotFactory;
import pl.loziuu.hmlpcb.core.bot.factory.CommandRepliesBuilder;
import pl.loziuu.hmlpcb.repository.ConversationRepository;
import pl.loziuu.hmlpcb.service.ApplicationService;

import java.util.Set;

@Configuration
@EnableMongoRepositories(basePackages = "pl.loziuu")
@EnableAutoConfiguration(exclude = {MongoRepositoriesAutoConfiguration.class})
public class AppConfiguration {
    private final ConversationRepository repository;

    public AppConfiguration(ConversationRepository repository) {
        this.repository = repository;
    }

    @Bean
    public ApplicationService applicationService(BotFactory factory) {
        return new ApplicationService(repository, factory);
    }

    @Bean
    public BotFactory botFactory() {
        Set<CommandReply> replies = CommandRepliesBuilder.getBuilder()
                .greeting("Hi", "Oh hi there!")
                .normal("How are you today?", "I'm fine, thanks!")
                .build();
        return new InMemoryBotFactory(replies);
    }
}
