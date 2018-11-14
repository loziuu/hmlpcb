package pl.loziuu.hmlpcb.service;

import pl.loziuu.hmlpcb.core.conversation.Message;
import pl.loziuu.hmlpcb.core.conversation.MessageAuthor;
import pl.loziuu.hmlpcb.repository.model.MessageModel;

public final class MessageMapper {

    public static Message toCore(MessageModel model) {
        return Message.fixedDate(MessageAuthor.valueOf(
                model.getAuthor()),
                model.getOrder(),
                model.getContent(),
                model.getCreatedAt());
    }
}
