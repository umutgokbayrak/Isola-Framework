package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsObject;
import isola.model.ext.base.Observable;
import isola.model.ext.form.FieldSet;
import isola.tags.ext.container.PanelTag;


/**
 * Standard container used for grouping form fields.
 * 
 * @author Umut Gokbayrak
 */
public class FieldSetTag extends PanelTag {
	private static final long serialVersionUID = -392316906398902141L;

	public String baseCls;
	public String checkboxName;
	public String checkboxToggle;
	public String itemCls;
	public String labelWidth;
	
	@Override
	public int doEndTag() throws JspException {
		FieldSet obj = new FieldSet();
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
		baseCls = checkboxName = itemCls = null;
		checkboxToggle = "false";
		labelWidth = "0";
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(FieldSet obj) {
		if (getBorder() == null) {
			setBorder("true");
		}
		JsObject margins = new JsObject();
		margins.put("right", 10);
		margins.put("bottom", 5);
		obj.put("margins", margins);
		
		super.prepareConfig(obj);

		if (checkboxToggle != null) {
			try {
				obj.checkboxToggle = Boolean.valueOf(checkboxToggle);
			} catch (Exception e) {}
		}

		if (labelWidth != null) {
			try {
				obj.labelWidth = Integer.valueOf(labelWidth);
			} catch (Exception e) {}
		}

		obj.baseCls = baseCls;
		obj.checkboxName = checkboxName;
		obj.itemCls = itemCls;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * The base CSS class applied to the fieldset (defaults to 'x-fieldset').
	 */
	public void setBaseCls(String baseCls) {
		this.baseCls = baseCls;
	}

	/**
	 * The name to assign to the fieldset's checkbox if checkboxToggle = true (defaults to 
	 * '[checkbox id]-checkbox').
	 */
	public void setCheckboxName(String checkboxName) {
		this.checkboxName = checkboxName;
	}

	/**
	 * True to render a checkbox into the fieldset frame just in front of the legend, or a 
	 * DomHelper config object to create the checkbox. (defaults to false). The fieldset will 
	 * be expanded or collapsed when the checkbox is toggled.
	 */
	public void setCheckboxToggle(String checkboxToggle) {
		this.checkboxToggle = checkboxToggle;
	}

	/**
	 * A css class to apply to the x-form-item of fields. This property cascades to child containers.
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
	}

	/**
	 * The width of labels. This property cascades to child containers.
	 */
	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

}
