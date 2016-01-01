package isola.model.ext.toolbar;import isola.helpers.JsHelper;import isola.model.ext.constants.XTypes;/** * <p> * A simple class that adds a vertical separator bar between toolbar items. * Example usage: * </p> *  * <code><pre> * 	new Ext.Panel({ * 	tbar : [ * 		'Item 1', * 		{xtype: 'tbseparator'}, // or '-' * 		'Item 2' * 	] * }); *  * </pre></code> *  * @author Umut Gokbayrak */public class ToolbarSeparator extends ToolbarItem {	private static final long serialVersionUID = 6685238888433963257L;	private static final String TAG = "Ext.Toolbar.Separator";	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.tbseparator;		public ToolbarSeparator() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}