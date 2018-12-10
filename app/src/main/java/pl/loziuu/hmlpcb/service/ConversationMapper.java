package pl.loziuu.hmlpcb.service;

import pl.loziuu.hmlpcb.core.bot.Bot;
import pl.loziuu.hmlpcb.core.bot.BotFactory;
import pl.loziuu.hmlpcb.core.conversation.Conversation;
import pl.loziuu.hmlpcb.core.conversation.Message;
import pl.loziuu.hmlpcb.repository.model.ConversationModel;

import java.util.List;
import java.util.stream.Collectors;

public class ConversationMapper {

    public static Conversation toCore(ConversationModel model, Bot bot) {
        List<Message> messages = model.getMessages().stream()
                .map(MessageMapper::toCore)
                .collect(Collectors.toList());
        return Conversation.withMessages(model.getUuid(), messages, bot);
    }
}
