package pl.loziuu.hmlpcb.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.loziuu.hmlpcb.core.conversation.Conversation;
import pl.loziuu.hmlpcb.shared.FriendlyId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Document(collection = "conversations")
public class ConversationModel {
    @Id
    private UUID uuid;
    private List<MessageModel> messages = new ArrayList<>();

    public static ConversationModel fromCore(Conversation conversation) {
        List<MessageModel> message = conversation.getMessages().stream()
                .map(MessageModel::fromCore)
                .collect(toList());
        return new ConversationModel(conversation.getId(), message);
    }

    public ConversationModel() {
    }

    public ConversationModel(UUID uuid, List<MessageModel> messages) {
        this.uuid = uuid;
        this.messages = messages;
    }

    @JsonIgnore
    public UUID getUuid() {
        return uuid;
    }

    public String getId() {
        return FriendlyId.makeItFriendly(uuid);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }
}
