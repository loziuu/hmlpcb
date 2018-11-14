package pl.loziuu.hmlpcb.core.bot;

import pl.loziuu.hmlpcb.core.conversation.Conversation;

import java.util.Set;

public class Bot {
    private final Set<CommandReply> cachedReplies;

    public Bot(Set<CommandReply> cachedReplies) {
        this.cachedReplies = cachedReplies;
    }

    public Conversation greet(String message) {
        Conversation conversation = new Conversation(this);
        conversation.send(Command.greeting(message));
        return conversation;
    }

    public String tell(Command command) {
        return cachedReplies.stream()
                .filter(r -> r.isApplicable(command))
                .findAny()
                .map(CommandReply::getAnswer)
                .orElse("Sorry, I can't understand that.");
    }
}
