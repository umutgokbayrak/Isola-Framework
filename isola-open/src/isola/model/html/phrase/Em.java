package isola.model.html.phrase;import isola.helpers.ElementParserHtml;import isola.model.html.core.Container;/** *  * Indicates emphasis. *  *  *  * @author Umut Gokbayrak */public class Em extends Container {	private static final String tag = "em";		public Em() {		super();		setId(tag + (Math.random() * 1000));	}		public Em(String id) {		super(id);	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}		public String getTag() {		return tag;	}}