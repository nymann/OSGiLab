package dk.sdu.mmmi.cbse.asteroidsplittingsystem;


import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {

        AsteroidSplitter ls = new AsteroidSplitter();
        context.registerService(IPostEntityProcessingService.class, ls, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

}
