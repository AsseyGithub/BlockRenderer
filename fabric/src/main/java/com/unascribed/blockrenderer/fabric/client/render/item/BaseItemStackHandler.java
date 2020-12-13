package com.unascribed.blockrenderer.fabric.client.render.item;

import com.unascribed.blockrenderer.fabric.client.varia.Identifiers;
import com.unascribed.blockrenderer.fabric.client.varia.StringUtils;
import com.unascribed.blockrenderer.fabric.client.varia.Styles;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.function.Consumer;

import static com.unascribed.blockrenderer.fabric.client.varia.StringUtils.translate;

public class BaseItemStackHandler implements Consumer<ItemStack> {

    @Nullable
    protected File future = null;

    protected final File folder;
    protected final int size;
    protected final boolean useIdentifier;
    protected final boolean addSize;
    protected final boolean addDate;

    public BaseItemStackHandler(File folder, int size, boolean useIdentifier, boolean addSize, boolean addDate) {
        this.folder = folder;
        this.size = size;
        this.useIdentifier = useIdentifier;
        this.addSize = addSize;
        this.addDate = addDate;
    }

    @Override
    public void accept(ItemStack value) {
        report(Identifiers.get(value.getItem()), future);
    }

    protected void report(Object name) {
        report(name, null);
    }

    protected void report(Object name, @Nullable File file) {
        if (file == null) {
            StringUtils.addMessage(translate(
                    "msg.block_renderer.render.success.nofile",
                    name,
                    StringUtils.asClickable(folder)
            ).withStyle(Styles.GOLD));
        } else {
            StringUtils.addMessage(translate(
                    "msg.block_renderer.render.success",
                    name,
                    StringUtils.asClickable(folder),
                    StringUtils.asClickable(file.getAbsoluteFile())
            ).withStyle(Styles.GOLD));
        }
    }

    protected String getFilename(ItemStack value) {
        String sizeString = addSize ? size + "x" + size + "_" : "";
        String fileName = _getFilename(value, useIdentifier);

        return (addDate ? StringUtils.dateTime() + "_" : "") + sizeString + fileName;
    }

    private String _getFilename(ItemStack value, boolean useIdentifier) {
        return useIdentifier ? StringUtils.sanitize(Identifiers.get(value.getItem())) : StringUtils.sanitize(value.getDisplayName());
    }

}
