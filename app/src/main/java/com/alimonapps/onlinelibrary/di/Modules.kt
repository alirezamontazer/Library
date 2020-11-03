package com.alimonapps.onlinelibrary.di

import com.alimonapps.onlinelibrary.remote.*
import com.alimonapps.onlinelibrary.remote.errorhandling.ResponseHandler
import com.alimonapps.onlinelibrary.ui.audio.AudioViewModel
import com.alimonapps.onlinelibrary.ui.audiodetail.AudioDetailViewModel
import com.alimonapps.onlinelibrary.ui.book.BookViewModel
import com.alimonapps.onlinelibrary.ui.bookdetail.BookDetailViewModel
import com.alimonapps.onlinelibrary.ui.discover.AudioSearchViewModel
import com.alimonapps.onlinelibrary.ui.discover.BookSearchViewModel
import com.alimonapps.onlinelibrary.ui.discover.DiscoverViewModel
import com.alimonapps.onlinelibrary.ui.main.MainViewModel
import com.alimonapps.onlinelibrary.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val storeModules = module(override = true) {
    single { provideSharedPreferences(get()) }
    single { provideSharedPrefs(get(), get()) }
}


val networkModule = module(override = true) {

    single { provideOkhttp(get()) }

    single(named("book")) { provideApiService(get((named("book")))) }
    single(named("audio")) { provideApiService(get((named("audio")))) }

    single { provideLoggingInterceptor() }

    single(named("book")) { provideBookRetrofit(get(), get()) }
    single(named("audio")) { provideAudioRetrofit(get(), get()) }

    single(named("book")) { ApiRepository(get(named("book")), get()) }
    single(named("audio")) { ApiRepository(get(named("audio")), get()) }

    single { provideMoshi() }
    factory { ResponseHandler(androidContext(), get()) }

}


val viewModelModule = module(override = true) {
    single { SplashViewModel(get(named("audio")), get(named("book")), get()) }
    single { MainViewModel(get()) }
    viewModel { BookViewModel(get(), get()) }
    viewModel { BookDetailViewModel(get(), get()) }
    viewModel { AudioViewModel(get(), get()) }
    viewModel { AudioDetailViewModel(get(), get()) }
    viewModel { DiscoverViewModel() }
    viewModel { AudioSearchViewModel() }
    viewModel { BookSearchViewModel(get(), get(named("book"))) }
}