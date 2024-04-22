package com.github.vitalibo.brickgame.game.shoot;
import com.github.vitalibo.brickgame.game.Point;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArmyTest {

    @Test
    public void testKillEnemy() {
        Army army = new Army();
        List<Point> enemyPoints = new ArrayList<>();
        enemyPoints.add(Point.of(0, 1));
        enemyPoints.add(Point.of(2, 3));

        army.addAll(enemyPoints);

        List<Point> shootPoints = new ArrayList<>();
        shootPoints.add(Point.of(0, 1));
        shootPoints.add(Point.of(2, 3));

        boolean result = army.killEnemy(shootPoints);

        Assert.assertTrue(result);
        Assert.assertEquals(army.size(), 0);
    }

    @Test
    public void testMakeAttack() {
        Army army = new Army();
        int initialSize = army.size();
        army.makeAttack();
        Assert.assertTrue(army.size() > initialSize);
    }

    @Test
    public void testHasWin() {
        Army army = new Army();
        army.add(Point.of(20, 20));
        Assert.assertTrue(army.hasWin());
    }

    @Test
    public void testHasNotWin() {
        Army army = new Army();
        army.add(Point.of(0, 10));
        Assert.assertFalse(army.hasWin());
    }
}
