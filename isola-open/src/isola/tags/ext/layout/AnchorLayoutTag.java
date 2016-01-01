package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This is a layout that enables anchoring of contained elements relative to the container's 
 * dimensions. If the container is resized, all anchored items are automatically rerendered 
 * according to their anchor rules. This class is intended to be extended or created via the 
 * layout:'anchor' Ext.Container.layout config, and should generally not need to be created 
 * directly via the new keyword.</p>
 * 
 * <p>AnchorLayout does not have any direct config options (other than inherited ones). However, 
 * the container using the AnchorLayout can supply an anchoring-specific config property of 
 * anchorSize. By default, AnchorLayout will calculate anchor measurements based on the size 
 * of the container itself. However, if anchorSize is specifed, the layout will use it as a 
 * virtual container for the purposes of calculating anchor measurements based on it instead, 
 * allowing the container to be sized independently of the anchoring logic if necessary.</p>
 * 
 * <p>The items added to an AnchorLayout can also supply an anchoring-specific config property 
 * of anchor which is a string containing two values: the horizontal anchor value and the 
 * vertical anchor value (for example, '100% 50%'). This value is what tells the layout how the 
 * item should be anchored to the container. The following types of anchor values are 
 * supported: </p>
 * 
 * <p><strong>Percentage</strong>: Any value between 1 and 100, expressed as a percentage. The first 
 * anchor is the percentage width that the item should take up within the container, and the 
 * second is the percentage height. Example: '100% 50%' would render an item the complete width 
 * of the container and 1/2 its height. If only one anchor value is supplied it is assumed to be 
 * the width value and the height will default to auto.</p>
 * <p><strong>Offsets</strong>: Any positive or negative integer value. The first anchor is the 
 * offset from the right edge of the container, and the second is the offset from the bottom edge. 
 * Example: '-50 -100' would render an item the complete width of the container minus 50 pixels 
 * and the complete height minus 100 pixels. If only one anchor value is supplied it is assumed 
 * to be the right offset value and the bottom offset will default to 0.</p>
 * <p><strong>Sides</strong>: Valid values are 'right' (or 'r') and 'bottom' (or 'b'). Either the 
 * container must have a fixed size or an anchorSize config value defined at render time in order 
 * for these to have any effect.</p>
 * Usage:
 * <pre><code>
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:anchorLayout id="anchorLayout" renderTo="hebelek" height="500" width="800" border="true" title="Anchor Layout"&gt;
 *			&lt;ext:panel id="testAnchorBox" anchor="50% 50%" bodyStyle="background-color:black;color:white;"&gt;
 *				Panel 1
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel id="testAnchorBox2" anchor="-100 -300" bodyStyle="background-color:red;color:white;"&gt;
 *				Panel 2
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:anchorLayout&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class AnchorLayoutTag extends PanelTag {
	private static final long serialVersionUID = 1793269410609610338L;

	@Override
	public int doEndTag() throws JspException {
		Panel obj = new Panel();
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
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Panel obj) {
		setLayout("anchor");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
