package wa.umiushi.butler

import com.slack.api.bolt.App

val SLACK_BOT_TOKEN = System.getenv("SLACK_BOT_TOKEN")

fun main() {
    println("Bot running.....")
    val app = App()
    app.client.chatPostMessage {
        it.token(SLACK_BOT_TOKEN)
        it.channel("C08R4UQS57T")
        it.text("Hello World!!")
    }
    println("Bot closed.....")
}