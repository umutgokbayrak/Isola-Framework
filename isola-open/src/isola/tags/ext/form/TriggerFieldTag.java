package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.TriggerField;


/**
 * <p>Provides a convenient wrapper for TextFields that adds a clickable trigger button 
 * (looks like a combobox by default). The trigger has no default action, so you must 
 * assign a function to implement the trigger click handler by overriding onTriggerClick. 
 * You can create a TriggerField directly, as it renders exactly like a combobox for 
 * which you can provide a custom implementation.</p>
 * 
 * @author Umut Gokbayrak
 */
public class TriggerFieldTag extends TextFieldTag {
	private static final long serialVersionUID = 2934395227437669301L;

	private String hideTrigger;
	private String triggerClass;
	
	@Override
	public int doEndTag() throws JspException {
		TriggerField obj = new TriggerField();
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
		hideTrigger = "false";
		triggerClass = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(TriggerField obj) {
		super.prepareConfig(obj);

		if (hideTrigger != null) {
			try {
				obj.hideTrigger = Boolean.valueOf(hideTrigger);
			} catch (Exception e) {}
		}

		obj.triggerClass = triggerClass;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	public void setHideTrigger(String hideTrigger) {
		this.hideTrigger = hideTrigger;
	}

	public void setTriggerClass(String triggerClass) {
		this.triggerClass = triggerClass;
	}

}
