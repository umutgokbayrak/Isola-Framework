package isola.tags.ext.container;import javax.servlet.jsp.JspException;import isola.model.ext.container.Panel;import isola.tags.ext.base.ContainerTag;/** *  *  *  * @author Umut Gokbayrak */public class TabTag extends PanelTag {	private static final long serialVersionUID = -8155146665876193620L;	private String closable;		@Override	public int doEndTag() throws JspException {		Panel obj = new Panel(true);		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		try {			if (getParent() instanceof ContainerTag) {				ContainerTag par = (ContainerTag) getParent();				par.getItems().add(obj);			} else {				pageContext.getOut().write(obj.toString() + ";");			}		} catch (Exception e) {			e.printStackTrace();		} finally {			clear();		}		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();		closable = "true";	}		/**	 * 	 * 	 * 	 * @param obj	 */	@Override	protected void prepareConfig(Panel obj) {		super.prepareConfig(obj);		if (closable != null) {			try {				obj.put("closable", Boolean.valueOf(closable));			} catch (Exception e) {			}		}	}		public void setClosable(String closable) {		this.closable = closable;	}}