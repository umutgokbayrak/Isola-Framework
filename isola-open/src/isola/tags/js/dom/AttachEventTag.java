package isola.tags.js.dom;import java.util.Locale;import javax.servlet.jsp.JspException;import isola.helpers.JsGenerator;import isola.model.core.JsFunction;import isola.tags.base.BaseTag;/** *  *  *  * @author Umut Gokbayrak */public class AttachEventTag extends BaseTag {	private static final long serialVersionUID = 6316090465480417166L;	private String elementId;	private String eventName;	private String handler;		@Override	public int doEndTag() throws JspException {		try {			if (elementId != null) {				String tmpElementId = elementId.trim().toLowerCase(Locale.ENGLISH);				if (tmpElementId.equals("document")) {					elementId = "$document";				}				if (tmpElementId.startsWith("document.")) {					elementId = "$" + elementId;				}				if (tmpElementId.equals("window")) {					elementId = "$window";				}				if (tmpElementId.startsWith("window.")) {					elementId = "$" + elementId;				}				if (null != eventName && !eventName.startsWith("on")) {					eventName = "on" + eventName;				}				String str = null;				str = JsGenerator.attachEvent(elementId, eventName, new JsFunction(handler).toString());				pageContext.getOut().write(str);			}		} catch (Exception e) {			e.printStackTrace();		}		return EVAL_PAGE;	}		@Override	protected void clear() {		elementId = eventName = handler = null;	}		public void setElementId(String elementId) {		this.elementId = elementId;	}		public void setEventName(String eventName) {		this.eventName = eventName;	}		public void setHandler(String handler) {		this.handler = handler;	}}