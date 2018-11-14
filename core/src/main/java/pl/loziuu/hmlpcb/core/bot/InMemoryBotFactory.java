package pl.loziuu.hmlpcb.core.bot;

import java.util.Set;

public class InMemoryBotFactory implements BotFactory {
    private final Set<CommandReply> replies;

    public InMemoryBotFactory(Set<CommandReply> replies) {
        this.replies = replies;
    }

    @Override
    public Bot createBot() {
        return new Bot(replies);
    }
}
