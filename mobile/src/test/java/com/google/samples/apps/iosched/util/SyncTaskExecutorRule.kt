package com.google.samples.apps.iosched.util

import com.google.samples.apps.iosched.shared.usecases.internal.DefaultScheduler
import com.google.samples.apps.iosched.shared.usecases.internal.SyncScheduler
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Rule to be used in tests that sets a synchronous task scheduler used to avoid race conditions.
 *
 * TODO: Move to testutils module b/72216577
 */
class SyncTaskExecutorRule : TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        DefaultScheduler.setDelegate(SyncScheduler)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        DefaultScheduler.setDelegate(null)
    }
}