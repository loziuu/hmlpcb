package pl.loziuu.hmlpcb.controllers;

import org.springframework.web.bind.annotation.*;
import pl.loziuu.hmlpcb.repository.BotResponseRepository;
import pl.loziuu.hmlpcb.repository.model.BotResponseModel;

import java.util.List;

@RestController
@RequestMapping("/management/responses")
public class BotManagementController {
    private final BotResponseRepository responseRepository;

    public BotManagementController(BotResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @GetMapping
    public List<BotResponseModel> getResponses() {
        return responseRepository.findAll();
    }

    @PostMapping
    public BotResponseModel addResponse(@RequestBody BotResponseModel model) {
        return responseRepository.save(model);
    }
}
