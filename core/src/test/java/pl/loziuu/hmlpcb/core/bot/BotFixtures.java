package pl.loziuu.hmlpcb.core.bot;

import java.util.Set;

final class BotFixtures {

    static Bot bot() {
        return new Bot(replies());
    }

    private static Set<CommandReply> replies() {
        return Set.of(
                new CommandReply(CommandType.GREETING, "Hi", "Hello!"),
                new CommandReply(CommandType.NORMAL, "How are you today?", "I'm great today, thank you.")
        );
    }
}
