package pl.loziuu.hmlpcb.repository.model;

import pl.loziuu.hmlpcb.core.conversation.Message;

import java.time.LocalDateTime;

public class MessageModel {
    private String author;
    private String content;
    private int order;
    private LocalDateTime createdAt;

    public static MessageModel fromCore(Message message) {
        return new MessageModel(message.getAuthor().name(), message.getMessage(), message.getOrder(), message.getSendAt());
    }

    public MessageModel() {
    }

    public MessageModel(String author, String content, int order, LocalDateTime createdAt) {
        this.author = author;
        this.content = content;
        this.order = order;
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getOrder() {
        return order;
    }
}
