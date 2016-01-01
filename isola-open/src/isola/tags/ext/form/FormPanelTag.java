package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.core.JsObject;
import isola.model.core.JsVariableImpl;
import isola.model.ext.base.Observable;
import isola.model.ext.data.DataReader;
import isola.model.ext.form.FormPanel;
import isola.tags.ext.container.PanelTag;


/**
 * <p>FormPanel uses a Ext.layout.FormLayout internally, and that is required for fields and labels to 
 * work correctly within the FormPanel's layout. To nest additional layout styles within a FormPanel, 
 * you should nest additional Panels or other containers that can provide additional layout 
 * functionality. You should not override FormPanel's layout.</p>
 * 
 * <p>By default, Ext Forms are submitted through Ajax, using Ext.form.Action. To enable normal 
 * browser submission of the Ext Form contained in this FormPanel, override the Form's onSubmit, 
 * and submit methods:</p>
 * 
 * <code><pre>
 * 	  &lt;ext:formPanel url="deneme.jsp" id="myForm" renderTo="form-ct" width="400" bodyStyle="background-color:#EEEEEE;" border="false"&gt;
 *	  	&lt;ext:dateField name="dateField" minValue="01/03/2008" maxValue="15/03/2008" fieldLabel="Select Date"/&gt;
 *		&lt;ext:button type="submit" text="Go!" /&gt;
 *	  &lt;/ext:formPanel&gt;
 * </pre></code>
 * 
 * @author Umut Gokbayrak
 */
public class FormPanelTag extends PanelTag {
	private static final long serialVersionUID = 8454002595146840133L;

	private String buttonAlign;
	private String formId;
	private String itemCls;
	private String labelAlign;
	private String labelWidth;
	private String minButtonWidth;
	private String monitorPoll;
	private String monitorValid;
	private String fileUpload;
	private String method;
	private String timeout;
	private String trackResetOnLoad;
	private String url;
	private String isAjaxForm = "false";
	private String onSubmit;
	private String waitingTitle;
	private String waitingText;

	private DataReader reader;
	private DataReader errorReader;
	private JsObject params;

	private String onClientValidation;
	private String onActionComplete;
	private String onActionFailed;
	private String onBeforeAction;
	
