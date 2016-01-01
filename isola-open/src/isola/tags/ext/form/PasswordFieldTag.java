package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.TextField;

/**
 * A textfield aimed for password input.
 * 
 * @author Umut Gokbayrak
 */
public class PasswordFieldTag extends TextFieldTag {
	private static final long serialVersionUID = -8791773840521130379L;

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
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(TextField obj) {
		setInputType("password");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}
}
