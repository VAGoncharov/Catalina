package catalina.ql.check;

import org.eclipse.osgi.util.NLS;

/**
 * The Class Messages.
 * @author Vadim Goncharov
 */
public class Messages
    extends NLS
{
    private static final String BUNDLE_NAME = Messages.class.getPackageName() + ".messages"; //$NON-NLS-1$
    public static String UseNonRecommendedSliceCheck_description;
    public static String UseNonRecommendedSliceCheck_message;
    public static String UseNonRecommendedSliceCheck_Param_Register_list_title;
    public static String UseNonRecommendedSliceCheck_title;
    static
    {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages()
    {
    }
}
