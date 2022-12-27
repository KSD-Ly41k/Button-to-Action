package com.example.buttontoaction.presintation.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.buttontoaction.domain.ButtonInteractor
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val buttonInteractor: ButtonInteractor
) : ViewModel() {

    init {
        Log.d("TESTING_TAG", "buttonInteractor - $buttonInteractor")
    }
}