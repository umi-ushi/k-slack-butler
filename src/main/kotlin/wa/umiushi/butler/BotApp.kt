package wa.umiushi.butler

import com.slack.api.bolt.App
import com.slack.api.bolt.context.builtin.SlashCommandContext
import com.slack.api.bolt.jetty.SlackAppServer
import com.slack.api.bolt.request.builtin.SlashCommandRequest

fun main() {
    val app = App()

    app.command(
        "/hello"
    ) { _: SlashCommandRequest?, ctx: SlashCommandContext? ->
        ctx!!.ack(":candy: はい、アメちゃん！")
    }

    val server = SlackAppServer(app)
    server.start()
}