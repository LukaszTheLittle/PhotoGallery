package com.bignerdranch.android.photogallery.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class PhotoInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl: HttpUrl = originalRequest.url().newBuilder()
            .addQueryParameter(API_KEY, MY_API_KEY)
            .addQueryParameter(FORMAT, JSON)
            .addQueryParameter(NOJSONCALLBACK, VALUE_1)
            .addQueryParameter(EXTRAS, URL_S)
            .addQueryParameter(SAFESEARCH, VALUE_1)
            .build()

        val newRequest: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    companion object {
        private const val API_KEY = "api_key"
        private const val MY_API_KEY = "93a8e77d2715f695e9e6f303bb8c739a"
        private const val FORMAT = "format"
        private const val JSON = "json"
        private const val NOJSONCALLBACK = "nojsoncallback"
        private const val VALUE_1 = "1"
        private const val EXTRAS = "extras"
        private const val URL_S = "url_s"
        private const val SAFESEARCH = "safesearch"
    }
}