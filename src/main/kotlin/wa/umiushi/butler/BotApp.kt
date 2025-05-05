package wa.umiushi.butler

import com.slack.api.bolt.App
import com.slack.api.bolt.jakarta_servlet.SlackAppServlet
import jakarta.servlet.annotation.WebServlet
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class BotApp

fun main(args: Array<String>) {
    runApplication<BotApp>(*args)
}

@WebServlet("/slack/events")
class BotController(app: App) : SlackAppServlet(app)