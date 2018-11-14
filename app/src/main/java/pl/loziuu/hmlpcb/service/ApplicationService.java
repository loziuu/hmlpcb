package pl.loziuu.hmlpcb.service;

import pl.loziuu.hmlpcb.core.bot.Bot;
import pl.loziuu.hmlpcb.core.bot.Command;
import pl.loziuu.hmlpcb.core.conversation.Conversation;
import pl.loziuu.hmlpcb.repository.ConversationRepository;
import pl.loziuu.hmlpcb.repository.model.ConversationModel;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.UUID;

public class ApplicationService {
    private final ConversationRepository repository;

    public ApplicationService(ConversationRepository repository) {
        this.repository = repository;
    }

    public Mono<ConversationModel> getConversation(UUID conversationId) {
        return repository.findById(conversationId);
    }

    public Mono<ConversationModel> startNewConversation(String greeting) {
        Bot bot = new Bot(new HashSet<>());
        Conversation conversation = bot.greet(greeting);
        return saveConversation(conversation);
    }

    public Mono<ConversationModel> sendToBot(UUID conversationId, String message) {
        return repository.findById(conversationId)
                .map(ConversationMapper::toCore)
                .doOnNext(core -> core.send(Command.normal(message)))
                .flatMap(this::saveConversation);
    }

    private Mono<ConversationModel> saveConversation(Conversation conversation) {
        return repository.save(ConversationModel.fromCore(conversation));
    }
}
