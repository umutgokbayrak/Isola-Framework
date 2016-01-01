package isola.tags.ext.data;import javax.servlet.jsp.JspException;import isola.model.core.JsObject;import isola.model.core.JsVariableImpl;import isola.tags.base.BaseTag;import isola.tags.ext.form.FormPanelTag;import isola.tags.ext.misc.AjaxRequestTag;import isola.tags.ext.tree.TreeLoaderTag;/** *  * This Tag is a helper tag for any of the Tag which communicate over HTTP to an * URL. Whilst opening *  * a post or get connection for the url this tag will let you set an http * parameter and assign a value *  * to it. *  * <pre> * &lt;code&gt; * 
 * 	&lt;ext:jsonStore url=&quot;fetchData.json&quot; root=&quot;result&quot; method=&quot;post&quot;&gt; * 
 * 	&lt;ext:httpParam name=&quot;user&quot; value=&quot;umut&quot;/&gt; * 
 * 	&lt;ext:httpParam name=&quot;paramId&quot; value=&quot;1&quot;/&gt; * 
 * 	... * 
 * &lt;/ext:jsonStore&gt; * 
 * &lt;/code&gt; * </pre> *  *  *  * There are many places this tag is used. In general anywhere you need to send * HTTP params this tag is used. *  * <ul> *  * <li>JsonStoreTag</li> *  * <li>FormPanelTag</li> *  * <li>TreeLoaderTag</li> *  * <li>XmlStoreTag</li> *  * </ul> *  *  *  * @author Umut Gokbayrak */public class HttpParamTag extends BaseTag {	private static final long serialVersionUID = -7721344933868240952L;	private String name;	private String value;		@Override	public int doEndTag() throws JspException {		JsObject obj = new JsObject();		prepareConfig(obj);		// insert item to the parent storetag		if (getParent() instanceof JsonStoreTag) {			JsonStoreTag st = (JsonStoreTag) getParent();			st.getParams().put(name, value);		} else if (getParent() instanceof FormPanelTag) {			FormPanelTag st = (FormPanelTag) getParent();			st.getParams().put(name, value);		} else if (getParent() instanceof TreeLoaderTag) {			TreeLoaderTag st = (TreeLoaderTag) getParent();			st.getParams().put(name, value);		} else if (getParent() instanceof AjaxRequestTag) {			AjaxRequestTag st = (AjaxRequestTag) getParent();			if (value.startsWith("Ext.")) {				st.getParams().put(name, new JsVariableImpl(value));			} else {				st.getParams().put(name, value);			}		} else if (getParent() instanceof XmlStoreTag) {			XmlStoreTag st = (XmlStoreTag) getParent();			st.getParams().put(name, value);		}		clear();		return EVAL_PAGE;	}		@Override	protected void clear() {		name = value = null;	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(JsObject obj) {		if (name != null) {			obj.put("name", name);		}		if (value != null) {			if (value.startsWith("Ext.")) {				obj.put("value", new JsVariableImpl(value));			} else {				obj.put("value", value);			}		}	}		/**	 * 	 * Name of the parameter	 * 	 * 	 * 	 * @param name	 */	public void setName(String name) {		this.name = name;	}		/**	 * 	 * Value for the parameter	 * 	 * 	 * 	 * @param value	 */	public void setValue(String value) {		this.value = value;	}}