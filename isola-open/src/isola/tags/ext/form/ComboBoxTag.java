package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.core.JsVariableImpl;
import isola.model.ext.base.Observable;
import isola.model.ext.data.Store;
import isola.model.ext.form.ComboBox;
import isola.tags.ext.data.StoreTag;


/**
 * A combobox control with support for autocomplete, remote-loading, paging and many other 
 * features. 
 * 
 * <code><pre>
 * 
 * &lt;ext:body runOnLoad="true"&gt;
 * 	var dummyData = [
 * 	['3m Co',71.72,0.02,0.03,'9/1 12:00am', 'Manufacturing'],
 * 	['Alcoa Inc',29.01,0.42,1.47,'9/1 12:00am', 'Manufacturing'],
 * 	['Altria Group Inc',83.81,0.28,0.34,'9/1 12:00am', 'Manufacturing'],
 * 	['American Express Company',52.55,0.01,0.02,'9/1 12:00am', 'Finance'],
 * 	['American International Group, Inc.',64.13,0.31,0.49,'9/1 12:00am', 'Services'],
 * 	['AT&T Inc.',31.61,-0.48,-1.54,'9/1 12:00am', 'Services'],
 * 	['Boeing Co.',75.43,0.53,0.71,'9/1 12:00am', 'Manufacturing'],
 * 	['Caterpillar Inc.',67.27,0.92,1.39,'9/1 12:00am', 'Services'],
 * 	['Citigroup, Inc.',49.37,0.02,0.04,'9/1 12:00am', 'Finance'],
 * 	['E.I. du Pont de Nemours and Company',40.48,0.51,1.28,'9/1 12:00am', 'Manufacturing'],
 * 	['Exxon Mobil Corp',68.1,-0.43,-0.64,'9/1 12:00am', 'Manufacturing'],
 * 	['General Electric Company',34.14,-0.08,-0.23,'9/1 12:00am', 'Manufacturing'],
 * 	['General Motors Corporation',30.27,1.09,3.74,'9/1 12:00am', 'Automotive'],
 * 	['Hewlett-Packard Co.',36.53,-0.03,-0.08,'9/1 12:00am', 'Computer'],
 * 	['Honeywell Intl Inc',38.77,0.05,0.13,'9/1 12:00am', 'Manufacturing'],
 * 	['Intel Corporation',19.88,0.31,1.58,'9/1 12:00am', 'Computer'],
 * 	['International Business Machines',81.41,0.44,0.54,'9/1 12:00am', 'Computer'],
 * 	['Johnson & Johnson',64.72,0.06,0.09,'9/1 12:00am', 'Medical'],
 * 	['JP Morgan & Chase & Co',45.73,0.07,0.15,'9/1 12:00am', 'Finance'],
 * 	['McDonald\'s Corporation',36.76,0.86,2.40,'9/1 12:00am', 'Food'],
 * 	['Merck & Co., Inc.',40.96,0.41,1.01,'9/1 12:00am', 'Medical'],
 * 	['Microsoft Corporation',25.84,0.14,0.54,'9/1 12:00am', 'Computer'],
 * 	['Pfizer Inc',27.96,0.4,1.45,'9/1 12:00am', 'Services', 'Medical'],
 * 	['The Coca-Cola Company',45.07,0.26,0.58,'9/1 12:00am', 'Food'],
 * 	['The Home Depot, Inc.',34.64,0.35,1.02,'9/1 12:00am', 'Retail'],
 * 	['The Procter & Gamble Company',61.91,0.01,0.02,'9/1 12:00am', 'Manufacturing'],
 * 	['United Technologies Corporation',63.26,0.55,0.88,'9/1 12:00am', 'Computer'],
 * 	['Verizon Communications',35.57,0.39,1.11,'9/1 12:00am', 'Services'],
 * 	['Wal-Mart Stores, Inc.',45.45,0.73,1.63,'9/1 12:00am', 'Retail'],
 * 	['Walt Disney Company (The) (Holding Company)',29.89,0.24,0.81,'9/1 12:00am', 'Services']
 * 	]; 
 * 
 *	&lt;ext:formPanel url="deneme.jsp" id="myForm" renderTo="form-ct" width="400" bodyStyle="background-color:#EEEEEE;" border="false"&gt;
 *		&lt;ext:comboBox fieldLabel="Select City" name="myCombo" displayField="company" emptyText="Please select" valueField="change"&gt;
 *			&lt;ext:arrayStore data="dummyData" autoLoad="true"&gt;
 *				&lt;ext:storeMapping name="company" /&gt;
 *				&lt;ext:storeMapping name="price" /&gt;
 *				&lt;ext:storeMapping name="change" /&gt;
 *				&lt;ext:storeMapping name="pctChange" /&gt;
 *				&lt;ext:storeMapping name="lastChange" /&gt;
 *				&lt;ext:storeMapping name="industry" /&gt;
 *			&lt;/ext:arrayStore&gt;
 *		&lt;/ext:comboBox&gt;
 *		&lt;ext:button type="submit" text="Go!" /&gt;
 *	&lt;/ext:formPanel&gt;
 * &lt;/ext:body&gt;
 * 
 * &lt;div style="width:800px;margin:50px;"&gt;
 *	 &lt;div class="x-box-tl"&gt;&lt;div class="x-box-tr"&gt;&lt;div class="x-box-tc"&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;
 *	 &lt;div class="x-box-ml"&gt;&lt;div class="x-box-mr"&gt;&lt;div class="x-box-mc"&gt;
 *	   &lt;h3 style="margin-bottom:5px;"&gt;Simple Form&lt;/h3&gt;
 *	     &lt;div id="form-ct"&gt;
 *	
 *	     &lt;/div&gt;
 *	 &lt;/div&gt;&lt;/div&gt;&lt;/div&gt;
 *	 &lt;div class="x-box-bl"&gt;&lt;div class="x-box-br"&gt;&lt;div class="x-box-bc"&gt;&lt;/div&gt;&lt;/div&gt;&lt;/div&gt;
 * &lt;/div&gt;
 * 
 * </pre></code>
 * 
 * @see StoreTag for how to load a combo box with data
 * @author Umut Gokbayrak
 */
