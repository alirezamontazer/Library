package com.alimonapps.onlinelibrary.di.hiltmodules

import android.content.Context
import com.alimonapps.onlinelibrary.BASE_AUDIO_URL
import com.alimonapps.onlinelibrary.BASE_BOOK_URL
import com.alimonapps.onlinelibrary.BaseApplication
import com.alimonapps.onlinelibrary.BuildConfig
import com.alimonapps.onlinelibrary.remote.ApiRepository
import com.alimonapps.onlinelibrary.remote.ApiService
import com.alimonapps.onlinelibrary.remote.errorhandling.ResponseHandler
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkhttp(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .addHeader("version", BuildConfig.VERSION_NAME)
            .build()
    }

    @Book
    @Singleton
    @Provides
    fun provideBookRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_BOOK_URL).client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Audio
    @Singleton
    @Provides
    fun provideAudioRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_AUDIO_URL).client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }


    @Book
    @Singleton
    @Provides
    fun provideBookApiService(@Book retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Audio
    @Singleton
    @Provides
    fun provideAudioApiService(@Audio retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Book
    @Singleton
    @Provides
    fun provideBookApiRepository(
        @Book apiService: ApiService,
        responseHandler: ResponseHandler
    ): ApiRepository {
        return ApiRepository(apiService, responseHandler)
    }


    @Audio
    @Singleton
    @Provides
    fun provideAudioApiRepository(
        @Audio apiService: ApiService,
        responseHandler: ResponseHandler
    ): ApiRepository {
        return ApiRepository(apiService, responseHandler)
    }


    @Provides
    fun provideResponseHandler(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): ResponseHandler {
        return ResponseHandler(context, moshi)
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Book

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Audio
