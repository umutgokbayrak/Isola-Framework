package isola.tags.ext.data;import javax.servlet.jsp.JspException;import isola.model.core.JsObject;import isola.model.ext.base.Observable;import isola.model.ext.data.Connection;import isola.model.ext.data.HttpProxy;import isola.model.ext.data.Store;import isola.model.ext.data.XmlReader;/** *  * A Datastore which fetches its data from a HTTP request and the response is a * valid XML String *  *  *  * <pre> * &lt;code&gt; * 
 * &lt;ext:gridPanel id=&quot;myGrid&quot; width=&quot;400&quot; height=&quot;200&quot; forceFit=&quot;true&quot; renderTo=&quot;pbar&quot; border=&quot;true&quot;&gt; * 
 * 	&lt;ext:xmlStore url=&quot;servlet/XmlSampleServlet&quot; record=&quot;property&quot;&gt; * 
 * 		&lt;ext:httpParam name=&quot;id&quot; value=&quot;111&quot;/&gt; * 
 * 		&lt;ext:httpParam name=&quot;user&quot; value=&quot;umut&quot;/&gt; * 
 * 		&lt;ext:storeMapping name=&quot;name&quot; /&gt; * 
 * 		&lt;ext:storeMapping name=&quot;value&quot;/&gt; * 
 * 	&lt;/ext:xmlStore&gt; * 
 * 	&lt;ext:columnModel&gt; * 
 * 		 &lt;ext:gridColumn dataIndex=&quot;name&quot; header=&quot;Name&quot; sortable=&quot;false&quot;/&gt; * 
 * 		 &lt;ext:gridColumn dataIndex=&quot;value&quot; header=&quot;Value&quot; sortable=&quot;true&quot;/&gt; * 
 * 	&lt;/ext:columnModel&gt; * 
 * &lt;/ext:gridPanel&gt; * 
 * &lt;/code&gt; * </pre> *  *  *  * <p> * This will consume a XML string like: * </p> *  * <pre> * &lt;code&gt; * 
 *  * 
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?&gt; * 
 * &lt;data&gt; * 
 * &lt;environment&gt; * 
 * 	&lt;property&gt; * 
 * 		&lt;name&gt;java.runtime.name&lt;/name&gt; * 
 * 		&lt;value&gt;Java(TM) SE Runtime Environment&lt;/value&gt; * 
 * 	&lt;/property&gt; * 
 * 	&lt;property&gt; * 
 * 		&lt;name&gt;com.atomikos.icatch.file&lt;/name&gt; * 
 * 		&lt;value&gt;D:\dev\java\jetty-6.1.7/contexts/test-jndi.d/WEB-INF/classes/jta.properties&lt;/value&gt; * 
 * 	&lt;/property&gt; * 
 * &lt;/environment&gt; * 
 * &lt;/data&gt; * 
 *  * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class XmlStoreTag extends StoreTag {	private static final long serialVersionUID = 6817661371788515685L;	private JsObject params;	private String id;	private String record;	private String success;	private String totalRecords;	private String method;		@Override	public int doEndTag() throws JspException {		Store obj = new Store();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		obj.put("scope", "this");		if (method != null) {			obj.put("method", method);		}		XmlReader xmlReader = new XmlReader();		JsObject o1 = new JsObject();		if (id != null) {			o1.put("id", id);		}		if (params != null) {			o1.put("params", params);		}		if (record != null) {			o1.put("record", record);		}		if (success != null) {			o1.put("success", success);		}		if (totalRecords != null) {			o1.put("totalRecords", totalRecords);		}		xmlReader.put("~~~NIL1", o1);		xmlReader.put("~~~NIL2", getFields());		obj.reader = xmlReader;		Connection conn = new Connection();		conn.url = getUrl();		conn.put("method", method);		HttpProxy proxy = new HttpProxy(conn);		obj.proxy = proxy;		printStore(obj);		clear();		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();		params = new JsObject();		id = record = success = totalRecords = method = null;	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(Store obj) {		super.prepareConfig(obj);	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}		public JsObject getParams() {		if (params == null) {			params = new JsObject();		}		return params;	}		public void setParams(JsObject params) {		this.params = params;	}		public void setId(String id) {		this.id = id;	}		public void setRecord(String record) {		this.record = record;	}		public void setSuccess(String success) {		this.success = success;	}		public void setTotalRecords(String totalRecords) {		this.totalRecords = totalRecords;	}		public void setMethod(String method) {		this.method = method;	}}