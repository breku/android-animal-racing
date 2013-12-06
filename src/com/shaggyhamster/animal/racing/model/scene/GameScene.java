package com.shaggyhamster.animal.racing.model.scene;

import com.shaggyhamster.animal.racing.manager.ResourcesManager;
import com.shaggyhamster.animal.racing.manager.SceneManager;
import com.shaggyhamster.animal.racing.matcher.ClassTouchAreaMacher;
import com.shaggyhamster.animal.racing.service.HighScoreService;
import com.shaggyhamster.animal.racing.util.ConstantsUtil;
import com.shaggyhamster.animal.racing.util.SceneType;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;

/**
 * User: Breku
 * Date: 21.09.13
 */
public class GameScene extends BaseScene {

    private HUD gameHUD;

    private HighScoreService highScoreService;

    public GameScene(Object... objects) {
        super(objects);
    }


    @Override
    public void createScene(Object... objects) {
        init(objects);
        createBackground();
        createHUD();
    }


    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAME);
    }

    private void init(Object... objects) {
        clearUpdateHandlers();
        clearTouchAreas();

        highScoreService = new HighScoreService();

    }


    private void createHUD() {
        gameHUD = new HUD();
        camera.setHUD(gameHUD);
    }

    private void createBackground() {
        unregisterTouchAreas(new ClassTouchAreaMacher(Sprite.class));
        clearChildScene();
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2,
                ResourcesManager.getInstance().getBackgroundGameTextureRegion(), vertexBufferObjectManager));
    }






    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.GAME;
    }

    @Override
    public void disposeScene() {
        gameHUD.clearChildScene();
        camera.setHUD(null);
        camera.setCenter(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2);
        camera.setChaseEntity(null);
    }
}