public class ComboBoxTag extends TriggerFieldTag {
	private static final long serialVersionUID = -3281783319027018730L;

	private String allQuery;
	private String displayField;
	private String editable;
	private String forceSelection;
	private String handleHeight;
	private String hiddenId;
	private String hiddenName;
	private String lazyInit; 
	private String lazyRender;
	private String listAlign;
	private String listClass;
	private String listWidth;
	private String loadingText;
	private String maxHeight;
	private String minChars;
	private String minListWidth;
	private String mode;
	private String pageSize;
	private String queryDelay;
	private String queryParam;
	private String resizable;
	private String selectOnFocus;
	private String selectedClass;
	private String shadow;
	private String title;
	private String tpl;
	private String transform;
	private String triggerAction;
	private String triggerClass;
	private String typeAhead;
	private String typeAheadDelay;
	private String valueField;
	private String valueNotFoundText;
	private String emptyText;

	private Store store;
	private String storeId;

	private String onBeforeQuery;
	private String onBeforeSelect;
	private String onCollapse;
	private String onExpand;
	private String onSelect;
	
	@Override
	public int doEndTag() throws JspException {
		ComboBox obj = new ComboBox();
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
		allQuery = emptyText = displayField = null;
		editable = "true";
		forceSelection = "false";
		handleHeight = "8";
		hiddenId = hiddenName = null;
		lazyInit = "true";
		lazyRender = "false";
		listAlign = listClass = null;
		listWidth = "0";
		loadingText = null;
		maxHeight = "300";
		minChars = "0";
		minListWidth = "70";
		mode = null;
		pageSize = queryDelay = "0";
		queryParam = null;
		resizable = selectOnFocus = "false";
		selectedClass = shadow = title = tpl = transform = triggerAction = triggerClass = null;
		typeAhead = "false";
		typeAheadDelay = "250";
		valueField = valueNotFoundText = null;
		store = null;
		onBeforeQuery = onBeforeSelect = onCollapse = onExpand = onSelect = null;
		storeId = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(ComboBox obj) {
		setTriggerAction("all");
		// setMode("local");
		// setSelectOnFocus("true");
		// setHiddenName(getName());
		// setHiddenId(getName());
		setName(getName());
		setId(getName());
		super.prepareConfig(obj);

		obj.allQuery = allQuery;
		obj.displayField = displayField;
		obj.emptyText = emptyText;
		
		if (editable != null) {
			try {
				obj.editable = Boolean.valueOf(editable);
			} catch (Exception e) {}
		}

		if (forceSelection != null) {
			try {
				obj.forceSelection = Boolean.valueOf(forceSelection);
			} catch (Exception e) {}
		}

		if (handleHeight != null) {
			try {
				obj.handleHeight = Integer.valueOf(handleHeight);
			} catch (Exception e) {}
		}
		
		obj.hiddenId = hiddenId;
		obj.hiddenName = hiddenName;

		if (lazyInit != null) {
			try {
				obj.lazyInit = Boolean.valueOf(lazyInit);
			} catch (Exception e) {}
		}
		
		if (lazyRender != null) {
			try {
				obj.lazyRender = Boolean.valueOf(lazyRender);
			} catch (Exception e) {}
		}
		
		obj.listAlign = listAlign;
		obj.listClass = listClass;
		
		if (listWidth != null) {
			try {
				obj.listWidth = Integer.valueOf(listWidth);
			} catch (Exception e) {}
		}
		
		obj.loadingText = loadingText;

		if (maxHeight != null) {
			try {
				obj.maxHeight = Integer.valueOf(maxHeight);
			} catch (Exception e) {}
		}

		if (minChars != null) {
			try {
				obj.minChars = Integer.valueOf(minChars);
			} catch (Exception e) {}
		}

		if (minListWidth != null) {
			try {
				obj.minListWidth = Integer.valueOf(minListWidth);
			} catch (Exception e) {}
		}
		
		obj.mode = mode;

		if (pageSize != null) {
			try {
				obj.pageSize = Integer.valueOf(pageSize);
			} catch (Exception e) {}
		}

		if (queryDelay != null) {
			try {
				obj.queryDelay = Integer.valueOf(queryDelay);
			} catch (Exception e) {}
		}

		obj.queryParam = queryParam;

		if (resizable != null) {
			try {
				obj.resizable = Boolean.valueOf(resizable);
			} catch (Exception e) {}
		}
		
		if (selectOnFocus != null) {
			try {
				obj.selectOnFocus = Boolean.valueOf(selectOnFocus);
			} catch (Exception e) {}
		}
		
		obj.selectedClass = selectedClass;
		obj.shadow = shadow;
		obj.title = title;
		obj.tpl = tpl;
		obj.transform = transform;
		obj.triggerAction = triggerAction;
		obj.triggerClass = triggerClass;

		if (typeAhead != null) {
			try {
				obj.typeAhead = Boolean.valueOf(typeAhead);
			} catch (Exception e) {}
		}

		if (typeAheadDelay != null) {
			try {
				obj.typeAheadDelay = Integer.valueOf(typeAheadDelay);
			} catch (Exception e) {}
		}

		if (queryDelay != null) {
			try {
				obj.queryDelay = Integer.valueOf(queryDelay);
			} catch (Exception e) {}
		}

		if (store != null) {
			obj.store = store;
		}

		obj.valueField = valueField;
		obj.valueNotFoundText = valueNotFoundText;

		if (storeId != null && store == null) {
			obj.put("store", new JsVariableImpl(storeId));
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onBeforeQuery != null) {
			obj.listeners.put("beforequery", new JsFunction(onBeforeQuery));
		}

		if (onBeforeSelect != null) {
			obj.listeners.put("beforeselect", new JsFunction(onBeforeSelect));
		}

		if (onCollapse != null) {
			obj.listeners.put("collapse", new JsFunction(onCollapse));
		}

		if (onExpand != null) {
			obj.listeners.put("expand", new JsFunction(onExpand));
		}

		if (onSelect != null) {
			obj.listeners.put("select", new JsFunction(onSelect));
		}
	}

	/**
	 * The text query to send to the server to return all records for the list with no 
	 * filtering (defaults to '')
	 */
	public void setAllQuery(String allQuery) {
		this.allQuery = allQuery;
	}

	/**
	 * The underlying data field name to bind to this ComboBox (defaults to undefined if 
	 * mode = 'remote' or 'text' if transforming a select)
	 */
	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	/**
	 * False to prevent the user from typing text directly into the field, just like a 
	 * traditional select (defaults to true)
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}

	/**
	 * True to restrict the selected value to one of the values in the list, false to 
	 * allow the user to set arbitrary text into the field (defaults to false)
	 */
	public void setForceSelection(String forceSelection) {
		this.forceSelection = forceSelection;
	}

	/**
	 * The height in pixels of the dropdown list resize handle if resizable = true 
	 * (defaults to 8)
	 */
	public void setHandleHeight(String handleHeight) {
		this.handleHeight = handleHeight;
	}

	/**
	 * If hiddenName is specified, hiddenId can also be provided to give the hidden 
	 * field a unique id (defaults to the hiddenName). The hiddenId and combo id 
	 * should be different, since no two DOM nodes should share the same id.
	 */
	public void setHiddenId(String hiddenId) {
		this.hiddenId = hiddenId;
	}

	/**
	 * If specified, a hidden form field with this name is dynamically generated to 
	 * store the field's data value (defaults to the underlying DOM element's name). 
	 * Required for the combo's value to automatically post during a form submission.
	 */
	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}