	@Override
	public int doEndTag() throws JspException {
		FormPanel obj = new FormPanel();
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
		buttonAlign = formId = itemCls = labelAlign = null;
		labelWidth = "0";
		minButtonWidth = "75";
		monitorPoll = "200";
		monitorValid = "true";
		fileUpload = "false";
		method = null;
		timeout = "30";
		trackResetOnLoad = isAjaxForm = "false";
		url = null;
		reader = null;
		errorReader = null;
		params = null;
		onClientValidation = onActionComplete = onSubmit = onActionFailed = onBeforeAction;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(FormPanel obj) {
		super.prepareConfig(obj);

		String myId = getId();
		setFormId(myId + "formid");
		
		if (isAjaxForm != null && isAjaxForm.trim().toLowerCase().equals("false")) {
			String submit = "this.getForm().getEl().dom.action='" + url + "';";
			if (method != null) {
				submit = submit + "this.getForm().getEl().dom.method='" + method + "';";
			}
			submit = submit + "this.getForm().getEl().dom.submit();";
			String submitter = "if (!(Ext.getCmp('" + getId() + "').getForm().isValid())) { return false; };";
			obj.put("submit", new JsFunction(submitter + " " + submit));
			obj.put("onSubmit", new JsFunction(JsFunction.CODE, "Ext.emptyFn"));
			obj.standardSubmit = true;
		}

		obj.buttonAlign = buttonAlign;
		obj.formId = formId;
		obj.itemCls = itemCls;
		obj.labelAlign = labelAlign;
		
		if (labelWidth != null) {
			try {
				obj.labelWidth = Integer.valueOf(labelWidth);
			} catch (Exception e) {}
		}

		if (minButtonWidth != null) {
			try {
				obj.minButtonWidth = Integer.valueOf(minButtonWidth);
			} catch (Exception e) {}
		}

		if (monitorPoll != null) {
			try {
				obj.monitorPoll = Integer.valueOf(monitorPoll);
			} catch (Exception e) {}
		}

		if (monitorValid != null) {
			try {
				obj.monitorValid = Boolean.valueOf(monitorValid);
			} catch (Exception e) {}
		}

		if (fileUpload != null) {
			try {
				obj.fileUpload = Boolean.valueOf(fileUpload);
			} catch (Exception e) {}
		}

		if (method == null) {
			method = "POST";
		}
		obj.method = method.toUpperCase();

		if (timeout != null) {
			try {
				obj.timeout = Integer.valueOf(timeout);
			} catch (Exception e) {}
		}

		if (trackResetOnLoad != null) {
			try {
				obj.trackResetOnLoad = Boolean.valueOf(trackResetOnLoad);
			} catch (Exception e) {}
		}

		obj.url = url;
		
		if (onSubmit != null) {
			obj.put("onSubmit", new JsVariableImpl(onSubmit));
		}

		if (reader != null) {
			obj.reader = reader;
		}

		if (errorReader != null) {
			obj.errorReader = errorReader;
		}
		
		if (params != null) {
			obj.baseParams = params;
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onClientValidation != null) {
			obj.listeners.put("clientvalidation", new JsFunction(onClientValidation));
		}

		if (onActionComplete != null) {
			obj.listeners.put("actioncomplete", new JsFunction(onActionComplete));
		}

		if (onActionFailed != null) {
			obj.listeners.put("actionfailed", new JsFunction(onActionFailed));
		}

		if (onBeforeAction != null) {
			obj.listeners.put("beforeaction", new JsFunction(onBeforeAction));
		}
		
		if (isAjaxForm != null && isAjaxForm.trim().toLowerCase().equals("false")) {
			String after = "function() {" + 
								"var buttons = Ext.getCmp('" + getId() + "').buttons;" + 
								"for (key in buttons) {" + 
								"var elem = buttons[key];" + 
								"if (elem.type != null && elem.type == 'submit') {" + 
								"elem.handler = function() {" + 
								"Ext.getCmp('" + getId() + "').submit();" + 
								"} " + 
								"} else if (elem.type != null && elem.type == 'reset') {" + 
								"elem.handler = function() {" + 
								"Ext.getCmp('" + getId() + "').getForm().reset();" + 
								"}" + 
								"}" + 	
								"}" + 
							"}";
			obj.listeners.put("afterlayout", new JsFunction(JsFunction.ANONYMOUS, after));
		} else {
			String after = "function() {" + 
						"var buttons = Ext.getCmp('" + getId() + "').buttons;" + 
						"for (key in buttons) {" + 
						"var elem = buttons[key];" + 
						"if (elem.type != null && elem.type == 'submit') {" + 
						"elem.handler = function() {";
			if (waitingText != null) {
				after += "Ext.getCmp('" + getId() + "').getForm().submit({waitTitle:'" + waitingTitle + "', waitMsg:'" + waitingText + "', method:'" + method + "'});"; 
			} else {
				after += "Ext.getCmp('" + getId() + "').getForm().submit({method:'" + method + "'});";
			}
			after += "} " + 
					"} else if (elem.type != null && elem.type == 'reset') {" + 
					"elem.handler = function() {" + 
					"Ext.getCmp('" + getId() + "').getForm().reset();" + 
					"}" + 
					"}" + 	
					"}" + 
				"}";
			obj.listeners.put("afterlayout", new JsFunction(JsFunction.ANONYMOUS, after));
		}
	}
	
	public JsObject getParams() {
		if (params == null) {
			params = new JsObject();
		}
		return params;
	}
	
	/**
	 * Parameters to pass with all requests. e.g. baseParams: {id: '123', foo: 'bar'}.
	 */
	public void setParams(JsObject params) {
		this.params = params;
	}

	/**
	 * Valid values are "left," "center" and "right" (defaults to "center")
	 */
	public void setButtonAlign(String buttonAlign) {
		this.buttonAlign = buttonAlign;
	}

	/**
	 * (optional) The id of the FORM tag (defaults to an auto-generated id).
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/**
	 * A css class to apply to the x-form-item of fields. This property cascades 
	 * to child containers.
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
	}

	/**
	 * Valid values are "left," "top" and "right" (defaults to "left"). This property 
	 * cascades to child containers if not set.
	 */
	public void setLabelAlign(String labelAlign) {
		this.labelAlign = labelAlign;
	}

	/**
	 * The width of labels. This property cascades to child containers.
	 */
	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

	/**
	 * Minimum width of all buttons in pixels (defaults to 75)
	 */
	public void setMinButtonWidth(String minButtonWidth) {
		this.minButtonWidth = minButtonWidth;
	}

	/**
	 * The milliseconds to poll valid state, ignored if monitorValid is not true (defaults to 
	 * 200)
	 */
	public void setMonitorPoll(String monitorPoll) {
		this.monitorPoll = monitorPoll;
	}

	/**
	 * If true the form monitors its valid state client-side and fires a looping event with 
	 * that state. This is required to bind buttons to the valid state using the config value 
	 * formBind:true on the button.
	 */
	public void setMonitorValid(String monitorValid) {
		this.monitorValid = monitorValid;
	}

	/**
	 * Set to true if this form is a file upload.
	 */
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * The request method to use (GET or POST) for form actions if one isn't supplied in 
	 * the action options.
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Timeout for form actions in seconds (default is 30 seconds).
	 */
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	/**
	 * If set to true, form.reset() resets to the last loaded or setValues() data instead 
	 * of when the form was first created.
	 */
	public void setTrackResetOnLoad(String trackResetOnLoad) {
		this.trackResetOnLoad = trackResetOnLoad;
	}

	/**
	 * The URL to use for form actions if one isn't supplied in the action options.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * If set to false, standard HTML form submits are used instead of XHR (Ajax) 
	 * style form submissions. (defaults to false)
	 */
	public void setIsAjaxForm(String isAjaxForm) {
		this.isAjaxForm = isAjaxForm;
	}

	public void setOnSubmit(String onSubmit) {
		this.onSubmit = onSubmit;
	}

	/**
	 * An Ext.data.DataReader (e.g. Ext.data.XmlReader) to be used to read data when executing "load" actions. 
	 * This is optional as there is built-in support for processing JSON.
	 */
	public void setReader(DataReader reader) {
		this.reader = reader;
	}

	/**
	 * An Ext.data.DataReader (e.g. Ext.data.XmlReader) to be used to read data when 
	 * reading validation errors on "submit" actions. This is completely optional as 
	 * there is built-in support for processing JSON.
	 */
	public void setErrorReader(DataReader errorReader) {
		this.errorReader = errorReader;
	}

	/**
	 * <p>If the monitorValid config option is true, this event fires repetitively to notify of valid state </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : Ext.form.FormPanel</li>
	 * <li><strong>valid</strong> : (Boolean) true if the form has passed client-side validation</li>
     * </ul>
	 * @param onClientValidation
	 */
	public void setOnClientValidation(String onClientValidation) {
		this.onClientValidation = onClientValidation;
	}

	/**
	 * <p>Fires when action is completed</p>
	 * @param onActionComplete
	 */
	public void setOnActionComplete(String onActionComplete) {
		this.onActionComplete = onActionComplete;
	}

	/**
	 * <p>Fires when action is failed</p>
	 * @param onActionFailed
	 */
	public void setOnActionFailed(String onActionFailed) {
		this.onActionFailed = onActionFailed;
	}

	/**
	 * <p>Fires just before action</p>
	 * @param onBeforeAction
	 */
	public void setOnBeforeAction(String onBeforeAction) {
		this.onBeforeAction = onBeforeAction;
	}

	public void setWaitingTitle(String waitingTitle) {
		this.waitingTitle = waitingTitle;
	}

	public void setWaitingText(String waitingText) {
		this.waitingText = waitingText;
	}
}
