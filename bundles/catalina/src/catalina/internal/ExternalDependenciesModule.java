package catalina.internal;

import org.eclipse.core.runtime.Plugin;

import com._1c.g5.wiring.AbstractServiceAwareModule;
import com.e1c.g5.v8.dt.check.settings.ICheckRepository;

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
        bind(ICheckRepository.class).toService();
    }
}
