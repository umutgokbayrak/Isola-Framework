package isola.model.ext.menu;import isola.helpers.JsHelper;/** *  * A menu containing a Ext.menu.DateItem component (which provides a date * picker). *  *  *  * @author Umut Gokbayrak */public class DateMenu extends Menu {	private static final long serialVersionUID = -4019548066983808374L;	private static final String TAG = "Ext.menu.DateMenu";		public DateMenu() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}