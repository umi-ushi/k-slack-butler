package wa.umiushi.butler

import com.slack.api.bolt.App
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BotConfiguration {
    @Bean
    fun slackApp(): App {
        return App().apply {
            command("/hello", { _, ctx -> ctx.ack("What's up?") })
        }
    }
}