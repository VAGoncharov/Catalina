
package catalina.internal.md;

import org.osgi.framework.Bundle;

import com._1c.g5.wiring.AbstractGuiceAwareExecutableExtensionFactory;
import com.google.inject.Injector;

/**
 * A factory for creating ExecutableExtension objects.
 * @author Vadim Goncharov
 */
public class ExecutableExtensionFactory
    extends AbstractGuiceAwareExecutableExtensionFactory
{
    @Override
    protected Bundle getBundle()
    {
        return CorePlugin.getDefault().getBundle();
    }

    @Override
    protected Injector getInjector()
    {
        return CorePlugin.getDefault().getInjector();
    }
}
