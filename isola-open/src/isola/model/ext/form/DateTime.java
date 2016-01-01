package isola.model.ext.form;

import isola.helpers.JsHelper;
import isola.model.core.JsObject;
import isola.model.ext.constants.XTypes;

public class DateTime extends Field {
	private static final long serialVersionUID = 3502711389556934662L;
	private static final String TAG = "Ext.ux.form.DateTime";
	
	/**
	 * Width of time field in pixels (defaults to 100)
	 */
	public int timeWidth = 100;
	
	/**
	 * Date - Time separator. Used to split date and time (defaults to ' ' (space))
	 */
	public String dtSeparator;
	
	/**
	 * Format of datetime used to store value in hidden field
     * and submitted to server (defaults to 'Y-m-d H:i:s' that is mysql format)
	 */
	public String hiddenFormat;
	
	/**
	 * Where the time field should be rendered. 'right' is suitable for forms
     * and 'below' is suitable if the field is used as the grid editor (defaults to 'right')
     * 
     * Valid values: below and right
	 */
	public String timePosition;
	
	/**
	 * Format of DateField. Can be localized. (defaults to 'm/y/d')
	 */
	public String dateFormat;
	
	/**
	 * Format of TimeField. Can be localized. (defaults to 'g:i A')
	 */
	public String timeFormat;
	
	
	public String xtype = XTypes.datetime;
	
	
	public boolean allowBlank = true;

	public DateTime() {
		super();
	}
	
	protected void _postProcessToString() {
		super._postProcessToString();
		if (timeWidth != 100) {
			put("timeWidth", timeWidth);
		}
		
		if (dtSeparator != null) {
			put("dtSeparator", dtSeparator);
		}
		
		if (hiddenFormat != null) {
			put("hiddenFormat", hiddenFormat);
		}
		
		if (timePosition != null) {
			put("timePosition", timePosition);
		}

		if (dateFormat != null) {
			put("dateFormat", dateFormat);
		}

		if (timeFormat != null) {
			put("timeFormat", timeFormat);
		}

		if (!allowBlank) {
			JsObject timeConfig = new JsObject();
			timeConfig.put("allowBlank", false);
			JsObject dateConfig = new JsObject();
			dateConfig.put("allowBlank", false);
			put("timeConfig", timeConfig);
			put("dateConfig", dateConfig);
		}
		
		if (xtype != null)
			put("xtype", xtype);
	}
	
	@Override
	public String toString() {
		_postProcessToString();
		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";
	}
	
}
