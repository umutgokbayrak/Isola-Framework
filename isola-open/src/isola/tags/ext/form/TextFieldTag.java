package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.core.JsRegExp;
import isola.model.ext.base.Observable;
import isola.model.ext.constants.VTypes;
import isola.model.ext.form.TextField;


/**
 * Basic text field. Can be used as a direct replacement for traditional text inputs, 
 * or as the base class for more sophisticated input controls (like Ext.form.TextArea 
 * and Ext.form.ComboBox).
 * 
 * @author Umut Gokbayrak
 */
public class TextFieldTag extends FieldTag {
	private static final long serialVersionUID = -1192491707510158642L;

	private String allowBlank;
	private String blankText;
	private String disableKeyFilter;
	private String emptyClass;
	private String emptyText;
	private String grow;
	private String growMax;
	private String growMin;
	private String maxLength;
	private String maxLengthText;
	private String minLength;
	private String minLengthText;
	private String regexText;
	private String selectOnFocus;
	private String vtype;
	private String vtypeText;
	private String regex;
	private String validator;
	private String onAutoSize;
	private String onKeyDown;
	private String onKeyPress;
	private String onKeyUp;

	@Override
	public int doEndTag() throws JspException {
		TextField obj = new TextField();
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
		allowBlank = "true";
		blankText = null;
		disableKeyFilter = "false";
		emptyClass = emptyText = null;
		grow = "false";
		growMax = "800";
		growMin = "30";
		maxLength = "0";
		maxLengthText = null;
		minLength = "0";
		minLengthText = regexText = null;
		selectOnFocus = "false";
		vtype = vtypeText = null;
		regex = null;
		validator = null;
		onAutoSize = onKeyPress = onKeyDown = onKeyUp = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(TextField obj) {
		super.prepareConfig(obj);

		if (allowBlank != null) {
			try {
				obj.allowBlank = Boolean.valueOf(allowBlank);
			} catch (Exception e) {}
		}

		obj.blankText = blankText;

		if (disableKeyFilter != null) {
			try {
				obj.disableKeyFilter = Boolean.valueOf(disableKeyFilter);
			} catch (Exception e) {}
		}

		obj.emptyClass = emptyClass;
		obj.emptyText = emptyText;
		
		if (grow != null) {
			try {
				obj.grow = Boolean.valueOf(grow);;
			} catch (Exception e) {}
		}

		if (growMax != null) {
			try {
				obj.growMax = Integer.valueOf(growMax);
			} catch (Exception e) {}
		}

		if (growMin != null) {
			try {
				obj.growMin = Integer.valueOf(growMin);
			} catch (Exception e) {}
		}

		if (maxLength != null) {
			try {
				obj.maxLength = Integer.valueOf(maxLength);
			} catch (Exception e) {}
		}

		obj.maxLengthText = maxLengthText;

		if (minLength != null) {
			try {
				obj.minLength = Integer.valueOf(minLength);
			} catch (Exception e) {}
		}

		obj.minLengthText = minLengthText;
		obj.regexText = regexText;
		
		if (selectOnFocus != null) {
			try {
				obj.selectOnFocus = Boolean.valueOf(selectOnFocus);
			} catch (Exception e) {}
		}
		
		obj.vtype = vtype;
		obj.vtypeText = vtypeText;
		if (regex != null) {
			obj.regex = new JsRegExp(regex);
		}
		if (validator != null) {
			obj.validator = new JsFunction(validator);
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onAutoSize != null) {
			obj.listeners.put("autosize", new JsFunction(onAutoSize));
		}

		if (onKeyUp != null) {
			obj.listeners.put("keyup", new JsFunction(onKeyUp));
		}

		if (onKeyPress != null) {
			obj.listeners.put("keypress", new JsFunction(onKeyPress));
		}

		if (onKeyDown != null) {
			obj.listeners.put("keydown", new JsFunction(onKeyDown));
		}
	}

	/**
	 * False to validate that the value length > 0 (defaults to true)
	 */
	public void setAllowBlank(String allowBlank) {
		this.allowBlank = allowBlank;
	}

	/**
	 * Error text to display if the allow blank validation fails (defaults to "This field is 
	 * required")
	 */
	public void setBlankText(String blankText) {
		this.blankText = blankText;
	}

	/**
	 * True to disable input keystroke filtering (defaults to false)
	 */
	public void setDisableKeyFilter(String disableKeyFilter) {
		this.disableKeyFilter = disableKeyFilter;
	}

	/**
	 * The CSS class to apply to an empty field to style the emptyText (defaults to 
	 * 'x-form-empty-field'). This class is automatically added and removed as needed depending on 
	 * the current field value.
	 */
	public void setEmptyClass(String emptyClass) {
		this.emptyClass = emptyClass;
	}

	/**
	 * The default text to display in an empty field (defaults to null).
	 */
	public void setEmptyText(String emptyText) {
		this.emptyText = emptyText;
	}

	/**
	 * True if this field should automatically grow and shrink to its content
	 */
	public void setGrow(String grow) {
		this.grow = grow;
	}

	/**
	 * The maximum width to allow when grow = true (defaults to 800)
	 */
	public void setGrowMax(String growMax) {
		this.growMax = growMax;
	}

	/**
	 * The minimum width to allow when grow = true (defaults to 30)
	 */
	public void setGrowMin(String growMin) {
		this.growMin = growMin;
	}

	/**
	 * Maximum input field length allowed (defaults to Number.MAX_VALUE)
	 */
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * Error text to display if the maximum length validation fails (defaults to 
	 * "The maximum length for this field is {maxLength}")
	 */
	public void setMaxLengthText(String maxLengthText) {
		this.maxLengthText = maxLengthText;
	}

	/**
	 * Minimum input field length required (defaults to 0)
	 */
	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}

