package com.shaggyhamster.animal.racing.loader;

import com.shaggyhamster.animal.racing.model.scene.BaseScene;
import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.IEntityLoaderData;
import org.andengine.util.level.constants.LevelConstants;
import org.xml.sax.Attributes;

import java.io.IOException;

/**
 * User: Breku
 * Date: 07.08.13
 */
public class MainLevelLoader<T extends IEntityLoaderData> extends EntityLoader<T> {

    private BaseScene scene;

    public MainLevelLoader(BaseScene scene, String... pEntityNames) {
        super(pEntityNames);
        this.scene = scene;
    }

    @Override
    public IEntity onLoadEntity(String pEntityName, IEntity pParent, Attributes pAttributes, T pEntityLoaderData) throws IOException {
        final int width = SAXUtils.getIntAttributeOrThrow(pAttributes, LevelConstants.TAG_LEVEL_ATTRIBUTE_WIDTH);
        final int height = SAXUtils.getIntAttributeOrThrow(pAttributes, LevelConstants.TAG_LEVEL_ATTRIBUTE_HEIGHT);

        return scene;
    }
}
