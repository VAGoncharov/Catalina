package catalina.md.check;

import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__CATALOGS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__CHARTS_OF_ACCOUNTS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__CHARTS_OF_CHARACTERISTIC_TYPES;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__CHARTS_OF_CALCULATION_TYPES;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__DOCUMENTS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__ACCUMULATION_REGISTERS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__ACCOUNTING_REGISTERS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__CALCULATION_REGISTERS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__INFORMATION_REGISTERS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__BUSINESS_PROCESSES;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.CONFIGURATION__TASKS;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.EXCHANGE_PLAN;
import static com._1c.g5.v8.dt.metadata.mdclass.MdClassPackage.Literals.EXCHANGE_PLAN__CONTENT;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com._1c.g5.v8.dt.metadata.mdclass.ExchangePlan;
import com._1c.g5.v8.dt.metadata.mdclass.ExchangePlanContentItem;
import com._1c.g5.v8.dt.metadata.mdclass.MdObject;
import com.e1c.g5.v8.dt.check.CheckComplexity;
import com.e1c.g5.v8.dt.check.ICheckParameters;
import com.e1c.g5.v8.dt.check.components.BasicCheck;
import com.e1c.g5.v8.dt.check.settings.IssueSeverity;
import com.e1c.g5.v8.dt.check.settings.IssueType;
import com.google.inject.Inject;

/**
 * The Class MdObjectExchangePlanCheck.
 * @author Vadim Goncharov
 */
