package com.unascribed.blockrenderer.forge.client.render.report;

import com.unascribed.blockrenderer.forge.client.varia.rendering.Display;
import com.unascribed.blockrenderer.render.report.BaseReporter;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class Reporter extends BaseReporter<ITextComponent> {

    public static Reporter INSTANCE = new Reporter();

    private Reporter() {
        super(new StringTextComponent("Rendering"), Display.INSTANCE);
    }

    @Override
    public void pop() {
        pop(title.getString(), message == null ? "null" : message.getString());
    }

    @Override
    public void end() {
        end(title.getString(), message == null ? "null" : message.getString());
    }

    @Override
    public ITextComponent getProgress() {
        return new StringTextComponent(getProgressString());
    }

}
