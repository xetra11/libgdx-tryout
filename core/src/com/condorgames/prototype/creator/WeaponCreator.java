package com.condorgames.prototype.creator;

import com.condorgames.prototype.entities.equipment.weapons.Weapon;
import com.condorgames.prototype.entities.equipment.weapons.WeaponProperties;
import com.condorgames.prototype.entities.equipment.weapons.WeaponPropertiesImpl;

public abstract class WeaponCreator {

  public static Weapon createRifle() {
    WeaponPropertiesImpl weaponPropertiesImpl = new WeaponPropertiesImpl(5, WeaponProperties.Type.RIFLE);
    weaponPropertiesImpl.setReloadTime(10f);
    weaponPropertiesImpl.setCadence(2f);
    Weapon weapon = new Weapon(weaponPropertiesImpl);
    return weapon;
  }
}