public class MdObjectExchangePlanCheck
    extends BasicCheck
{

    private static final String CHECK_ID = "md-object-exchange-plan-content"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_CATALOG = "checkCatalog"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_CHARTS_OF_ACCOUNTS = "checkChartsOfAccounts"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_CHARTS_OF_CHARACTERISTIC_TYPES = "checkChartsOfCharacteristicTypes"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_CHARTS_OF_CALCULATION_TYPES = "checkChartsOfCalculationTypes"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_DOCUMENTS = "checkDocuments"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_ACCUMULATION_REGISTERS = "checkAccumulationRegisters"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_ACCOUNTING_REGISTERS = "checkAccountingRegisters"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_CALCULATION_REGISTERS = "checkCalculationRegisters"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_INFORMATION_REGISTERS = "checkInformationRegisters"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_BUSINESS_PROCESSES = "checkBusinessProcesses"; //$NON-NLS-1$

    private static final String PARAM_NAME_CHECK_TASKS = "checkTasks"; //$NON-NLS-1$

    private static final String PARAM_EXCHANGE_PLAN_LIST = "exchangePlans"; //$NON-NLS-1$

    private static final Set<String> EXCHANGE_PLAN_LIST = Set.of("”–¡ƒ", //$NON-NLS-1$
        "‘ËÎË‡Î˚"); //$NON-NLS-1$

    private static final String DELIMITER = ","; //$NON-NLS-1$

    private static final String DEFAULT_EXCHANGE_PLAN_LIST = String.join(DELIMITER, EXCHANGE_PLAN_LIST); //$NON-NLS-1$

    private final IScopeProvider scopeProvider;

    @Inject
    public MdObjectExchangePlanCheck(IScopeProvider scopeProvider)
    {
        super();
        this.scopeProvider = scopeProvider;
    }

    @Override
    public String getCheckId()
    {
        return CHECK_ID;
    }

    @Override
    protected void configureCheck(CheckConfigurer builder)
    {
        builder.title(Messages.MdObjectExchangePlanCheck_title)
            .description(Messages.MdObjectExchangePlanCheck_description)
            .complexity(CheckComplexity.NORMAL)
            .severity(IssueSeverity.MAJOR)
            .issueType(IssueType.WARNING)
            .topObject(EXCHANGE_PLAN)
            .features(EXCHANGE_PLAN__CONTENT)
            .parameter(PARAM_NAME_CHECK_CATALOG, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_catalogs_title)
            .parameter(PARAM_NAME_CHECK_CHARTS_OF_ACCOUNTS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_charts_of_accounts_title)
            .parameter(PARAM_NAME_CHECK_CHARTS_OF_CHARACTERISTIC_TYPES, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_charts_of_characteristic_types_title)
            .parameter(PARAM_NAME_CHECK_CHARTS_OF_CALCULATION_TYPES, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_charts_of_calculation_types_title)
            .parameter(PARAM_NAME_CHECK_DOCUMENTS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_documents_title)
            .parameter(PARAM_NAME_CHECK_ACCUMULATION_REGISTERS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_accumulation_registers_title)
            .parameter(PARAM_NAME_CHECK_ACCOUNTING_REGISTERS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_accounting_registers_title)
            .parameter(PARAM_NAME_CHECK_CALCULATION_REGISTERS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_calculation_registers_title)
            .parameter(PARAM_NAME_CHECK_INFORMATION_REGISTERS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_information_registers_title)
            .parameter(PARAM_NAME_CHECK_BUSINESS_PROCESSES, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_business_processes_title)
            .parameter(PARAM_NAME_CHECK_TASKS, Boolean.class, Boolean.TRUE.toString(),
                Messages.MdObjectExchangePlanCheck_Param_Check_tasks_title)
            .parameter(PARAM_EXCHANGE_PLAN_LIST, String.class, DEFAULT_EXCHANGE_PLAN_LIST,
                Messages.MdObjectExchangePlanCheck_Param_Exchange_plans_for_check_title);
        builder.topObject(EXCHANGE_PLAN).features(EXCHANGE_PLAN__CONTENT);
    }

    @Override
    protected void check(Object object, ResultAcceptor resultAcceptor, ICheckParameters parameters,
        IProgressMonitor monitor)
    {

        ExchangePlan exchPlan = (ExchangePlan)object;

        StructParameters structParams = new StructParameters(parameters);

        if (monitor.isCanceled() || !needCheckExchPlan(exchPlan, structParams))
        {
            return;
        }

        checkCatalogs(exchPlan, structParams, resultAcceptor, monitor);
        checkChartsOfAccounts(exchPlan, structParams, resultAcceptor, monitor);
        checkChartsOfCharacteristicTypes(exchPlan, structParams, resultAcceptor, monitor);
        checkChartsOfCalculationTypes(exchPlan, structParams, resultAcceptor, monitor);
        checkDocuments(exchPlan, structParams, resultAcceptor, monitor);
        checkAccountingRegisters(exchPlan, structParams, resultAcceptor, monitor);
        checkAccumulationRegisters(exchPlan, structParams, resultAcceptor, monitor);
        checkCalculationRegisters(exchPlan, structParams, resultAcceptor, monitor);
        checkInformationRegisters(exchPlan, structParams, resultAcceptor, monitor);
        checkBusinessProcesses(exchPlan, structParams, resultAcceptor, monitor);
        checkTasks(exchPlan, structParams, resultAcceptor, monitor);

    }

    List<MdObject> getListOfMdObjects(ExchangePlan exchPlan, EReference ref, IProgressMonitor monitor)
    {
        List<MdObject> listOfObject = new ArrayList<>();
        IScope scope = scopeProvider.getScope(exchPlan, ref);
        for (IEObjectDescription desc : scope.getAllElements())
        {
            if (monitor.isCanceled())
            {
                break;
            }
            listOfObject.add((MdObject)desc.getEObjectOrProxy());
        }

        return listOfObject;
    }

    void checkCatalogs(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkCatalogs)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__CATALOGS, structParams, resultAcceptor, monitor);
    }

    void checkChartsOfAccounts(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkChartsOfAccounts)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__CHARTS_OF_ACCOUNTS, structParams, resultAcceptor, monitor);
    }

    void checkChartsOfCharacteristicTypes(ExchangePlan exchPlan, StructParameters structParams,
        ResultAcceptor resultAcceptor, IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkChartsOfCharacteristicTypes)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__CHARTS_OF_CHARACTERISTIC_TYPES, structParams, resultAcceptor, monitor);
    }

    void checkChartsOfCalculationTypes(ExchangePlan exchPlan, StructParameters structParams,
        ResultAcceptor resultAcceptor, IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkChartsOfCalculationTypes)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__CHARTS_OF_CALCULATION_TYPES, structParams, resultAcceptor, monitor);
    }

    void checkDocuments(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkDocuments)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__DOCUMENTS, structParams, resultAcceptor, monitor);
    }

    void checkAccountingRegisters(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkAccountingRegisters)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__ACCOUNTING_REGISTERS, structParams, resultAcceptor, monitor);
    }

    void checkAccumulationRegisters(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkAccumulationRegisters)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__ACCUMULATION_REGISTERS, structParams, resultAcceptor, monitor);
    }

    void checkCalculationRegisters(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkCalculationRegisters)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__CALCULATION_REGISTERS, structParams, resultAcceptor, monitor);
    }

    void checkInformationRegisters(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkInformationRegisters)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__INFORMATION_REGISTERS, structParams, resultAcceptor, monitor);
    }

    void checkBusinessProcesses(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkBusinessProcesses)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__BUSINESS_PROCESSES, structParams, resultAcceptor, monitor);
    }

    void checkTasks(ExchangePlan exchPlan, StructParameters structParams, ResultAcceptor resultAcceptor,
        IProgressMonitor monitor)
    {
        if (monitor.isCanceled() || !structParams.checkTasks)
        {
            return;
        }
        checkMdObjects(exchPlan, CONFIGURATION__TASKS, structParams, resultAcceptor, monitor);
    }

    void checkMdObjects(ExchangePlan exchPlan, EReference mdObject, StructParameters structParams,
        ResultAcceptor resultAcceptor, IProgressMonitor monitor)
    {

        if (monitor.isCanceled())
        {
            return;
        }

        List<MdObject> listOfMdObjects = getListOfMdObjects(exchPlan, mdObject, monitor);
        if (monitor.isCanceled() || listOfMdObjects.isEmpty())
        {
            return;
        }

        List<MdObject> mdObjectsOfExchPl = new ArrayList<>();
        for (ExchangePlanContentItem item : exchPlan.getContent())
        {
            mdObjectsOfExchPl.add(item.getMdObject());
        }

        for (MdObject item : listOfMdObjects)
        {

            if (monitor.isCanceled())
            {
                return;
            }

            if (!mdObjectsOfExchPl.contains(item))
            {
                addIssue(resultAcceptor, exchPlan, item);
            }
        }

    }

    boolean needCheckExchPlan(ExchangePlan exchPlan, StructParameters parameters)
    {
        return parameters.exchangePlanList.contains(exchPlan.getName());
    }

    void addIssue(ResultAcceptor resultAcceptor, ExchangePlan exchPlan, MdObject mdObject)
    {
        String msg =
            MessageFormat.format(Messages.MdObjectExchangePlanCheck_message, mdObject.getName(), exchPlan.getName());
        resultAcceptor.addIssue(msg, exchPlan, EXCHANGE_PLAN__CONTENT);
    }

    private class StructParameters
    {

        private boolean checkCatalogs;

        private boolean checkChartsOfAccounts;

        private boolean checkChartsOfCharacteristicTypes;

        private boolean checkChartsOfCalculationTypes;

        private boolean checkDocuments;

        private boolean checkAccumulationRegisters;

        private boolean checkAccountingRegisters;

        private boolean checkCalculationRegisters;

        private boolean checkInformationRegisters;

        private boolean checkBusinessProcesses;

        private boolean checkTasks;

        private Set<String> exchangePlanList;

        public StructParameters(ICheckParameters checkParameters)
        {
            checkCatalogs = checkParameters.getBoolean(PARAM_NAME_CHECK_CATALOG);
            checkChartsOfAccounts = checkParameters.getBoolean(PARAM_NAME_CHECK_CHARTS_OF_ACCOUNTS);
            checkChartsOfCharacteristicTypes =
                checkParameters.getBoolean(PARAM_NAME_CHECK_CHARTS_OF_CHARACTERISTIC_TYPES);
            checkChartsOfCalculationTypes = checkParameters.getBoolean(PARAM_NAME_CHECK_CHARTS_OF_CALCULATION_TYPES);
            checkDocuments = checkParameters.getBoolean(PARAM_NAME_CHECK_DOCUMENTS);
            checkAccumulationRegisters = checkParameters.getBoolean(PARAM_NAME_CHECK_ACCUMULATION_REGISTERS);
            checkAccountingRegisters = checkParameters.getBoolean(PARAM_NAME_CHECK_ACCOUNTING_REGISTERS);
            checkCalculationRegisters = checkParameters.getBoolean(PARAM_NAME_CHECK_CALCULATION_REGISTERS);
            checkInformationRegisters = checkParameters.getBoolean(PARAM_NAME_CHECK_INFORMATION_REGISTERS);
            checkBusinessProcesses = checkParameters.getBoolean(PARAM_NAME_CHECK_BUSINESS_PROCESSES);
            checkTasks = checkParameters.getBoolean(PARAM_NAME_CHECK_TASKS);

            String paramExchangePlanList = checkParameters.getString(PARAM_EXCHANGE_PLAN_LIST);
            exchangePlanList = Set.of(paramExchangePlanList.replace(" ", "").split(DELIMITER)); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

}
