package lucassales.com.domain

import io.reactivex.Scheduler

data class AppSchedulers(
    val io: Scheduler,
    val computation: Scheduler,
    val main: Scheduler
)