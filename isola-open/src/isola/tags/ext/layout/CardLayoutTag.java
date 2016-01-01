package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This layout contains multiple panels, each fit to the container, where only a single panel 
 * can be visible at any given time. This layout style is most commonly used for wizards, tab 
 * implementations, etc. This class is intended to be extended or created via the layout:'card' 
 * Ext.Container.layout config, and should generally not need to be created directly via the 
 * new keyword.</p>
 * 
 * <p>The CardLayout's focal method is setActiveItem. Since only one panel is displayed at a time, 
 * the only way to move from one panel to the next is by calling setActiveItem, passing the id 
 * or index of the next panel to display. The layout itself does not provide a mechanism for 
 * handling this navigation, so that functionality must be provided by the developer.</p>
 * 
 * <p>In the following example, a simplistic wizard setup is demonstrated. A button bar is added 
 * to the footer of the containing panel to provide navigation buttons. The buttons will be 
 * handled by a common navigation routine -- for this example, the implementation of that 
 * routine has been ommitted since it can be any type of custom logic. Note that other uses of 
 * a CardLayout (like a tab control) would require a completely different implementation. For 
 * serious implementations, a better approach would be to extend CardLayout to provide the 
 * custom functionality needed. Example usage:</p>
 * 
 * <code><pre>
 * 
 * &lt;ext:body runOnLoad="true"&gt;
 * 	var navHandler = function(direction){
 * 		var lay = Ext.getCmp('card1').getLayout();
 * 		var i = lay.activeItem.id.split('card-')[1];
 * 		var next = parseInt(i) + direction;
 * 		lay.setActiveItem(next);
 * 		Ext.getCmp('move-prev').setDisabled(next==0);
 * 		Ext.getCmp('move-next').setDisabled(next==2);
 * 	};
 * 
 * 	&lt;ext:cardLayout id="card1" renderTo="hebelek" title="Example Wizard" activeItem="0" bodyStyle="padding:15px" border="true" width="700" height="500"&gt;
 * 		&lt;ext:toolbar position="bottom"&gt;
 * 			&lt;ext:toolbarButton id="move-prev" text="Back" handler="navHandler(-1)" disabled="true" /&gt;
 * 			&lt;ext:toolbarFill/&gt;
 * 			&lt;ext:toolbarButton id="move-next" text="Next" handler="navHandler(1)" /&gt;
 * 		&lt;/ext:toolbar&gt;
 * 		&lt;ext:panel id="card-0" border="false"&gt;
 * 			&lt;h1&gt;Welcome to the Wizard!&lt;/h1&gt;&lt;p&gt;Step 1 of 3&lt;/p&gt;
 * 		&lt;/ext:panel&gt;
 * 		&lt;ext:panel id="card-1" border="false"&gt;
 * 			&lt;h1&gt;Second Step&lt;/h1&gt;&lt;p&gt;Step 2 of 3&lt;/p&gt;
 * 		&lt;/ext:panel&gt;
 * 		&lt;ext:panel id="card-2" border="false"&gt;
 * 			&lt;h1&gt;Congratulations!&lt;/h1&gt;&lt;p&gt;Step 3 of 3 - Complete&lt;/p&gt;
 * 		&lt;/ext:panel&gt;
 * 	&lt;/ext:cardLayout&gt;
 * &lt;/ext:body&gt;
 * 
 * &lt;div id="hebelek"&gt;&lt;/div&gt;
 * 
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class CardLayoutTag extends PanelTag {
	private static final long serialVersionUID = -2823824711463000648L;

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
		setLayout("card");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
