package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.Editor;
import isola.tags.ext.base.ComponentTag;


/**
 * <strong>This class is used internally and not needed to be instantiated by a new statement</strong>
 * 
 * A base editor field that handles displaying/hiding on demand and has some built-in sizing 
 * and event handling logic.
 * 
 * @author Umut Gokbayrak
 */
public class EditorTag extends ComponentTag {
	private static final long serialVersionUID = 3168747650561325358L;

	private String alignment;
	private String cancelOnEsc;
	private String completeOnEnter;
	private String constrain;
	private String ignoreNoChange;
	private String revertInvalid;
	private String shadow;
	private String swallowKeys; 
	private String updateEl;
	private String value;

	private String onBeforeComplete;
	private String onBeforeStartEdit;
	private String onComplete;
	private String onSpecialKey;
	private String onStartEdit;

	@Override
	public int doEndTag() throws JspException {
		Editor obj = new Editor();
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

		alignment = null;
		cancelOnEsc = completeOnEnter = constrain = ignoreNoChange = "false";
		revertInvalid = "true";
		shadow = null;
		swallowKeys = "true"; 
		updateEl = "false";
		value = null;	
		onBeforeComplete = onBeforeStartEdit = onComplete = onSpecialKey = onStartEdit = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Editor obj) {
		super.prepareConfig(obj);
		obj.alignment = alignment;

		if (cancelOnEsc != null) {
			try {
				obj.cancelOnEsc = Boolean.valueOf(cancelOnEsc);
			} catch (Exception e) {}
		}

		if (completeOnEnter != null) {
			try {
				obj.completeOnEnter = Boolean.valueOf(completeOnEnter);
			} catch (Exception e) {}
		}

		if (constrain != null) {
			try {
				obj.constrain = Boolean.valueOf(constrain);
			} catch (Exception e) {}
		}

		if (ignoreNoChange != null) {
			try {
				obj.ignoreNoChange = Boolean.valueOf(ignoreNoChange);
			} catch (Exception e) {}
		}

		if (revertInvalid != null) {
			try {
				obj.revertInvalid = Boolean.valueOf(revertInvalid);
			} catch (Exception e) {}
		}

		obj.shadow = shadow;

		if (swallowKeys != null) {
			try {
				obj.swallowKeys = Boolean.valueOf(swallowKeys);
			} catch (Exception e) {}
		}

		if (updateEl != null) {
			try {
				obj.updateEl = Boolean.valueOf(updateEl);
			} catch (Exception e) {}
		}

		obj.value = value;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onBeforeComplete != null) {
			obj.listeners.put("beforecomplete", new JsFunction(onBeforeComplete));
		}
		if (onBeforeStartEdit != null) {
			obj.listeners.put("beforestartedit", new JsFunction(onBeforeStartEdit));
		}
		if (onComplete != null) {
			obj.listeners.put("complete", new JsFunction(onComplete));
		}
		if (onSpecialKey != null) {
			obj.listeners.put("specialkey", new JsFunction(onSpecialKey));
		}
		if (onStartEdit != null) {
			obj.listeners.put("startedit", new JsFunction(onStartEdit));
		}
	}

	/**
	 * The position to align to (see Ext.Element.alignTo for more details, defaults to "c-c?").
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	/**
	 * True to cancel the edit when the escape key is pressed (defaults to false)
	 */
	public void setCancelOnEsc(String cancelOnEsc) {
		this.cancelOnEsc = cancelOnEsc;
	}

	/**
	 * True to complete the edit when the enter key is pressed (defaults to false)
	 */
	public void setCompleteOnEnter(String completeOnEnter) {
		this.completeOnEnter = completeOnEnter;
	}

	/**
	 * True to constrain the editor to the viewport
	 */
	public void setConstrain(String constrain) {
		this.constrain = constrain;
	}

	/**
	 * True to skip the the edit completion process (no save, no events fired) if the 
	 * user completes an edit and the value has not changed (defaults to false). Applies 
	 * only to string values - edits for other data types will never be ignored.
	 */
	public void setIgnoreNoChange(String ignoreNoChange) {
		this.ignoreNoChange = ignoreNoChange;
	}

	/**
	 * True to automatically revert the field value and cancel the edit when the user 
	 * completes an edit and the field validation fails (defaults to true)
	 */
	public void setRevertInvalid(String revertInvalid) {
		this.revertInvalid = revertInvalid;
	}

	/**
	 * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for 
	 * bottom-right shadow (defaults to "frame")
	 */
	public void setShadow(String shadow) {
		this.shadow = shadow;
	}

	/**
	 * Handle the keydown/keypress events so they don't propagate (defaults to true)
	 */
	public void setSwallowKeys(String swallowKeys) {
		this.swallowKeys = swallowKeys;
	}

	/**
	 * True to update the innerHTML of the bound element when the update completes (defaults to false)
	 */
	public void setUpdateEl(String updateEl) {
		this.updateEl = updateEl;
	}

	/**
	 * The data value of the underlying field (defaults to "")
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * <p>Fires after a change has been made to the field, but before the change is reflected in the underlying field. 
	 * Saving the change to the field can be canceled by returning false from the handler of this event. Note that if 
	 * the value has not changed and ignoreNoChange = true, the editing will still end but this event will not fire since
	 * no edit actually occurred.</p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * 	<li><strong>this</strong> : Editor</li>
	 * 	<li><strong>value</strong> : (Mixed) current field value</li>
     *  <li><strong>startValue</strong> : (Mixed) The original field value</li>
     * </ul>
	 * @param onBeforeComplete
	 */
	public void setOnBeforeComplete(String onBeforeComplete) {
		this.onBeforeComplete = onBeforeComplete;
	}

	/**
	 * <p>Fires when editing is initiated, but before the value changes. Editing can be canceled by 
	 * returning false from the handler of this event. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Editor</li>
	 * <li><strong>boundEl</strong> : (Ext.Element) The underlying element bound to this editor</li>
     * <li><strong>value</strong> : (Mixed) The field value being set</li>
     * </ul>
	 * @param onBeforeStartEdit
	 */
	public void setOnBeforeStartEdit(String onBeforeStartEdit) {
		this.onBeforeStartEdit = onBeforeStartEdit;
	}

	/**
	 * <p>Fires after editing is complete and any changed value has been written to the underlying field. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Editor</li>
     * <li><strong>value</strong> : (Mixed) The current field value</li>
	 * <li><strong>startValue </strong> : (Mixed) The original field value</li>
     * </ul>
	 * @param onComplete
	 */
	public void setOnComplete(String onComplete) {
		this.onComplete = onComplete;
	}

	/**
	 * <p>Fires when any key related to navigation (arrows, tab, enter, esc, etc.) is pressed. You can check 
	 * Ext.EventObject.getKey to determine which key was pressed.</p>
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
	 * <p>Fires when this editor is displayed </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>boundEl</strong> : (Ext.Element) The underlying element bound to this editor</li>
     * <li><strong>value</strong> : (Mixed) The starting field value</li>
     * </ul>
	 * @param onStartEdit
	 */
	public void setOnStartEdit(String onStartEdit) {
		this.onStartEdit = onStartEdit;
	}


}
