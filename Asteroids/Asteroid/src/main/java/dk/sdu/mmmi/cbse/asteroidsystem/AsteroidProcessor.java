package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;


public class AsteroidProcessor implements IEntityProcessingService {
    private final Random random = new Random();
    private IAsteroidSplitter asteroidSplitter;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);

            boolean goingLeft = random.nextBoolean();
            movingPart.setLeft(goingLeft);
            movingPart.setRight(!goingLeft);
            movingPart.setUp(random.nextBoolean());
            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            if (this.asteroidSplitter != null) {
                asteroidSplitter.splitAsteroid(asteroid, world);
            }
        }
    }

    public void setAsteroidSplitterService(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplitter = asteroidSplitter;
    }

    public void removeAsteroidSplitterService(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplitter = null;
    }
}
