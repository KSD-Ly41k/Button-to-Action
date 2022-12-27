package com.example.buttontoaction.di

import com.example.buttontoaction.data.remote.ButtonApi
import com.example.buttontoaction.data.repo.ButtonRepoImpl
import com.example.buttontoaction.domain.ButtonRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @[Singleton Provides]
    fun provideButtonRepo(api: ButtonApi): ButtonRepo = ButtonRepoImpl(api)
}