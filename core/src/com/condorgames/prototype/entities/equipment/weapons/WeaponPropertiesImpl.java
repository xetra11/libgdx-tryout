package com.condorgames.prototype.entities.equipment.weapons;

public class WeaponPropertiesImpl implements WeaponProperties {

  private Status status;
  private Type type;
  private int ammoCount;
  private final int ammoCapacity;
  private static float remainingReloadTime;
  private static float remainingCadenceTime;
  private float reloadTime;
  private float cadence;

  public WeaponPropertiesImpl(int ammoCapacity, Type type) {
    this.ammoCapacity = ammoCapacity;
    this.type = type;
    this.status = Status.READY;
    ammoCount = ammoCapacity;
  }

  @Override
  public Status getState() {
    return status;
  }

  @Override
  public void setState(Status state) {
    this.status = state;
  }

  @Override
  public int getAmmoCount() {
    return ammoCount;
  }

  @Override
  public void setAmmoCount(int amount) {

    this.ammoCount = amount;
  }

  @Override
  public int getAmmoCapacity() {
    return ammoCapacity;
  }

  @Override
  public float getReloadTime() {
    return reloadTime;
  }

  @Override
  public void setReloadTime(float reloadTime){
    this.reloadTime = reloadTime;
  }

  @Override
  public float getCadence() {
    return cadence;
  }

  @Override
  public void setCadence(float cadence){
    this.cadence = cadence;
  }

  @Override
  public Type getType() {
    return type;
  }

}