	/**
	 * Error text to display if the minimum length validation fails (defaults to 
	 * "The minimum length for this field is {minLength}")
	 */
	public void setMinLengthText(String minLengthText) {
		this.minLengthText = minLengthText;
	}

	/**
	 * The error text to display if regex is used and the test fails during validation (defaults to "")
	 */
	public void setRegexText(String regexText) {
		this.regexText = regexText;
	}

	/**
	 * True to automatically select any existing field text when the field receives input 
	 * focus (defaults to false)
	 */
	public void setSelectOnFocus(String selectOnFocus) {
		this.selectOnFocus = selectOnFocus;
	}

	/**
	 * A validation type name as defined in Ext.form.VTypes (defaults to null)
	 */
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	/**
	 * A custom error message to display in place of the default message provided for the 
	 * vtype currently set for this field (defaults to ''). Only applies if vtype is set, 
	 * else ignored.
	 * @see VTypes
	 */
	public void setVtypeText(String vtypeText) {
		this.vtypeText = vtypeText;
	}

	/**
	 * A JavaScript RegExp object to be tested against the field value during validation 
	 * (defaults to null). If available, this regex will be evaluated only after the basic 
	 * validators all return true, and will be passed the current field value. If the test 
	 * fails, the field will be marked invalid using regexText.
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/**
	 * A custom validation function to be called during field validation (defaults to null). 
	 * If available, this function will be called only after the basic validators all return 
	 * true, and will be passed the current field value and expected to return boolean true 
	 * if the value is valid or a string error message if invalid.
	 */
	public void setValidator(String validator) {
		this.validator = validator;
	}

	/**
	 * <p>Fires when the autosize function is triggered. The field may or may not have actually
	 *  changed size according to the default logic, but this event provides a hook for the 
	 *  developer to apply additional logic at runtime to resize the field if needed. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : (Ext.form.Field) This text field</li>
	 * <li><strong>width</strong> : (Number) The new field width</li>
     * </ul>
	 * @param onAutoSize
	 */
	public void setOnAutoSize(String onAutoSize) {
		this.onAutoSize = onAutoSize;
	}

	public void setOnKeyDown(String onKeyDown) {
		this.onKeyDown = onKeyDown;
	}

	public void setOnKeyPress(String onKeyPress) {
		this.onKeyPress = onKeyPress;
	}

	public void setOnKeyUp(String onKeyUp) {
		this.onKeyUp = onKeyUp;
	}
	
}