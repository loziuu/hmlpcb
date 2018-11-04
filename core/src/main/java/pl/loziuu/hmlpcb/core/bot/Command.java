package pl.loziuu.hmlpcb.core.bot;

public class Command {
    private final CommandType type;
    private final String question;

    public Command(CommandType type, String question) {
        this.type = type;
        this.question = question;
    }

    public static Command normal(String question) {
        return new Command(CommandType.NORMAL, question);
    }

    public static Command greeting(String question) {
        return new Command(CommandType.GREETING, question);
    }

    public CommandType getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }
}
