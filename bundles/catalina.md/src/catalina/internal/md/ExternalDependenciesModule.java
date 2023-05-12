
package catalina.internal.md;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.emf.common.util.URI;

import com._1c.g5.v8.dt.core.naming.ITopObjectFqnGenerator;
import com._1c.g5.v8.dt.core.platform.IV8ProjectManager;
import com._1c.g5.wiring.AbstractServiceAwareModule;
import com._1c.g5.v8.dt.core.platform.IConfigurationProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * The Class ExternalDependenciesModule.
 * @author Vadim Goncharov
 */
public class ExternalDependenciesModule
    extends AbstractServiceAwareModule
{

    /**
     * @param plugin
     */
    public ExternalDependenciesModule(Plugin plugin)
    {
        super(plugin);
    }

    @Override
    protected void doConfigure()
    {
        bind(IV8ProjectManager.class).toService();
        bind(IQualifiedNameConverter.class).toService();
        bind(ITopObjectFqnGenerator.class).toService();
//        bind(IScopeProvider.class).toService();
        bind(IConfigurationProvider.class).toService();

        URI uri = URI.createURI("*.mdo"); //$NON-NLS-1$
        final IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
        bind(IScopeProvider.class).toProvider(() -> rsp.get(IScopeProvider.class));
    }

}
