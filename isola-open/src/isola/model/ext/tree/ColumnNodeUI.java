package isola.model.ext.tree;import isola.helpers.JsHelper;public class ColumnNodeUI extends TreeNodeUI {	private static final long serialVersionUID = 801833117940445920L;	private static final String TAG = "Ext.tree.ColumnNodeUI";		public ColumnNodeUI() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}