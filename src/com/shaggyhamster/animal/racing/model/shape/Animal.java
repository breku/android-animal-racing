package com.shaggyhamster.animal.racing.model.shape;

import com.shaggyhamster.animal.racing.manager.ResourcesManager;
import com.shaggyhamster.animal.racing.util.AnimalType;
import org.andengine.entity.sprite.AnimatedSprite;

/**
 * User: Breku
 * Date: 06.12.13
 */
public class Animal extends AnimatedSprite {

    private AnimalType animalType;

    public Animal(final float pX, final float pY, AnimalType animalType) {
        super(pX, pY, ResourcesManager.getInstance().getAnimalTiledTextureRegionFor(animalType), ResourcesManager.getInstance().getVertexBufferObjectManager());
        animate(animalType.getSpeed(), true);
        this.animalType = animalType;
    }
}
