package dk.sdu.mmmi.cbse.asteroidsplittingsystem;

import dk.sdu.mmmi.cbse.common.asteroid.IAsteroidSplitter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class AsteroidSplitterActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) {
        AsteroidSplitter ls = new AsteroidSplitter();
        context.registerService(IAsteroidSplitter.class, ls, null);
    }

    @Override
    public void stop(BundleContext context) {
    }

}