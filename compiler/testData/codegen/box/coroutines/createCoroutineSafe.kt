// WITH_RUNTIME
// WITH_COROUTINES
import helpers.*
import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*

fun builder(c: suspend () -> Unit) {
    val x = c.createCoroutine(EmptyContinuation)

    x.resume(Unit)
    x.resume(Unit)
}

fun box(): String {
    var result = ""

    try {
        builder {
            result = "OK"
        }
    } catch (e: IllegalStateException) {
        return result
    }

    return "fail: $result"
}
