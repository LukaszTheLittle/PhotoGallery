package com.bignerdranch.android.photogallery

import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

class ThumbnailDownloader<in T>: HandlerThread(TAG), DefaultLifecycleObserver {

    private var hasQuit = false
    private lateinit var requestHandler: Handler
    private val requestMap = ConcurrentHashMap<T, String>()

    override fun quit(): Boolean {
        hasQuit = true
        return super.quit()
    }

    override fun onCreate(owner: LifecycleOwner) {
        Log.i(TAG, "Starting background thread")
        start()
        looper
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.i(TAG, "Destroying background thread")
        quit()
    }

    fun queueThumbnail(target: T, url: String) {
        Log.i(TAG, "Got a URL: $url")
    }

    companion object {
        private const val TAG = "ThumbnailDownloader"
        private const val MESSAGE_DOWNLOAD = 0
        private val flickrFetchr = FlickrFetchr()
    }
}