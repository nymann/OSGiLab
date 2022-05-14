package org.netbeans.modules.autoupdate.silentupdate;

import org.openide.modules.ModuleInstall;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UpdateActivator extends ModuleInstall {
    private static final int startupDelay = 0;
    private static final int timeBetweenRun = 2;
    private static final int corePoolSize = 1;
    private static final Runnable updateHandler = UpdateHandler::checkAndHandleUpdates;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(corePoolSize);

    @Override
    public void restored() {
        executorService.scheduleAtFixedRate(updateHandler, startupDelay, timeBetweenRun, TimeUnit.SECONDS);
    }
}
