package catalina.internal.ql;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com._1c.g5.v8.dt.core.platform.IConfigurationProvider;
import com._1c.g5.v8.dt.core.platform.IV8ProjectManager;
import com._1c.g5.v8.dt.ql.typesystem.IDynamicDbViewFieldComputer;
import com._1c.g5.wiring.AbstractServiceAwareModule;

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
        bind(IConfigurationProvider.class).toService();
        bind(IV8ProjectManager.class).toService();

        URI uri = URI.createURI("*.qldcs"); //$NON-NLS-1$
        final IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
        bind(IDynamicDbViewFieldComputer.class).toProvider(() -> rsp.get(IDynamicDbViewFieldComputer.class));

    }

}
