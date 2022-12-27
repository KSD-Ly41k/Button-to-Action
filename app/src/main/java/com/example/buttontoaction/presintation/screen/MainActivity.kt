package com.example.buttontoaction.presintation.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.buttontoaction.databinding.ActivityMainBinding
import com.example.buttontoaction.di.ButtonApp
import com.example.buttontoaction.helpers.Event
import com.example.buttontoaction.presintation.model.ButtonInfoItemModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButtonApp.appComponent.inject(this)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initListeners()
        observeViewModelEvents()
    }

    private fun observeViewModelEvents() {
        lifecycleScope.launchWhenStarted {
            launch { viewModel.buttonInfoFlow.collect(::processButtonInfo) }
        }
    }

    private fun initListeners() {
        viewBinding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }
    }

    private fun processButtonInfo(event: Event<ButtonInfoItemModel?>) {
        /// TODO checking type in ButtonInfoItemModel
    }

    private fun processStartCall() {
        // TODO Check permission and start call
    }

    private fun processButtonAnimation() {
        // TODO Animate button
    }

    private fun processShowToast() {
        // TODO Check internet connection
    }

    private fun processNotification() {
        // TODO show Notification
    }
}

