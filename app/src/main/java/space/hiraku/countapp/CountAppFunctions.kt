package space.hiraku.countapp

import androidx.appfunctions.AppFunctionContext
import androidx.appfunctions.AppFunctionSerializable
import androidx.appfunctions.service.AppFunction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountAppFunctions @Inject constructor(
    private val countService: CountService
) {
    /** Represents the current count. */
    @AppFunctionSerializable(isDescribedByKDoc = true)
    data class Count(
        /** The current count. */
        val value: Int
    )

    /**
     * Increments the count and returns the new value.
     */
    @AppFunction(isDescribedByKDoc = true)
    suspend fun countUp(context: AppFunctionContext): Count {
        return withContext(Dispatchers.IO) {
            countService.countUp()
            Count(countService.count)
        }
    }
}
