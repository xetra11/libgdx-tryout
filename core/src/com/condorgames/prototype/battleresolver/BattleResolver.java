package com.condorgames.prototype.battleresolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleResolver {

  private List<ResolvableSituation> battleSituations = new ArrayList<>();

  public void addBattleSituations(List<ResolvableSituation> battleSituations) {
    battleSituations.addAll(battleSituations);
  }

  public void addBattleSituations(ResolvableSituation... battleSituations) {
    this.battleSituations.addAll(Arrays.asList(battleSituations));
  }

  public void resolve(boolean parallel, float deltaTime) {
    if (battleSituations.isEmpty() == false) {
      if (parallel) {
        battleSituations.parallelStream().forEach(battleSituation -> battleSituation.resolve(deltaTime));
      } else {
        battleSituations.forEach(battleSituation -> battleSituation.resolve(deltaTime));
      }
    }
  }
}
