package lucassales.com.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface Interactor<in P> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(input: P)
}

interface ResultInteractor<in P, R : Any> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(input: P): R
}

fun <P> CoroutineScope.launchInteractor(interactor: Interactor<P>, param: P): Job {
    return launch(context = interactor.dispatcher, block = { interactor(param) })
}

suspend fun <P, R : Any> runInteractor(interactor: ResultInteractor<P, R>, param: P): R {
    return withContext(context = interactor.dispatcher, block = { interactor(param) })
}

suspend fun <R : Any> runInteractor(interactor: ResultInteractor<Unit, R>): R {
    return runInteractor(interactor, Unit)
}

fun CoroutineScope.launchInteractor(interactor: Interactor<Unit>) =
    launchInteractor(interactor, Unit)
