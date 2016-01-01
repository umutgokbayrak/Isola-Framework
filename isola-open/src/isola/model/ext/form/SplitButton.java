package isola.model.ext.form;import isola.helpers.JsHelper;import isola.model.core.JsFunction;import isola.model.ext.constants.XTypes;/** *  * <p> * A split button that provides a built-in dropdown arrow that can fire an event *  * separately from the default click event of the button. Typically this would * be *  * used to display a dropdown menu that provides additional options to the *  * primary button action, but any custom handler can provide the arrowclick *  * implementation. Example usage: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * // display a dropdown menu: * 
 * new Ext.SplitButton({ * 
 * 	renderTo: 'button-ct', // the container id * 
 *    	text: 'Options', * 
 *    	handler: optionsHandler, // handle a click on the button itself * 
 *    	menu: new Ext.menu.Menu({ * 
 *         items: [ * 
 *         	// these items will render as dropdown menu items when the arrow is clicked: * 
 * 	        {text: 'Item 1', handler: item1Handler}, * 
 * 	        {text: 'Item 2', handler: item2Handler}, * 
 *         ] * 
 *    	}) * 
 * }); * 
 *  * 
 * // Instead of showing a menu, you provide any type of custom * 
 * // functionality you want when the dropdown arrow is clicked: * 
 * new Ext.SplitButton({ * 
 * 	renderTo: 'button-ct', * 
 *    	text: 'Options', * 
 *    	handler: optionsHandler, * 
 *    	arrowHandler: myCustomHandler * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class SplitButton extends Button {	private static final long serialVersionUID = 2147150362865556970L;	private static final String TAG = "Ext.SplitButton";	/**	 * 	 * A function called when the arrow button is clicked (can be used instead	 * of click event)	 */	public JsFunction arrowHandler;	/**	 * 	 * The title attribute of the arrow	 */	public String arrowTooltip;	/**	 * 	 * The type of event to map to the button's event handler (defaults to	 * 'click')	 */	public String clickEvent;	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.splitbutton;		public SplitButton() {		super();	}		protected void _postProcessToString() {		super._postProcessToString();		if (arrowHandler != null)			put("arrowHandler", arrowHandler);		if (arrowTooltip != null)			put("arrowTooltip", arrowTooltip);		if (clickEvent != null)			put("clickEvent", clickEvent);		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}