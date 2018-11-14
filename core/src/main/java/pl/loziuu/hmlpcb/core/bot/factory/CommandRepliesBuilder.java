package pl.loziuu.hmlpcb.core.bot.factory;

import pl.loziuu.hmlpcb.core.bot.CommandReply;
import pl.loziuu.hmlpcb.core.bot.CommandType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CommandRepliesBuilder {
    private final Set<CommandReply> replies = new HashSet<>();

    public static CommandRepliesBuilder getBuilder() {
        return new CommandRepliesBuilder();
    }

    public CommandRepliesBuilder normal(String question, String answer) {
        this.replies.add(new CommandReply(CommandType.NORMAL, question, answer));
        return this;
    }

    public CommandRepliesBuilder greeting(String question, String answer) {
        this.replies.add(new CommandReply(CommandType.GREETING, question, answer));
        return this;
    }

    public Set<CommandReply> build() {
        return Collections.unmodifiableSet(replies);
    }
}
