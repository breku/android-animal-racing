package com.shaggyhamster.animal.racing.model.scene;

import com.shaggyhamster.animal.racing.manager.SceneManager;
import com.shaggyhamster.animal.racing.service.HighScoreService;
import com.shaggyhamster.animal.racing.util.ConstantsUtil;
import com.shaggyhamster.animal.racing.util.SceneType;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.sprite.Sprite;

/**
 * User: Breku
 * Date: 08.10.13
 */
public class GameTypeScene extends BaseScene implements MenuScene.IOnMenuItemClickListener {

    private MenuScene menuScene;
    private HighScoreService highScoreService;

    @Override
    public void createScene(Object... objects) {
        init();
        createBackground();
    }

    private void init() {
        highScoreService = new HighScoreService();
    }

    private void createBackground() {
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2, resourcesManager.getBackgroundGameTypeTextureRegion(), vertexBufferObjectManager));
    }

    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAMETYPE);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.GAMETYPE;
    }

    @Override
    public void disposeScene() {
    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
