package com.alimonapps.onlinelibrary.remote.errorhandling

import android.content.Context
import android.util.Log
import com.alimonapps.onlinelibrary.R
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException


open class ResponseHandler(val context: Context, val moshi: Moshi) {

    private val TAG = "ResponseHandler"

    fun <T> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: java.lang.Exception): Resource<T> {
        return when (e) {

            is HttpException -> Resource.error(getErrorMessage(e.code()), null)
            is ConnectException -> Resource.error(
                context.getString(R.string.connection_problem),
                null
            )
            is SocketTimeoutException -> Resource.error(context.getString(R.string.timeout), null)
            else -> Resource.error(e.toString(), null)

        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> "Unauthorised"
            404 -> "Not Found"
            else -> ""
        }
    }


}
