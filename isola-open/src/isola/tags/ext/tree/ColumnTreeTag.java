package isola.tags.ext.tree;import javax.servlet.jsp.JspException;import isola.model.core.JsArray;import isola.model.core.JsObject;import isola.model.core.JsVariableImpl;import isola.model.ext.base.Observable;import isola.model.ext.tree.ColumnTree;import isola.model.ext.tree.TreeLoader;/** *  * <p> * A TreePanel with GridPanel like column capabilities. A sample: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * &lt;ext:columnTree region=&amp;north&amp; split=&amp;true&amp; rootVisible=&amp;true&amp; autoScroll=&amp;true&amp; height=&amp;400&amp; border=&amp;true&amp; bodyBorder=&amp;true&amp;&gt; * 
 * 	&lt;ext:columnModel&gt; * 
 * 		&lt;ext:gridColumn dataIndex=&amp;task&amp; header=&amp;Task&amp; width=&amp;350&amp; /&gt; * 
 * 		&lt;ext:gridColumn dataIndex=&amp;duration&amp; header=&amp;Duration&amp; width=&amp;200&amp; /&gt; * 
 * 		&lt;ext:gridColumn dataIndex=&amp;user&amp; header=&amp;Assigned To&amp; width=&amp;300&amp; /&gt; * 
 * 	&lt;/ext:columnModel&gt; * 
 * 	&lt;ext:treeLoader url=&amp;isola/columntree.js&amp; preloadChildren=&amp;true&amp;&gt; * 
 * 		&lt;ext:httpParam name=&amp;method&amp; value=&amp;getColumns&amp;/&gt; * 
 * 	&lt;/ext:treeLoader&gt; * 
 * 	&lt;ext:asyncTreeNode text=&amp;Tasks&amp; expanded=&amp;true&amp;/&gt; * 
 * &lt;/ext:columnTree&gt; * 
 * &lt;/code&gt; * </pre> *  *  *  * This would consume a JSON String like: *  *  *  * <pre> * &lt;code&gt; * 
 * [{ * 
 *     task:'ColumnTree Example', * 
 *     duration:'3 hours', * 
 *     user:'', * 
 *     uiProvider:'col', * 
 *     cls:'master-task', * 
 *     iconCls:'task-folder', * 
 *     children:[{ * 
 *         task:'Abstract rendering in TreeNodeUI', * 
 *         duration:'15 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreeNodeUI with column knowledge', * 
 *         duration:'45 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreePanel to render and lock headers', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Add CSS to make it look fly', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Test and make sure it works', * 
 *         duration:'1 hour', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     }] * 
 * },{ * 
 *     task:'Custom Field Example', * 
 *     duration:'2 1/2 hours', * 
 *     user:'', * 
 *     uiProvider:'col', * 
 *     cls:'master-task', * 
 *     iconCls:'task-folder', * 
 *     children:[{ * 
 *         task:'Implement &quot;Live Search&quot; on extjs.com from Alex', * 
 *         duration:'1 hour', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Extend TwinTrigger', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Testing and debugging', * 
 *         duration:'1 hour', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     }] * 
 * },{ * 
 *     task:'Foo Bar Item', * 
 *     duration:'3 hours', * 
 *     user:'', * 
 *     uiProvider:'col', * 
 *     cls:'master-task', * 
 *     iconCls:'task-folder', * 
 *     children:[{ * 
 *         task:'Abstract rendering in TreeNodeUI', * 
 *         duration:'15 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreeNodeUI with column knowledge', * 
 *         duration:'45 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreePanel to render and lock headers', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Add CSS to make it look fly', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Test and make sure it works', * 
 *         duration:'1 hour', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     }] * 
 * },{ * 
 *     task:'WTF Item', * 
 *     duration:'3 hours', * 
 *     user:'', * 
 *     uiProvider:'col', * 
 *     cls:'master-task', * 
 *     iconCls:'task-folder', * 
 *     children:[{ * 
 *         task:'Abstract rendering in TreeNodeUI', * 
 *         duration:'15 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreeNodeUI with column knowledge', * 
 *         duration:'45 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Create TreePanel to render and lock headers', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Add CSS to make it look fly', * 
 *         duration:'30 min', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     },{ * 
 *         task:'Test and make sure it works', * 
 *         duration:'1 hour', * 
 *         user:'Jack Slocum', * 
 *         uiProvider:'col', * 
 *         leaf:true, * 
 *         iconCls:'task' * 
 *     }] * 
 * }] * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak *  *  */public class ColumnTreeTag extends TreePanelTag {	private static final long serialVersionUID = -1314799081123639439L;	private JsArray columns;	private String el;		@Override	public int doEndTag() throws JspException {		ColumnTree obj = new ColumnTree();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();		columns = null;		el = null;	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(ColumnTree obj) {		super.prepareConfig(obj);		if (el != null) {			obj.el = el;		}		if (columns != null && columns.size() > 0) {			obj.columns = columns;		}		if (getLoader() == null) {			setLoader(new TreeLoader());		}		if (getLoader().uiProviders == null) {			getLoader().uiProviders = new JsObject();		}		getLoader().uiProviders.put("col", new JsVariableImpl("Ext.tree.ColumnNodeUI"));	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}		public void setColumns(JsArray columns) {		this.columns = columns;	}		public void setEl(String el) {		this.el = el;	}		public JsArray getColumns() {		if (columns == null) {			columns = new JsArray();		}		return columns;	}}