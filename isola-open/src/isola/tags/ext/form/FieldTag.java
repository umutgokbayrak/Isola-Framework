package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.Field;
import isola.tags.ext.container.BoxComponentTag;


/**
 * Base class for form fields that provides default event handling, sizing, value handling 
 * and other functionality.
 * 
 * @author Umut Gokbayrak
 */
public class FieldTag extends BoxComponentTag {
	private static final long serialVersionUID = 7809214295061751145L;

	private String clearCls;
	private String disabled;
	private String fieldClass;
	private String fieldLabel;
	private String focusClass;
	private String hideLabel;
	private String inputType;
	private String invalidClass;
	private String invalidText;
	private String itemCls;
	private String labelSeparator;
	private String labelStyle;
	private String msgFx;
	private String msgTarget;
	private String name;
	private String readOnly;
	private String tabIndex;
	private String validateOnBlur;
	private String validationDelay;
	private String validationEvent;
	private String value;

	private String onBlur;
	private String onChange;
	private String onFocus;
	private String onInvalid;
	private String onSpecialKey;
	private String onValid;
	
	@Override
	public int doEndTag() throws JspException {
		Field obj = new Field();
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

		clearCls = null;
		disabled = "false";
		fieldClass = fieldLabel = focusClass = null;
		hideLabel = "false";
		inputType = invalidClass = invalidText = itemCls = labelSeparator = null;
		labelStyle = msgFx = msgTarget = name = readOnly = null;
		tabIndex = "0";
		validateOnBlur = "true";
		validationDelay = "250";
		validationEvent = value = null;
		onBlur = onChange = onFocus = onInvalid = onSpecialKey = onValid = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Field obj) {
		super.prepareConfig(obj);
		obj.enableKeyEvents = true;
		
		obj.clearCls = clearCls;
		
		if (disabled != null) {
			try {
				obj.disabled = Boolean.valueOf(disabled);
			} catch (Exception e) {}
		}
		
		obj.fieldClass = fieldClass;
		obj.fieldLabel = fieldLabel;
		obj.focusClass = focusClass;

		if (hideLabel != null) {
			try {
				obj.hideLabel = Boolean.valueOf(hideLabel);
			} catch (Exception e) {}
		}

		obj.inputType = inputType;
		obj.invalidClass = invalidClass;
		obj.invalidText = invalidText;
		obj.itemCls = itemCls;
		obj.labelSeparator = labelSeparator;
		obj.labelStyle = labelStyle;
		obj.msgFx = msgFx;
		obj.msgTarget = msgTarget;
		obj.name = name;

		if (readOnly != null) {
			try {
				obj.readOnly = Boolean.valueOf(readOnly);
			} catch (Exception e) {}
		}

		if (tabIndex != null) {
			try {
				obj.tabIndex = Integer.parseInt(tabIndex);
			} catch (Exception e) {}
		}

		if (validateOnBlur != null) {
			try {
				obj.validateOnBlur = Boolean.valueOf(validateOnBlur);
			} catch (Exception e) {}
		}
		
		obj.validationEvent = validationEvent;

		if (validationDelay != null) {			try {				obj.validationDelay = Integer.parseInt(validationDelay);			} catch (Exception e) {}		}		if (value != null) {			obj.value = "" + value;		} else {			obj.value = null;		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onBlur != null) {
			obj.listeners.put("blur", new JsFunction(onBlur));
		}

		if (onChange != null) {
			obj.listeners.put("change", new JsFunction(onChange));
		}

		if (onFocus != null) {
			obj.listeners.put("focus", new JsFunction(onFocus));
		}

		if (onInvalid != null) {
			obj.listeners.put("invalid", new JsFunction(onInvalid));
		}

		if (onSpecialKey != null) {
			obj.listeners.put("specialkey", new JsFunction(onSpecialKey));
		}

		if (onValid != null) {
			obj.listeners.put("valid", new JsFunction(onValid));
		}
	}

	/**
	 * The CSS class used to provide field clearing (defaults to 'x-form-clear-left')
	 */
	public void setClearCls(String clearCls) {
		this.clearCls = clearCls;
	}

	/**
	 * True to disable the field (defaults to false).
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * The default CSS class for the field (defaults to "x-form-field")
	 */
	public void setFieldClass(String fieldClass) {
		this.fieldClass = fieldClass;
	}

	/**
	 * The label text to display next to this field (defaults to '')
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	/**
	 * The CSS class to use when the field receives focus (defaults to "x-form-focus")
	 */
	public void setFocusClass(String focusClass) {
		this.focusClass = focusClass;
	}

	/**
	 * True to completely hide the label element (defaults to false)
	 */
	public void setHideLabel(String hideLabel) {
		this.hideLabel = hideLabel;
	}

	/**
	 * The type attribute for input fields -- e.g. radio, text, password (defaults to "text").
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	/**
	 * The CSS class to use when marking a field invalid (defaults to "x-form-invalid")
	 */
	public void setInvalidClass(String invalidClass) {
		this.invalidClass = invalidClass;
	}

