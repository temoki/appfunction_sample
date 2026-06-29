package space.hiraku.countapp

import android.app.Application
import androidx.appfunctions.service.AppFunctionConfiguration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CountApplication : Application(), AppFunctionConfiguration.Provider {

    @Inject
    lateinit var countAppFunctions: CountAppFunctions

    override val appFunctionConfiguration: AppFunctionConfiguration
        get() = AppFunctionConfiguration.Builder()
            .addEnclosingClassFactory(CountAppFunctions::class.java) {
                countAppFunctions
            }
            .build()
}
