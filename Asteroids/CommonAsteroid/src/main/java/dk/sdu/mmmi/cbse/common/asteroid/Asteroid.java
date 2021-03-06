package dk.sdu.mmmi.cbse.common.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.shape.IShapeRender;
import dk.sdu.mmmi.cbse.common.shape.ShapeType;

public class Asteroid extends Entity {
    public Asteroid() {
        super(10, 30);
        hexColor = "756153";
        shapeType = ShapeType.FILLED;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ASTEROID;
    }

    @Override
    protected void drawMethod(IShapeRender sr) {
        PositionPart pos = this.getPart(PositionPart.class);
        sr.addCircle(pos.getX(), pos.getY(), this.getRadius());
    }
}
