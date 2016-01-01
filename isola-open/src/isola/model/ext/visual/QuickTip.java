package isola.model.ext.visual;import isola.helpers.JsHelper;/** *  * A specialized tooltip class for tooltips that can be specified in markup and * automatically *  * managed by the global Ext.QuickTips instance. *  * <p> * Provides attractive and customizable tooltips for any element. The QuickTips *  * singleton is used to configure and manage tooltips globally for multiple * elements *  * in a generic manner. To create individual tooltips with maximum * customizability, *  * you should consider either {@link Ext.Tip} or {@link Ext.ToolTip}. * </p> *  * <p> * Quicktips can be configured via tag attributes directly in markup, or by *  * registering quick tips programmatically via the {@link #register} method. * </p> *  * <p> * The singleton's instance of {@link Ext.QuickTip} is available via *  * {@link #getQuickTip}, and supports all the methods, and all the all the *  * configuration properties of Ext.QuickTip. These settings will apply to all *  * tooltips shown by the singleton. * </p> *  * <p> * Below is the summary of the configuration properties which can be used. *  * For detailed descriptions see {@link #getQuickTip} * </p> *  * <p> * <b>QuickTips singleton configs (all are optional)</b> * </p> *  * <div class="mdetail-params"> * <ul> * <li>dismissDelay</li> *  * <li>hideDelay</li> *  * <li>maxWidth</li> *  * <li>minWidth</li> *  * <li>showDelay</li> *  * <li>trackMouse</li> * </ul> * </div> *  * <p> * <b>Target element configs (optional unless otherwise noted)</b> * </p> *  * <div class="mdetail-params"> * <ul> * <li>autoHide</li> *  * <li>cls</li> *  * <li>dismissDelay (overrides singleton value)</li> *  * <li>target (required)</li> *  * <li>text (required)</li> *  * <li>title</li> *  * <li>width</li> * </ul> * </div> *  * <p> * Here is an example showing how some of these config options could be used: * </p> *  * <pre> * &lt;code&gt; * 
 * // Init the singleton.  Any tag-based quick tips will start working. * 
 * Ext.QuickTips.init(); * 
 * 
 * // Apply a set of config properties to the singleton * 
 * Ext.apply(Ext.QuickTips.getQuickTip(), { * 
 *   maxWidth: 200, * 
 *   minWidth: 100, * 
 *   showDelay: 50, * 
 *   trackMouse: true * 
 * }); * 
 * 
 * // Manually register a quick tip for a specific element * 
 * q.register({ * 
 *   target: 'my-div', * 
 *   title: 'My Tooltip', * 
 *   text: 'This tooltip was added in code', * 
 *   width: 100, * 
 *   dismissDelay: 20 * 
 * }); * 
 * &lt;/code&gt; * </pre> *  * <p> * To register a quick tip in markup, you simply add one or more of the valid * QuickTip attributes prefixed with *  * the <b>ext:</b> namespace. The HTML element itself is automatically set as * the quick tip target. Here is the summary *  * of supported attributes (optional unless otherwise noted): * </p> *  * <ul> * <li><b>hide</b>: Specifying "user" is equivalent to setting autoHide = false. * Any other value will be the *  * same as autoHide = true.</li> *  * <li><b>qclass</b>: A CSS class to be applied to the quick tip (equivalent to * the 'cls' target element config).</li> *  * <li><b>qtip (required)</b>: The quick tip text (equivalent to the 'text' * target element config).</li> *  * <li><b>qtitle</b>: The quick tip title (equivalent to the 'title' target * element config).</li> *  * <li><b>qwidth</b>: The quick tip width (equivalent to the 'width' target * element config).</li> * </ul> *  * <p> * Here is an example of configuring an HTML element to display a tooltip from * markup: * </p> *  * <pre> * &lt;code&gt; * 
 * // Add a quick tip to an HTML button * 
 * &lt;input type=&quot;button&quot; value=&quot;OK&quot; ext:qtitle=&quot;OK Button&quot; ext:qwidth=&quot;100&quot; * 
 *    ext:qtip=&quot;This is a quick tip from markup!&quot;&gt;&lt;/input&gt; * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class QuickTip extends ToolTip {	private static final long serialVersionUID = 7429406991477404966L;	private static final String TAG = "Ext.QuickTip";	/**	 * 	 * True to automatically use the element's DOM title value if available	 * (defaults to false).	 */	public boolean interceptTitles = false;		public QuickTip() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (interceptTitles)			put("interceptTitles", interceptTitles);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}