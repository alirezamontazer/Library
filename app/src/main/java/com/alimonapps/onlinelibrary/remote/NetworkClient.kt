package com.alimonapps.onlinelibrary.remote

import com.alimonapps.onlinelibrary.BASE_AUDIO_URL
import com.alimonapps.onlinelibrary.BASE_BOOK_URL
import com.alimonapps.onlinelibrary.BuildConfig
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun provideBookRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_BOOK_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
}

fun provideAudioRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_AUDIO_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideLoggingInterceptor(): LoggingInterceptor {
    return LoggingInterceptor.Builder()
        .setLevel(Level.BASIC)
        .log(Platform.INFO)
        .request("Request")
        .response("Response")
        .addHeader("version", BuildConfig.VERSION_NAME)
        .build()
}

fun provideOkhttp(loggingInterceptor: LoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()
}

fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)