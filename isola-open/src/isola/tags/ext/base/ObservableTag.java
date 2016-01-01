package isola.tags.ext.base;import javax.servlet.jsp.JspException;import isola.model.core.JsObject;import isola.model.ext.base.Observable;import isola.tags.base.BaseTag;/** *  * Abstract base class that provides a common interface for publishing events. * Subclasses are *  * expected to to have a property "events" with all the events defined. *  * For example: *  *  *  * <pre> * &lt;code&gt; * 
 * Employee = function(name){ * 
 *   this.name = name; * 
 *   this.addEvents({ * 
 *       &quot;fired&quot; : true, * 
 *       &quot;quit&quot; : true * 
 *   }); * 
 * } * 
 * Ext.extend(Employee, Ext.util.Observable); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak *  *  */public class ObservableTag extends BaseTag {	private static final long serialVersionUID = -1076213998914667728L;		/**
	 * 
	 */	public int doEndTag() throws JspException {		Observable obj = new Observable();		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		public void clear() {		// do nothing	}		/**	 * 	 * 	 * 	 * @return	 */	protected void prepareEvents(Observable obj) {		obj.listeners = new JsObject();	}}