package isola.tags.ext.form;

import isola.model.ext.base.Observable;
import isola.model.ext.form.DateTime;

import javax.servlet.jsp.JspException;

public class DateTimeFieldTag extends FieldTag {
	private static final long serialVersionUID = -5402789924693149641L;

	/**
	 * Width of time field in pixels (defaults to 100)
	 */
	private String timeWidth = "100";
	
	/**
	 * Date - Time separator. Used to split date and time (defaults to ' ' (space))
	 */
	private String dtSeparator;
	
	/**
	 * Format of datetime used to store value in hidden field
     * and submitted to server (defaults to 'Y-m-d H:i:s' that is mysql format)
	 */
	private String hiddenFormat;
	
	/**
	 * Where the time field should be rendered. 'right' is suitable for forms
     * and 'below' is suitable if the field is used as the grid editor (defaults to 'right')
     * 
     * Valid values: below and right
	 */
	private String timePosition;
	
	/**
	 * Format of DateField. Can be localized. (defaults to 'm/y/d')
	 */
	private String dateFormat;
	
	/**
	 * Format of TimeField. Can be localized. (defaults to 'H:i:s')
	 */
	private String timeFormat = "H:i";
	
	
	private String allowBlank = "true";

	@Override
	public int doEndTag() throws JspException {
		DateTime obj = new DateTime();

		prepareConfig(obj);
		prepareEvents(obj);
		printOut(obj);
		return EVAL_PAGE;
	}

	@Override
	public void clear() {
		super.clear();
		timeWidth = "100";
		dtSeparator = hiddenFormat = timePosition = dateFormat = timeFormat = null;
	}

	protected void prepareConfig(DateTime obj) {
		super.prepareConfig(obj);
		
		if (timeWidth != null) {
			try {
				obj.timeWidth = Integer.valueOf(timeWidth);
			} catch (Exception e) {}
		}
		
		obj.dtSeparator = dtSeparator;
		obj.hiddenFormat = hiddenFormat;
		obj.timePosition = timePosition;
		obj.dateFormat = dateFormat;
		obj.timeFormat = timeFormat;
		
		if (allowBlank != null) {
			try {
				obj.allowBlank = Boolean.valueOf(allowBlank);
			} catch (Exception e) {}
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	public String getTimeWidth() {
		return timeWidth;
	}

	public void setTimeWidth(String timeWidth) {
		this.timeWidth = timeWidth;
	}

	public String getDtSeparator() {
		return dtSeparator;
	}

	public void setDtSeparator(String dtSeparator) {
		this.dtSeparator = dtSeparator;
	}

	public String getHiddenFormat() {
		return hiddenFormat;
	}

	public void setHiddenFormat(String hiddenFormat) {
		this.hiddenFormat = hiddenFormat;
	}

	public String getTimePosition() {
		return timePosition;
	}

	public void setTimePosition(String timePosition) {
		this.timePosition = timePosition;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getAllowBlank() {
		return allowBlank;
	}

	public void setAllowBlank(String allowBlank) {
		this.allowBlank = allowBlank;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
