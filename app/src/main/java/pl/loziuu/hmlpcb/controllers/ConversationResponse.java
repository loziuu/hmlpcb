package pl.loziuu.hmlpcb.controllers;

import pl.loziuu.hmlpcb.core.conversation.Conversation;

public class ConversationResponse {
    private final Conversation conversation;

    public ConversationResponse(Conversation conversation) {
        this.conversation = conversation;
    }

    public Conversation getConversation() {
        return conversation;
    }
}
