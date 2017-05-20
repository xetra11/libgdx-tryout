
package com.condorgames.prototype;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.condorgames.prototype.entities.AutonomousPlatoonEntity;
import com.condorgames.prototype.entities.StandardPlatoonEntity;

public class CondorAiPrototype extends ApplicationAdapter implements InputProcessor{
  public static final float PIXEL_TO_METERS = 100f;
  private Box2DDebugRenderer debugRenderer;
  private Matrix4 debugMatrix;
  private Body platoon, enemy, movementTarget;
  private World world;
  private OrthographicCamera camera;

  @Override
  public void create() {
    createMeta();
    platoon = BodyFactory.createRectangleBody(1f, 0.5f, new Vector2(1.5f, 0.5f), world, BodyDef.BodyType.DynamicBody);
    enemy = BodyFactory.createRectangleBody(0.5f, 0.5f, new Vector2(3f, 4f), world, BodyDef.BodyType.DynamicBody);

    AutonomousPlatoonEntity friendly = new AutonomousPlatoonEntity(platoon);

    friendly.getBoundingRadius();

    movementTarget = BodyFactory.createCircleBody(0.2f, new Vector2(1.5f, 3f), world, BodyDef.BodyType.StaticBody);
    movementTarget.getFixtureList().first().setSensor(true);
  }

  @Override
  public void render() {
    camera.update();
    world.step(1f/60f, 6, 2);

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    debugRenderer.render(world, debugMatrix);
  }

  @Override
  public void dispose() {
  }

  private void createMeta() {
    debugRenderer = new Box2DDebugRenderer();
    world = new World(new Vector2(0f,0f), false);
    camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    debugMatrix = camera.combined.cpy().scale(PIXEL_TO_METERS, PIXEL_TO_METERS, 0f);

    Gdx.input.setInputProcessor(this);
  }

  //<editor-fold desc="InputProcessing">
  @Override
  public boolean keyDown(int keycode) {
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {
    return false;
  }

  @Override
  public boolean keyTyped(char character) {
    return false;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    Helper.setClickedPositionForBox2D(screenX, screenY, movementTarget);
    return true;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    return false;
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    return false;
  }

  @Override
  public boolean scrolled(int amount) {
    return false;
  }
  //</editor-fold>
}
