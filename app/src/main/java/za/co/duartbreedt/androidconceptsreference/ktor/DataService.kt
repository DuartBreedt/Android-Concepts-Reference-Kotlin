package za.co.duartbreedt.androidconceptsreference.ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import za.co.duartbreedt.Data

class DataService(private val httpClient: HttpClient) {

    private val BASE_URL: String = "https://my.api.root"

    suspend fun getData(id: String): Data =
        httpClient.get("$BASE_URL/data/$id").body()
}