package com.bignerdranch.android.photogallery.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface FlickrApi {

    @GET(HTTPS_ADDRESS_INTERESTINGNESS)
    fun fetchPhotos(): Call<FlickrResponse>

    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>

    @GET(HTTPS_ADDRESS_SEARCH_METHOD)
    fun searchPhotos(@Query(TEXT) query: String): Call<FlickrResponse>

    companion object {
        private const val HTTPS_ADDRESS_INTERESTINGNESS = "services/rest/?method" +
        "=flickr.interestingness.getList"
        private const val HTTPS_ADDRESS_SEARCH_METHOD = "services/rest/?method=flickr.photos.search"
        private const val TEXT = "text"
    }
}