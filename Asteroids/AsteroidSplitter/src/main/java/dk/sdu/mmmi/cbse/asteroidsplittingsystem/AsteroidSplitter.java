package dk.sdu.mmmi.cbse.asteroidsplittingsystem;

import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;


public class AsteroidSplitter implements IAsteroidSplitter {
    private Asteroid createPostSplitAsteroid(Entity entityToSplit, float radius, float offset) {
        Asteroid asteroid = new Asteroid();
        asteroid.setRadius(radius);

        LifePart lifePart = entityToSplit.getPart(LifePart.class);
        asteroid.add(new LifePart(lifePart.getLife(), lifePart.getHealth()));

        MovingPart movingPart = entityToSplit.getPart(MovingPart.class);
        asteroid.add(movingPart);

        PositionPart positionPart = entityToSplit.getPart(PositionPart.class);
        float x = positionPart.getX() + offset;
        float y = positionPart.getY() + offset;
        positionPart.setPosition(x, y);
        asteroid.add(new PositionPart(x, y, positionPart.getRadians()));
        return asteroid;
    }

    @Override
    public void splitAsteroid(Entity entity, World world) {
        LifePart lifePart = entity.getPart(LifePart.class);
        if (!lifePart.lostLifeLastCycle()) {
            return;
        }
        lifePart.lostLifeProcessed();
        world.removeEntity(entity.getID());
        float newRadius = entity.getRadius() / 2;
        if (newRadius < 3) {
            return;
        }
        float offset = newRadius * 6;
        world.addEntity(createPostSplitAsteroid(entity, newRadius, offset));
        world.addEntity(createPostSplitAsteroid(entity, newRadius, -offset));
    }

}
