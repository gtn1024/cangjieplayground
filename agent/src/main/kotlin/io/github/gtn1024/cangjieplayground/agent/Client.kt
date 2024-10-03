package io.github.gtn1024.cangjieplayground.agent

import com.fasterxml.jackson.databind.DeserializationFeature
import io.github.gtn1024.cangjieplayground.agent.Configuration.SANDBOX_SERVER
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.jackson.jackson

object Client {
    private val client =
        HttpClient(CIO) {
            install(ContentNegotiation) {
                jackson {
                    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                }
            }
        }

    object Sandbox {
        suspend fun run(req: SandboxRequest): List<SandboxResult> {
            val response =
                client.post("$SANDBOX_SERVER/run") {
                    contentType(ContentType.Application.Json)
                    setBody(req)
                }
            return response.body()
        }

        suspend fun deleteFile(fileId: String?) {
            if (fileId != null) {
                val url = "$SANDBOX_SERVER/file/$fileId"
                client.delete(url)
            }
        }

        suspend fun version(): SandboxVersion {
            val response = client.get("$SANDBOX_SERVER/version")
            return response.body()
        }
    }
}
