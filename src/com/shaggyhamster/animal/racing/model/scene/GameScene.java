package com.shaggyhamster.animal.racing.model.scene;

import com.shaggyhamster.animal.racing.loader.MainLevelLoader;
import com.shaggyhamster.animal.racing.loader.ShapeAndTextLoader;
import com.shaggyhamster.animal.racing.manager.ResourcesManager;
import com.shaggyhamster.animal.racing.manager.SceneManager;
import com.shaggyhamster.animal.racing.matcher.ClassTouchAreaMacher;
import com.shaggyhamster.animal.racing.model.shape.Animal;
import com.shaggyhamster.animal.racing.service.HighScoreService;
import com.shaggyhamster.animal.racing.util.AnimalType;
import com.shaggyhamster.animal.racing.util.ConstantsUtil;
import com.shaggyhamster.animal.racing.util.SceneType;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;

/**
 * User: Breku
 * Date: 21.09.13
 */
public class GameScene extends BaseScene {

    private HUD gameHUD;

    private HighScoreService highScoreService;

    private SimpleLevelLoader levelLoader;
    private EntityLoader mainLevelLoader;
    private EntityLoader shapeAndTextLoader;

    public GameScene(Object... objects) {
        super(objects);
    }


    @Override
    public void createScene(Object... objects) {
        init(objects);
        createHUD();
        createBackground();
        createAnimal();
        loadLevel(1);
    }

    private void createAnimal() {
        AnimatedSprite as = new Animal(400, 240, AnimalType.HORSE);
        attachChild(as);
    }


    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAME);
    }

    private void init(Object... objects) {
        clearUpdateHandlers();
        clearTouchAreas();

        highScoreService = new HighScoreService();

        levelLoader = new SimpleLevelLoader(vertexBufferObjectManager);
        mainLevelLoader = new MainLevelLoader<SimpleLevelEntityLoaderData>(this, ConstantsUtil.TAG_LEVEL);
        shapeAndTextLoader = new ShapeAndTextLoader<SimpleLevelEntityLoaderData>(this, ConstantsUtil.TAG_ENTITY);

    }

    private void loadLevel(int levelID) {
        levelLoader.registerEntityLoader(mainLevelLoader);
        levelLoader.registerEntityLoader(shapeAndTextLoader);
        levelLoader.loadLevelFromAsset(activity.getAssets(), "lvl/" + levelID + ".lvl");
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
