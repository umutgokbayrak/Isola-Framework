package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.CheckBox;


/**
 * 
 * @author Umut Gokbayrak
 */
public class CheckBoxTag extends FieldTag {
	private static final long serialVersionUID = 6736619540633052706L;

	private String boxLabel;
	private String checked;
	private String fieldClass;
	private String focusClass;
	private String inputValue;

	private String onCheck;

	@Override
	public int doEndTag() throws JspException {
		CheckBox obj = new CheckBox();
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
		boxLabel = null;
		checked = "false";
		fieldClass = focusClass = inputValue = onCheck = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(CheckBox obj) {
		super.prepareConfig(obj);

		obj.boxLabel = boxLabel;

		if (checked != null) {
			try {
				obj.checked = Boolean.valueOf(checked);
			} catch (Exception e) {}
		}

		obj.fieldClass = fieldClass;
		obj.focusClass = focusClass;
		obj.inputValue = inputValue;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onCheck != null) {
			obj.listeners.put("check", new JsFunction(onCheck));
		}
	}

	/**
	 * The text that appears beside the checkbox
	 */
	public void setBoxLabel(String boxLabel) {
		this.boxLabel = boxLabel;
	}

	/**
	 * True if the the checkbox should render already checked (defaults to false)
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 * The default CSS class for the checkbox (defaults to "x-form-field")
	 */
	public void setFieldClass(String fieldClass) {
		this.fieldClass = fieldClass;
	}

	/**
	 * The CSS class to use when the checkbox receives focus (defaults to undefined)
	 */
	public void setFocusClass(String focusClass) {
		this.focusClass = focusClass;
	}

	/**
	 * The value that should go into the generated input element's value attribute
	 */
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	/**
	 * <p>Fires when the checkbox is checked or unchecked. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>:(Ext.form.Checkbox) This checkbox</li>
	 * <li><strong>checked</strong>:(Boolean) The new checked value</li>
	 * </ul>
	 * @param onCheck
	 */
	public void setOnCheck(String onCheck) {
		this.onCheck = onCheck;
	}

}
