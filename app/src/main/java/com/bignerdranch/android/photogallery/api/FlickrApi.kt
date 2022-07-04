package com.bignerdranch.android.photogallery.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface FlickrApi {

    @GET(HTTPS_ADDRESS)
    fun fetchPhotos(): Call<FlickrResponse>

    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>

    companion object {
        private const val API_KEY = "93a8e77d2715f695e9e6f303bb8c739a"
        private const val HTTPS_ADDRESS = "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=${API_KEY}" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    }
}