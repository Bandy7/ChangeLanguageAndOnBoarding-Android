package com.example.changelanguageandonbording.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.changelanguageandonbording.data.DataStoreRepository
import com.example.changelanguageandonbording.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
     val lang = mutableStateOf("en")

    private val _startDestination: MutableState<String> = mutableStateOf(Screen.Language.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readLanguage().collect { langg ->
                lang.value = langg
            }
        }
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Screen.Home.route
                } else {
                    _startDestination.value = Screen.Language.route
                }
            }
            _isLoading.value = false
        }
    }

}