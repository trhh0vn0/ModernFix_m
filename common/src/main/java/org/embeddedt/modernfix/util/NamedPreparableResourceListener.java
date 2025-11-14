package org.embeddedt.modernfix.util;

import net.minecraft.server.packs.resources.PreparableReloadListener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class NamedPreparableResourceListener implements PreparableReloadListener {
    private final PreparableReloadListener delegate;
    public NamedPreparableResourceListener(PreparableReloadListener delegate) {
        this.delegate = delegate;
    }

    @Override
    public CompletableFuture<Void> reload(PreparableReloadListener.SharedState stage, Executor backgroundExecutor, PreparableReloadListener.PreparationBarrier preparationBarrier, Executor gameExecutor) {
        return this.delegate.reload(stage, backgroundExecutor, preparationBarrier, gameExecutor);
    }

    @Override
    public String getName() {
        return this.delegate.getName() + " [" + this.delegate.getClass().getName() + "]";
    }
}
