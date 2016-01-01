package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.Hidden;

/**
 * A basic hidden field for storing hidden values in forms that need to be passed in the form 
 * submit.
 * 
 * @author Umut Gokbayrak
 */
public class HiddenTag extends FieldTag {
	private static final long serialVersionUID = 7342386934705944085L;

	@Override
	public int doEndTag() throws JspException {
		Hidden obj = new Hidden();
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
	protected void prepareConfig(Hidden obj) {
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}
}
