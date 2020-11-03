package com.alimonapps.onlinelibrary.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.ActivitySplashBinding
import com.alimonapps.onlinelibrary.remote.errorhandling.Status
import com.alimonapps.onlinelibrary.ui.main.MainActivity
import com.alimonapps.onlinelibrary.zipLiveData
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    private val viewModel by viewModel<SplashViewModel>()
    private val TAG = "SplashActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //Functions
        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.minimumSplashWaitingPassed.observe(this, Observer {
            if (it) {

                zipLiveData(
                    viewModel.responseBestPodcast,
                    viewModel.responseAllBooks
                ) { responseBook, responseAudio ->
                    responseBook != null && responseAudio != null
                }.observe(this as LifecycleOwner, Observer { isDataLoad ->
                    if (isDataLoad) {

                        viewModel.responseAllBooks.value.let { responseBook ->
                            if (responseBook?.status == Status.SUCCESS) {
                                viewModel.saveBooksData(responseBook.data!!)

                            } else {
                                Toast.makeText(this, responseBook?.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        viewModel.responseBestPodcast.value.let { responseAudio ->
                            if (responseAudio?.status == Status.SUCCESS) {
                                viewModel.saveAudioData(responseAudio.data!!)
                            } else {
                                Toast.makeText(this, responseAudio?.message, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                        openMain()
                    }
                })
            }
        })
    }

    private fun openMain() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}


