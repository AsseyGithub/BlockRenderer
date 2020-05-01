package com.unascribed.blockrenderer.mixin.accessor;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import javax.annotation.Nullable;

@Mixin(HandledScreen.class)
public interface IHoveredSlot {

    @Accessor(value = "focusedSlot")
    @Nullable
    Slot getHoveredSlot();

}
