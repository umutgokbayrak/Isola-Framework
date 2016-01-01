package isola.tags.ext.helpers;import java.util.HashMap;import java.util.Locale;import java.util.Map;import javax.servlet.jsp.JspException;import javax.servlet.jsp.JspTagException;import isola.helpers.TemplateHelper;import isola.tags.base.BaseTag;/** *  * Used to start a new Extjs script. Do not use this for a replacement of a Html * script tag. *  * <strong>BECAUSE IT ISN'T</strong> *  *  *  * @author Umut Gokbayrak *  *  */public class ScriptTag extends BaseTag {	private static final long serialVersionUID = 8164395017079050181L;	private String storeSession;	private String runOnLoad;		public int doEndTag() throws JspException {		try {			Map<String, Object> root = new HashMap<String, Object>();			if (storeSession != null && storeSession.toLowerCase(Locale.ENGLISH).equals("true")) {				root.put("storeSession", "true");			} else {				root.put("storeSession", "false");			}			root.put("code", getBodyContent().getString());			root.put("runOnLoad", this.runOnLoad);			TemplateHelper merger = new TemplateHelper(templatePath + "/ext/Script.ftl", root);			String result = merger.merge();			pageContext.getOut().write(result);		} catch (Exception e) {			throw new JspTagException("Error: " + e.getMessage());		}		return EVAL_PAGE;	}		@Override	public void clear() {		storeSession = runOnLoad = null;	}		public void setStoreSession(String storeSession) {		this.storeSession = storeSession;	}		public void setRunOnLoad(String runOnLoad) {		this.runOnLoad = runOnLoad;	}}