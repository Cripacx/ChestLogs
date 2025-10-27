package com.aguga.Utils;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ContainerUser;
import net.minecraft.server.network.ServerPlayerEntity;

@FunctionalInterface
public interface ChestClosedCallback {
    void invoke(ContainerUser player);

    Event<ChestClosedCallback> EVENT = EventFactory.createArrayBacked(ChestClosedCallback.class,
            (listeners) -> (player) -> {
                for (ChestClosedCallback listener : listeners) {
                    listener.invoke(player);
                }
            });
}
