package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.TextArea;

/**
 * Multiline text field. Can be used as a direct replacement for traditional textarea 
 * fields, plus adds support for auto-sizing.
 * 
 * @author Umut Gokbayrak
 */
public class TextAreaTag extends TextFieldTag {
	private static final long serialVersionUID = -8668242477768894000L;

	private String growMax;
	private String growMin;
	private String preventScrollbars;

	@Override
	public int doEndTag() throws JspException {
		TextArea obj = new TextArea();
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
		growMax = "1000";
		growMin = "60";
		preventScrollbars = "false";
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(TextArea obj) {
		if (getId() == null) {
			setId(getName());
		}
		super.prepareConfig(obj);

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

		if (preventScrollbars != null) {
			try {
				obj.preventScrollbars = Boolean.valueOf(preventScrollbars);
			} catch (Exception e) {}
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * The maximum height to allow when grow = true (defaults to 1000)
	 */
	public void setGrowMax(String growMax) {
		this.growMax = growMax;
	}

	/**
	 * The minimum height to allow when grow = true (defaults to 60)
	 */
	public void setGrowMin(String growMin) {
		this.growMin = growMin;
	}

	/**
	 * True to prevent scrollbars from appearing regardless of how much text is in the 
	 * field (equivalent to setting overflow: hidden, defaults to false)
	 */
	public void setPreventScrollbars(String preventScrollbars) {
		this.preventScrollbars = preventScrollbars;
	}

}