	/**
	 * The error text to use when marking a field invalid and no message is provided 
	 * (defaults to "The value in this field is invalid")
	 */
	public void setInvalidText(String invalidText) {
		this.invalidText = invalidText;
	}

	/**
	 * <p>An additional CSS class to apply to the wrapper element of this field (defaults 
	 * to the container's itemCls value if set, or ''). Since it is applied to the 
	 * wrapper, it allows you to write standard CSS rules that can apply to the field, 
	 * the label (if specified) or any other element within the markup for the field. 
	 * Example use:</p>
	 * 
	 * <pre><code>
	 * // Apply a style to the field's label:
	 * &lt;style&gt;
	 *     .required .x-form-item-label {font-weight:bold;color:red;}
	 * &lt;/style&gt;
	 * 
	 * new Ext.FormPanel({
	 * 	height: 100,
	 * 	renderTo: document.body,
	 * 	items: [{
	 * 		xtype: 'textfield',
	 * 		fieldLabel: 'Name',
	 * 		itemCls: 'required' //this label will be styled
	 * 	},{
	 * 		xtype: 'textfield',
	 * 		fieldLabel: 'Favorite Color'
	 * 	}]
	 * });
	 * </code></pre>
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
	}

	/**
	 * The standard separator to display after the text of each form label (defaults to the 
	 * value of Ext.layout.FormLayout.labelSeparator, which is a colon ':' by default). 
	 * To display no separator for this field's label specify empty string ''.
	 */
	public void setLabelSeparator(String labelSeparator) {
		this.labelSeparator = labelSeparator;
	}

	/**
	 * A CSS style specification to apply directly to this field's label (defaults to the 
	 * container's labelStyle value if set, or ''). For example, labelStyle: 'font-weight:bold;'.
	 */
	public void setLabelStyle(String labelStyle) {
		this.labelStyle = labelStyle;
	}

	/**
	 * The effect used when displaying a validation message under the field (defaults to 'normal').
	 */
	public void setMsgFx(String msgFx) {
		this.msgFx = msgFx;
	}

	/**
	 * The location where error text should display. Should be one of the following values 
	 * (defaults to 'qtip'):
	 * <pre>
	 * Value         Description
	 * -----------   ----------------------------------------------------------------------
	 * qtip          Display a quick tip when the user hovers over the field
	 * title         Display a default browser title attribute popup
	 * under         Add a block div beneath the field containing the error text
	 * side          Add an error icon to the right of the field with a popup on hover
	 * [element id]  Add the error text directly to the innerHTML of the specified element
	 * </pre>
	 */
	public void setMsgTarget(String msgTarget) {
		this.msgTarget = msgTarget;
	}

	/**
	 * The field's HTML name attribute.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * True to mark the field as readOnly in HTML (defaults to false) -- Note: this only sets 
	 * the element's readOnly DOM attribute.
	 */
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * The tabIndex for this field. Note this only applies to fields that are rendered, not those 
	 * which are built via applyTo (defaults to undefined).
	 */
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	public void setValidateOnBlur(String validateOnBlur) {
		this.validateOnBlur = validateOnBlur;
	}

	/**
	 * The length of time in milliseconds after user input begins until validation is initiated 
	 * (defaults to 250)
	 */
	public void setValidationDelay(String validationDelay) {
		this.validationDelay = validationDelay;
	}

	/**
	 * The event that should initiate field validation. Set to false to disable automatic 
	 * validation (defaults to "keyup").
	 */
	public void setValidationEvent(String validationEvent) {
		this.validationEvent = validationEvent;
	}

	/**
	 * A value to initialize this field with.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * <p>Fires when this field loses input focus. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
     * </ul>
	 * @param onBlur
	 */
	public void setOnBlur(String onBlur) {
		this.onBlur = onBlur;
	}

	/**
	 * <p>Fires just before the field blurs if the field value has changed. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
     * <li><strong>newValue</strong> : (Mixed) The new value</li>
     * <li><strong>oldValue</strong> : (Mixed) The original value</li>
     * </ul>
	 * @param onChange
	 */
	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	/**
	 * <p>Fires when this field receives input focus. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
     * </ul>
	 * @param onFocus
	 */
	public void setOnFocus(String onFocus) {
		this.onFocus = onFocus;
	}

	/**
	 * <p>Fires after the field has been marked as invalid. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
	 * <li><strong>msg</strong> : (String) The validation message</li>
     * </ul>
	 * @param onInvalid
	 */
	public void setOnInvalid(String onInvalid) {
		this.onInvalid = onInvalid;
	}

	/**
	 * <p>Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can 
	 * check Ext.EventObject.getKey to determine which key was pressed. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
	 * <li><strong>e</strong> : (Ext.EventObject) The event object</li>
     * </ul>
	 * @param onSpecialKey
	 */
	public void setOnSpecialKey(String onSpecialKey) {
		this.onSpecialKey = onSpecialKey;
	}

	/**
	 * Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can check 
	 * Ext.EventObject.getKey to determine which key was pressed. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.Field</li>
     * </ul>
	 * @param onValid
	 */
	public void setOnValid(String onValid) {
		this.onValid = onValid;
	}

	public String getName() {
		return name;
	}
	
	
}
