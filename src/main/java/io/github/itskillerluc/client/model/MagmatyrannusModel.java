package io.github.itskillerluc.client.model;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.duclib.client.model.AnimatableDucModel;
import io.github.itskillerluc.duclib.client.model.Ducling;
import io.github.itskillerluc.entity.Magmatyrannus;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class MagmatyrannusModel extends AnimatableDucModel<Magmatyrannus> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AlternaCraft.MODID, "magmatyrannus"), "main");

    public MagmatyrannusModel(Ducling ducling) {
        super(ducling, RenderType::entityCutout);
    }
}
