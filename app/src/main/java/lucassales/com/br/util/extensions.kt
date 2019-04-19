package lucassales.com.br.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observe(
    lifecycleOwner: LifecycleOwner,
    crossinline observer: (T?) -> Unit
) {
    this.observe(lifecycleOwner, Observer {
        observer(it)
    })
}

inline fun <T> LiveData<T>.observeNonNull(
    lifecycleOwner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(lifecycleOwner, Observer {
        it?.let(observer)
    })
}