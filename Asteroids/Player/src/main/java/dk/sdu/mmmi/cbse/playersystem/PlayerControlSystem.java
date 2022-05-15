package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.bullet.IBulletBehaviour;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class PlayerControlSystem implements IEntityProcessingService {

    private IBulletBehaviour bulletService;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities(Player.class)) {
            Player player = (Player) entity;

            if (canShoot(player, gameData)) {
                world.addEntity(bulletService.bulletCreator(player));
                player.resetCooldown();
            }

            MovingPart movingPart = player.getPart(MovingPart.class);
            movingPart.setLeft(gameData.getKeys().isDown(GameKeys.LEFT));
            movingPart.setRight(gameData.getKeys().isDown(GameKeys.RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(GameKeys.UP));
            movingPart.process(gameData, player);

            PositionPart positionPart = player.getPart(PositionPart.class);
            positionPart.process(gameData, player);

            updateShape(player);
        }
    }

    private boolean canShoot(Player player, GameData gameData) {
        if (this.bulletService == null) {
            return false;
        }
        if (!player.canShoot(gameData.getDelta())) {
            return false;
        }

        if (!gameData.getKeys().isDown(GameKeys.SPACE)) {
            return false;
        }

        return true;
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
