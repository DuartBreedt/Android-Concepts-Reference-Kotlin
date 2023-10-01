package za.co.duartbreedt.androidconceptsreference.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object RetrofitFactory {

    private var instance: Retrofit? = null
    private val json: Json by lazy {
        Json {
            isLenient = false
            encodeDefaults = true
            ignoreUnknownKeys = true
        }
    }

    private const val BASE_URL: String = "https://my.api.root"

    fun getInstance(): Retrofit {
        if (instance == null) {
            buildRetrofitInstance()
        }

        return instance!!
    }

    private fun buildRetrofitInstance() {
        // Build a retrofit instance
        instance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(MediaType.get("application/json"))) // Configure the serialization strategy
            .client(getHttpClient())
            .build()
    }

    private fun getHttpClient(): OkHttpClient {
        // Create an HttpClient builder
        val builder = OkHttpClient().newBuilder()

        // Configure the HttpClient
        with(builder) {
            readTimeout(2, TimeUnit.MINUTES)
            connectTimeout(2, TimeUnit.MINUTES)
            writeTimeout(30, TimeUnit.SECONDS)
        }

        return builder.build()
    }
}