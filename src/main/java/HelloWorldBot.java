

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.api.objects.Update;


public final class HelloWorldBot extends Bot {

    public final static String BOT_TOKEN = "2100871877:AAE8kLOULiXjqP_l7DcOwAw85Z7qVE8FI94";
    public final static String BOT_NAME = "DummyBot";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        Bot.runBot(new HelloWorldBot(HelloWorldBot.BOT_TOKEN, HelloWorldBot.BOT_NAME));
    }



    private HelloWorldBot(String token, String botName) {
        super(token, botName);
    }

    @Override
    protected void processTheException(Exception e) {
        e.printStackTrace();
        System.out.println(e.toString());
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendTextMessage(update.getMessage(), "Eto bot for laba 3 IIT 2, Peresunko, Shulgin");
    }
}
