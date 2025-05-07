package wa.umiushi.butler

import com.slack.api.bolt.App
import com.slack.api.model.event.AppMentionEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BotConfiguration {
    @Bean
    fun slackApp(): App {
        return App().apply {
            event(AppMentionEvent::class.java, { req, ctx ->

                val args = req.event.text.split(Regex("\\s+"))

                val message = ctx.client().chatPostMessage {
                    it.channel(req.event.channel)
                        .threadTs(req.event.ts)
                        .text("<@${req.event.user}> 要求は ${args.joinToString(",")} ですか？ :two_hearts:")
                }
                if (!message.isOk) {
                    ctx.logger.error("chat.postMessage failed: ${message.error}")
                }
                ctx.ack()
            })
            command("/hello", { _, ctx -> ctx.ack("What's up?") })
        }
    }
}