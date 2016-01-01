package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsArray;
import isola.model.ext.base.Observable;
import isola.model.ext.form.RadioGroup;

/**
 * Extjs Extension to generate structured radio groups.
 * 
 * @author Umut Gokbayrak
 *
 */
public class RadioGroupTag extends FieldTag {
	private static final long serialVersionUID = 9149676601950742502L;

	private String checked;
	
	private JsArray radios;

	private String horizontal;
	
	@Override
	public int doEndTag() throws JspException {
		RadioGroup obj = new RadioGroup();
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
		checked = "false";
		horizontal = "false";
		radios = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(RadioGroup obj) {
		super.prepareConfig(obj);
		
		if (checked != null) {
			try {
				obj.checked = Boolean.valueOf(checked);
			} catch (Exception e) {}
		}
		
		if (horizontal != null) {
			try {
				obj.horizontal = Boolean.valueOf(horizontal);
			} catch (Exception e) {}
		}
		
		if (radios != null && radios.size() > 0) {
			obj.radios = radios;
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * True if the the checkbox should render already checked (defaults to false)
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}

	public JsArray getRadios() {
		if (radios == null) {
			radios = new JsArray();
		}
		return radios;
	}

	public void setRadios(JsArray radios) {
		this.radios = radios;
	}

	/**
	 * If set to true radio group will group radio buttons horizantally
	 */
	public void setHorizontal(String horizontal) {
		this.horizontal = horizontal;
	}
}
