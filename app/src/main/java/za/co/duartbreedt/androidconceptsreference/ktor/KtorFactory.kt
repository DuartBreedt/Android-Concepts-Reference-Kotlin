package za.co.duartbreedt.androidconceptsreference.ktor

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorFactory {

    private var client: HttpClient? = null

    fun getKtorClient(): HttpClient {
        if (client == null) {
            createKtorClient()
        }

        return client!!
    }

    private fun createKtorClient() {
        // Create an Android HttpClient
        client = HttpClient(Android) {

            // Define the Engine parameters
            engine {
                connectTimeout = 5000
                socketTimeout = 5000
            }

            // Install the serialization feature
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }

            // Install the logging feature
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("KTOR Logger ->", message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}