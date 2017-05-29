package com.condorgames.prototype.entities.soldier;

public class SoldierPropertiesImpl implements SoldierProperties {
  private MoraleState morale;
  private Health health;

  public SoldierPropertiesImpl(MoraleState morale, Health health) {
    this.morale = morale;
    this.health = health;
  }

  @Override
  public void setMorale(MoraleState morale) {
    this.morale = morale;
  }

  @Override
  public void decreaseMorale() {
    morale = morale.decrease();
  }

  @Override
  public void raiseMorale() {
    morale = morale.raise();
  }

  @Override
  public MoraleState getMorale() {
    return morale;
  }

  @Override
  public void setHealth(Health health) {
    this.health = health;
  }

  @Override
  public Health getHealth() {
    return health;
  }
}