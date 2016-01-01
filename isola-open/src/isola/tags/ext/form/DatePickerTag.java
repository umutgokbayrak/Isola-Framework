package isola.tags.ext.form;

import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import isola.model.core.JsArray;
import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.DatePicker;
import isola.tags.ext.base.ComponentTag;


/**
 * 
 * @author Umut Gokbayrak
 */
public class DatePickerTag extends ComponentTag {
	private static final long serialVersionUID = 70036537249079636L;

	private String cancelText;
	private String constrainToViewport;
	private String disabledDatesText;
	private String format;
	private String maxText;
	private String minText;
	private String monthYearText;
	private String nextText;
	private String okText;
	private String prevText;
	private String startDay;
	private String todayText;
	private String todayTip;
	private String monthNames;
	private String dayNames;
	private String maxDate;
	private String minDate;

	private String onSelect;

	@Override
	public int doEndTag() throws JspException {
		DatePicker obj = new DatePicker();
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
		cancelText = null;
		constrainToViewport = "true";
		disabledDatesText = format = maxText = minText = monthYearText = null;
		nextText = okText = prevText = null;
		startDay = "1";
		todayText = todayTip = null;
		monthNames = null;
		dayNames = null;
		maxDate = null;
		minDate = null;
		onSelect = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(DatePicker obj) {
		super.prepareConfig(obj);

		obj.cancelText = cancelText;
		
		if (constrainToViewport != null) {
			try {
				obj.constrainToViewport = Boolean.valueOf(constrainToViewport);
			} catch (Exception e) {}
		}

		obj.disabledDatesText = disabledDatesText;

		if (format == null) {
			obj.format = "d/m/y";
		} else {
			obj.format = format;
		}
		
		obj.maxText = maxText;
		obj.minText = minText;
		obj.monthYearText = monthYearText;
		obj.nextText = nextText;
		obj.okText = okText;
		obj.prevText = prevText;

		if (startDay != null) {
			try {
				obj.startDay = Integer.valueOf(startDay);
			} catch (Exception e) {}
		}

		obj.todayText = todayText;
		obj.todayTip = todayTip;

		if (monthNames != null) {
			StringTokenizer st = new StringTokenizer(monthNames, "|");
			JsArray tmp = new JsArray();
			while (st.hasMoreTokens()) {
				tmp.add(st.nextToken());
			}
			obj.monthNames = tmp;
		}

		if (dayNames != null) {
			StringTokenizer st = new StringTokenizer(dayNames, "|");
			JsArray tmp = new JsArray();
			while (st.hasMoreTokens()) {
				tmp.add(st.nextToken());
			}
			obj.dayNames = tmp;
		}

		
		if (maxDate != null) {
			String seperator = null;
			if (maxDate.indexOf("/") >= 0) {
				seperator = "/";
			} else if (maxDate.indexOf(".") >= 0) {
				seperator = ".";
			} else if (maxDate.indexOf("-") >= 0) {
				seperator = "-";
			}
			StringTokenizer st = new StringTokenizer(maxDate, seperator);
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				obj.maxDate = cal.getTime();
			} catch (Exception e) {}
		}

		if (minDate != null) {
			String seperator = null;
			if (minDate.indexOf("/") >= 0) {
				seperator = "/";
			} else if (minDate.indexOf(".") >= 0) {
				seperator = ".";
			} else if (minDate.indexOf("-") >= 0) {
				seperator = "-";
			}
			StringTokenizer st = new StringTokenizer(minDate, seperator);
			try {
				String day = st.nextToken();
				String month = st.nextToken();
				String year = st.nextToken();
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(day));
				cal.set(Calendar.YEAR, Integer.parseInt(year));
				obj.minDate = cal.getTime();
			} catch (Exception e) {}
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onSelect != null) {
			obj.listeners.put("select", new JsFunction(onSelect));
		}
	}

	public void setCancelText(String cancelText) {
		this.cancelText = cancelText;
	}

	public void setConstrainToViewport(String constrainToViewport) {
		this.constrainToViewport = constrainToViewport;
	}

	public void setDisabledDatesText(String disabledDatesText) {
		this.disabledDatesText = disabledDatesText;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setMaxText(String maxText) {
		this.maxText = maxText;
	}

	public void setMinText(String minText) {
		this.minText = minText;
	}

	public void setMonthYearText(String monthYearText) {
		this.monthYearText = monthYearText;
	}

	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	public void setOkText(String okText) {
		this.okText = okText;
	}

	public void setPrevText(String prevText) {
		this.prevText = prevText;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setTodayText(String todayText) {
		this.todayText = todayText;
	}

	public void setTodayTip(String todayTip) {
		this.todayTip = todayTip;
	}

	public void setMonthNames(String monthNames) {
		this.monthNames = monthNames;
	}

	public void setDayNames(String dayNames) {
		this.dayNames = dayNames;
	}

	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	/**
	 * <p>Fires when a date is selected </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this </strong>:DatePicker </li>
	 * <li><strong>date </strong>:(Date) The selected date</li>
	 * </ul>
	 * @param onSelect
	 */
	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}

}
