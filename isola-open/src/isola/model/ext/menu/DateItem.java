package isola.model.ext.menu;import isola.helpers.JsHelper;/** *  * A menu item that wraps the Ext.DatePicker component. *  *  *  * @author Umut Gokbayrak */public class DateItem extends Adapter {	private static final long serialVersionUID = 5583164433649251911L;	private static final String TAG = "Ext.menu.DateItem";		public DateItem() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}