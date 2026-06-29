package space.hiraku.countapp

import androidx.appfunctions.AppFunctionContext
import androidx.appfunctions.service.AppFunction
import javax.inject.Inject

class CountAppFunctions @Inject constructor(
    private val countService: CountService
) {
    /**
     * Increments the count and returns the new value.
     */
    @AppFunction(isDescribedByKDoc = true)
    fun countUp(context: AppFunctionContext): Int {
        countService.countUp()
        return countService.count
    }
}
