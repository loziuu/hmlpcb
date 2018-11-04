package pl.loziuu.hmlpcb.core.conversation;

import pl.loziuu.hmlpcb.core.bot.Bot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static pl.loziuu.hmlpcb.core.conversation.MessageAuthor.*;
import static pl.loziuu.hmlpcb.core.conversation.MessageAuthor.BOT;

public class Conversation {
    private final UUID id = UUID.randomUUID();
    private final List<Message> messages;

    private final Bot bot;

    public Conversation(Bot bot) {
        this.bot = bot;
        this.messages = new ArrayList<>();
    }

    public static Conversation withMessages(List<Message> messages) {
        return new Conversation(messages);
    }

    public Conversation(List<Message> messages) {
        this.messages = messages;
        this.bot = new Bot(new HashSet<>());
    }

    public UUID getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void send(String message) {
        addMessage(USER, message);
        addMessage(BOT, bot.tell(message));
    }

    private void addMessage(MessageAuthor author, String message) {
        messages.add(new Message(author, messages.size(), message));
    }
}
