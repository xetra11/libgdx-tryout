package com.condorgames.prototype.creator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.condorgames.prototype.entities.platoon.Platoon;
import com.condorgames.prototype.entities.squad.Squad;
import com.condorgames.prototype.entities.squad.SquadBase;
import com.condorgames.prototype.helper.FilterCategories;

public abstract class PlatoonCreator {

  public static Platoon createPlatoon(World world, Vector2 position) {
    final Body rectangleBody = BodyCreator.createCircleBody(0.15f, position, world, BodyDef.BodyType.DynamicBody, FilterCategories.ALLY, FilterCategories.NONE);
//    addLOS(rectangleBody);
    Platoon platoon = new Platoon(rectangleBody);
    return platoon;
  }

  private static void addLOS(Body body) {
    final Vector2[] vector2s = new Vector2[6];
    vector2s[0] = new Vector2(0f, 0f);
    vector2s[2] = new Vector2(1.5f, 1.5f);
    vector2s[3] = new Vector2(2f, 1f);
    vector2s[4] = new Vector2(0f, 2.1f);
    vector2s[1] = new Vector2(-2f, 1f);
    vector2s[5] = new Vector2(-1.5f, 1.5f);
    PolygonShape shape = new PolygonShape();
    shape.set(vector2s);

    FixtureDef losFixtureDef = new FixtureDef();
    losFixtureDef.shape = shape;
    losFixtureDef.isSensor = true;
    losFixtureDef.filter.categoryBits = FilterCategories.LOS;
    losFixtureDef.filter.maskBits = FilterCategories.ENEMY;
    body.createFixture(losFixtureDef).setUserData("LOS");
  }

}
