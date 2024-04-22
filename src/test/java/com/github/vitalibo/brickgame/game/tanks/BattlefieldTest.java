package com.github.vitalibo.brickgame.game.tanks;

import com.github.vitalibo.brickgame.game.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BattlefieldTest {

    
    public void testSpawn() {
        Battlefield battlefield = new Battlefield();
        battlefield.spawn();

        List<Tank> tanks = battlefield.getTanks();
        Assert.assertNotNull(tanks);
        Assert.assertEquals(tanks.size(), 1);
    }

    public void testSpawnMultiple() {
        Battlefield battlefield = new Battlefield();
        int expectedSize = 3;

        for (int i = 0; i < expectedSize; i++) {
            battlefield.spawn();
        }

        List<Tank> tanks = battlefield.getTanks();
        Assert.assertNotNull(tanks);
        Assert.assertEquals(tanks.size(), expectedSize);

     
    }

    

    @Test
    public void testCanDoUp() {
        Battlefield battlefield = new Battlefield();
        Tank tank = new Tank(Point.of(5, 5), Direction.UP);
        battlefield.getTanks().add(tank);

        int result = battlefield.canDoUp(tank);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCanDoRight() {
        Battlefield battlefield = new Battlefield();
        Tank tank = new Tank(Point.of(5, 5), Direction.UP);
        battlefield.getTanks().add(tank);

        int result = battlefield.canDoRight(tank);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCanDoDown() {
        Battlefield battlefield = new Battlefield();
        Tank tank = new Tank(Point.of(5, 5), Direction.UP);
        battlefield.getTanks().add(tank);

        int result = battlefield.canDoDown(tank);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCanDoLeft() {
        Battlefield battlefield = new Battlefield();
        Tank tank = new Tank(Point.of(5, 5), Direction.UP);
        battlefield.getTanks().add(tank);

        int result = battlefield.canDoLeft(tank);

        Assert.assertEquals(result, 1);
    }
}
