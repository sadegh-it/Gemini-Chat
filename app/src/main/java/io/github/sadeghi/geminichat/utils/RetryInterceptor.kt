package io.github.sadeghi.geminichat.utils

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RetryInterceptor(private val maxRetries: Int = 3) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response: Response? = null
        var tryCount = 0
        var lastException: IOException? = null

        while (tryCount < maxRetries && (response == null || !response.isSuccessful)) {
            try {
                response = chain.proceed(request)
            } catch (e: IOException) {
                lastException = e
                tryCount++
            }
        }

        return response ?: throw lastException ?: IOException("Unknown network error")
    }
}
