package isola.model.ext.menu;import isola.helpers.JsHelper;/** *  * Adds a menu item that contains a checkbox by default, but can also be part of * a radio group. *  *  *  * @author Umut Gokbayrak */public class CheckItem extends Item {	private static final long serialVersionUID = -2026065371598460631L;	private static final String TAG = "Ext.menu.CheckItem";	private boolean printWithNoTags = false;	/**	 * 	 * True to initialize this checkbox as checked (defaults to false). Note	 * that if this checkbox	 * 	 * is part of a radio group (group = true) only the last item in the group	 * that is initialized	 * 	 * with checked = true will be rendered as checked.	 */	public boolean checked = false;	/**	 * 	 * All check items with the same group name will automatically be grouped	 * into a single-select	 * 	 * radio button group (defaults to '')	 */	public String group;	/**	 * 	 * The default CSS class to use for radio group check items (defaults to	 * "x-menu-group-item")	 */	public String groupClass;	/**	 * 	 * The default CSS class to use for check items (defaults to	 * "x-menu-item x-menu-check-item")	 */	public String itemCls;		/**
	 * 
	 */	public CheckItem() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (checked)			put("checked", checked);		if (group != null)			put("group", group);		if (groupClass != null)			put("groupClass", groupClass);		if (itemCls != null)			put("itemCls", itemCls);	}		@Override	public String toString() {		_postProcessToString();		if (printWithNoTags) {			return JsHelper.printJsObject(this);		}		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}		public void setPrintWithNoTags(boolean printWithNoTags) {		this.printWithNoTags = printWithNoTags;	}}