package com.sergio.unsplash

import android.app.Application
import com.sergio.unsplash.di.components.ApplicationComponent
import com.sergio.unsplash.di.components.DaggerApplicationComponent
import com.sergio.unsplash.di.modules.ApplicationModule

class UnsplashApplication: Application() {

    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = applicationComponent.inject(this)
}
