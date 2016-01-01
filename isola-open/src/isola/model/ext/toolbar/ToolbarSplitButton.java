package isola.model.ext.toolbar;import isola.helpers.JsHelper;import isola.model.ext.constants.XTypes;import isola.model.ext.form.SplitButton;/** *  * A split button that renders into a toolbar. *  *  *  * <pre> * &lt;code&gt; * 
 * new Ext.Panel({ * 
 * 	tbar : [ * 
 * 		{ * 
 * 			xtype: 'tbsplit', * 
 * 		   	text: 'Options', * 
 * 		   	handler: optionsHandler, // handle a click on the button itself * 
 * 		   	menu: new Ext.menu.Menu({ * 
 * 		        items: [ * 
 * 		        	// These items will display in a dropdown menu when the split arrow is clicked * 
 * 			        {text: 'Item 1', handler: item1Handler}, * 
 * 			        {text: 'Item 2', handler: item2Handler}, * 
 * 		        ] * 
 * 		   	}) * 
 * 		} * 
 * 	] * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class ToolbarSplitButton extends SplitButton {	private static final long serialVersionUID = -7509660297802203460L;	private static final String TAG = "Ext.Toolbar.SplitButton";	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.tbsplit;		public ToolbarSplitButton() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}