	/**
	 * True to not initialize the list for this combo until the field is focused. 
	 * (defaults to true)
	 */
	public void setLazyInit(String lazyInit) {
		this.lazyInit = lazyInit;
	}

	/**
	 * True to prevent the ComboBox from rendering until requested (should always be 
	 * used when rendering into an Ext.Editor, defaults to false).
	 */
	public void setLazyRender(String lazyRender) {
		this.lazyRender = lazyRender;
	}

	/**
	 * A valid anchor position value. See Ext.Element.alignTo for details on supported 
	 * anchor positions (defaults to 'tl-bl')
	 */
	public void setListAlign(String listAlign) {
		this.listAlign = listAlign;
	}

	/**
	 * CSS class to apply to the dropdown list element (defaults to '')
	 */
	public void setListClass(String listClass) {
		this.listClass = listClass;
	}

	/**
	 * The width in pixels of the dropdown list (defaults to the width of the ComboBox 
	 * field)
	 */
	public void setListWidth(String listWidth) {
		this.listWidth = listWidth;
	}

	/**
	 * The text to display in the dropdown list while data is loading. Only applies 
	 * when mode = 'remote' (defaults to 'Loading...')
	 */
	public void setLoadingText(String loadingText) {
		this.loadingText = loadingText;
	}

