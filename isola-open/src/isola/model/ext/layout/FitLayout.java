package isola.model.ext.layout;import isola.helpers.JsHelper;/** *  * <p> * This is a base class for layouts that contain a single item that * automatically expands *  * to fill the layout's container. This class is intended to be extended or * created via the *  * layout:'fit' Ext.Container.layout config, and should generally not need to be * created *  * directly via the new keyword. * </p> *  *  *  * <p> * FitLayout does not have any direct config options (other than inherited * ones). To fit *  * a panel to a container using FitLayout, simply set layout:'fit' on the * container and add *  * a single panel to it. If the container has multiple panels, only the first * one will be *  * displayed. Example usage: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var p = new Ext.Panel({ * 
 *   title: 'Fit Layout', * 
 *   layout:'fit', * 
 *   items: { * 
 *       title: 'Inner Panel', * 
 *       html: '&lt;p&gt;This is the inner panel content&lt;/p&gt;', * 
 *       border: false * 
 *   } * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class FitLayout extends ContainerLayout {	private static final long serialVersionUID = 4264431413609949866L;	private static final String TAG = "Ext.layout.FitLayout";	/**	 * 	 * An optional extra CSS class that will be added to the container (defaults	 * to ''). This can	 * 	 * be useful for adding customized styles to the container or any of its	 * children using	 * 	 * standard CSS rules.	 */	public String extraCls;	/**	 * 	 * True to hide each contained item on render (defaults to false).	 */	public boolean renderHidden = false;		/**
	 * 
	 */	public FitLayout() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (extraCls != null)			put("extraCls", extraCls);		if (renderHidden)			put("renderHidden", renderHidden);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}