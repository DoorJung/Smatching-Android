package com.icoo.smatching.util

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun mainThread(): Scheduler
}