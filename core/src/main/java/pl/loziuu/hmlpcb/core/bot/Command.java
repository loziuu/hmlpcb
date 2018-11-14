package pl.loziuu.hmlpcb.core.bot;

public class Command {
    private final CommandType type;
    private final String question;

    private Command(CommandType type, String question) {
        this.type = type;
        this.question = question;
    }

    public static Command normal(String question) {
        return new Command(CommandType.NORMAL, question);
    }

    static Command greeting(String question) {
        return new Command(CommandType.GREETING, question);
    }

    CommandType getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }
}
