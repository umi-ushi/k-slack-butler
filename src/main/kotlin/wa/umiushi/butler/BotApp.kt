package wa.umiushi.butler

import com.slack.api.bolt.App
import com.slack.api.bolt.jakarta_servlet.SlackAppServlet
import jakarta.servlet.annotation.WebServlet
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import wa.umiushi.butler.api.github.GitHubService

@SpringBootApplication
@ServletComponentScan
class BotApp

fun main(args: Array<String>) {
    runApplication<BotApp>(*args)
}

@WebServlet("/slack/events")
class BotController(app: App) : SlackAppServlet(app)

@Controller
class ApiTester(
    private val gitHubService: GitHubService
) {
    @GetMapping("api/test/github")
    fun githubApiTest(): ResponseEntity<String> {
        gitHubService.callDispatch(
            "k-slack-butler",
            "example-wf-dispatch.yml"
        )

        return ResponseEntity.ok("success")
    }
}