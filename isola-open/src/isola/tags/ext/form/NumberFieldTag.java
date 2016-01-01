package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.NumberField;

/**
 * Numeric text field that provides automatic keystroke filtering and numeric validation.
 * 
 * @author Umut Gokbayrak
 */
public class NumberFieldTag extends TextFieldTag {
	private static final long serialVersionUID = 4154350509875444634L;

	private String allowDecimals;
	private String allowNegative;
	private String baseChars;
	private String decimalPrecision;
	private String decimalSeparator;
	private String fieldClass;
	private String maxText;
	private String maxValue;
	private String minText;
	private String minValue;
	private String nanText;

	@Override
	public int doEndTag() throws JspException {
		NumberField obj = new NumberField();
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
		allowDecimals = allowNegative = "true";
		baseChars = null;
		decimalPrecision = "2";
		decimalSeparator = fieldClass = maxText = null;
		maxValue = "0";
		minText = null;
		minValue = "0";
		nanText = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(NumberField obj) {
		super.prepareConfig(obj);

		if (allowDecimals != null) {
			try {
				obj.allowDecimals = Boolean.valueOf(allowDecimals);
			} catch (Exception e) {}
		}

		if (allowNegative != null) {
			try {
				obj.allowNegative = Boolean.valueOf(allowNegative);
			} catch (Exception e) {}
		}

		obj.baseChars = baseChars;
		
		if (decimalPrecision != null) {
			try {
				obj.decimalPrecision = Integer.valueOf(decimalPrecision);
			} catch (Exception e) {}
		}
		
		obj.decimalSeparator = decimalSeparator;
		obj.fieldClass = fieldClass;
		obj.maxText = maxText;

		if (maxValue != null) {
			try {
				obj.maxValue = Integer.valueOf(maxValue);
			} catch (Exception e) {}
		}

		obj.minText = minText;

		if (minValue != null) {
			try {
				obj.minValue = Integer.valueOf(minValue);
			} catch (Exception e) {}
		}

		obj.nanText = nanText;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * False to disallow decimal values (defaults to true)
	 */
	public void setAllowDecimals(String allowDecimals) {
		this.allowDecimals = allowDecimals;
	}

	/**
	 * False to prevent entering a negative sign (defaults to true)
	 */
	public void setAllowNegative(String allowNegative) {
		this.allowNegative = allowNegative;
	}

	/**
	 * The base set of characters to evaluate as valid numbers (defaults to '0123456789').
	 */
	public void setBaseChars(String baseChars) {
		this.baseChars = baseChars;
	}

	/**
	 * The maximum precision to display after the decimal separator (defaults to 2)
	 */
	public void setDecimalPrecision(String decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	/**
	 * Character(s) to allow as the decimal separator (defaults to '.')
	 */
	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	/**
	 * The default CSS class for the field (defaults to "x-form-field x-form-num-field")
	 */
	public void setFieldClass(String fieldClass) {
		this.fieldClass = fieldClass;
	}

	/**
	 * Error text to display if the maximum value validation fails (defaults to "The maximum value 
	 * for this field is {maxValue}")
	 */
	public void setMaxText(String maxText) {
		this.maxText = maxText;
	}

	/**
	 * The maximum allowed value (defaults to Number.MAX_VALUE)
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * Error text to display if the minimum value validation fails (defaults to "The 
	 * minimum value for this field is {minValue}")
	 */
	public void setMinText(String minText) {
		this.minText = minText;
	}

	/**
	 * The minimum allowed value (defaults to Number.NEGATIVE_INFINITY)
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	/**
	 * Error text to display if the value is not a valid number. For example, this can 
	 * happen if a valid character like '.' or '-' is left in the field with no number 
	 * (defaults to "{value} is not a valid number")
	 */
	public void setNanText(String nanText) {
		this.nanText = nanText;
	}
}
