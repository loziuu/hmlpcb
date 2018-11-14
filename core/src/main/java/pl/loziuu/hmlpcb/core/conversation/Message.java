package pl.loziuu.hmlpcb.core.conversation;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private final int order;
    private final String message;
    private final MessageAuthor author;
    private final LocalDateTime sendAt;

    public Message(MessageAuthor author, int order, String message) {
        this.author = author;
        this.order = order;
        this.message = message;
        this.sendAt = LocalDateTime.now();
    }

    public static Message fixedDate(MessageAuthor author, int order, String message, LocalDateTime sendAt) {
        return new Message(order, message, author, sendAt);
    }

    private Message(int order, String message, MessageAuthor author, LocalDateTime sendAt) {
        this.order = order;
        this.message = message;
        this.author = author;
        this.sendAt = sendAt;
    }

    public MessageAuthor getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public int getOrder() {
        return order;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return getOrder() == message1.getOrder() &&
                Objects.equals(getMessage(), message1.getMessage()) &&
                getAuthor() == message1.getAuthor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getMessage(), getAuthor());
    }
}
