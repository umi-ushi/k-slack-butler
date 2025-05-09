package wa.umiushi.butler.api.github

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class GitHubService(
    @Qualifier("githubApiClient")
    private val client: RestClient,
    @Value("\${api.github.token}")
    private val token: String,
    @Value("\${api.github.owner}")
    private val owner: String
) {
    fun callDispatch(
        repo: String,
        workflowFileName: String,
        ref: String = "main"
    ) {
        val payload = mapOf(
            "ref" to ref,
        )

        val response = client.post()
            .uri { uriBuilder ->
                uriBuilder.pathSegment(
                    "repos",
                    "{owner}",
                    "{repo}",
                    "actions",
                    "workflows",
                    "{workflowFileName}",
                    "dispatches"
                ).build(owner, repo, workflowFileName)
            }
            .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
            .header(HttpHeaders.ACCEPT, "application/vnd.github+json")
            .body(payload)
            .retrieve()
            .toBodilessEntity()

        if (response.statusCode.is2xxSuccessful.not()) {
            throw RuntimeException("GitHub Api Call failed: ${response.statusCode}")
        }
    }
}