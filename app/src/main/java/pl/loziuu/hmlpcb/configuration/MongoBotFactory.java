package pl.loziuu.hmlpcb.configuration;

import pl.loziuu.hmlpcb.core.bot.Bot;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.core.bot.CommandReply;
import pl.loziuu.hmlpcb.repository.BotResponseRepository;
import pl.loziuu.hmlpcb.repository.model.BotResponseModel;

import java.util.Set;
import java.util.stream.Collectors;

public class MongoBotFactory implements BotFactory {
    private final BotResponseRepository responseRepository;

    public MongoBotFactory(BotResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public Bot createBot() {
        return new Bot(loadReplies());
    }

    private Set<CommandReply> loadReplies() {
        return responseRepository.findAll().stream()
                .map(BotResponseModel::asCommandReply)
                .collect(Collectors.toSet());
    }
}
