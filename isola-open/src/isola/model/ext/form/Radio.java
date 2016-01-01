package isola.model.ext.form;import isola.helpers.JsHelper;import isola.model.ext.constants.XTypes;/** *  * Single radio field. Same as CheckBox, but provided as a convenience for * automatically *  * setting the input type. Radio grouping is handled automatically by the * browser if you *  * give each radio in a group the same name. *  *  *  * @author Umut Gokbayrak */public class Radio extends CheckBox {	private static final long serialVersionUID = 2956772375823536305L;	private static final String TAG = "Ext.form.Radio";	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.radio;		public Radio() {		super();	}		protected void _postProcessToString() {		super._postProcessToString();		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}