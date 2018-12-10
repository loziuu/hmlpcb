package pl.loziuu.hmlpcb.controllers;

import org.springframework.web.bind.annotation.*;
import pl.loziuu.hmlpcb.repository.model.ConversationModel;
import pl.loziuu.hmlpcb.service.ApplicationService;
import pl.loziuu.hmlpcb.shared.FriendlyId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("v1")
public class ReactiveBotController {
    private final ApplicationService applicationService;

    public ReactiveBotController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/conversations")
    public Flux<ConversationModel> getConversation() {
        return applicationService.getConversations();
    }

    @GetMapping("/conversations/{conversationId}")
    public Mono<ConversationModel> getConversation(@PathVariable("conversationId") String conversationId) {
        return applicationService.getConversation(FriendlyId.showMeYourTrueNature(conversationId));
    }

    @PostMapping("/conversations/{conversationId}/send")
    public Mono<ConversationModel> sendMessageToConversation(@PathVariable("conversationId") String conversationId,
                                                             @RequestBody Message message) {
        return applicationService.sendToBot(FriendlyId.showMeYourTrueNature(conversationId), message.getContent());
    }

    @PostMapping("/bot/greet")
    public Mono<ConversationModel> startNewConversation(@RequestBody Message message) {
        return applicationService.startNewConversation(message.getContent());
    }
}
