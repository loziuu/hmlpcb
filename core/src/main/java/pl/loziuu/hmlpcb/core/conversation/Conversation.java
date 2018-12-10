package pl.loziuu.hmlpcb.core.conversation;

import pl.loziuu.hmlpcb.core.bot.Bot;
import pl.loziuu.hmlpcb.core.bot.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static pl.loziuu.hmlpcb.core.conversation.MessageAuthor.BOT;
import static pl.loziuu.hmlpcb.core.conversation.MessageAuthor.USER;

public class Conversation {
    private final UUID id;
    private final List<Message> messages;
    private final Bot bot;

    public Conversation(Bot bot) {
        this.bot = bot;
        this.messages = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    private Conversation(UUID uuid, List<Message> messages, Bot bot) {
        this.id = uuid;
        this.messages = messages;
        this.bot = bot;
    }

    public static Conversation withMessages(UUID uuid, List<Message> messages, Bot bot) {
        return new Conversation(uuid, messages, bot);
    }

    public UUID getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void send(Command command) {
        addMessage(USER, command.getQuestion());
        addMessage(BOT, bot.tell(command));
    }

    private void addMessage(MessageAuthor author, String message) {
        messages.add(new Message(author, messages.size(), message));
    }
}
