package com.github.vitalibo.brickgame.game.tanks;

import com.github.vitalibo.brickgame.game.Point;
import org.testng.annotations.Test;

public class DirectionTest {

    @Test
    public void testUp() {
        Point point = Point.of(5, 5);
        Direction.UP.accept(point);

        assert point.getX() == 5;
        assert point.getY() == 4;
    }

    @Test
    public void testRight() {
        Point point = Point.of(5, 5);
        Direction.RIGHT.accept(point);

        assert point.getX() == 6;
        assert point.getY() == 5;
    }

    @Test
    public void testDown() {
        Point point = Point.of(5, 5);
        Direction.DOWN.accept(point);

        assert point.getX() == 5;
        assert point.getY() == 6;
    }

    @Test
    public void testLeft() {
        Point point = Point.of(5, 5);
        Direction.LEFT.accept(point);

        assert point.getX() == 4;
        assert point.getY() == 5;
    }
}
