package isola.tags.ext.form;

import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.TimeField;

/**
 * Provides a time input field with a time dropdown and automatic time validation.
 * 
 * @author Umut Gokbayrak
 */
public class TimeFieldTag extends ComboBoxTag {
	private static final long serialVersionUID = -422219759515367284L;

	private String altFormats;
	private String format;
	private String increment;
	private String invalidText;
	private String maxText;
	private String maxValue;
	private String minText;
	private String minValue;

	@Override
	public int doEndTag() throws JspException {
		TimeField obj = new TimeField();
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
		altFormats = format = null;
		increment = "15";
		invalidText = maxText = null;
		maxValue = minText = minValue = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(TimeField obj) {
		setEditable("false");
		super.prepareConfig(obj);

		obj.altFormats = altFormats;

		if (format == null) {
			obj.format = "d/m/Y G:i";
		} else {
			obj.format = format;
		}

		if (increment != null) {
			try {
				obj.increment = Integer.valueOf(increment);
			} catch (Exception e) {}
		}

		obj.invalidText = invalidText;
		obj.maxText = maxText;

		if (maxValue != null) {
			StringTokenizer st = new StringTokenizer(maxValue, "/");
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				String hour = null;
				String minute = null;
				if (year.indexOf(" ") > 0) {
					String hm = year.substring(year.indexOf(" ") + 1);
					year = year.substring(0, year.indexOf(" "));
					hour = hm.substring(0, hm.indexOf(":"));
					minute = hm.substring(hm.indexOf(":") + 1);
				}
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				if (hour != null) {
					cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
				}
				if (minute != null) {
					cal.set(Calendar.MINUTE, Integer.parseInt(minute));
				}
				obj.maxValue = cal.getTime();
			} catch (Exception e) {}
		}

		obj.minText = minText;
		
		if (minValue != null) {
			StringTokenizer st = new StringTokenizer(minValue, "/");
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				String hour = null;
				String minute = null;
				if (year.indexOf(" ") > 0) {
					String hm = year.substring(year.indexOf(" ") + 1);
					year = year.substring(0, year.indexOf(" "));
					hour = hm.substring(0, hm.indexOf(":"));
					minute = hm.substring(hm.indexOf(":") + 1);
				}
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				if (hour != null) {
					cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
				}
				if (minute != null) {
					cal.set(Calendar.MINUTE, Integer.parseInt(minute));
				}
				obj.minValue = cal.getTime();
			} catch (Exception e) {}
		}

	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * Multiple date formats separated by "|" to try when parsing a user input value 
	 * and it doesn't match the defined format (defaults to 'm/d/Y|m-d-y|m-d-Y|m/d|m-d|d').
	 */
	public void setAltFormats(String altFormats) {
		this.altFormats = altFormats;
	}

	/**
	 * The default date format string which can be overriden for localization support. 
	 * The format must be valid according to Date.parseDate (defaults to 'm/d/y').
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * The number of minutes between each time value in the list (defaults to 15).
	 */
	public void setIncrement(String increment) {
		this.increment = increment;
	}

	/**
	 * The error text to display when the time in the field is invalid (defaults to 
	 * '{value} is not a valid time - it must be in the format {format}').
	 */
	public void setInvalidText(String invalidText) {
		this.invalidText = invalidText;
	}

	/**
	 * The error text to display when the time is after maxValue (defaults to 'The time 
	 * in this field must be equal to or before {0}').
	 */
	public void setMaxText(String maxText) {
		this.maxText = maxText;
	}

	/**
	 * The maximum allowed time. Must be in format d/m/Y
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * The error text to display when the date in the cell is before minValue (defaults to 
	 * 'The time in this field must be equal to or after {0}').
	 */
	public void setMinText(String minText) {
		this.minText = minText;
	}

	/**
	 * The minimum allowed time. Can be either a Javascript date object or a string date 
	 * in a valid format (defaults to null).
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

}
