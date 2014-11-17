package net.notanothercraft.mintcraft.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by KJ4IPS on 11/16/2014.
 * The model used by the cardboard bos
 */
public class ModelCardboardBox extends ModelBase {

    ModelRenderer theBox;

    public ModelCardboardBox(){
        textureWidth = 64;
        textureHeight = 64;

        theBox = new ModelRenderer(this, 0, 0);
        theBox.addBox(-8F, -8F, -8F, 8, 8, 8);

    }

    @Override
    public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6) {
        super.render(entity, f1, f2, f3, f4, f5, f6);
        setRotationAngles(f1, f2, f3 ,f4, f5, f6, entity);
        theBox.render(f5);
    }


}
