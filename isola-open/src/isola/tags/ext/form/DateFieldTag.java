package isola.tags.ext.form;

import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import isola.model.core.JsArray;
import isola.model.ext.base.Observable;
import isola.model.ext.form.DateField;


/**
 * 
 * Provides a date input field with a Ext.DatePicker dropdown and automatic date validation.
 * 
 * <code><pre>
 * 	&lt;ext:formPanel url="deneme.jsp" id="myForm" renderTo="form-ct" width="400" bodyStyle="background-color:#EEEEEE;" border="false"&gt;
 *	  	&lt;ext:dateField name="dateField" minValue="01/03/2008" maxValue="15/03/2008" fieldLabel="Select Date"/&gt;
 *		&lt;ext:button type="submit" text="Go!" /&gt;
 *	&lt;/ext:formPanel&gt;
 * </pre></code>
 * 
 * @author Umut Gokbayrak
 */
public class DateFieldTag extends TriggerFieldTag {
	private static final long serialVersionUID = 6740694735908425464L;
	private String altFormats;
	private String disabledDates;
	private String disabledDatesText;
	private String disabledDays;
	private String disabledDaysText;
	private String format;
	private String invalidText;
	private String maxText;
	private String maxValue;
	private String minText;
	private String minValue;

	@Override
	public int doEndTag() throws JspException {
		DateField obj = new DateField();
		prepareConfig(obj);

		// manage listeners
		prepareEvents(obj);

		// print the output
		printOut(obj);

		return EVAL_PAGE;
	}

	@Override
	public void clear() {
		super.clear();
		altFormats = null;
		disabledDates = null;
		disabledDatesText = null;
		disabledDays = null;
		disabledDaysText = format = invalidText = maxText = null;
		maxValue = null;
		minText = null;
		minValue = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(DateField obj) {
		setFormat("d/m/Y");
		super.prepareConfig(obj);

		obj.altFormats = altFormats;
		
		if (disabledDates != null) {
			StringTokenizer st = new StringTokenizer(disabledDates, "|");
			JsArray tmp = new JsArray();
			while (st.hasMoreTokens()) {
				tmp.add(st.nextToken());
			}
			obj.disabledDates = tmp;
		}
		
		obj.disabledDatesText = disabledDatesText;
		
		if (disabledDays != null) {
			StringTokenizer st = new StringTokenizer(disabledDays, "|");
			JsArray tmp = new JsArray();
			while (st.hasMoreTokens()) {
				tmp.add(st.nextToken());
			}
			obj.disabledDays = tmp;
		}
		
		obj.disabledDaysText = disabledDaysText;

		if (format == null) {
			obj.format = "d/m/y";
		} else {
			obj.format = format;
		}

		obj.invalidText = invalidText;
		obj.maxText = maxText;
		
		if (maxValue != null) {
			String seperator = null;
			if (maxValue.indexOf("/") >= 0) {
				seperator = "/";
			} else if (maxValue.indexOf(".") >= 0) {
				seperator = ".";
			} else if (maxValue.indexOf("-") >= 0) {
				seperator = "-";
			}
			StringTokenizer st = new StringTokenizer(maxValue, seperator);
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				obj.maxValue = cal.getTime();
			} catch (Exception e) {}
		}
		obj.minText = minText;

		if (minValue != null) {
			String seperator = null;
			if (minValue.indexOf("/") >= 0) {
				seperator = "/";
			} else if (minValue.indexOf(".") >= 0) {
				seperator = ".";
			} else if (minValue.indexOf("-") >= 0) {
				seperator = "-";
			}
			StringTokenizer st = new StringTokenizer(minValue, seperator);
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				obj.minValue = cal.getTime();
			} catch (Exception e) {}
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * Multiple date formats separated by "|" to try when parsing a user input value and 
	 * it doesn't match the defined format (defaults to 'm/d/Y|m-d-y|m-d-Y|m/d|m-d|d').
	 */
	public void setAltFormats(String altFormats) {
		this.altFormats = altFormats;
	}

	/**
	 * <p>"dates" seperated by "|" to disable, as strings. These strings will be used to build a dynamic 
	 * regular expression so they are very powerful. Some examples:</p>
	 * ["03/08/2003", "09/16/2003"] would disable those exact dates<br/>
     * ["03/08", "09/16"] would disable those days for every year<br/>
     * ["^03/08"] would only match the beginning (useful if you are using short years)<br/>
     * ["03/../2006"] would disable every day in March 2006<br/>
     * ["^03"] would disable every day in every March<br/>
     * <p>In order to support regular expressions, if you are using a date format that has "." 
     * in it, you will have to escape the dot when restricting dates. 
     * For example: ["03\\.08\\.03"].</p>
	 */
	public void setDisabledDates(String disabledDates) {
		this.disabledDates = disabledDates;
	}

	/**
	 * The tooltip text to display when the date falls on a disabled date (defaults to 'Disabled')
	 */
	public void setDisabledDatesText(String disabledDatesText) {
		this.disabledDatesText = disabledDatesText;
	}

	/**
	 * An array of days to disable, 0 based. For example, [0, 6] disables Sunday and Saturday 
	 * (defaults to null).
	 */
	public void setDisabledDays(String disabledDays) {
		this.disabledDays = disabledDays;
	}

	/**
	 * The tooltip to display when the date falls on a disabled day (defaults to 'Disabled')
	 */
	public void setDisabledDaysText(String disabledDaysText) {
		this.disabledDaysText = disabledDaysText;
	}

	/**
	 * The default date format string which can be overriden for localization support. The format 
	 * must be valid according to Date.parseDate (defaults to 'd/m/Y').
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	
	/**
	 * The error text to display when the date in the field is invalid (defaults to '{value} 
	 * is not a valid date - it must be in the format {format}').
	 */
	public void setInvalidText(String invalidText) {
		this.invalidText = invalidText;
	}

	/**
	 * The error text to display when the date in the cell is after maxValue (defaults to 'The 
	 * date in this field must be before {maxValue}').
	 */
	public void setMaxText(String maxText) {
		this.maxText = maxText;
	}

	/**
	 * The maximum allowed date. This value must be in format d/m/Y.
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * The error text to display when the date in the cell is before minValue (defaults to 'The 
	 * date in this field must be after {minValue}').
	 */
	public void setMinText(String minText) {
		this.minText = minText;
	}

	/**
	 * The minimum allowed date. This value must be in format d/m/Y
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

}
