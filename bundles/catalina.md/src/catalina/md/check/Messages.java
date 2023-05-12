package catalina.md.check;

import org.eclipse.osgi.util.NLS;

/**
 * The Class Messages.
 * @author Vadim Goncharov
 */
public class Messages
    extends NLS
{
    private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
    public static String MdObjectExchangePlanCheck_description;
    public static String MdObjectExchangePlanCheck_message;
    public static String MdObjectExchangePlanCheck_Param_Check_accounting_registers_title;
    public static String MdObjectExchangePlanCheck_Param_Check_accumulation_registers_title;
    public static String MdObjectExchangePlanCheck_Param_Check_business_processes_title;
    public static String MdObjectExchangePlanCheck_Param_Check_calculation_registers_title;
    public static String MdObjectExchangePlanCheck_Param_Check_catalogs_title;
    public static String MdObjectExchangePlanCheck_Param_Check_charts_of_accounts_title;
    public static String MdObjectExchangePlanCheck_Param_Check_charts_of_calculation_types_title;
    public static String MdObjectExchangePlanCheck_Param_Check_charts_of_characteristic_types_title;
    public static String MdObjectExchangePlanCheck_Param_Check_documents_title;
    public static String MdObjectExchangePlanCheck_Param_Check_information_registers_title;
    public static String MdObjectExchangePlanCheck_Param_Check_tasks_title;
    public static String MdObjectExchangePlanCheck_Param_Exchange_plans_for_check_title;
    public static String MdObjectExchangePlanCheck_title;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages()
    {
    }
}
