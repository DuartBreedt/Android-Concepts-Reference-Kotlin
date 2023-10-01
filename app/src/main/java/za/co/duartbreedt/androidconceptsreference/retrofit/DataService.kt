package za.co.duartbreedt.androidconceptsreference.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import za.co.duartbreedt.Data

interface DataService {

    @GET("/data/{id}")
    fun getData(@Path("id") id: String): Response<Data>
}