	/**
	 * The maximum height in pixels of the dropdown list before scrollbars are shown 
	 * (defaults to 300)
	 */
	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	/**
	 * The minimum number of characters the user must type before autocomplete and 
	 * typeahead activate (defaults to 4 if remote or 0 if local, does not apply if editable = false)
	 */
	public void setMinChars(String minChars) {
		this.minChars = minChars;
	}

	/**
	 * The minimum width of the dropdown list in pixels (defaults to 70, will be ignored if 
	 * listWidth has a higher value)
	 */
	public void setMinListWidth(String minListWidth) {
		this.minListWidth = minListWidth;
	}

	/**
	 * Set to 'local' if the ComboBox loads local data (defaults to 'remote' which loads 
	 * from the server)
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * If greater than 0, a paging toolbar is displayed in the footer of the dropdown list 
	 * and the filter queries will execute with page start and limit parameters. Only 
	 * applies when mode = 'remote' (defaults to 0)
	 */
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * The length of time in milliseconds to delay between the start of typing and sending 
	 * the query to filter the dropdown list (defaults to 500 if mode = 'remote' or 10 
	 * if mode = 'local')
	 */
	public void setQueryDelay(String queryDelay) {
		this.queryDelay = queryDelay;
	}

	/**
	 * Name of the query as it will be passed on the querystring (defaults to 'query')
	 */
	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}

	/**
	 * True to add a resize handle to the bottom of the dropdown list (defaults to false)
	 */
	public void setResizable(String resizable) {
		this.resizable = resizable;
	}

	/**
	 * True to select any existing text in the field immediately on focus. Only applies 
	 * when editable = true (defaults to false)
	 */
	public void setSelectOnFocus(String selectOnFocus) {
		this.selectOnFocus = selectOnFocus;
	}

	/**
	 * CSS class to apply to the selected item in the dropdown list (defaults to 
	 * 'x-combo-selected')
	 */
	public void setSelectedClass(String selectedClass) {
		this.selectedClass = selectedClass;
	}

	/**
	 * True or "sides" for the default effect, "frame" for 4-way shadow, and "drop" 
	 * for bottom-right
	 */
	public void setShadow(String shadow) {
		this.shadow = shadow;
	}

	/**
	 * If supplied, a header element is created containing this text and 
	 * added into the top of the dropdown list (defaults to undefined, with no header 
	 * element)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <p>The template string, or Ext.XTemplate instance to use to display each item in the 
	 * dropdown list. Use this to create custom UI layouts for items in the list.</p>
	 * 
	 * <p>If you wish to preserve the default visual look of list items, add the CSS class 
	 * name.</p>
	 * 
	 * <code><pre>
	 * 	x-combo-list-item
	 * </pre></code>
	 * 
	 * <p>to the template's container element. The template must contain one or more substitution 
	 * parameters using field names from the Combo's Store. An example of a custom template 
	 * would be adding an </p>
	 * 
	 * <code><pre>ext:qtip</pre></code>
	 * attribute which might display other fields from the Store. The dropdown list is 
	 * displayed in a DataView. See Ext.DataView for details. 
	 */
	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	/**
	 * The id, DOM node or element of an existing HTML SELECT to convert to a ComboBox. 
	 * Note that if you specify this and the combo is going to be in a Ext.form.BasicForm or 
	 * Ext.form.FormPanel, you must also set lazyRender = true.
	 */
	public void setTransform(String transform) {
		this.transform = transform;
	}

	/**
	 * The action to execute when the trigger field is activated. Use 'all' to run the query 
	 * specified by the allQuery config option (defaults to 'query')
	 */
	public void setTriggerAction(String triggerAction) {
		this.triggerAction = triggerAction;
	}

	/**
	 * An additional CSS class used to style the trigger button. The trigger will always 
	 * get the class 'x-form-trigger' and triggerClass will be appended if specified 
	 * (defaults to 'x-form-arrow-trigger' which displays a downward arrow icon).
	 */
	public void setTriggerClass(String triggerClass) {
		this.triggerClass = triggerClass;
	}

	/**
	 * True to populate and autoselect the remainder of the text being typed after a 
	 * configurable delay (typeAheadDelay) if it matches a known value (defaults to false)
	 */
	public void setTypeAhead(String typeAhead) {
		this.typeAhead = typeAhead;
	}

	/**
	 * The length of time in milliseconds to wait until the typeahead text is displayed 
	 * if typeAhead = true (defaults to 250)
	 */
	public void setTypeAheadDelay(String typeAheadDelay) {
		this.typeAheadDelay = typeAheadDelay;
	}

	/**
	 * The underlying data value name to bind to this ComboBox (defaults to undefined 
	 * if mode = 'remote' or 'value' if transforming a select) Note: use of a valueField 
	 * requires the user to make a selection in order for a value to be mapped.
	 */
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	/**
	 * When using a name/value combo, if the value passed to setValue is not found in the 
	 * store, valueNotFoundText will be displayed as the field text if defined (defaults to undefined)
	 */
	public void setValueNotFoundText(String valueNotFoundText) {
		this.valueNotFoundText = valueNotFoundText;
	}

	/**
	 * The data store to which this combo is bound (defaults to undefined)
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * <p>Fires before all queries are processed. Return false to cancel the query
	 *  or set the queryEvent's cancel property to true.</p>
	 *  Listeners will be called with the following arguments:
	 *  <ul>
	 *  <li><strong>queryEvent </strong>:(Object) An object that has these properties:
	 *  	<ul>
	 *  	<li><strong>combo </strong>:(Ext.form.ComboBox) This combo box </li>
	 *  	<li><strong>query </strong>:(String) The query</li>
	 *  	<li><strong>forceAll </strong>:(Boolean) True to force "all" query </li>
	 *  	<li><strong>cancel </strong>:(Boolean) Set to true to cancel the query</li>
	 *  	</ul>
	 *  </li>
	 *  </ul>
	 * @param onBeforeQuery
	 */
	public void setOnBeforeQuery(String onBeforeQuery) {
		this.onBeforeQuery = onBeforeQuery;
	}

	/**
	 * <p>Fires before a list item is selected. Return false to cancel the selection. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>combo </strong>:(Ext.form.ComboBox) This combo box </li>
	 * <li><strong>record </strong>:(Ext.data.Record) The data record returned from the underlying store</li>
	 * <li><strong>index </strong>:(Number) The index of the selected item in the dropdown list </li>
	 * </ul>
	 * @param onBeforeSelect
	 */
	public void setOnBeforeSelect(String onBeforeSelect) {
		this.onBeforeSelect = onBeforeSelect;
	}

	/**
	 * <p>Fires when the dropdown list is collapsed </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>combo </strong>:(Ext.form.ComboBox) This combo box </li>
	 * </ul>
	 * @param onCollapse
	 */
	public void setOnCollapse(String onCollapse) {
		this.onCollapse = onCollapse;
	}

	/**
	 * <p>Fires when the dropdown list is expanded </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>combo </strong>:(Ext.form.ComboBox) This combo box </li>
	 * </ul>
	 * @param onExpand
	 */
	public void setOnExpand(String onExpand) {
		this.onExpand = onExpand;
	}

	/**
	 * <p>Fires when a list item is selected <p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>combo </strong>:(Ext.form.ComboBox) This combo box </li>
	 * <li><strong>record </strong>:(Ext.data.Record) The data record returned from the underlying store</li>
	 * <li><strong>index </strong>:(Number) The index of the selected item in the dropdown list </li>
	 * </ul>
	 * @param onSelect
	 */
	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}

	/**
	 * Lets assigning a pre-defined store to this component using the store's id
	 * @param storeId
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
}
