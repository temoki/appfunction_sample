package space.hiraku.countapp

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountService @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("count_prefs", Context.MODE_PRIVATE)

    var count: Int
        get() = prefs.getInt("count", 0)
        private set(value) {
            prefs.edit { putInt("count", value) }
        }

    fun countUp() {
        count++
    }
}
