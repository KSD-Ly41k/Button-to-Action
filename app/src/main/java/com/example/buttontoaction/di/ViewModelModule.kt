package com.example.buttontoaction.di

import com.example.buttontoaction.domain.ButtonInteractor
import com.example.buttontoaction.domain.ButtonInteractorImpl
import com.example.buttontoaction.domain.ButtonRepo
import com.example.buttontoaction.presintation.screen.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    fun provideMainViewModel(interactor: ButtonInteractor): MainViewModel = MainViewModel(interactor)

}