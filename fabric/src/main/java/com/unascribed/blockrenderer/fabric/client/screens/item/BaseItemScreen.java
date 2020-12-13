package com.unascribed.blockrenderer.fabric.client.screens.item;

import com.unascribed.blockrenderer.fabric.client.screens.BaseScreen;
import com.unascribed.blockrenderer.fabric.client.screens.widgets.HoverableCheckboxWidget;
import com.unascribed.blockrenderer.fabric.client.screens.widgets.HoverableTinyButtonWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import static com.unascribed.blockrenderer.fabric.client.varia.StringUtils.translate;

/*
 * Note: Screen's get initialized in init
 */
@SuppressWarnings("NotNullFieldNotInitialized")
public abstract class BaseItemScreen extends BaseScreen {

    protected Button actualSize;
    protected Checkbox useId;
    protected Checkbox addSize;

    public BaseItemScreen(Component title, @Nullable Screen old) {
        super(title, old);
    }

    @Override
    public void init() {
        assert minecraft != null;
        boolean enabled = enabled();

        super.init();

        actualSize = addButton(new HoverableTinyButtonWidget(this, width / 2 + 104, height / 6 + 80, translate("block_renderer.gui.actualSize"), translate("block_renderer.gui.actualSize.tooltip"), button -> slider.update((int) minecraft.getWindow().getGuiScale() * 16)), enabled);
        useId = addButton(new HoverableCheckboxWidget(this, width / 2 - 100, height / 6 + 144, 98, 20, translate("block_renderer.gui.useId"), translate("block_renderer.gui.useId.tooltip"), false), enabled);
        addSize = addButton(new HoverableCheckboxWidget(this, width / 2 + 2, height / 6 + 144, 98, 20, translate("block_renderer.gui.addSize"), translate("block_renderer.gui.addSize.tooltip"), false), enabled);
    }
}
