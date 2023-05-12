package catalina.ql.check;

import static com._1c.g5.v8.dt.ql.model.QlPackage.Literals.ABSTRACT_QUERY_SCHEMA_TABLE__TABLE_NAME;

import java.text.MessageFormat;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import com._1c.g5.v8.dt.metadata.dbview.DbViewElement;
import com._1c.g5.v8.dt.metadata.dbview.DbViewSelectDef;
import com._1c.g5.v8.dt.metadata.mdclass.InformationRegister;
import com._1c.g5.v8.dt.ql.model.QuerySchemaTable;
import com._1c.g5.v8.dt.ql.typesystem.IDynamicDbViewFieldComputer;
import com.e1c.g5.v8.dt.check.CheckComplexity;
import com.e1c.g5.v8.dt.check.ICheckParameters;
import com.e1c.g5.v8.dt.check.settings.IssueSeverity;
import com.e1c.g5.v8.dt.check.settings.IssueType;
import com.e1c.g5.v8.dt.ql.check.QlBasicDelegateCheck;
import com.google.inject.Inject;

import catalina.internal.ql.CorePlugin;

/**
 * The Class UseNonRecommendedSliceCheck.
 * @author Vadim Goncharov
 */
public class UseNonRecommendedSliceCheck
    extends QlBasicDelegateCheck
{

    private static final String CHECK_ID = "ql-vistual-table-use-non-recommended-slice"; //$NON-NLS-1$

    private static final String PARAM_REGISTER_LIST = "registerList"; //$NON-NLS-1$

    private static final Set<String> REGISTERS_LIST = Set.of(" адрова€»стори€—отрудников", //$NON-NLS-1$
        " адрова€»стори€—отрудников»нтервальный"); //$NON-NLS-1$

    private static final String DELIMITER = ","; //$NON-NLS-1$

    private static final String DEFAULT_REGISTERS_LIST = String.join(DELIMITER, REGISTERS_LIST); //$NON-NLS-1$

    private final IDynamicDbViewFieldComputer dynamicDbViewFieldComputer;

    @Inject
    public UseNonRecommendedSliceCheck(IDynamicDbViewFieldComputer dynamicDbViewFieldComputer)
    {
        super();
        this.dynamicDbViewFieldComputer = dynamicDbViewFieldComputer;
    }

    @Override
    public String getCheckId()
    {
        return CHECK_ID;
    }

    @Override
    protected void configureCheck(CheckConfigurer builder)
    {
        builder.title(Messages.UseNonRecommendedSliceCheck_title)
            .description(Messages.UseNonRecommendedSliceCheck_description)
            .complexity(CheckComplexity.NORMAL)
            .severity(IssueSeverity.MAJOR)
            .issueType(IssueType.PERFORMANCE)
            .parameter(PARAM_REGISTER_LIST, String.class, DEFAULT_REGISTERS_LIST,
                Messages.UseNonRecommendedSliceCheck_Param_Register_list_title);
        builder.delegate(QuerySchemaTable.class);
    }

    @Override
    protected void checkQlObject(EObject object, QueryOwner owner, IQlResultAcceptor resultAcceptor,
        ICheckParameters parameters, IProgressMonitor monitor)
    {

        QuerySchemaTable sourceTable = (QuerySchemaTable)object;

        DbViewElement dbView = null;
        try
        {
            dbView = dynamicDbViewFieldComputer.computeDbView(sourceTable.getTable());
        }
        catch (Exception e)
        {
            CorePlugin.logError(e);
            return;
        }

        if (monitor.isCanceled() || !(dbView instanceof DbViewSelectDef))
        {
            return;
        }

        Set<String> registers = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        String paramString = parameters.getString(PARAM_REGISTER_LIST);
        Set<String> params = Set.of(paramString.replace(" ", "").split(DELIMITER)); //$NON-NLS-1$ //$NON-NLS-2$
        registers.addAll(params);

        EObject mdObject = dbView.getMdObject();
        if (mdObject instanceof InformationRegister && registers.contains(((InformationRegister)mdObject).getName()))
        {
            String msg = MessageFormat.format(Messages.UseNonRecommendedSliceCheck_message,
                ((InformationRegister)mdObject).getName());
            resultAcceptor.addIssue(msg, sourceTable.getTable(), ABSTRACT_QUERY_SCHEMA_TABLE__TABLE_NAME);
        }

    }

}
