package com.example.buttontoaction.presintation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buttontoaction.domain.ButtonInteractor
import com.example.buttontoaction.helpers.Event
import com.example.buttontoaction.presintation.model.ButtonInfoItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel @Inject constructor(
    buttonInteractor: ButtonInteractor
) : ViewModel() {

    private val defaultContext: CoroutineContext = Dispatchers.Default
    fun onButtonClicked() {
        // TODO Need to add save start time in _buttonCoolDownState
        _onButtonClicked.tryEmit(Unit)
    }

    private val _onButtonClicked = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val _buttonCoolDownState = MutableStateFlow<Map<String, String>>(emptyMap())

    private val _buttonInfoFlow: Flow<List<ButtonInfoItemModel>> = buttonInteractor.getButtonInfo()
        .catch {
            //TODO need to add error handler
        }
        .flowOn(defaultContext)


    val buttonInfoFlow: Flow<Event<ButtonInfoItemModel?>> = _onButtonClicked
        .debounce(400)
        .flatMapLatest { _buttonInfoFlow }
        .map { it.filter { it.enabled } }
        .combine(_buttonCoolDownState) { a, b -> a to b }
        .map {
            // TODO Need to sort items by priority after check cooldown
        }
        .flowOn(defaultContext)
        .stateIn(
            scope = viewModelScope,
            started = Eagerly,
            initialValue = null
        )
}
