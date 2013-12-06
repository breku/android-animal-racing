package com.shaggyhamster.animal.racing.model.shape;

import com.shaggyhamster.animal.racing.manager.ResourcesManager;
import com.shaggyhamster.animal.racing.util.LevelDifficulty;
import com.shaggyhamster.animal.racing.util.MathParameter;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;

/**
 * User: Breku
 * Date: 20.10.13
 */
public class GameTypeMenuItem extends ScaleMenuItemDecorator {

    private LevelDifficulty levelDifficulty;
    private MathParameter mathParameter;

    public GameTypeMenuItem(Integer ID, LevelDifficulty levelDifficulty, MathParameter mathParameter, Integer positionX, Integer positionY) {
        super(new SpriteMenuItem(ID, ResourcesManager.getInstance().getPlayButtonTextureRegion(), ResourcesManager.getInstance().getVertexBufferObjectManager()), 1.5f, 1.0f);
        this.levelDifficulty = levelDifficulty;
        this.mathParameter = mathParameter;
        setPosition(positionX, positionY);
    }


    public LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public MathParameter getMathParameter() {
        return mathParameter;
    }
}

