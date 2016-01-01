package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.LovField;
import isola.model.ext.grid.GridPanel;


/**
 * <p>Provides a convenient wrapper for TextFields that adds a clickable trigger button 
 * (looks like a combobox by default). The trigger has no default action, so you must 
 * assign a function to implement the trigger click handler by overriding onTriggerClick. 
 * You can create a TriggerField directly, as it renders exactly like a combobox for 
 * which you can provide a custom implementation.</p>
 * 
 * @author Umut Gokbayrak
 */
public class LovFieldTag extends TriggerFieldTag {
	private static final long serialVersionUID = 2934395227437669301L;

    private String lovWidth;
    private String lovHeight;
    private String lovTitle;
    private String multiSelect;
    private String alwaysLoadStore;
    private GridPanel view;
    private String valueField;
    private String displayField;
    private String valueSeparator;
    private String displaySeparator;
    private String showOnFocus;
    private String textarea;
    private String minItem;
    private String minItemText;
    private String maxItem;
    public String maxItemText;
    
	private String onSelect;
	private String onCancel;
	private String onShow;    
    
	
	@Override
	public int doEndTag() throws JspException {
		LovField obj = new LovField();
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
		lovWidth = "300";
		lovHeight = "300";
		lovTitle = null;
		multiSelect = "false";
		alwaysLoadStore = "false";
		view = null;
		valueField = null;
		displayField = null;
		valueSeparator = ",";
		displaySeparator = ",";
		showOnFocus = "false";
		textarea = "false";
		minItem = "0";
		minItemText = "The minimum selected item number for this field is {0}";
		maxItem = "500";
		maxItemText = "The maximum selected item number for this field is {0}";		
		onSelect = onCancel = onShow;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(LovField obj) {
		super.prepareConfig(obj);

		if (lovWidth != null) {
			try {
				obj.lovWidth = Integer.valueOf(lovWidth);
			} catch (Exception e) {}
		}
		if (lovHeight != null) {
			try {
				obj.lovHeight = Integer.valueOf(lovHeight);
			} catch (Exception e) {}
		}
		
		obj.lovTitle = lovTitle;
		
		if (multiSelect != null) {
			try {
				obj.multiSelect = Boolean.valueOf(multiSelect);
			} catch (Exception e) {}
		}		
		
		if (alwaysLoadStore != null) {
			try {
				obj.alwaysLoadStore = Boolean.valueOf(alwaysLoadStore);
			} catch (Exception e) {}
		}		
		
		obj.view = view;
		
		obj.valueField = valueField;
		obj.displayField = displayField;
		obj.valueSeparator = valueSeparator;
		obj.displaySeparator = displaySeparator;		
		
		if (showOnFocus != null) {
			try {
				obj.showOnFocus = Boolean.valueOf(showOnFocus);
			} catch (Exception e) {}
		}	
		
		if (textarea != null) {
			try {
				obj.showOnFocus = Boolean.valueOf(textarea);
			} catch (Exception e) {}
		}			
		
		if (minItem != null) {
			try {
				obj.minItem = Integer.valueOf(minItem);
			} catch (Exception e) {}
		}		
		
		obj.minItemText = minItemText;
		
		if (maxItem != null) {
			try {
				obj.maxItem = Integer.valueOf(maxItem);
			} catch (Exception e) {}
		}
		
		obj.valueField = valueField;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
		
		if (onSelect != null) {
			obj.listeners.put("selected", new JsFunction(onSelect));
		}

		if (onCancel != null) {
			obj.listeners.put("cancelled", new JsFunction(onCancel));
		}

		if (onShow != null) {
			obj.listeners.put("showed", new JsFunction(onShow));
		}
		
	}

	public String getLovWidth() {
		return lovWidth;
	}

	public void setLovWidth(String lovWidth) {
		this.lovWidth = lovWidth;
	}

	public String getLovHeight() {
		return lovHeight;
	}

	public void setLovHeight(String lovHeight) {
		this.lovHeight = lovHeight;
	}

	public String getLovTitle() {
		return lovTitle;
	}

	public void setLovTitle(String lovTitle) {
		this.lovTitle = lovTitle;
	}

	public String getMultiSelect() {
		return multiSelect;
	}

	public void setMultiSelect(String multiSelect) {
		this.multiSelect = multiSelect;
	}

	public String getAlwaysLoadStore() {
		return alwaysLoadStore;
	}

	public void setAlwaysLoadStore(String alwaysLoadStore) {
		this.alwaysLoadStore = alwaysLoadStore;
	}

	public GridPanel getView() {
		return view;
	}

	public void setView(GridPanel view) {
		this.view = view;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getDisplayField() {
		return displayField;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	public String getValueSeparator() {
		return valueSeparator;
	}

	public void setValueSeparator(String valueSeparator) {
		this.valueSeparator = valueSeparator;
	}

	public String getDisplaySeparator() {
		return displaySeparator;
	}

	public void setDisplaySeparator(String displaySeparator) {
		this.displaySeparator = displaySeparator;
	}

	public String getShowOnFocus() {
		return showOnFocus;
	}

	public void setShowOnFocus(String showOnFocus) {
		this.showOnFocus = showOnFocus;
	}
	
	

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	public String getMinItem() {
		return minItem;
	}

	public void setMinItem(String minItem) {
		this.minItem = minItem;
	}

	public String getMinItemText() {
		return minItemText;
	}

	public void setMinItemText(String minItemText) {
		this.minItemText = minItemText;
	}

	public String getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(String maxItem) {
		this.maxItem = maxItem;
	}

	public String getMaxItemText() {
		return maxItemText;
	}

	public void setMaxItemText(String maxItemText) {
		this.maxItemText = maxItemText;
	}

	public String getOnSelect() {
		return onSelect;
	}

	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}

	public String getOnCancel() {
		return onCancel;
	}

	public void setOnCancel(String onCancel) {
		this.onCancel = onCancel;
	}

	public String getOnShow() {
		return onShow;
	}

	public void setOnShow(String onShow) {
		this.onShow = onShow;
	}




}
