package wa.umiushi.butler.api.github

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestClient
import java.time.Duration

@Configuration
class GitHubApiConfig {
    @Bean("githubApiClient")
    fun githubApiClient(): RestClient {
        return RestClient.builder().baseUrl("https://api.github.com").requestFactory(
            SimpleClientHttpRequestFactory().apply {
                setConnectTimeout(Duration.ofSeconds(3L))
                setReadTimeout(Duration.ofSeconds(3L))
            }).build()
    }
}