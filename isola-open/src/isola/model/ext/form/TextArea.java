package isola.model.ext.form;import isola.helpers.JsHelper;import isola.model.core.JsObject;import isola.model.ext.constants.XTypes;/** *  * Multiline text field. Can be used as a direct replacement for traditional * textarea *  * fields, plus adds support for auto-sizing. *  *  *  * @author Umut Gokbayrak */public class TextArea extends TextField {	private static final long serialVersionUID = 8670416142852623157L;	private static final String TAG = "Ext.form.TextArea";	/**	 * 	 * A DomHelper element spec, or true for a default element spec (defaults to	 * 	 * {tag: "textarea", style: "width:100px;height:60px;", autocomplete:	 * "off"})	 */	public JsObject autoCreate;	/**	 * 	 * The maximum height to allow when grow = true (defaults to 1000)	 */	public int growMax = 1000;	/**	 * 	 * The minimum height to allow when grow = true (defaults to 60)	 */	public int growMin = 60;	/**	 * 	 * True to prevent scrollbars from appearing regardless of how much text is	 * in the	 * 	 * field (equivalent to setting overflow: hidden, defaults to false)	 */	public boolean preventScrollbars = false;	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.textarea;		public TextArea() {		super();	}		protected void _postProcessToString() {		super._postProcessToString();		if (autoCreate != null)			put("autoCreate", autoCreate);		if (growMax != 1000)			put("growMax", growMax);		if (growMin != 60)			put("growMin", growMin);		if (preventScrollbars)			put("preventScrollbars", preventScrollbars);		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}