package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.IBulletBehaviour;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.List;
import java.util.Random;

public class EnemyControlSystem implements IEntityProcessingService {

    private final Random random;
    private IBulletBehaviour bulletService;

    public EnemyControlSystem() {
        super();
        random = new Random();
    }

    @Override
    public void process(GameData gameData, World world) {
        List<Entity> enemies = world.getEntities(Enemy.class);
        for (Entity entity : enemies) {
            Enemy enemy = (Enemy) entity;

            MovingPart movingPart = enemy.getPart(MovingPart.class);
            boolean goingLeft = random.nextBoolean();
            movingPart.setLeft(goingLeft);
            movingPart.setRight(!goingLeft);
            movingPart.setUp(random.nextBoolean());
            movingPart.process(gameData, enemy);

            PositionPart positionPart = enemy.getPart(PositionPart.class);
            positionPart.process(gameData, enemy);

            handleWeaponLogic(enemy, gameData, world);


            updateShape(enemy);
        }
    }

    private void handleWeaponLogic(Enemy enemy, GameData gameData, World world) {
        if (this.bulletService == null) {
            return;
        }
        if (!enemy.canShoot(gameData.getDelta())) {
            return;
        }

        world.addEntity(bulletService.bulletCreator(enemy));
        enemy.resetCooldown();
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    public void setBulletService(IBulletBehaviour bulletService) {
        this.bulletService = bulletService;
    }

    public void removeBulletService(IBulletBehaviour bulletService) {
        this.bulletService = null;
    }

}
